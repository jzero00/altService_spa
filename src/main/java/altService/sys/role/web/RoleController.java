package altService.sys.role.web;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import altService.sys.role.service.RoleManageService;
import altService.utils.SearchCriteria;

@RequestMapping("/sys")
@Controller
public class RoleController {
	
	@Autowired
	private RoleManageService rService;
	
	private final String rootView = "/sys/role/";

	@RequestMapping("/roleManage.do")
	public ModelAndView getRoleManage(ModelAndView mnv, SearchCriteria cri) {
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
}