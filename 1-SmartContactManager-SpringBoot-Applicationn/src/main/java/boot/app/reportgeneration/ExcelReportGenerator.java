package boot.app.reportgeneration;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import boot.app.entity.ContactDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("xlReport")
public class ExcelReportGenerator extends AbstractXlsView {

	int i = 1;

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<ContactDetails> c = (List<ContactDetails>) map.get("conList");

		org.apache.poi.ss.usermodel.Sheet o = workbook.createSheet("Contacts Report");

		Row r1 = o.createRow(0);

		r1.createCell(0).setCellValue("Contact name");
		r1.createCell(1).setCellValue("Contact Number");
		r1.createCell(2).setCellValue("Nick Name");
		r1.createCell(3).setCellValue("Destination");

		c.forEach(cn -> {
			Row r = o.createRow(i);

			r.createCell(0).setCellValue(cn.getCName());
			r.createCell(1).setCellValue(String.valueOf(cn.getCNo()));
			r.createCell(2).setCellValue(cn.getCNickName());
			r.createCell(3).setCellValue(cn.getDest());
			i++;
		});
	}
}
