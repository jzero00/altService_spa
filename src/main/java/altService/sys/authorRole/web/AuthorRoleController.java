package altService.sys.authorRole.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import altService.sys.authorRole.service.AuthorRoleService;
import altService.utils.SearchCriteria;

@RequestMapping("/sys")
@Controller
public class AuthorRoleController {

	private final String rootView = "/sys/authorRole/";
	
	@Autowired
	private AuthorRoleService arService;
	
	@RequestMapping("/authorRoleManage.do")
	public ModelAndView authorRole(ModelAndView mnv, SearchCriteria cri, String keyword) {
		String url = rootView + "authorRoleManage";
		Map<String, Object> dataMap = null;
		cri.setKeyword(keyword);
		
		try {
			dataMap = arService.getAuthorRoleManageList(cri);
			mnv.addAllObjects(dataMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		return mnv;
	}
	
	@ResponseBody
	@PostMapping("/authorRoleReg.do")
	public Map<String, Object> authorRoleReg(@RequestBody HashMap<String, Object> paramMap){
		Map<String, Object> resMap = new HashMap<>();
		
		try {
			arService.registAuthorRole(paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resMap;
	}
}