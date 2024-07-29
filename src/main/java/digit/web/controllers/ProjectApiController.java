package digit.web.controllers;


import digit.service.ProjectService;
import digit.util.ResponseInfoFactory;
import digit.web.models.*;
import org.egov.common.contract.response.ResponseInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.*;

    import jakarta.validation.constraints.*;
    import jakarta.validation.Valid;
    import jakarta.servlet.http.HttpServletRequest;
        import java.util.Optional;
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T13:24:26.248936936+05:30[Asia/Kolkata]")
@Controller
@RequestMapping("")
public class ProjectApiController{

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ResponseInfoFactory responseInfoFactory;


    @RequestMapping(value="/project/v1/_create", method = RequestMethod.POST)
    public ResponseEntity<ProjectResponse> projectV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Details for the new Project.", required=true, schema=@Schema()) @Valid @RequestBody ProjectRequest projectRequest) {
        List<Project> projects = projectService.createPtRequest(projectRequest);
        ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(projectRequest.getRequestInfo(), true);
        ProjectResponse response = ProjectResponse.builder().projects(projects).responseInfo(responseInfo).build();

        return new ResponseEntity<ProjectResponse>(response, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/project/v1/_search", method = RequestMethod.POST)
    public ResponseEntity<ProjectResponse> projectV1SearchPost(
            @Parameter(in = ParameterIn.DEFAULT, description = "Details for the project.", required=true, schema=@Schema()) @Valid @RequestBody ProjectRequest body,
            @NotNull @Min(0) @Max(1000) @Parameter(in = ParameterIn.QUERY, description = "Pagination - limit records in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "limit", required = true) Integer limit,
            @NotNull @Min(0)@Parameter(in = ParameterIn.QUERY, description = "Pagination - offset from which records should be returned in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "offset", required = true) Integer offset,
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique id for a tenant." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
            @Parameter(in = ParameterIn.QUERY, description = "epoch of the time since when the changes on the object should be picked up. Search results from this parameter should include both newly created objects since this time as well as any modified objects since this time. This criterion is included to help polling clients to get the changes in system since a last time they synchronized with the platform. " ,schema=@Schema()) @Valid @RequestParam(value = "lastChangedSince", required = false) Long lastChangedSince,
            @Parameter(in = ParameterIn.QUERY, description = "Used in search APIs to specify if (soft) deleted records should be included in search results." ,schema=@Schema()) @Valid @RequestParam(value = "includeDeleted", required = false) Boolean includeDeleted,
            @Parameter(in = ParameterIn.QUERY, description = "Used in project search API to specify if response should include project elements that are in the preceding hierarchy of matched projects." ,schema=@Schema()) @Valid @RequestParam(value = "includeAncestors", required = false) Boolean includeAncestors,
            @Parameter(in = ParameterIn.QUERY, description = "Used in project search API to specify if response should include project elements that are in the following hierarchy of matched projects." ,schema=@Schema()) @Valid @RequestParam(value = "includeDescendants", required = false) Boolean includeDescendants,
            @Parameter(in = ParameterIn.QUERY, description = "Used in project search API to limit the search results to only those projects whose creation date is after the specified 'createdFrom' date. " ,schema=@Schema()) @Valid @RequestParam(value = "createdFrom", required = false) Long createdFrom,
            @Parameter(in = ParameterIn.QUERY, description = "Used in project search API to limit the search results to only those projects whose creation date is before the specified 'createdTo' date. " ,schema=@Schema()) @Valid @RequestParam(value = "createdTo", required = false) Long createdTo) {

        List<Project> projects = projectService.searchProjects(body.getRequestInfo(), body.getProjects(), limit, offset, tenantId, lastChangedSince, includeDeleted, includeAncestors, includeDescendants, createdFrom, createdTo);
        ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(body.getRequestInfo(), true);

        ProjectResponse response = ProjectResponse.builder()
                .projects(projects)
                .responseInfo(responseInfo)
                .build();

        return new ResponseEntity<ProjectResponse>(response, HttpStatus.OK);
    }

//    @RequestMapping(value="/project/v1/_create", method = RequestMethod.POST)
//    public ResponseEntity<ProjectResponse> projectV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Details for the new Project.", required=true, schema=@Schema()) @Valid @RequestBody ProjectRequest projectRequest) {
//                        String accept = request.getHeader("Accept");
//                        if (accept != null && accept.contains("application/json")) {
//                            try {
//
//                            return new ResponseEntity<ProjectResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Projects\" : [ {    \"parent\" : \"parent\",    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"rowVersion\" : 4,    \"endDate\" : 2,    \"projectNumber\" : \"PR/2022-23/010\",    \"projectType\" : \"projectType\",    \"description\" : \"description\",    \"projectSubType\" : \"projectSubType\",    \"additionalDetails\" : { },    \"targets\" : [ {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    }, {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    } ],    \"referenceID\" : \"referenceID\",    \"natureOfWork\" : \"natureOfWork\",    \"tenantId\" : \"tenantA\",    \"name\" : \"name\",    \"projectHierarchy\" : \"projectHierarchy\",    \"id\" : \"id\",    \"department\" : \"department\",    \"startDate\" : 5,    \"isTaskEnabled\" : false  }, {    \"parent\" : \"parent\",    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"rowVersion\" : 4,    \"endDate\" : 2,    \"projectNumber\" : \"PR/2022-23/010\",    \"projectType\" : \"projectType\",    \"description\" : \"description\",    \"projectSubType\" : \"projectSubType\",    \"additionalDetails\" : { },    \"targets\" : [ {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    }, {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    } ],    \"referenceID\" : \"referenceID\",    \"natureOfWork\" : \"natureOfWork\",    \"tenantId\" : \"tenantA\",    \"name\" : \"name\",    \"projectHierarchy\" : \"projectHierarchy\",    \"id\" : \"id\",    \"department\" : \"department\",    \"startDate\" : 5,    \"isTaskEnabled\" : false  } ]}", ProjectResponse.class), HttpStatus.NOT_IMPLEMENTED);
//                            } catch (IOException e) {
//                            return new ResponseEntity<ProjectResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//                            }
//                        }
//
//        return new ResponseEntity<ProjectResponse>(HttpStatus.ACCEPTED);
//    }
//
//    @RequestMapping(value="/project/v1/_search", method = RequestMethod.POST)
//    public ResponseEntity<ProjectResponse> projectV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "Details for the project.", required=true, schema=@Schema()) @Valid @RequestBody ProjectRequest body,@NotNull @Min(0) @Max(1000) @Parameter(in = ParameterIn.QUERY, description = "Pagination - limit records in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "limit", required = true) Integer limit,@NotNull @Min(0)@Parameter(in = ParameterIn.QUERY, description = "Pagination - offset from which records should be returned in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "offset", required = true) Integer offset,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique id for a tenant." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,@Parameter(in = ParameterIn.QUERY, description = "epoch of the time since when the changes on the object should be picked up. Search results from this parameter should include both newly created objects since this time as well as any modified objects since this time. This criterion is included to help polling clients to get the changes in system since a last time they synchronized with the platform. " ,schema=@Schema()) @Valid @RequestParam(value = "lastChangedSince", required = false) Long lastChangedSince,@Parameter(in = ParameterIn.QUERY, description = "Used in search APIs to specify if (soft) deleted records should be included in search results." ,schema=@Schema()) @Valid @RequestParam(value = "includeDeleted", required = false) Boolean includeDeleted,@Parameter(in = ParameterIn.QUERY, description = "Used in project search API to specify if response should include project elements that are in the preceding hierarchy of matched projects." ,schema=@Schema()) @Valid @RequestParam(value = "includeAncestors", required = false) Boolean includeAncestors,@Parameter(in = ParameterIn.QUERY, description = "Used in project search API to specify if response should include project elements that are in the following hierarchy of matched projects." ,schema=@Schema()) @Valid @RequestParam(value = "includeDescendants", required = false) Boolean includeDescendants,@Parameter(in = ParameterIn.QUERY, description = "Used in project search API to limit the search results to only those projects whose creation date is after the specified 'createdFrom' date. " ,schema=@Schema()) @Valid @RequestParam(value = "createdFrom", required = false) Long createdFrom,@Parameter(in = ParameterIn.QUERY, description = "Used in project search API to limit the search results to only those projects whose creation date is before the specified 'createdTo' date. " ,schema=@Schema()) @Valid @RequestParam(value = "createdTo", required = false) Long createdTo) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<ProjectResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Projects\" : [ {    \"parent\" : \"parent\",    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"rowVersion\" : 4,    \"endDate\" : 2,    \"projectNumber\" : \"PR/2022-23/010\",    \"projectType\" : \"projectType\",    \"description\" : \"description\",    \"projectSubType\" : \"projectSubType\",    \"additionalDetails\" : { },    \"targets\" : [ {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    }, {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    } ],    \"referenceID\" : \"referenceID\",    \"natureOfWork\" : \"natureOfWork\",    \"tenantId\" : \"tenantA\",    \"name\" : \"name\",    \"projectHierarchy\" : \"projectHierarchy\",    \"id\" : \"id\",    \"department\" : \"department\",    \"startDate\" : 5,    \"isTaskEnabled\" : false  }, {    \"parent\" : \"parent\",    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"rowVersion\" : 4,    \"endDate\" : 2,    \"projectNumber\" : \"PR/2022-23/010\",    \"projectType\" : \"projectType\",    \"description\" : \"description\",    \"projectSubType\" : \"projectSubType\",    \"additionalDetails\" : { },    \"targets\" : [ {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    }, {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    } ],    \"referenceID\" : \"referenceID\",    \"natureOfWork\" : \"natureOfWork\",    \"tenantId\" : \"tenantA\",    \"name\" : \"name\",    \"projectHierarchy\" : \"projectHierarchy\",    \"id\" : \"id\",    \"department\" : \"department\",    \"startDate\" : 5,    \"isTaskEnabled\" : false  } ]}", ProjectResponse.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                return new ResponseEntity<ProjectResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<ProjectResponse>(HttpStatus.NOT_IMPLEMENTED);
//    }

                @RequestMapping(value="/project/beneficiary/v1/bulk/_create", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectBeneficiaryV1BulkCreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of beneficiary type.", required=true, schema=@Schema()) @Valid @RequestBody BeneficiaryBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/beneficiary/v1/bulk/_delete", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectBeneficiaryV1BulkDeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Project Beneficiary Registration.", required=true, schema=@Schema()) @Valid @RequestBody BeneficiaryBulkRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/beneficiary/v1/bulk/_update", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectBeneficiaryV1BulkUpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Project Beneficiary Registration.", required=true, schema=@Schema()) @Valid @RequestBody BeneficiaryBulkRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/beneficiary/v1/_create", method = RequestMethod.POST)
                public ResponseEntity<BeneficiaryResponse> projectBeneficiaryV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of benificiary type.", required=true, schema=@Schema()) @Valid @RequestBody BeneficiaryRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BeneficiaryResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectBeneficiary\" : {    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"dateOfRegistration\" : 1663218161,    \"beneficiaryClientReferenceId\" : \"beneficiaryClientReferenceId\",    \"id\" : \"id\",    \"tag\" : \"tag\",    \"clientReferenceId\" : \"clientReferenceId\",    \"projectId\" : \"projectId\",    \"beneficiaryId\" : \"beneficiaryId\"  }}", BeneficiaryResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BeneficiaryResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BeneficiaryResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/beneficiary/v1/_delete", method = RequestMethod.POST)
                public ResponseEntity<BeneficiaryResponse> projectBeneficiaryV1DeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Soft Delete Project Beneficiary Registration.", required=true, schema=@Schema()) @Valid @RequestBody BeneficiaryRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BeneficiaryResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectBeneficiary\" : {    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"dateOfRegistration\" : 1663218161,    \"beneficiaryClientReferenceId\" : \"beneficiaryClientReferenceId\",    \"id\" : \"id\",    \"tag\" : \"tag\",    \"clientReferenceId\" : \"clientReferenceId\",    \"projectId\" : \"projectId\",    \"beneficiaryId\" : \"beneficiaryId\"  }}", BeneficiaryResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BeneficiaryResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BeneficiaryResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/beneficiary/v1/_search", method = RequestMethod.POST)
                public ResponseEntity<BeneficiaryBulkResponse> projectBeneficiaryV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "Project Beneficiary Search.", required=true, schema=@Schema()) @Valid @RequestBody BeneficiarySearchRequest body,@NotNull @Min(0) @Max(1000) @Parameter(in = ParameterIn.QUERY, description = "Pagination - limit records in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "limit", required = true) Integer limit,@NotNull @Min(0)@Parameter(in = ParameterIn.QUERY, description = "Pagination - offset from which records should be returned in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "offset", required = true) Integer offset,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique id for a tenant." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,@Parameter(in = ParameterIn.QUERY, description = "epoch of the time since when the changes on the object should be picked up. Search results from this parameter should include both newly created objects since this time as well as any modified objects since this time. This criterion is included to help polling clients to get the changes in system since a last time they synchronized with the platform. " ,schema=@Schema()) @Valid @RequestParam(value = "lastChangedSince", required = false) Long lastChangedSince,@Parameter(in = ParameterIn.QUERY, description = "Used in search APIs to specify if (soft) deleted records should be included in search results." ,schema=@Schema()) @Valid @RequestParam(value = "includeDeleted", required = false) Boolean includeDeleted) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BeneficiaryBulkResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectBeneficiaries\" : [ {    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"dateOfRegistration\" : 1663218161,    \"beneficiaryClientReferenceId\" : \"beneficiaryClientReferenceId\",    \"id\" : \"id\",    \"tag\" : \"tag\",    \"clientReferenceId\" : \"clientReferenceId\",    \"projectId\" : \"projectId\",    \"beneficiaryId\" : \"beneficiaryId\"  }, {    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"dateOfRegistration\" : 1663218161,    \"beneficiaryClientReferenceId\" : \"beneficiaryClientReferenceId\",    \"id\" : \"id\",    \"tag\" : \"tag\",    \"clientReferenceId\" : \"clientReferenceId\",    \"projectId\" : \"projectId\",    \"beneficiaryId\" : \"beneficiaryId\"  } ]}", BeneficiaryBulkResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BeneficiaryBulkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BeneficiaryBulkResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/beneficiary/v1/_update", method = RequestMethod.POST)
                public ResponseEntity<BeneficiaryResponse> projectBeneficiaryV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Project Beneficiary Registration.", required=true, schema=@Schema()) @Valid @RequestBody BeneficiaryRequest body,@Parameter(in = ParameterIn.QUERY, description = "Client can specify if the resource in request body needs to be sent back in the response. This is being used to limit amount of data that needs to flow back from the server to the client in low bandwidth scenarios. Server will always send the server generated id for validated requests." ,schema=@Schema()) @Valid @RequestParam(value = "echoResource", required = false) Boolean echoResource) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BeneficiaryResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectBeneficiary\" : {    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"dateOfRegistration\" : 1663218161,    \"beneficiaryClientReferenceId\" : \"beneficiaryClientReferenceId\",    \"id\" : \"id\",    \"tag\" : \"tag\",    \"clientReferenceId\" : \"clientReferenceId\",    \"projectId\" : \"projectId\",    \"beneficiaryId\" : \"beneficiaryId\"  }}", BeneficiaryResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BeneficiaryResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BeneficiaryResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/facility/v1/bulk/_create", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectFacilityV1BulkCreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and facility.", required=true, schema=@Schema()) @Valid @RequestBody ProjectFacilityBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/facility/v1/bulk/_delete", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectFacilityV1BulkDeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and facility.", required=true, schema=@Schema()) @Valid @RequestBody ProjectFacilityBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/facility/v1/bulk/_update", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectFacilityV1BulkUpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and facility.", required=true, schema=@Schema()) @Valid @RequestBody ProjectFacilityBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/facility/v1/_create", method = RequestMethod.POST)
                public ResponseEntity<ProjectFacilityResponse> projectFacilityV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and facility.", required=true, schema=@Schema()) @Valid @RequestBody ProjectFacilityRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectFacilityResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectFacility\" : {    \"facilityId\" : \"facilityId\",    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\"  }}", ProjectFacilityResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectFacilityResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectFacilityResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/facility/v1/_delete", method = RequestMethod.POST)
                public ResponseEntity<ProjectFacilityResponse> projectFacilityV1DeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and facility.", required=true, schema=@Schema()) @Valid @RequestBody ProjectFacilityRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectFacilityResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectFacility\" : {    \"facilityId\" : \"facilityId\",    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\"  }}", ProjectFacilityResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectFacilityResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectFacilityResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/facility/v1/_search", method = RequestMethod.POST)
                public ResponseEntity<ProjectFacilityBulkResponse> projectFacilityV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and facility.", required=true, schema=@Schema()) @Valid @RequestBody ProjectFacilitySearchRequest body,@NotNull @Min(0) @Max(1000) @Parameter(in = ParameterIn.QUERY, description = "Pagination - limit records in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "limit", required = true) Integer limit,@NotNull @Min(0)@Parameter(in = ParameterIn.QUERY, description = "Pagination - offset from which records should be returned in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "offset", required = true) Integer offset,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique id for a tenant." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,@Parameter(in = ParameterIn.QUERY, description = "epoch of the time since when the changes on the object should be picked up. Search results from this parameter should include both newly created objects since this time as well as any modified objects since this time. This criterion is included to help polling clients to get the changes in system since a last time they synchronized with the platform. " ,schema=@Schema()) @Valid @RequestParam(value = "lastChangedSince", required = false) Long lastChangedSince,@Parameter(in = ParameterIn.QUERY, description = "Used in search APIs to specify if (soft) deleted records should be included in search results." ,schema=@Schema()) @Valid @RequestParam(value = "includeDeleted", required = false) Boolean includeDeleted) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectFacilityBulkResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectFacilities\" : [ {    \"facilityId\" : \"facilityId\",    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\"  }, {    \"facilityId\" : \"facilityId\",    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\"  } ]}", ProjectFacilityBulkResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectFacilityBulkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectFacilityBulkResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/facility/v1/_update", method = RequestMethod.POST)
                public ResponseEntity<ProjectFacilityResponse> projectFacilityV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and facility.", required=true, schema=@Schema()) @Valid @RequestBody ProjectFacilityRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectFacilityResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectFacility\" : {    \"facilityId\" : \"facilityId\",    \"isDeleted\" : true,    \"rowVersion\" : 0,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\"  }}", ProjectFacilityResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectFacilityResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectFacilityResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/resource/v1/bulk/_create", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectResourceV1BulkCreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and resources.", required=true, schema=@Schema()) @Valid @RequestBody ProjectResourceBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/resource/v1/bulk/_delete", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectResourceV1BulkDeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Delete linkage of Project and Resource.", required=true, schema=@Schema()) @Valid @RequestBody ProjectResourceBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/resource/v1/bulk/_update", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectResourceV1BulkUpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and Resource.", required=true, schema=@Schema()) @Valid @RequestBody ProjectResourceBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/resource/v1/_create", method = RequestMethod.POST)
                public ResponseEntity<ProjectResourceResponse> projectResourceV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and resources.", required=true, schema=@Schema()) @Valid @RequestBody ProjectResourceRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectResourceResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectResource\" : {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"resource\" : {      \"productVariantId\" : \"productVariantId\",      \"isBaseUnitVariant\" : true,      \"type\" : \"type\"    },    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  }}", ProjectResourceResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectResourceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectResourceResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/resource/v1/_delete", method = RequestMethod.POST)
                public ResponseEntity<ProjectResourceResponse> projectResourceV1DeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Delete linkage of Project and Resource.", required=true, schema=@Schema()) @Valid @RequestBody ProjectResourceRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectResourceResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectResource\" : {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"resource\" : {      \"productVariantId\" : \"productVariantId\",      \"isBaseUnitVariant\" : true,      \"type\" : \"type\"    },    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  }}", ProjectResourceResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectResourceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectResourceResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/resource/v1/_search", method = RequestMethod.POST)
                public ResponseEntity<ProjectResourceBulkResponse> projectResourceV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "Search linkage of Project and resource.", required=true, schema=@Schema()) @Valid @RequestBody ProjectResourceSearchRequest body,@NotNull @Min(0) @Max(1000) @Parameter(in = ParameterIn.QUERY, description = "Pagination - limit records in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "limit", required = true) Integer limit,@NotNull @Min(0)@Parameter(in = ParameterIn.QUERY, description = "Pagination - offset from which records should be returned in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "offset", required = true) Integer offset,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique id for a tenant." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,@Parameter(in = ParameterIn.QUERY, description = "epoch of the time since when the changes on the object should be picked up. Search results from this parameter should include both newly created objects since this time as well as any modified objects since this time. This criterion is included to help polling clients to get the changes in system since a last time they synchronized with the platform. " ,schema=@Schema()) @Valid @RequestParam(value = "lastChangedSince", required = false) Long lastChangedSince,@Parameter(in = ParameterIn.QUERY, description = "Used in search APIs to specify if (soft) deleted records should be included in search results." ,schema=@Schema()) @Valid @RequestParam(value = "includeDeleted", required = false) Boolean includeDeleted) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectResourceBulkResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectResources\" : [ {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"resource\" : {      \"productVariantId\" : \"productVariantId\",      \"isBaseUnitVariant\" : true,      \"type\" : \"type\"    },    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  }, {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"resource\" : {      \"productVariantId\" : \"productVariantId\",      \"isBaseUnitVariant\" : true,      \"type\" : \"type\"    },    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  } ]}", ProjectResourceBulkResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectResourceBulkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectResourceBulkResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/resource/v1/_update", method = RequestMethod.POST)
                public ResponseEntity<ProjectResourceResponse> projectResourceV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and Resource.", required=true, schema=@Schema()) @Valid @RequestBody ProjectResourceRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectResourceResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectResource\" : {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"resource\" : {      \"productVariantId\" : \"productVariantId\",      \"isBaseUnitVariant\" : true,      \"type\" : \"type\"    },    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  }}", ProjectResourceResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectResourceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectResourceResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/staff/v1/bulk/_create", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectStaffV1BulkCreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and staff users.", required=true, schema=@Schema()) @Valid @RequestBody ProjectStaffBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/staff/v1/bulk/_delete", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectStaffV1BulkDeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and staff user.", required=true, schema=@Schema()) @Valid @RequestBody ProjectStaffBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/staff/v1/bulk/_update", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectStaffV1BulkUpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and staff user.", required=true, schema=@Schema()) @Valid @RequestBody ProjectStaffBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/staff/v1/_create", method = RequestMethod.POST)
                public ResponseEntity<ProjectStaffResponse> projectStaffV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and staff user.", required=true, schema=@Schema()) @Valid @RequestBody ProjectStaffRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectStaffResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectStaff\" : {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"channel\" : \"channel\",    \"id\" : \"id\",    \"userId\" : \"userId\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  }}", ProjectStaffResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectStaffResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectStaffResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/staff/v1/_delete", method = RequestMethod.POST)
                public ResponseEntity<ProjectStaffResponse> projectStaffV1DeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and staff user.", required=true, schema=@Schema()) @Valid @RequestBody ProjectStaffRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectStaffResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectStaff\" : {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"channel\" : \"channel\",    \"id\" : \"id\",    \"userId\" : \"userId\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  }}", ProjectStaffResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectStaffResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectStaffResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/staff/v1/_search", method = RequestMethod.POST)
                public ResponseEntity<ProjectStaffBulkResponse> projectStaffV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and staff user.", required=true, schema=@Schema()) @Valid @RequestBody ProjectStaffSearchRequest body,@NotNull @Min(0) @Max(1000) @Parameter(in = ParameterIn.QUERY, description = "Pagination - limit records in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "limit", required = true) Integer limit,@NotNull @Min(0)@Parameter(in = ParameterIn.QUERY, description = "Pagination - offset from which records should be returned in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "offset", required = true) Integer offset,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique id for a tenant." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,@Parameter(in = ParameterIn.QUERY, description = "epoch of the time since when the changes on the object should be picked up. Search results from this parameter should include both newly created objects since this time as well as any modified objects since this time. This criterion is included to help polling clients to get the changes in system since a last time they synchronized with the platform. " ,schema=@Schema()) @Valid @RequestParam(value = "lastChangedSince", required = false) Long lastChangedSince,@Parameter(in = ParameterIn.QUERY, description = "Used in search APIs to specify if (soft) deleted records should be included in search results." ,schema=@Schema()) @Valid @RequestParam(value = "includeDeleted", required = false) Boolean includeDeleted) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectStaffBulkResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectStaff\" : [ {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"channel\" : \"channel\",    \"id\" : \"id\",    \"userId\" : \"userId\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  }, {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"channel\" : \"channel\",    \"id\" : \"id\",    \"userId\" : \"userId\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  } ]}", ProjectStaffBulkResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectStaffBulkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectStaffBulkResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/staff/v1/_update", method = RequestMethod.POST)
                public ResponseEntity<ProjectStaffResponse> projectStaffV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture linkage of Project and staff user.", required=true, schema=@Schema()) @Valid @RequestBody ProjectStaffRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectStaffResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"ProjectStaff\" : {    \"isDeleted\" : true,    \"rowVersion\" : 1,    \"endDate\" : 6,    \"auditDetails\" : {      \"lastModifiedTime\" : 2,      \"createdBy\" : \"createdBy\",      \"lastModifiedBy\" : \"lastModifiedBy\",      \"createdTime\" : 3    },    \"tenantId\" : \"tenantA\",    \"channel\" : \"channel\",    \"id\" : \"id\",    \"userId\" : \"userId\",    \"projectId\" : \"projectId\",    \"startDate\" : 0  }}", ProjectStaffResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectStaffResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectStaffResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/task/v1/bulk/_create", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectTaskV1BulkCreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of Task", required=true, schema=@Schema()) @Valid @RequestBody TaskBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/task/v1/bulk/_delete", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectTaskV1BulkDeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of Existing task", required=true, schema=@Schema()) @Valid @RequestBody TaskBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/task/v1/bulk/_update", method = RequestMethod.POST)
                public ResponseEntity<BulkAcceptedResponse> projectTaskV1BulkUpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of Existing tasks", required=true, schema=@Schema()) @Valid @RequestBody TaskBulkRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<BulkAcceptedResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  }}", BulkAcceptedResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<BulkAcceptedResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/task/v1/_create", method = RequestMethod.POST)
                public ResponseEntity<TaskResponse> projectTaskV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of Task", required=true, schema=@Schema()) @Valid @RequestBody TaskRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<TaskResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Task\" : {    \"actualEndDate\" : 5,    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 2,    \"projectBeneficiaryClientReferenceId\" : \"R-ID-1\",    \"resources\" : [ {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    }, {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    } ],    \"clientReferenceId\" : \"clientReferenceId\",    \"plannedEndDate\" : 1,    \"projectBeneficiaryId\" : \"R-ID-1\",    \"createdDate\" : 1663218161,    \"plannedStartDate\" : 6,    \"createdBy\" : \"UUID\",    \"tenantId\" : \"tenantA\",    \"actualStartDate\" : 5,    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"status\" : \"DELIVERED\"  }}", TaskResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<TaskResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<TaskResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/task/v1/_delete", method = RequestMethod.POST)
                public ResponseEntity<TaskResponse> projectTaskV1DeletePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of Existing task", required=true, schema=@Schema()) @Valid @RequestBody TaskRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<TaskResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Task\" : {    \"actualEndDate\" : 5,    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 2,    \"projectBeneficiaryClientReferenceId\" : \"R-ID-1\",    \"resources\" : [ {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    }, {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    } ],    \"clientReferenceId\" : \"clientReferenceId\",    \"plannedEndDate\" : 1,    \"projectBeneficiaryId\" : \"R-ID-1\",    \"createdDate\" : 1663218161,    \"plannedStartDate\" : 6,    \"createdBy\" : \"UUID\",    \"tenantId\" : \"tenantA\",    \"actualStartDate\" : 5,    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"status\" : \"DELIVERED\"  }}", TaskResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<TaskResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<TaskResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/task/v1/_search", method = RequestMethod.POST)
                public ResponseEntity<TaskBulkResponse> projectTaskV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "Project Task Search.", required=true, schema=@Schema()) @Valid @RequestBody TaskSearchRequest body,@NotNull @Min(0) @Max(1000) @Parameter(in = ParameterIn.QUERY, description = "Pagination - limit records in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "limit", required = true) Integer limit,@NotNull @Min(0)@Parameter(in = ParameterIn.QUERY, description = "Pagination - offset from which records should be returned in response" ,required=true,schema=@Schema(allowableValues="")) @Valid @RequestParam(value = "offset", required = true) Integer offset,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Unique id for a tenant." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "tenantId", required = true) String tenantId,@Parameter(in = ParameterIn.QUERY, description = "epoch of the time since when the changes on the object should be picked up. Search results from this parameter should include both newly created objects since this time as well as any modified objects since this time. This criterion is included to help polling clients to get the changes in system since a last time they synchronized with the platform. " ,schema=@Schema()) @Valid @RequestParam(value = "lastChangedSince", required = false) Long lastChangedSince,@Parameter(in = ParameterIn.QUERY, description = "Used in search APIs to specify if (soft) deleted records should be included in search results." ,schema=@Schema()) @Valid @RequestParam(value = "includeDeleted", required = false) Boolean includeDeleted) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<TaskBulkResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Tasks\" : [ {    \"actualEndDate\" : 5,    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 2,    \"projectBeneficiaryClientReferenceId\" : \"R-ID-1\",    \"resources\" : [ {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    }, {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    } ],    \"clientReferenceId\" : \"clientReferenceId\",    \"plannedEndDate\" : 1,    \"projectBeneficiaryId\" : \"R-ID-1\",    \"createdDate\" : 1663218161,    \"plannedStartDate\" : 6,    \"createdBy\" : \"UUID\",    \"tenantId\" : \"tenantA\",    \"actualStartDate\" : 5,    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"status\" : \"DELIVERED\"  }, {    \"actualEndDate\" : 5,    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 2,    \"projectBeneficiaryClientReferenceId\" : \"R-ID-1\",    \"resources\" : [ {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    }, {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    } ],    \"clientReferenceId\" : \"clientReferenceId\",    \"plannedEndDate\" : 1,    \"projectBeneficiaryId\" : \"R-ID-1\",    \"createdDate\" : 1663218161,    \"plannedStartDate\" : 6,    \"createdBy\" : \"UUID\",    \"tenantId\" : \"tenantA\",    \"actualStartDate\" : 5,    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"status\" : \"DELIVERED\"  } ]}", TaskBulkResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<TaskBulkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<TaskBulkResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

                @RequestMapping(value="/project/task/v1/_update", method = RequestMethod.POST)
                public ResponseEntity<TaskResponse> projectTaskV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Capture details of Existing task", required=true, schema=@Schema()) @Valid @RequestBody TaskRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<TaskResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Task\" : {    \"actualEndDate\" : 5,    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"additionalFields\" : {      \"schema\" : \"HOUSEHOLD\",      \"fields\" : [ {        \"value\" : \"180\",        \"key\" : \"height\"      }, {        \"value\" : \"180\",        \"key\" : \"height\"      } ],      \"version\" : 2    },    \"rowVersion\" : 2,    \"projectBeneficiaryClientReferenceId\" : \"R-ID-1\",    \"resources\" : [ {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    }, {      \"isDelivered\" : true,      \"quantity\" : 0,      \"productVariantId\" : \"ID-1\",      \"isDeleted\" : true,      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"deliveryComment\" : \"deliveryComment\",      \"id\" : \"id\"    } ],    \"clientReferenceId\" : \"clientReferenceId\",    \"plannedEndDate\" : 1,    \"projectBeneficiaryId\" : \"R-ID-1\",    \"createdDate\" : 1663218161,    \"plannedStartDate\" : 6,    \"createdBy\" : \"UUID\",    \"tenantId\" : \"tenantA\",    \"actualStartDate\" : 5,    \"id\" : \"id\",    \"projectId\" : \"projectId\",    \"status\" : \"DELIVERED\"  }}", TaskResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<TaskResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<TaskResponse>(HttpStatus.NOT_IMPLEMENTED);
                }


                @RequestMapping(value="/project/v1/_update", method = RequestMethod.POST)
                public ResponseEntity<ProjectResponse> projectV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "Details for the new Project.", required=true, schema=@Schema()) @Valid @RequestBody ProjectRequest body) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                            return new ResponseEntity<ProjectResponse>(objectMapper.readValue("{  \"ResponseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"Projects\" : [ {    \"parent\" : \"parent\",    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"rowVersion\" : 4,    \"endDate\" : 2,    \"projectNumber\" : \"PR/2022-23/010\",    \"projectType\" : \"projectType\",    \"description\" : \"description\",    \"projectSubType\" : \"projectSubType\",    \"additionalDetails\" : { },    \"targets\" : [ {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    }, {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    } ],    \"referenceID\" : \"referenceID\",    \"natureOfWork\" : \"natureOfWork\",    \"tenantId\" : \"tenantA\",    \"name\" : \"name\",    \"projectHierarchy\" : \"projectHierarchy\",    \"id\" : \"id\",    \"department\" : \"department\",    \"startDate\" : 5,    \"isTaskEnabled\" : false  }, {    \"parent\" : \"parent\",    \"address\" : {      \"locationAccuracy\" : 5962.133916683182,      \"pincode\" : \"pincode\",      \"city\" : \"city\",      \"latitude\" : 18.494211295267263,      \"locality\" : {        \"code\" : \"code\",        \"materializedPath\" : \"materializedPath\",        \"children\" : [ null, null ],        \"latitude\" : \"latitude\",        \"name\" : \"name\",        \"label\" : \"label\",        \"longitude\" : \"longitude\"      },      \"type\" : \"type\",      \"buildingName\" : \"buildingName\",      \"street\" : \"street\",      \"tenantId\" : \"tenantA\",      \"addressLine1\" : \"addressLine1\",      \"addressLine2\" : \"addressLine2\",      \"id\" : \"id\",      \"doorNo\" : \"doorNo\",      \"landmark\" : \"landmark\",      \"longitude\" : -127.23073270189397    },    \"rowVersion\" : 4,    \"endDate\" : 2,    \"projectNumber\" : \"PR/2022-23/010\",    \"projectType\" : \"projectType\",    \"description\" : \"description\",    \"projectSubType\" : \"projectSubType\",    \"additionalDetails\" : { },    \"targets\" : [ {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    }, {      \"isDeleted\" : true,      \"beneficiaryType\" : \"HOUSEHOLD\",      \"auditDetails\" : {        \"lastModifiedTime\" : 2,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 3      },      \"id\" : \"id\",      \"baseline\" : 7,      \"target\" : 9    } ],    \"referenceID\" : \"referenceID\",    \"natureOfWork\" : \"natureOfWork\",    \"tenantId\" : \"tenantA\",    \"name\" : \"name\",    \"projectHierarchy\" : \"projectHierarchy\",    \"id\" : \"id\",    \"department\" : \"department\",    \"startDate\" : 5,    \"isTaskEnabled\" : false  } ]}", ProjectResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (IOException e) {
                            return new ResponseEntity<ProjectResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<ProjectResponse>(HttpStatus.NOT_IMPLEMENTED);
                }

        }
