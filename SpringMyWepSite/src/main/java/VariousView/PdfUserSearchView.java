package VariousView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import BeanModel.userinfo;

public class PdfUserSearchView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<userinfo> userlist=(List<userinfo>) model.get("PdfUser");
		Table table = new Table(8, userlist.size() + 1);
		table.setPadding(5);
		BaseFont bfKorean = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);
		Font font = new Font(bfKorean);
		Cell cell = new Cell(new Paragraph("아이디", font));
		cell.setHeader(true);
		table.addCell(cell);
		cell = new Cell(new Paragraph("비밀번호", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("이름", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("생일", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("성별", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("핸드폰번호", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("이메일", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("프로필 사진 파일 이름", font));
		table.addCell(cell);
		
		for (userinfo userinfo : userlist) {
			table.addCell(userinfo.getId());
			table.addCell(userinfo.getPw());
			table.addCell(userinfo.getName());
			table.addCell(userinfo.getBirth());
			table.addCell(userinfo.getGender());
			table.addCell(userinfo.getPhone());
			table.addCell(userinfo.getEmail());
			table.addCell(userinfo.getImgname());
		}
		document.add(table);
		
	}
	
}
