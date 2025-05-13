package altService.sys.menuManage.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altService.sys.menuManage.service.MenuManageService;
import altService.sys.menuManage.service.MenuManageVO;
import altService.utils.PageMaker;
import altService.utils.SearchCriteria;

@Service
public class MenuManageServiceImpl implements MenuManageService {
	
	@Autowired
	private MenuManageMapper mMapper;

	@Override
	public Map<String, Object> getMenuMangeList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<>();
		List<MenuManageVO> menuList = null;
		int totalCount = 0;
		
		menuList = mMapper.selectMenuList(cri);
		totalCount = mMapper.selectMenuManageListCnt(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("list", menuList);
		dataMap.put("cri", cri);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public void registMenuManage(Map<String, Object> paramMap) throws SQLException {
		MenuManageVO vo = (MenuManageVO) paramMap.get("vo");
		mMapper.insertMenuManage(vo);
	}

	@Override
	public List<MenuManageVO> getUpperMenuNoByMenuNm(String keyword) throws SQLException {
		List<MenuManageVO> list = null;
		list = mMapper.selectUpperMenuNoByMenuNm(keyword);
		return list;
	}

	@Override
	public Map<String, Object> getMenuManageDetail(Map<String, Object> paramMap) throws SQLException {
		Map<String,Object> dataMap = new HashMap<>();
		String menu_no = (String) paramMap.get("menu_no");
		MenuManageVO vo = null;
		
		vo = mMapper.selectMenuManageDetail(menu_no);
		
		dataMap.put("vo", vo);
		
		return dataMap;
	}

	@Override
	public void modifyMenuManage(Map<String, Object> paramMap) throws SQLException {
		MenuManageVO vo = (MenuManageVO) paramMap.get("vo");
		mMapper.updateMenuManage(vo);
	}

	@Override
	public void registMenuByExcel(List<MenuManageVO> list) throws SQLException {
		for(int i = 0; i < list.size(); i++) {
			
			boolean flag = true;
			flag = checkDupleMenuInfo(list.get(i));
			if(flag) {
				mMapper.insertMenuManage(list.get(i));				
			}
			
		}
	}

	private boolean checkDupleMenuInfo(MenuManageVO vo) throws SQLException {
		boolean flag = true;
		int cnt = 0;
		cnt = mMapper.selectMenuManageDetailForCheck(vo);
		if (cnt >= 1) flag = false;
		return flag;
	}

}
