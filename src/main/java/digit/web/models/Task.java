package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * Task
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task   {
        @JsonProperty("id")

        @Size(min=2,max=64)         private String id = null;

        @JsonProperty("clientReferenceId")

        @Size(min=2,max=64)         private String clientReferenceId = null;

        @JsonProperty("tenantId")
          @NotNull

        @Size(min=2,max=1000)         private String tenantId = null;

        @JsonProperty("projectId")
          @NotNull

        @Size(min=2,max=64)         private String projectId = null;

        @JsonProperty("projectBeneficiaryId")
          @NotNull

                private String projectBeneficiaryId = null;

        @JsonProperty("projectBeneficiaryClientReferenceId")

                private String projectBeneficiaryClientReferenceId = null;

        @JsonProperty("resources")
          @NotNull
          @Valid
                private List<TaskResource> resources = new ArrayList<>();

        @JsonProperty("plannedStartDate")

                private Long plannedStartDate = null;

        @JsonProperty("plannedEndDate")

                private Long plannedEndDate = null;

        @JsonProperty("actualStartDate")

                private Long actualStartDate = null;

        @JsonProperty("actualEndDate")

                private Long actualEndDate = null;

        @JsonProperty("createdBy")

                private String createdBy = null;

        @JsonProperty("createdDate")

                private Long createdDate = null;

        @JsonProperty("address")

          @Valid
                private Address address = null;

        @JsonProperty("additionalFields")

          @Valid
                private AdditionalFields additionalFields = null;

        @JsonProperty("isDeleted")

                private Boolean isDeleted = null;

        @JsonProperty("rowVersion")

                private Long rowVersion = null;

        @JsonProperty("auditDetails")

          @Valid
                private AuditDetails auditDetails = null;

        @JsonProperty("status")

                private String status = null;


        public Task addResourcesItem(TaskResource resourcesItem) {
        this.resources.add(resourcesItem);
        return this;
        }

}
