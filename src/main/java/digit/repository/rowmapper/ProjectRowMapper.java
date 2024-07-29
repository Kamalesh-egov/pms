package digit.repository.rowmapper;

import digit.web.models.*;
import org.egov.common.contract.models.AuditDetails;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class ProjectRowMapper implements ResultSetExtractor<List<Project>> {

    public List<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<String, Project> projectMap = new LinkedHashMap<>();

        while (rs.next()) {
            String projectId = rs.getString("pid");
            Project project = projectMap.get(projectId);

            if (project == null) {

                Long lastModifiedTime = rs.getLong("plastModifiedTime");
                if (rs.wasNull()) {
                    lastModifiedTime = null;
                }

                AuditDetails auditDetails = AuditDetails.builder()
                        .createdBy(rs.getString("pcreatedBy"))
                        .createdTime(rs.getLong("pcreatedTime"))
                        .lastModifiedBy(rs.getString("plastModifiedBy"))
                        .lastModifiedTime(lastModifiedTime)
                        .build();

                project = Project.builder()
                        .id(rs.getString("pid"))
                        .tenantId(rs.getString("ptenantId"))
                        .name(rs.getString("pname"))
                        .projectType(rs.getString("pprojectType"))
                        .projectSubType(rs.getString("pprojectSubType"))
                        .department(rs.getString("pdepartment"))
                        .description(rs.getString("pdescription"))
                        .referenceID(rs.getString("preferenceID"))
                        .natureOfWork(rs.getString("pnatureOfWork"))
                        .projectHierarchy(rs.getString("pancestors"))
                        .startDate(rs.getLong("pstartDate"))
                        .endDate(rs.getLong("pendDate"))
                        .isTaskEnabled(rs.getBoolean("pisTaskEnabled"))
                        .parent(rs.getString("pparent"))
                        .auditDetails(auditDetails)
                        .rowVersion(rs.getLong("prowVersion"))
                        .build();
            }
            addAddressToProject(rs, project);
            addTargetsToProject(rs, project);
            projectMap.put(projectId, project);
        }
        return new ArrayList<>(projectMap.values());
    }

    private void addAddressToProject(ResultSet rs, Project project) throws SQLException {
        Address address = Address.builder()
                .id(rs.getString("aid"))
                .tenantId(rs.getString("aTenantId"))
                .doorNo(rs.getString("adoorNo"))
                .latitude(rs.getDouble("alatitude"))
                .longitude(rs.getDouble("alongitude"))
                .locationAccuracy(rs.getDouble("alocationAccuracy"))
                .type(rs.getString("atype"))
                .addressLine1(rs.getString("aaddressLine1"))
                .addressLine2(rs.getString("aaddressLine2"))
                .landmark(rs.getString("alandmark"))
                .city(rs.getString("acity"))
                .pincode(rs.getString("apincode"))
                .buildingName(rs.getString("abuildingName"))
                .street(rs.getString("astreet"))
                .locality(Boundary.builder()
                        .code(rs.getString("alocalityCode"))
                        .name(rs.getString("alocalityName"))
                        .label(rs.getString("alocalityLabel"))
                        .latitude(rs.getString("alocalityLatitude"))
                        .longitude(rs.getString("alocalityLongitude"))
                        .build())
                .build();

        project.setAddress(address);
    }

    private void addTargetsToProject(ResultSet rs, Project project) throws SQLException {
        Target target = Target.builder()
                .id(rs.getString("tId"))
                .beneficiaryType(rs.getString("tbeneficiaryType"))
                .baseline(rs.getInt("tbaseline"))
                .target(rs.getInt("ttarget"))
                .build();

        if (project.getTargets() == null) {
            project.setTargets(new ArrayList<>());
        }

        project.getTargets().add(target);
    }
}
