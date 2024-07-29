package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.IdForSearch;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * This object defines the mapping of a facility to a project.
 */
@Schema(description = "This object defines the mapping of a facility to a project.")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectFacilitySearch   {
        @JsonProperty("id")

          @Valid
                private IdForSearch id = null;

        @JsonProperty("facilityId")

          @Valid
                private IdForSearch facilityId = null;

        @JsonProperty("projectId")

          @Valid
                private IdForSearch projectId = null;


}
