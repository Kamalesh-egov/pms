package digit.repository;

import digit.repository.querybuilder.ProjectQueryBuilder;
import digit.repository.rowmapper.ProjectRowMapper;
import digit.web.models.Project;
import digit.web.models.ProjectSearch;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class ProjectRepository {

    @Autowired
    private ProjectQueryBuilder queryBuilder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProjectRowMapper rowMapper;

    public List<Project> getProjects(Project criteria, Integer limit, Integer offset, String tenantId, Long lastChangedSince, Boolean includeDeleted, Boolean includeAncestors, Boolean includeDescendants, Long createdFrom, Long createdTo) {
        List<Object> preparedStmtList = new ArrayList<>();
        String query = queryBuilder.getProjectSearchQuery(criteria, limit, offset, tenantId, lastChangedSince, includeDeleted, includeAncestors, includeDescendants, createdFrom, createdTo, preparedStmtList);
        log.info("Final query: " + query);
        return jdbcTemplate.query(query, preparedStmtList.toArray(), rowMapper);
    }
}
