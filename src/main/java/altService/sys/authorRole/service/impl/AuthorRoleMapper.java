package altService.sys.authorRole.service.impl;

import java.sql.SQLException;
import java.util.List;

import altService.sys.authorRole.service.AuthorRoleListDTO;
import altService.sys.authorRole.service.AuthorRoleManageVO;
import altService.utils.SearchCriteria;

public interface AuthorRoleMapper {

	public List<AuthorRoleListDTO> selectAuthorRoleList(SearchCriteria cri) throws SQLException;

	public int selectAuthorRoleListCnt(SearchCriteria cri) throws SQLException;

	public void insertAuthorRole(AuthorRoleManageVO vo) throws SQLException;
	
}