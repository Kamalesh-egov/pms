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
 * The purpose of this object to define the Project for a geography and period
 */
@Schema(description = "The purpose of this object to define the Project for a geography and period")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project   {
        @JsonProperty("id")

        @Size(min=2,max=64)         private String id = null;

        @JsonProperty("tenantId")

        @Size(min=2,max=64)         private String tenantId = null;

        @JsonProperty("name")

        @Size(min=2)         private String name = null;

        @JsonProperty("projectNumber")

                private String projectNumber = null;

        @JsonProperty("projectType")

        @Size(min=2,max=64)         private String projectType = null;

        @JsonProperty("projectSubType")

        @Size(min=2,max=64)         private String projectSubType = null;

        @JsonProperty("department")

        @Size(min=2,max=64)         private String department = null;

        @JsonProperty("description")

        @Size(min=2)         private String description = null;

        @JsonProperty("referenceID")

        @Size(min=2,max=100)         private String referenceID = null;

        @JsonProperty("natureOfWork")

        @Size(min=2,max=64)         private String natureOfWork = null;

        @JsonProperty("projectHierarchy")

                private String projectHierarchy = null;

        @JsonProperty("ancestors")

          @Valid
        private String ancestors = null;
//                private Project ancestors = null;


        @JsonProperty("address")

          @Valid
                private Address address = null;

        @JsonProperty("startDate")

                private Long startDate = null;

        @JsonProperty("endDate")

                private Long endDate = null;

        @JsonProperty("isTaskEnabled")

                private Boolean isTaskEnabled = false;

        @JsonProperty("parent")

        @Size(min=2,max=64)         private String parent = null;

        @JsonProperty("targets")
          @Valid
                private List<Target> targets = null;

        @JsonProperty("additionalDetails")

                private Object additionalDetails = null;

        @JsonProperty("isDeleted")

                private Boolean isDeleted = null;

        @JsonProperty("rowVersion")

                private Long rowVersion = null;

        @JsonProperty("auditDetails")

          @Valid
                private AuditDetails auditDetails = null;


        public Project addTargetsItem(Target targetsItem) {
            if (this.targets == null) {
            this.targets = new ArrayList<>();
            }
        this.targets.add(targetsItem);
        return this;
        }

}
