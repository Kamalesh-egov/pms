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
 * TaskResource
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResource   {
        @JsonProperty("id")

        @Size(min=2,max=64)         private String id = null;

        @JsonProperty("tenantId")
          @NotNull

        @Size(min=2,max=1000)         private String tenantId = null;

        @JsonProperty("productVariantId")
          @NotNull

        @Size(min=2,max=64)         private String productVariantId = null;

        @JsonProperty("quantity")
          @NotNull

                private Long quantity = null;

        @JsonProperty("isDelivered")
          @NotNull

                private Boolean isDelivered = null;

        @JsonProperty("deliveryComment")

        @Size(max=1000)         private String deliveryComment = null;

        @JsonProperty("isDeleted")

                private Boolean isDeleted = null;

        @JsonProperty("auditDetails")

          @Valid
                private AuditDetails auditDetails = null;


}
