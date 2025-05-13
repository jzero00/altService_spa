package altService.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/download")
@Controller
public class UtilDownload {
	
	@GetMapping("/memberManageExcel.do")
	public void downloadMemberManageExcel(HttpServletResponse res) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("사용자 등록 명단");
		int rowNo = 0;
		
		CellStyle cellStyle = workbook.createCellStyle();
		
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		Row headerRow = sheet.createRow(rowNo++);
		List<String> headerList = new ArrayList<>();
		headerList.add("ID");
		headerList.add("이름");
		headerList.add("성별");
		headerList.add("전화번호");
		headerList.add("이메일주소");
		headerList.add("우편번호");
		headerList.add("주소");
		headerList.add("상세주소");
		
		for(int i = 0; i < headerList.size(); i++) {
			Cell headerCell = headerRow.createCell(i);
			headerCell.setCellValue(headerList.get(i));
			headerCell.setCellStyle(cellStyle);			
		}
		
		res.setContentType("application/vnd.ms-excel");
		res.setHeader("Content-Disposition", "attachment;filename=registUser.xls");
		
		workbook.write(res.getOutputStream());
        workbook.close();
	}
	
	@GetMapping("/menuManageExcel.do")
	public void downloadMenuManageExcel(HttpServletResponse res) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("메뉴 등록 명단");
		int rowNo = 0;
		
		CellStyle cellStyle = workbook.createCellStyle();
		
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		Row headerRow = sheet.createRow(rowNo++);
		List<String> headerList = new ArrayList<>();
		headerList.add("메뉴 No");
		headerList.add("메뉴 순서");
		headerList.add("메뉴 명");
		headerList.add("상위메뉴 No");
		headerList.add("메뉴설명");
		
		for(int i = 0; i < headerList.size(); i++) {
			Cell headerCell = headerRow.createCell(i);
			headerCell.setCellValue(headerList.get(i));
			headerCell.setCellStyle(cellStyle);			
		}
		
		res.setContentType("application/vnd.ms-excel");
		res.setHeader("Content-Disposition", "attachment;filename=registMenu.xls");
		
		workbook.write(res.getOutputStream());
        workbook.close();
	}
}