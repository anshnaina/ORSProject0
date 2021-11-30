package in.co.rays.proj0.ctl;

import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Front controller will check authentication and authorization. If user is not
 * logged-in then forward control to login page.  Authorization means role based access. User of different roles will have different kind of access in the application. 
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class FrontCtl extends HandlerInterceptorAdapter {
	
	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")==null){
			Locale locale = null;
			String msg=messageSource.getMessage("frontcontroller.message", null, locale);
			request.setAttribute("message", msg);	    
			RequestDispatcher rd = request.getRequestDispatcher("/Login");
			String str=request.getRequestURI();
            session.setAttribute("URI", str);
            rd.forward(request, response);
            return false;
		}
		
		return true;
	}

}
