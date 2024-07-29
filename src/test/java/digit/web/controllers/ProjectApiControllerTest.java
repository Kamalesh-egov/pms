package digit.web.controllers;

import digit.web.models.BeneficiaryBulkRequest;
import digit.web.models.BeneficiaryBulkResponse;
import digit.web.models.BeneficiaryRequest;
import digit.web.models.BeneficiaryResponse;
import digit.web.models.BeneficiarySearchRequest;
import digit.web.models.BulkAcceptedResponse;
import digit.web.models.ErrorRes;
import digit.web.models.ProjectFacilityBulkRequest;
import digit.web.models.ProjectFacilityBulkResponse;
import digit.web.models.ProjectFacilityRequest;
import digit.web.models.ProjectFacilityResponse;
import digit.web.models.ProjectFacilitySearchRequest;
import digit.web.models.ProjectRequest;
import digit.web.models.ProjectResourceBulkRequest;
import digit.web.models.ProjectResourceBulkResponse;
import digit.web.models.ProjectResourceRequest;
import digit.web.models.ProjectResourceResponse;
import digit.web.models.ProjectResourceSearchRequest;
import digit.web.models.ProjectResponse;
import digit.web.models.ProjectStaffBulkRequest;
import digit.web.models.ProjectStaffBulkResponse;
import digit.web.models.ProjectStaffRequest;
import digit.web.models.ProjectStaffResponse;
import digit.web.models.ProjectStaffSearchRequest;
import digit.web.models.TaskBulkRequest;
import digit.web.models.TaskBulkResponse;
import digit.web.models.TaskRequest;
import digit.web.models.TaskResponse;
import digit.web.models.TaskSearchRequest;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import digit.TestConfiguration;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* API tests for ProjectApiController
*/
@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(ProjectApiController.class)
@Import(TestConfiguration.class)
public class ProjectApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void projectBeneficiaryV1BulkCreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectBeneficiaryV1BulkCreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectBeneficiaryV1BulkDeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectBeneficiaryV1BulkDeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectBeneficiaryV1BulkUpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectBeneficiaryV1BulkUpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectBeneficiaryV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectBeneficiaryV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectBeneficiaryV1DeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectBeneficiaryV1DeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectBeneficiaryV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectBeneficiaryV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectBeneficiaryV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectBeneficiaryV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/beneficiary/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectFacilityV1BulkCreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/facility/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectFacilityV1BulkCreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/facility/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectFacilityV1BulkDeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/facility/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectFacilityV1BulkDeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/facility/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectFacilityV1BulkUpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/facility/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectFacilityV1BulkUpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/facility/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectFacilityV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/facility/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectFacilityV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/facility/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectFacilityV1DeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/facility/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectFacilityV1DeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/facility/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectFacilityV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/project/facility/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectFacilityV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/project/facility/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectFacilityV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/facility/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectFacilityV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/facility/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectResourceV1BulkCreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/resource/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectResourceV1BulkCreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/resource/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectResourceV1BulkDeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/resource/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectResourceV1BulkDeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/resource/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectResourceV1BulkUpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/resource/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectResourceV1BulkUpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/resource/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectResourceV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/resource/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectResourceV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/resource/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectResourceV1DeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/resource/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectResourceV1DeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/resource/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectResourceV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/project/resource/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectResourceV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/project/resource/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectResourceV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/resource/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectResourceV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/resource/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectStaffV1BulkCreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/staff/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectStaffV1BulkCreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/staff/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectStaffV1BulkDeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/staff/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectStaffV1BulkDeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/staff/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectStaffV1BulkUpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/staff/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectStaffV1BulkUpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/staff/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectStaffV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/staff/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectStaffV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/staff/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectStaffV1DeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/staff/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectStaffV1DeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/staff/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectStaffV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/project/staff/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectStaffV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/project/staff/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectStaffV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/staff/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectStaffV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/staff/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectTaskV1BulkCreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/task/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectTaskV1BulkCreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/task/v1/bulk/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectTaskV1BulkDeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/task/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectTaskV1BulkDeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/task/v1/bulk/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectTaskV1BulkUpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/task/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectTaskV1BulkUpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/task/v1/bulk/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectTaskV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/task/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectTaskV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/task/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectTaskV1DeletePostSuccess() throws Exception {
        mockMvc.perform(post("/project/task/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectTaskV1DeletePostFailure() throws Exception {
        mockMvc.perform(post("/project/task/v1/_delete").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectTaskV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/project/task/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectTaskV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/project/task/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectTaskV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/task/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectTaskV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/task/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/project/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/project/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/project/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void projectV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/project/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void projectV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/project/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

}
