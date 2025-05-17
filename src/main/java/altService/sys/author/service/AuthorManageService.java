package altService.sys.author.service;

import java.sql.SQLException;
import java.util.Map;

import altService.utils.SearchCriteria;

public interface AuthorManageService {

	public Map<String, Object> getAuthManageList(SearchCriteria cri) throws SQLException;
	
}