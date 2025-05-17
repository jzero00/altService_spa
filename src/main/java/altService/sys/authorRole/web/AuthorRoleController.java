package altService.sys.authorRole.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import altService.sys.authorRole.service.AuthorRoleService;
import altService.utils.SearchCriteria;

//@RequestMapping("/sys")
//@Controller
public class AuthorRoleController {

	private final String rootView = "/sys/authorRole/";
	
	@Autowired
	private AuthorRoleService arService;
	
	@RequestMapping("/authorRole.do")
	public ModelAndView authorRole(ModelAndView mnv, SearchCriteria cri) {
		String url = rootView + "authorRoleManage";
		Map<String, Object> dataMap = null;
		
		
		mnv.setViewName(url);
		return mnv;
	}
}