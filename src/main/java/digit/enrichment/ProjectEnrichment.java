package digit.enrichment;

import digit.web.models.Project;
import digit.web.models.ProjectRequest;
import digit.web.models.Target;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.models.AuditDetails;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class ProjectEnrichment {

    public void enrichProject(ProjectRequest projectRequest) {

        for(Project project: projectRequest.getProjects()){
            AuditDetails auditDetails = AuditDetails.builder()
                    .createdBy(projectRequest.getRequestInfo().getUserInfo().getUuid())
                    .createdTime(System.currentTimeMillis())
                    .lastModifiedBy(projectRequest.getRequestInfo().getUserInfo().getUuid())
                    .lastModifiedTime(System.currentTimeMillis()).build();

            project.setAuditDetails(auditDetails);

            // Enrich UUIDs
            if (project.getId() == null) {
                project.setId(UUID.randomUUID().toString());
            }

            if (project.getIsDeleted() == null) {
                project.setIsDeleted(false);
            }

            if (project.getAddress() != null && project.getAddress().getId() == null) {
                project.getAddress().setId(UUID.randomUUID().toString());
            }

            if (project.getTargets() != null) {
                for (Target target : project.getTargets()) {
                    if (target.getId() == null) {
                        target.setId(UUID.randomUUID().toString());
                        target.setIsDeleted(false);
                        target.setAuditDetails(auditDetails);
                    }
                }
            }

            System.out.println(project.getTargets());
        }

    }
}
