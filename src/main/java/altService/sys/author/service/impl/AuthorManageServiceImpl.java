package altService.sys.author.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altService.sys.author.service.AuthorManageService;
import altService.sys.author.service.AuthorManageVO;
import altService.utils.PageMaker;
import altService.utils.SearchCriteria;

@Service
public class AuthorManageServiceImpl implements AuthorManageService {
	
	@Autowired
	private AuthorMapper aMapper;

	@Override
	public Map<String, Object> getAuthManageList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<>();
		List<AuthorManageVO> list = null;
		int totalCount = 0;
		
		list = aMapper.selectAuthManageList(cri);
		totalCount = aMapper.selectAuthManageListCnt(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("list", list);
		dataMap.put("cri", cri);
		dataMap.put("pageMaker", pageMaker);
				
		return dataMap;
	}

}
