package altService.sys.role.service;

import java.sql.SQLException;
import java.util.Map;

import altService.utils.SearchCriteria;

public interface RoleManageService {

	public Map<String, Object> getRoleManageList(SearchCriteria cri) throws SQLException;
	
}