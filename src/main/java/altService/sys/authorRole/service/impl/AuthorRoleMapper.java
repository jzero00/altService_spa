package altService.sys.authorRole.service.impl;

import java.sql.SQLException;
import java.util.List;

import altService.utils.SearchCriteria;

public interface AuthorRoleMapper {

	public List<?> selectAuthorRoleList(SearchCriteria cri) throws SQLException;
	
}