package in.co.rays.proj0.ctl;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.proj0.dto.RoleDTO;
import in.co.rays.proj0.dto.UserDTO;
import in.co.rays.proj0.exception.ApplicationException;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.exception.RecordNotFoundException;
import in.co.rays.proj0.form.ForgetPasswordForm;
import in.co.rays.proj0.form.LoginForm;
import in.co.rays.proj0.form.UserRegistrationForm;
import in.co.rays.proj0.form.UserRegistrationValidator;
import in.co.rays.proj0.service.RoleServiceInt;
import in.co.rays.proj0.service.UserServiceInt;

/**
 * Contains navigation logics for Login, Forgot Password and SignUp Usecases.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Controller
public class LoginCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(LoginCtl.class);

	/**
	 * Operations
	 */
	protected static final String OP_SIGNIN = "SignIn";
	protected static final String OP_SIGNUP = "SignUp";

	@Autowired
	private UserServiceInt service;

	@Autowired
	private RoleServiceInt roleService;
	
	@Autowired
	private UserRegistrationValidator validator;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Displays Login View.
	 * 
	 * @param form
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String display(Locale locale, @ModelAttribute("form") LoginForm form, HttpSession session, Model model) {

		System.out.println("this is display method in LoginCtl for Login");

		UserDTO dto = (UserDTO) session.getAttribute("user");

		if (dto != null) {
			session.invalidate();
			String msg = messageSource.getMessage("message.logout", null, locale);
			model.addAttribute("success", msg);

		}
		return "Login";
	}

	/**
	 * Submits Login data.
	 * 
	 * @param form
	 * @param bindingResult
	 * @param session
	 * @return
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(value = "/Login", method = { RequestMethod.POST })
	public String submit(Locale locale, @ModelAttribute("form") @Valid LoginForm form, BindingResult bindingResult,
			HttpSession session, Model model) {

		System.out.println("this is submit method in LoginCtl for Login");

		if (bindingResult.hasErrors()) {
			return "Login";
		}
		
		
		if (OP_SIGNIN.equalsIgnoreCase(form.getOperation())) {
			
			System.out.println("sign in operation");
			
			UserDTO dto = new UserDTO();
			dto.setLogin(form.getLogin());
			dto.setPassword(form.getPassword());
			
			try {
				dto = service.authenticate(dto.getLogin(), dto.getPassword());
				if (dto != null) {
					session.setAttribute("user", dto);
					RoleDTO roleDto=roleService.findById(dto.getRoleId());
					session.setAttribute("role", roleDto);
					String str = (String)session.getAttribute("URI");
					System.out.println("URI : "+str);
					if (str == null||"null".equalsIgnoreCase(str)) {
						return "redirect:/Welcome";
					} else {
						str=str.replace("/ORSProject0", "");			
						return "redirect:"+str;
					}
				}
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
				String msg = messageSource.getMessage("login.error", null, locale);
				model.addAttribute("error", msg);
			}
		}
		return "Login";
	}

	/**
	 * Displays Forget Password View
	 * 
	 * @param form
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.GET)
	public String display(@ModelAttribute("form") ForgetPasswordForm form, Model model) {
		System.out.println("this is display method in LoginCtl for Forget Password");
		return "ForgetPassword";
	}

	/**
	 * Submits ForgetPassword data.
	 * 
	 * @param locale
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid ForgetPasswordForm form, BindingResult bindingResult, Model model) {

		System.out.println("this is Forget Password : Submit method in LoginCtl");

		if (OP_RESET.equalsIgnoreCase(operation)) {
			System.out.println("this is Operation : Reset (Submit method) in ForgetPassword for User Registration");
			return "redirect:ForgetPassword";
		}

		if (bindingResult.hasErrors()) {
			return "ForgetPassword";
		}

		UserDTO dto = service.findByLogin(form.getLogin());
		System.out.println("LOGIN id : "+dto.getLogin());

		if (dto == null) {
			String msg = messageSource.getMessage("forgetpass.error", null, locale);
			model.addAttribute("error", msg);
		} else {
			try {
				service.forgetPassword(form.getLogin());
				String msg = messageSource.getMessage("sendPassword.message", null, locale);
				model.addAttribute("success", msg);

			} catch (ApplicationException e) {
				return "redirect:/ErrorCtl";
			}
		}
		return "ForgetPassword";
	}

	/**
	 * Displays UserRegistration view
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/UserRegistration", method = RequestMethod.GET)
	public String userRegistration(@ModelAttribute("form") UserRegistrationForm form, Model model) {
		System.out.println("this is display method in LoginCtl for User Registration");
		return "UserRegistration";
	}
	
	/**
	 * Submits SignUp data
	 * 
	 * @param locale
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 * @throws DuplicateRecordException
	 */
	@RequestMapping(value = "/UserRegistration", method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid UserRegistrationForm form, BindingResult bindingResult, Model model, HttpSession session) {
		
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:UserRegistration";
		}

		validator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "UserRegistration";
		}

		UserDTO dto = (UserDTO) form.getDto(session);

		// Default Role is Student
		dto.setRoleId((long) RoleDTO.STUDENT);
		
		try {
			long pk = service.registerUser(dto);
			form.setId(pk);
			String msg = messageSource.getMessage("registration.sucess.message", null, locale);
			model.addAttribute("success", msg);

		} catch (DuplicateRecordException e) {
			log.error(e);
			String msg = messageSource.getMessage("duplicate.message.user", null, locale);
			model.addAttribute("error", msg);
			return "UserRegistration";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Login";

	}
}
