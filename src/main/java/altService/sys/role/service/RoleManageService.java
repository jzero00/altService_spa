package altService.sys.role.service;

import java.sql.SQLException;
import java.util.Map;

import altService.utils.SearchCriteria;

public interface RoleManageService {
	
	public void registRoleManage(Map<String, Object> paramMap) throws SQLException;

	public Map<String, Object> getRoleManageList(SearchCriteria cri) throws SQLException;

	public RoleManageVO getRoleManageDetail(RoleManageVO vo) throws SQLException;

	public void modifyRoleManage(Map<String, Object> paramMap) throws SQLException;
	
}