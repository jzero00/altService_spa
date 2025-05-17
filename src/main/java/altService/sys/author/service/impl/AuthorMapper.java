package altService.sys.author.service.impl;

import java.sql.SQLException;
import java.util.List;

import altService.sys.author.service.AuthorManageVO;
import altService.utils.SearchCriteria;

public interface AuthorMapper {

	public List<AuthorManageVO> selectAuthManageList(SearchCriteria cri) throws SQLException;

	public int selectAuthManageListCnt(SearchCriteria cri) throws SQLException;

}