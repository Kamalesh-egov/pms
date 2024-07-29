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
 * Search model for project beneficiary.
 */
@Schema(description = "Search model for project beneficiary.")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectBeneficiarySearch   {
        @JsonProperty("id")

          @Valid
                private IdForSearch id = null;

        @JsonProperty("clientReferenceId")

          @Valid
                private ClientReferenceIdForSearch clientReferenceId = null;

        @JsonProperty("projectId")

                private List<String> projectId = null;

        @JsonProperty("beneficiaryId")

                private List<String> beneficiaryId = null;

        @JsonProperty("dateOfRegistration")

                private Long dateOfRegistration = null;


        public ProjectBeneficiarySearch addProjectIdItem(String projectIdItem) {
            if (this.projectId == null) {
            this.projectId = new ArrayList<>();
            }
        this.projectId.add(projectIdItem);
        return this;
        }

        public ProjectBeneficiarySearch addBeneficiaryIdItem(String beneficiaryIdItem) {
            if (this.beneficiaryId == null) {
            this.beneficiaryId = new ArrayList<>();
            }
        this.beneficiaryId.add(beneficiaryIdItem);
        return this;
        }

}