package altService.sys.role.service.impl;

import java.sql.SQLException;
import java.util.List;

import altService.sys.role.service.RoleManageVO;
import altService.utils.SearchCriteria;

public interface RoleManageMapper {

	public List<RoleManageVO> selectRoleManageList(SearchCriteria cri) throws SQLException;
	
	public int selectRoleManageListCnt(SearchCriteria cri) throws SQLException;
	
}