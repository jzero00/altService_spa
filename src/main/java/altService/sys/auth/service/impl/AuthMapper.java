package altService.sys.auth.service.impl;

import java.sql.SQLException;
import java.util.List;

import altService.sys.auth.service.AuthManageVO;
import altService.utils.SearchCriteria;

public interface AuthMapper {

	public List<AuthManageVO> selectAuthManageList(SearchCriteria cri) throws SQLException;

	public int selectAuthManageListCnt(SearchCriteria cri) throws SQLException;

}