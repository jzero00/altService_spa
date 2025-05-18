package altService.sys.role.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import altService.sys.role.service.RoleManageService;
import altService.sys.role.service.RoleManageVO;
import altService.utils.SearchCriteria;

@RequestMapping("/sys")
@Controller
public class RoleController {
	
	@Autowired
	private RoleManageService rService;
	
	private final String rootView = "/sys/role/";

	@RequestMapping("/roleManage.do")
	public ModelAndView roleManage(ModelAndView mnv, SearchCriteria cri) {
		String url = rootView + "roleManage";
		Map<String, Object> dataMap = null;
		
		try {
			dataMap = rService.getRoleManageList(cri);
			mnv.addAllObjects(dataMap);
			mnv.setViewName(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mnv;
	}
	
	@RequestMapping("/roleManageRegView.do")
	public ModelAndView roleManageRegView(ModelAndView mnv) {
		String url = rootView + "roleManageReg";
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/roleManageReg.do")
	@ResponseBody
	public Map<String, Object> roleManageReg(RoleManageVO vo){
		Map<String, Object> paramMap = new HashMap<>();
		Map<String, Object> resMap = new HashMap<>();
		paramMap.put("vo", vo);
		
		try {
			rService.registRoleManage(paramMap);
			resMap.put("status", HttpStatus.OK);
		} catch (SQLException e) {
			resMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resMap;
	}
	
	
	@PostMapping("/roleManageDtl.do")
	public ModelAndView roleManageDtl(ModelAndView mnv, String role_code) {
		String url = rootView + "roleManageDtl";
		RoleManageVO reqVO = new RoleManageVO();
		reqVO.setRole_code(role_code);
		
		RoleManageVO resVO = null;
		try {
			resVO = rService.getRoleManageDetail(reqVO);
			mnv.addObject("vo", resVO);
			mnv.setViewName(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mnv;
	}
	
	@PostMapping("/roleManageModView.do")
	public ModelAndView roleManageModView(ModelAndView mnv, String role_code) {
		String url = rootView + "roleManageMod";
		RoleManageVO reqVO = new RoleManageVO();
		reqVO.setRole_code(role_code);
		
		RoleManageVO resVO = null;
		
		try {
			resVO = rService.getRoleManageDetail(reqVO);
			mnv.addObject("vo", resVO);
			mnv.setViewName(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mnv;
	}
	
	@PostMapping("/roleManageMod.do")
	@ResponseBody
	public Map<String, Object> roleManageMod(RoleManageVO vo){
		Map<String, Object> paramMap = new HashMap<>();
		Map<String, Object> resMap = new HashMap<>();
		paramMap.put("vo", vo);
		
		try {
			rService.modifyRoleManage(paramMap);
			resMap.put("status", HttpStatus.OK);
		} catch (SQLException e) {
			resMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resMap;
	}
}