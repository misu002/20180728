package VariousView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import BeanModel.userinfo;

@SuppressWarnings("deprecation")
public class ExcelUserSearchView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//1.시트생성
		HSSFSheet sheet=createFirstSheet(workbook);
		
		//2.시트의 첫번째 행의 라벨 작성
		createColumnLavel(sheet);
		List<userinfo> userlist=(List<userinfo>) model.get("ExcelUser");
	
		int rowNum=1;
		for (userinfo userinfo : userlist) {
			createUserlistRow(sheet,rowNum++,userinfo);
		}
}

	private void createUserlistRow(HSSFSheet sheet, int rowNum, userinfo userinfo) {
		HSSFRow row=sheet.createRow(rowNum);
		
		HSSFCell cell=row.createCell(0);
		cell.setCellValue(userinfo.getId());
		cell=row.createCell(1);
		cell.setCellValue(userinfo.getPw());
		cell=row.createCell(2);
		cell.setCellValue(userinfo.getName());
		cell=row.createCell(3);
		cell.setCellValue(userinfo.getBirth());
		cell=row.createCell(4);
		cell.setCellValue(userinfo.getGender());
		cell=row.createCell(5);
		cell.setCellValue(userinfo.getPhone());
		cell=row.createCell(6);
		cell.setCellValue(userinfo.getEmail());
		cell=row.createCell(7);
		cell.setCellValue(userinfo.getImgname());
		
	}

	private void createColumnLavel(HSSFSheet sheet) {
		
		//행 생성
		HSSFRow firstRow=sheet.createRow(0);
		
		//셀 생성
		HSSFCell cell=firstRow.createCell(0);
		cell.setCellValue("아이디");
		
		cell=firstRow.createCell(1);
		cell.setCellValue("비밀번호");
		cell=firstRow.createCell(2);
		cell.setCellValue("이름");
		cell=firstRow.createCell(3);
		cell.setCellValue("생일");
		cell=firstRow.createCell(4);
		cell.setCellValue("성별");
		cell=firstRow.createCell(5);
		cell.setCellValue("핸드폰번호");
		cell=firstRow.createCell(6);
		cell.setCellValue("이메일");
		cell=firstRow.createCell(7);
		cell.setCellValue("프로필 사진 파일 이름");
		
	}

	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet=workbook.createSheet();
		workbook.setSheetName(0, "생일에 따른 회원정보");
		sheet.setColumnWidth(1, 256*20);
		return sheet;
	}
	
}
