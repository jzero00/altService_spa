
package altService.sys.author.web;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import altService.sys.author.service.AuthorManageService;
import altService.utils.SearchCriteria;

@RequestMapping("/sys")
@Controller
public class AuthManageController {

	private final String rootView = "/sys/author/";
	
	@Autowired
	private AuthorManageService aService;
	
	@RequestMapping("/authorManage.do")
	public ModelAndView authManage(ModelAndView mnv, SearchCriteria cri) {
		String url = rootView + "authManage";
		Map<String, Object> dataMap = null;
		
		try {
			dataMap = aService.getAuthManageList(cri);
			mnv.addAllObjects(dataMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		return mnv;
	}
}