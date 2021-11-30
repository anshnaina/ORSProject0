package in.co.rays.proj0.ctl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Jasper functionality Controller .Performs operation for Jasper Report
 * 
 * @author Singleton
 * @version 1.0
 * @Copyrigh (c) SunilOS
 */

@Controller
@RequestMapping("/ctl/JasperCtl")
public class JasperCtl {

	private static final long serialVersionUID = 1L;

	/**
	 * Jasper functionality Controller display contant
	 */
	@Autowired
	private SessionFactory sessionfactory = null;

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@RequestMapping(method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public void display(ModelMap map,HttpServletRequest request, HttpServletResponse response)
	{
		try {
			Connection con = null;
			String path = request.getServletContext().getRealPath("resources/report/GetMeritList.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(path);
			Map<String, Object> map2 = new HashMap<String, Object>();
			
			con =  ((SessionImpl) sessionfactory.getCurrentSession()).connection();
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

			response.setContentType("application/pdf");
			response.getOutputStream().write(pdf);
			response.getOutputStream().flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
