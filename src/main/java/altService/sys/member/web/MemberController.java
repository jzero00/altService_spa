package altService.sys.member.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import altService.exception.LoginFailException;
import altService.sys.member.service.MemberManageVO;
import altService.sys.member.service.MemberService;
import altService.utils.SearchCriteria;


@RequestMapping("/sys")
@Controller
public class MemberController {

	@Autowired
	private MemberService mService;

	private final String rootView = "/member/";

	@GetMapping("/login.do")
	public ModelAndView login(ModelAndView mnv) {
		String url = rootView + "login";

		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/login.do")
	public ModelAndView postLogin(ModelAndView mnv, MemberManageVO vo, HttpServletRequest req) {

		MemberManageVO loginUser = null;
		try {
			loginUser = mService.login(vo);
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", loginUser);
			String url = rootView + "loginSuccess";
			mnv.setViewName(url);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (LoginFailException e) {
			String url = "/alert";
			String message = e.getMessage();

			mnv.addObject("url", "/sys/login.do");
			mnv.addObject("result", message);
			mnv.setViewName(url);
			e.getMessage();
		}

		return mnv;
	}

	@RequestMapping("/memberManage.do")
	public ModelAndView memberManage(ModelAndView mnv, SearchCriteria cri) {
		String url = "/sys" + rootView + "memberManage";
		Map<String, Object> dataMap = null;

		try {
			dataMap = mService.getMemberManageList(cri);
			mnv.addAllObjects(dataMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mnv.setViewName(url);
		return mnv;
	}

	@RequestMapping("/memberRegView.do")
	public ModelAndView memberRegView(ModelAndView mnv) {
		String url = "/sys" + rootView + "memberRegView";
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/memberReg.do")
	@ResponseBody
	public Map<String,Object> memberReg(ModelAndView mnv, MemberManageVO vo) {
		Map<String, Object> paramMap = new HashMap<>();
		Map<String, Object> resMap = new HashMap<>();
		paramMap.put("vo", vo);

		try {
			mService.registMemberManage(paramMap);
			resMap.put("status", HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			resMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resMap;
	}
	
	@PostMapping("/checkDupleId.do")
	@ResponseBody
	public Map<String,Object> checkDupleId(String id){
		Map<String,Object> resMap = new HashMap<>();
		boolean flag = false;
		
		try {
			flag = mService.getMemeberDupleCheck(id);
			if (flag) {
				resMap.put("result", "사용가능");
				resMap.put("status", HttpStatus.OK);
			} else {
				resMap.put("result", "사용불가");
				resMap.put("status", HttpStatus.OK);
			}
		} catch (SQLException e) {
			resMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return resMap;
	}
	

	@RequestMapping("/memberDtl.do")
	public ModelAndView memberDtl(ModelAndView mnv, String id) {
		String url = "/sys" + rootView + "memberDtl";
		MemberManageVO reqVO = new MemberManageVO();
		reqVO.setEmplyr_id(id);

		try {
			MemberManageVO resVO = mService.getMemberManageDetail(reqVO);
			mnv.addObject("vo", resVO);
			mnv.setViewName(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mnv;
	}
	
	@PostMapping("/memberModView.do")
	public ModelAndView memberModView(ModelAndView mnv, String emplyr_id) {
		String url = "/sys" + rootView + "memberModView";
		MemberManageVO reqVO = new MemberManageVO();
		reqVO.setEmplyr_id(emplyr_id);
		
		MemberManageVO resVO;
		try {
			resVO = mService.getMemberManageDetail(reqVO);
			mnv.addObject("vo", resVO);
			mnv.setViewName(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mnv;
	}
	
	@PostMapping("/memberMod.do")
	public ModelAndView memberMod(ModelAndView mnv, MemberManageVO vo) {
		Map<String, Object> paramMap = new HashMap<>();
		String url = "";
		paramMap.put("vo", vo);
		
		try {
			mService.modifyMemberManage(paramMap);
		url = "/alert";
		
		mnv.addObject("url","/sys/memberManage.do");
		mnv.addObject("result","사용자 수정 완료");
		mnv.setViewName(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mnv;
	}
	
	@PostMapping("/memberDelete.do")
	public ModelAndView memberDelete(ModelAndView mnv, String id) {
		String url = "/alert";
		String redirectUrl = "/sys/memberManage.do";
		
		try {
			mService.deleteMemberManage(id);
			
			String result = "삭제 완료했습니다.";
			
			mnv.addObject("result", result);
			mnv.addObject("url", redirectUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String result = "삭제 실패했습니다. 관리자에게 문의하십시오.";
			mnv.addObject("result", result);
			mnv.addObject("url", redirectUrl);
		}
		
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping("/registMemberManageExcelView.do")
	public ModelAndView insertMemberManageExcelView(ModelAndView mnv) {
		String url = "/sys" + rootView + "registMemberExcel";
		mnv.setViewName(url);
		return mnv;
	}
}