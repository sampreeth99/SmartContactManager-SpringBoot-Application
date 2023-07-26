package boot.app.reportgeneration;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import org.w3c.dom.views.AbstractView;
import org.w3c.dom.views.DocumentView;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import boot.app.entity.ContactDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("PDFreport")
public class PDFReportGenerator extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<ContactDetails > c=(List<ContactDetails >)map.get("conList");
		
		Paragraph p=new Paragraph("Contacts Report",new Font(Font.HELVETICA));
		p.setAlignment("center");
		
		
		
		document.add(p);
		document.addTitle("Contacts Report");
		Table t=new Table(4, c.size());
		t.setPadding(5.0f);
		t.setBorderColor(new Color(254));
		t.addCell("Contact Name");
		t.addCell("Contact Number");
		t.addCell("Nick name");
		t.addCell("Destination");
		
		
		
		
		
		c.forEach(contact -> {
			try {
				t.addCell(contact.getCName());
				t.addCell(String.valueOf(contact.getCNo()) );
				
				t.addCell(contact.getCNickName());
				t.addCell(contact.getDest());
				
				
				
			} catch (BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		
		document.add(t);
		}

		
}
