package altService.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/index.do")
	public ModelAndView mainPage (ModelAndView mnv) {
		String url = "index";
		mnv.setViewName(url);
		return mnv;		
	}
}