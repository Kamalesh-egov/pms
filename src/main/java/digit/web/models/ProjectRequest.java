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
 * ProjectRequest
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequest   {
        @JsonProperty("RequestInfo")
          @NotNull

          @Valid
                private RequestInfo requestInfo = null;

        @JsonProperty("Projects")
          @Valid
        @Size(min=1)         private List<Project> projects = null;

        @JsonProperty("apiOperation")

          @Valid
                private ApiOperation apiOperation = null;


        public ProjectRequest addProjectsItem(Project projectsItem) {
            if (this.projects == null) {
            this.projects = new ArrayList<>();
            }
        this.projects.add(projectsItem);
        return this;
        }

}
