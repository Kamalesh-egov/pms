package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.models.AuditDetails;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * This is the master data to capture the metadata of Project
 */
@Schema(description = "This is the master data to capture the metadata of Project")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectType   {
        @JsonProperty("id")

        @Size(min=2,max=64)         private String id = null;

        @JsonProperty("tenantId")

        @Size(min=2,max=1000)         private String tenantId = null;

        @JsonProperty("name")

        @Size(min=2,max=64)         private String name = null;

        @JsonProperty("code")

        @Size(min=2,max=64)         private String code = null;

        @JsonProperty("group")

        @Size(min=2,max=64)         private String group = null;

        @JsonProperty("beneficiaryType")

                private String beneficiaryType = null;

        @JsonProperty("eligibilityCriteria")

        @Size(max=10)         private List<String> eligibilityCriteria = null;

        @JsonProperty("taskProcedure")

        @Size(max=10)         private List<String> taskProcedure = null;

        @JsonProperty("resources")
          @Valid
                private List<ProjectProductVariant> resources = null;

        @JsonProperty("auditDetails")

          @Valid
                private AuditDetails auditDetails = null;


        public ProjectType addEligibilityCriteriaItem(String eligibilityCriteriaItem) {
            if (this.eligibilityCriteria == null) {
            this.eligibilityCriteria = new ArrayList<>();
            }
        this.eligibilityCriteria.add(eligibilityCriteriaItem);
        return this;
        }

        public ProjectType addTaskProcedureItem(String taskProcedureItem) {
            if (this.taskProcedure == null) {
            this.taskProcedure = new ArrayList<>();
            }
        this.taskProcedure.add(taskProcedureItem);
        return this;
        }

        public ProjectType addResourcesItem(ProjectProductVariant resourcesItem) {
            if (this.resources == null) {
            this.resources = new ArrayList<>();
            }
        this.resources.add(resourcesItem);
        return this;
        }

}
