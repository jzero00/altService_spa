package altService.sys.authorRole.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altService.sys.authorRole.service.AuthorRoleListDTO;
import altService.sys.authorRole.service.AuthorRoleService;
import altService.utils.PageMaker;
import altService.utils.SearchCriteria;

@Service
public class AuthorRoleServiceImpl implements AuthorRoleService {
	
	@Autowired
	private AuthorRoleMapper arMapper;

	@Override
	public Map<String, Object> getAuthorRoleManageList(SearchCriteria cri) throws SQLException {
		Map<String,Object> dataMap = new HashMap<>();
		List<AuthorRoleListDTO> list = null;
		int totalCount = 0;
		
		list = arMapper.selectAuthorRoleList(cri);
		totalCount = arMapper.selectAuthorRoleListCnt(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("list", list);
		dataMap.put("cri", cri);
		dataMap.put("pageMaker", pageMaker);
				
		return dataMap;
	}

}
