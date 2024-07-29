package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * ProjectFacilityBulkResponse
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectFacilityBulkResponse   {
        @JsonProperty("ResponseInfo")
          @NotNull

          @Valid
                private ResponseInfo responseInfo = null;

        @JsonProperty("ProjectFacilities")
          @Valid
                private List<ProjectFacility> projectFacilities = null;


        public ProjectFacilityBulkResponse addProjectFacilitiesItem(ProjectFacility projectFacilitiesItem) {
            if (this.projectFacilities == null) {
            this.projectFacilities = new ArrayList<>();
            }
        this.projectFacilities.add(projectFacilitiesItem);
        return this;
        }

}
