package altService.sys.menuManage.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import altService.utils.SearchCriteria;

public interface MenuManageService {

	public Map<String,Object> getMenuMangeList(SearchCriteria cri) throws SQLException;
	
	public void registMenuManage(Map<String,Object> paramMap) throws SQLException;
	
	public List<MenuManageVO> getUpperMenuNoByMenuNm(String keyword) throws SQLException;

	public Map<String, Object> getMenuManageDetail(Map<String, Object> paramMap) throws SQLException;

	public void modifyMenuManage(Map<String, Object> paramMap) throws SQLException;

	public void registMenuByExcel(List<MenuManageVO> list) throws SQLException;
	
}