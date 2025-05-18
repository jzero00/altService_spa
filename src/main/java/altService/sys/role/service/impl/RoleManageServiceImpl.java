package altService.sys.role.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altService.sys.role.service.RoleManageService;
import altService.sys.role.service.RoleManageVO;
import altService.utils.PageMaker;
import altService.utils.SearchCriteria;

@Service
public class RoleManageServiceImpl implements RoleManageService {
	
	@Autowired
	private RoleManageMapper rMapper;

	@Override
	public Map<String, Object> getRoleManageList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<>();
		List<RoleManageVO> list = null;
		int totalCount = 0;
		
		list = rMapper.selectRoleManageList(cri);
		totalCount = rMapper.selectRoleManageListCnt(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("list", list);
		dataMap.put("cri", cri);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public RoleManageVO getRoleManageDetail(RoleManageVO vo) throws SQLException {
		RoleManageVO resVO = null;
		resVO = rMapper.selectRoleManageDetail(vo);
		return resVO;
	}

	@Override
	public void registRoleManage(Map<String, Object> paramMap) throws SQLException {
		RoleManageVO vo = (RoleManageVO) paramMap.get("vo");
		rMapper.insertRoleManage(vo);
	}

	@Override
	public void modifyRoleManage(Map<String, Object> paramMap) throws SQLException {
		RoleManageVO vo = (RoleManageVO) paramMap.get("vo");
		rMapper.updateRoleManage(vo);
	}

}