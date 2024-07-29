package digit.repository.querybuilder;

import digit.web.models.Project;
import digit.web.models.ProjectSearch;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class ProjectQueryBuilder {

    private static final String BASE_QUERY = "SELECT p.id as pid, p.tenantid as ptenantid, p.name as pname, p.projecttype as pprojecttype, p.projectsubtype as pprojectsubtype, p.department as pdepartment, p.description as pdescription, p.referenceid as preferenceid, p.natureofwork as pnatureofwork, p.ancestors as pancestors, p.startdate as pstartdate, p.enddate as penddate, p.istaskenabled as pistaskenabled, p.parent as pparent,  p.rowversion as prowversion, p.createdby as pcreatedby, p.lastmodifiedby as plastmodifiedby, p.createdtime as pcreatedtime, p.lastmodifiedtime as plastmodifiedtime, " +
            "a.id as aid, a.tenantid as atenantid, a.doorno as adoorno, a.latitude as alatitude, a.longitude as alongitude, a.locationaccuracy as alocationaccuracy, a.type as atype, a.addressline1 as aaddressline1, a.addressline2 as aaddressline2, a.landmark as alandmark,  a.city as acity, a.pincode as apincode, a.buildingname as abuildingname, a.street as astreet, a.localitycode as alocalitycode, a.localityname as alocalityname, a.localitylabel as alocalitylabel, a.localitylatitude as alocalitylatitude, a.localitylongitude as alocalitylongitude, " +
            "t.id as tid, t.beneficiarytype as tbeneficiarytype, t.baseline as tbaseline, t.target as ttarget, t.isdeleted as tisdeleted " +
//            "l.child as children " +
            "FROM eg_project p " +
            "LEFT JOIN eg_address a ON p.id = a.projectid " +
            "LEFT JOIN eg_target t ON p.id = t.projectid ";
//            "LEFT JOIN eg_locality_children l ON p.id = l.localityId ";

    private final String ORDER_BY_CREATED_DATE = " ORDER BY p.startdate DESC ";

    public String getProjectSearchQuery(Project criteria, Integer limit, Integer offset, String tenantId, Long lastChangedSince, Boolean includeDeleted, Boolean includeAncestors, Boolean includeDescendants, Long createdFrom, Long createdTo, List<Object> preparedStmtList) {
        StringBuilder query = new StringBuilder(BASE_QUERY);
        query.append(" WHERE p.tenantid = ?");
        preparedStmtList.add(tenantId);

        if (!ObjectUtils.isEmpty(criteria.getStartDate())) {
            query.append(" AND p.startdate >= ? ");
            preparedStmtList.add(criteria.getStartDate());
        }
        if (!ObjectUtils.isEmpty(criteria.getEndDate())) {
            query.append(" AND p.enddate <= ? ");
            preparedStmtList.add(criteria.getEndDate());
        }
        if (!ObjectUtils.isEmpty(criteria.getIsTaskEnabled())) {
            query.append(" AND p.istaskenabled = ? ");
            preparedStmtList.add(criteria.getIsTaskEnabled());
        }
        if (!ObjectUtils.isEmpty(criteria.getParent())) {
            query.append(" AND p.parent = ? ");
            preparedStmtList.add(criteria.getParent());
        }
        if (!ObjectUtils.isEmpty(criteria.getProjectType())) {
            query.append(" AND p.projecttype = ? ");
            preparedStmtList.add(criteria.getProjectType());
        }
        if (!ObjectUtils.isEmpty(criteria.getProjectSubType())) {
            query.append(" AND p.projectsubtype = ? ");
            preparedStmtList.add(criteria.getProjectSubType());
        }
        if (!ObjectUtils.isEmpty(criteria.getDepartment())) {
            query.append(" AND p.department = ? ");
            preparedStmtList.add(criteria.getDepartment());
        }
        if (!ObjectUtils.isEmpty(criteria.getReferenceID())) {
            query.append(" AND p.referenceid = ? ");
            preparedStmtList.add(criteria.getReferenceID());
        }
//        if (!ObjectUtils.isEmpty(criteria.getBoundaryCode())) {
//            query.append(" AND a.boundaryCode = ? ");
//            preparedStmtList.add(criteria.getBoundaryCode());
//        }

        if (lastChangedSince != null) {
            query.append(" AND p.lastmodifiedtime >= ?");
            preparedStmtList.add(lastChangedSince);
        }

        if (includeDeleted != null && includeDeleted) {
            query.append(" AND p.isdeleted = true");
        } else {
            query.append(" AND p.isdeleted = false");
        }

        if (createdFrom != null) {
            query.append(" AND p.createdtime >= ?");
            preparedStmtList.add(createdFrom);
        }

        if (createdTo != null) {
            query.append(" AND p.createdtime <= ?");
            preparedStmtList.add(createdTo);
        }

        // Order by startDate in descending order
        query.append(ORDER_BY_CREATED_DATE);
        query.append(" LIMIT ?");
        preparedStmtList.add(limit);
        query.append(" OFFSET ?");
        preparedStmtList.add(offset);


        return query.toString();
    }
}
