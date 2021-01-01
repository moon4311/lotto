package egovframework.com.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import egovframework.rte.fdl.string.EgovDateUtil;
import egovframework.com.util.EncodingUtil;
import egovframework.com.util.NullUtil;
import net.sf.jxls.transformer.XLSTransformer;

public class ExcelView extends AbstractXlsxView {	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		XLSTransformer transformer = new XLSTransformer();
		
		HttpSession session  = request.getSession();
		String root = session.getServletContext().getRealPath("/");
		String templateFileName = root + 
				File.separator + "WEB-INF"+ 
				File.separator + "jsp"+ 
				File.separator + "egovframework"+
				File.separator + "exceltemplate"+ 
				File.separator + model.get("excelTemplateName")+".xlsx";
		
		String browser = EncodingUtil.getBrowser(request);
    	String encodeFileName = EncodingUtil.getDisposition(NullUtil.nullString((String)model.get("excelStoreName")), browser);
		
		String destFileName = encodeFileName + "_"+EgovDateUtil.getCurrentDateTimeAsString()+".xlsx";
		Workbook resultWorkbook = transformer.transformXLS(new FileInputStream(templateFileName), model);
		
		StringBuffer contentDisposition = new StringBuffer();
		contentDisposition.append("attachment;fileName=\"");
		contentDisposition.append(destFileName);
		contentDisposition.append("\";");
		response.setHeader("Content-Disposition", contentDisposition.toString());
		response.setContentType("application/x-msexcel");
		resultWorkbook.write(response.getOutputStream());
	}
}