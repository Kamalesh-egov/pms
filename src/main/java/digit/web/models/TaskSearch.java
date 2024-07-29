package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.ClientReferenceIdForSearch;
import digit.web.models.IdForSearch;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * TaskSearch
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskSearch   {
        @JsonProperty("id")

          @Valid
                private IdForSearch id = null;

        @JsonProperty("clientReferenceId")

          @Valid
                private ClientReferenceIdForSearch clientReferenceId = null;

        @JsonProperty("projectId")

                private List<String> projectId = null;

        @JsonProperty("projectBeneficiaryId")

                private List<String> projectBeneficiaryId = null;

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

        @JsonProperty("status")

                private String status = null;

        @JsonProperty("boundaryCode")

        @Size(max=64)         private String boundaryCode = null;


        public TaskSearch addProjectIdItem(String projectIdItem) {
            if (this.projectId == null) {
            this.projectId = new ArrayList<>();
            }
        this.projectId.add(projectIdItem);
        return this;
        }

        public TaskSearch addProjectBeneficiaryIdItem(String projectBeneficiaryIdItem) {
            if (this.projectBeneficiaryId == null) {
            this.projectBeneficiaryId = new ArrayList<>();
            }
        this.projectBeneficiaryId.add(projectBeneficiaryIdItem);
        return this;
        }

}
