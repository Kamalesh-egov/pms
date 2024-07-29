package digit.service;

import digit.config.PTConfiguration;
import digit.enrichment.ProjectEnrichment;
import digit.kafka.Producer;
import digit.repository.ProjectRepository;
import digit.repository.querybuilder.ProjectQueryBuilder;
import digit.web.models.Project;
import digit.web.models.ProjectRequest;
import digit.web.models.ProjectResponse;
import digit.web.models.ProjectSearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class ProjectService {

    @Autowired
    private ProjectQueryBuilder projectQueryBuilder;

    @Autowired
    private ProjectEnrichment projectEnrichment;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private Producer producer;

    @Autowired
    private PTConfiguration configuration;

    public List<Project> createPtRequest(ProjectRequest projectRequest) {

        projectEnrichment.enrichProject(projectRequest);

        System.out.println(projectRequest);
//        System.out.println(configuration.getCreateTopic());

        producer.push(configuration.getCreateTopic(), projectRequest);

        return projectRequest.getProjects();
    }

    public List<Project> searchProjects(RequestInfo requestInfo,
                                        List<Project> criteria,
                                        Integer limit,
                                        Integer offset,
                                        String tenantId,
                                        Long lastChangedSince,
                                        Boolean includeDeleted,
                                        Boolean includeAncestors,
                                        Boolean includeDescendants,
                                        Long createdFrom,
                                        Long createdTo) {
        // Fetch projects from the repository based on the search criteria
        Project postCriteria = criteria.get(0);
        List<Project> projects = projectRepository.getProjects(postCriteria, limit, offset, tenantId, lastChangedSince, includeDeleted, includeAncestors, includeDescendants, createdFrom, createdTo);

        if(CollectionUtils.isEmpty(projects))
            return new ArrayList<>();

        return projects;
    }


}