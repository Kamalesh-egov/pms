package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * ProjectStaffBulkRequest
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectStaffBulkRequest   {
        @JsonProperty("RequestInfo")
          @NotNull

          @Valid
                private RequestInfo requestInfo = null;

        @JsonProperty("ProjectStaff")
          @NotNull
          @Valid
        @Size(min=1)         private List<ProjectStaff> projectStaff = new ArrayList<>();


        public ProjectStaffBulkRequest addProjectStaffItem(ProjectStaff projectStaffItem) {
        this.projectStaff.add(projectStaffItem);
        return this;
        }

}
