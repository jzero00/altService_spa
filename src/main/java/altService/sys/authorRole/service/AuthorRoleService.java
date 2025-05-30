package altService.sys.authorRole.service;

import java.util.HashMap;
import java.util.Map;

import java.sql.SQLException;

import altService.utils.SearchCriteria;

public interface AuthorRoleService {

	public Map<String, Object> getAuthorRoleManageList(SearchCriteria cri) throws SQLException;

	public void registAuthorRole(HashMap<String, Object> paramMap) throws SQLException;
	
}