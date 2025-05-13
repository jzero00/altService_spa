package altService.sys.excel.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import altService.sys.member.service.MemberManageVO;
import altService.sys.member.service.MemberService;
import altService.sys.menuManage.service.MenuManageService;
import altService.sys.menuManage.service.MenuManageVO;

@RequestMapping("/excel")
@Controller
public class ExcelController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MenuManageService menuService;

	@SuppressWarnings("resource")
	@PostMapping("/insertMember.do")
	public ModelAndView insertMemberExcel(ModelAndView mnv, MultipartFile excelFile) throws IOException {
		/*엑셀파일 처리 */
		Workbook workbook = new HSSFWorkbook(excelFile.getInputStream());
		Sheet worksheet = workbook.getSheetAt(0);
		
		List<MemberManageVO> list = new ArrayList<>();
		
		for(int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			MemberManageVO vo = new MemberManageVO();
			
			DataFormatter formatter = new DataFormatter();
			Row row = worksheet.getRow(i);
			
			String emplyr_id = formatter.formatCellValue(row.getCell(0));
			String user_nm = formatter.formatCellValue(row.getCell(1));
			String sexdstn_code = formatter.formatCellValue(row.getCell(2));
			String moblphon_no = formatter.formatCellValue(row.getCell(3));
//			String[] tel_no = formatter.formatCellValue(row.getCell(3)).split("-");
//			String area_no = formatter.formatCellValue(row.getCell(3)).substring(0,2);
//			String house_middle_telno = formatter.formatCellValue(row.getCell(3)).substring(4,7);
//			String house_end_telno = formatter.formatCellValue(row.getCell(3)).substring(9,12);
			String email_adres = formatter.formatCellValue(row.getCell(4));
			String zip = formatter.formatCellValue(row.getCell(5));
			String house_adres = formatter.formatCellValue(row.getCell(6));
			String detail_adres = formatter.formatCellValue(row.getCell(7));
			
			vo.setEmplyr_id(emplyr_id);
			/*비밀번호 설정 0000 암호화*/
			vo.setPassword("9af15b336e6a9619928537df30b2e6a2376569fcf9d7e773eccede65606529a0");
			vo.setUser_nm(user_nm);
			vo.setSexdstn_code(sexdstn_code);
			vo.setMoblphon_no(moblphon_no);
//			vo.setArea_no(area_no);
//			vo.setHouse_middle_telno(house_middle_telno);
//			vo.setHouse_end_telno(house_end_telno);
			vo.setEmail_adres(email_adres);
			vo.setZip(zip);
			vo.setHouse_adres(house_adres);
			vo.setDetail_adres(detail_adres);
			
			list.add(vo);
		}
		
		String url = "";
		/*중복체크는 service에서 처리 insert*/
		try {
			memberService.registMemberManageByExcel(list);
			url = "/alert";
			mnv.addObject("url", "/sys/memberManage.do");
			mnv.addObject("result", "사용자 등록 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url = "/505error.page";
		}
		mnv.setViewName(url);
		return mnv;
	}

	@SuppressWarnings("resource")
	@PostMapping("/registMenu.do")
	public ModelAndView registMenuExcel(ModelAndView mnv, MultipartFile excelFile) throws IOException{
		Workbook workbook = new HSSFWorkbook(excelFile.getInputStream());
		Sheet worksheet = workbook.getSheetAt(0);
		
		List<MenuManageVO> list = new ArrayList<>();
		
		for(int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			MenuManageVO vo = new MenuManageVO();
			
			DataFormatter formatter = new DataFormatter();
			Row row = worksheet.getRow(i);
			
			String menu_no = formatter.formatCellValue(row.getCell(0));
			int menu_ordr = Integer.parseInt(formatter.formatCellValue(row.getCell(1)));
			String menu_nm = formatter.formatCellValue(row.getCell(2));
			int upper_menu_no = Integer.parseInt(formatter.formatCellValue(row.getCell(3)));
			String menu_dc = formatter.formatCellValue(row.getCell(4));
			
			vo.setMenu_no(menu_no);
			vo.setMenu_ordr(menu_ordr);
			vo.setMenu_nm(menu_nm);
			vo.setUpper_menu_no(upper_menu_no);
			vo.setMenu_dc(menu_dc);
			
			list.add(vo);
		}
		
		String url = "";
		
		try {
			menuService.registMenuByExcel(list);
			url = "/alert";
			mnv.addObject("url", "/sys/menuManage.do");
			mnv.addObject("result", "메뉴 등록 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		return mnv;
	}
	
}