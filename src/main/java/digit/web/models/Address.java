package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.Boundary;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Representation of a address. Individual APIs may choose to extend from this using allOf if more details needed to be added in their case. 
 */
@Schema(description = "Representation of a address. Individual APIs may choose to extend from this using allOf if more details needed to be added in their case. ")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address   {
        @JsonProperty("id")

        @Size(min=2,max=64)         private String id = null;

        @JsonProperty("tenantId")

        @Size(min=2,max=1000)         private String tenantId = null;

        @JsonProperty("doorNo")

        @Size(min=2,max=64)         private String doorNo = null;

        @JsonProperty("latitude")

        @DecimalMin("-90") @DecimalMax("90")         private Double latitude = null;

        @JsonProperty("longitude")

        @DecimalMin("-180") @DecimalMax("180")         private Double longitude = null;

        @JsonProperty("locationAccuracy")

        @DecimalMin("0") @DecimalMax("10000")         private Double locationAccuracy = null;

        @JsonProperty("type")

                private String type = null;

        @JsonProperty("addressLine1")

        @Size(min=2,max=256)         private String addressLine1 = null;

        @JsonProperty("addressLine2")

        @Size(min=2,max=256)         private String addressLine2 = null;

        @JsonProperty("landmark")

        @Size(min=2,max=256)         private String landmark = null;

        @JsonProperty("city")

        @Size(min=2,max=256)         private String city = null;

        @JsonProperty("pincode")

        @Size(min=2,max=64)         private String pincode = null;

        @JsonProperty("buildingName")

        @Size(min=2,max=256)         private String buildingName = null;

        @JsonProperty("street")

        @Size(min=2,max=256)         private String street = null;

        @JsonProperty("locality")

          @Valid
                private Boundary locality = null;


}
