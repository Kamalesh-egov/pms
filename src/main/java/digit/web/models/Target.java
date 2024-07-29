package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.egov.common.contract.models.AuditDetails;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Target
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Target   {
        @JsonProperty("id")

        @Size(min=2,max=64)         private String id = null;

    @JsonProperty("projectId")

    @Size(min=2,max=64)         private String projectId = null;

        @JsonProperty("beneficiaryType")
          @NotNull

        @Size(min=2,max=64)         private String beneficiaryType = null;

        @JsonProperty("baseline")
          @NotNull

                private Integer baseline = null;

        @JsonProperty("target")
          @NotNull

                private Integer target = null;

        @JsonProperty("isDeleted")

                private Boolean isDeleted = null;

        @JsonProperty("auditDetails")

          @Valid
                private AuditDetails auditDetails = null;


}
