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
 * ProjectSearch
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectSearch   {
        @JsonProperty("id")

          @Valid
                private IdForSearch id = null;

        @JsonProperty("startDate")

                private Long startDate = null;

        @JsonProperty("endDate")

                private Long endDate = null;

        @JsonProperty("isTaskEnabled")

                private Boolean isTaskEnabled = false;

        @JsonProperty("parent")

        @Size(min=2,max=64)         private String parent = null;

        @JsonProperty("projectTypeId")

        @Size(min=2,max=64)         private String projectTypeId = null;

        @JsonProperty("subProjectTypeId")

        @Size(min=2,max=64)         private String subProjectTypeId = null;

        @JsonProperty("department")

        @Size(min=2,max=64)         private String department = null;

        @JsonProperty("referenceId")

        @Size(min=2,max=100)         private String referenceId = null;

        @JsonProperty("boundaryCode")

        @Size(max=64)         private String boundaryCode = null;


}
