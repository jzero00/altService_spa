package altService.sys.auth.service;

import java.sql.SQLException;
import java.util.Map;

import altService.utils.SearchCriteria;

public interface AuthManageService {

	public Map<String, Object> getAuthManageList(SearchCriteria cri) throws SQLException;
	
}