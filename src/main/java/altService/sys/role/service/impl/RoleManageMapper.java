package altService.sys.role.service.impl;

import java.sql.SQLException;
import java.util.List;

import altService.sys.role.service.RoleManageVO;
import altService.utils.SearchCriteria;

public interface RoleManageMapper {
	
	public void insertRoleManage(RoleManageVO vo) throws SQLException;

	public List<RoleManageVO> selectRoleManageList(SearchCriteria cri) throws SQLException;
	
	public int selectRoleManageListCnt(SearchCriteria cri) throws SQLException;

	public RoleManageVO selectRoleManageDetail(RoleManageVO vo) throws SQLException;

	public void updateRoleManage(RoleManageVO vo) throws SQLException;

	public void deleteRoleManage(String role_code) throws SQLException;
	
}