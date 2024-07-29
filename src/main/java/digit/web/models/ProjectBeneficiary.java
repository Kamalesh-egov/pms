package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.egov.common.contract.models.AuditDetails;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * A representation of the registration of an entity to a Project.
 */
@Schema(description = "A representation of the registration of an entity to a Project.")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectBeneficiary   {
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

        @JsonProperty("beneficiaryId")
          @NotNull

        @Size(min=2,max=64)         private String beneficiaryId = null;

        @JsonProperty("beneficiaryClientReferenceId")

        @Size(min=2,max=64)         private String beneficiaryClientReferenceId = null;

        @JsonProperty("tag")

        @Size(max=1000)         private String tag = null;

        @JsonProperty("dateOfRegistration")

                private Long dateOfRegistration = null;

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


}
