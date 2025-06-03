package altService.sys.authorRole.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altService.sys.authorRole.service.AuthorRoleListDTO;
import altService.sys.authorRole.service.AuthorRoleManageVO;
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

	@Override
	public void registAuthorRole(HashMap<String, Object> paramMap) throws SQLException {
		List<String> role_id = (List<String>) paramMap.get("role_id");
		List<Boolean> sttsFlag = (List<Boolean>) paramMap.get("sttsFlag");
		String author_code = (String) paramMap.get("author_code");
		
		for(int i = 0; i < sttsFlag.size(); i++) {
			AuthorRoleManageVO vo = new AuthorRoleManageVO();
			vo.setAuthor_code(author_code);
			vo.setRole_code(role_id.get(i));
			
			if(sttsFlag.get(i) == true) {
				arMapper.insertAuthorRole(vo);
			} else {
				arMapper.deleteAuthorRole(vo);
			}
		}
		
//		sttsFlag 리스트로 뽑아서 쓰기
		
		/*for(String id : role_id) {
			AuthorRoleManageVO vo = new AuthorRoleManageVO();
			vo.setRole_code(id);
			vo.setAuthor_code(author_code);
			arMapper.insertAuthorRole(vo);
		}*/
		
	}

}
