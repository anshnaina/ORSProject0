package in.co.rays.proj0.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.proj0.dto.UserDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.form.ChangePasswordForm;
import in.co.rays.proj0.form.ChangePasswordValidator;
import in.co.rays.proj0.form.MyProfileForm;
import in.co.rays.proj0.form.MyProfileValidator;
import in.co.rays.proj0.form.UserForm;
import in.co.rays.proj0.form.UserValidator;
import in.co.rays.proj0.service.RoleServiceInt;
import in.co.rays.proj0.service.UserServiceInt;
import in.co.rays.proj0.util.EmailBuilder;
import in.co.rays.proj0.util.Util;

/**
 * Contains navigation logics for User, UserList, MyProfile, ChangePassword,
 * usecases.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(UserCtl.class);

	@Autowired
	private UserServiceInt service;

	@Autowired
	private RoleServiceInt roleService;

	@Autowired
	UserValidator uservalidator;
	
	@Autowired
	private MyProfileValidator profileValidator;
	
	@Autowired
	private ChangePasswordValidator passwordValidator;
	
	@Autowired
	private JavaMailSenderImpl mailSender;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Preload Rols List
	 */
	public void preload(Model model) {
		// Preload Role List
		List rolelist = roleService.search(null);
		model.addAttribute("roleList", rolelist);

		List userList = service.search(null);
		model.addAttribute("userList", userList);

	}

	/**
	 * Displays User view.
	 * 
	 * @param id
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") UserForm form, Model model) {
		System.out.println("this is display(Get) method in UserCtl for User");
		if (id != null && id > 0) {
			form.populate(service.findById(id));
		}
		return "User";
	}

	/**
	 * Submits User data.
	 * 
	 * @param locale
	 * @param operation
	 * @param form
	 * @param bindingResult
	 * @param session
	 * @param model
	 * @return
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation, @ModelAttribute("form") @Valid UserForm form,
			BindingResult bindingResult, HttpSession session, Model model) {

		log.debug("UserCtl doSubmit Start ");

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:User";
		}
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:User/search";
		}

		uservalidator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "User";
		}

		UserDTO dto = (UserDTO) form.getDto(session);

		try {
			if (OP_SAVE.equals(operation) || OP_UPDATE.equals(operation)) {

				if (dto.getId() > 0) {
					service.update(dto);
					String msg = messageSource.getMessage("message.success.update", null, locale);
					model.addAttribute("success", msg);
				} else {
					Long id = service.add(dto);
					String msg = messageSource.getMessage("message.success.add", null, locale);
					model.addAttribute("success", msg);
				}
				return "User";

			} else if (OP_DELETE.equals(operation)) {
				service.delete(form.getId());
				String msg = messageSource.getMessage("message.success", null, locale);
				model.addAttribute("success", msg);
				return "redirect:Student/search";
			}
		} catch (DuplicateRecordException e) {
			String msg = messageSource.getMessage("duplicate.message.user", null, locale);
			model.addAttribute("error", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "User";
	}

	/**
	 * Displays User List
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(Locale locale, @ModelAttribute("form") UserForm form, Model model) {
		System.out.println("this is display method in UserCtl for User List");

		List list = service.search(null, form.getPageNo(), form.getPageSize());
		if (list == null || list.size() == 0) {
			String msg = messageSource.getMessage("message.listNull", null, locale);
			model.addAttribute("error", msg);
		}
		model.addAttribute("list", list);

		return "UserList";
	}

	/**
	 * Submits User List data.
	 * 
	 * @param locale
	 * @param form
	 * @param operation
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale, @ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation, Model model, HttpSession session) {

		System.out.println("this is searchList (Post) method in UserCtl for User");

		// Calculate next page number
		int pageNo = form.getPageNo();

		pageNo = pageNo < 1 ? 1 : pageNo;
		if ("search".equalsIgnoreCase(operation) || "Next".equalsIgnoreCase(operation)
				|| "Previous".equalsIgnoreCase(operation)) {
			if ("search".equalsIgnoreCase(operation)) {
				pageNo = 1;
			} else if ("Next".equalsIgnoreCase(operation)) {
				++pageNo;
			} else if ("Previous".equalsIgnoreCase(operation) && pageNo > 1) {
				--pageNo;
			}
		}

		form.setPageNo(pageNo);

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:search";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:User";
		}
		
		if (OP_BACK.equalsIgnoreCase(operation)) {
			return "redirect:search";
		}

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			form.setPageNo(pageNo);
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					service.delete(id);
				}
				String msg = messageSource.getMessage("message.success.delete", null, locale);
				model.addAttribute("success", msg);
			} else {
				String msg = messageSource.getMessage("message.list.delete", null, locale);
				model.addAttribute("error", msg);
			}
		}

		// Get search attributes
		UserDTO dto = (UserDTO) form.getDto(session);
		List list = service.search(dto, pageNo, form.getPageSize());
		
		if (!OP_DELETE.equalsIgnoreCase(operation)) {
			if (list == null || list.size() == 0) {
				String msg = messageSource.getMessage("message.listNull", null, locale);
				model.addAttribute("error", msg);
			}
		}

		model.addAttribute("list", list);

		return "UserList";
	}

	/**
	 * Displays MyProfile View
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/MyProfile", method = RequestMethod.GET)
	public String displayProfile(HttpSession session, @ModelAttribute("form") MyProfileForm form, Model model) {
		System.out.println("this is display method in UserCtl for MyProfile");
		UserDTO dto = (UserDTO) session.getAttribute("user");
		form.populate(dto);
		return "MyProfile";
	}
	
	/**
	 * Submits MyProfile
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 * @throws DuplicateRecordException
	 */
	@RequestMapping(value = "/MyProfile", method = RequestMethod.POST)
	public String submitProfile(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid MyProfileForm form, BindingResult bindingResult, Model model)
			throws DuplicateRecordException {
		
		profileValidator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "MyProfile";
		}
		
		if (OP_CHANGE_MY_PASSWORD.equalsIgnoreCase(operation)) {
			return "redirect:ChangePassword";
		}

		if (OP_UPDATE.equalsIgnoreCase(operation)) {
		
			UserDTO dto = service.findById(form.getId());
			dto.setFirstName(form.getFirstName());
			dto.setLastName(form.getLastName());
			dto.setDob(Util.getDate(form.getDob()));
			dto.setMobileNo(form.getMobileNo());
			dto.setGender(form.getGender());

			service.update(dto);
			String msg = messageSource.getMessage("message.success", null, locale);
			model.addAttribute("success", msg);
		}
		return "MyProfile";
	}
	
	/**
	 * Displays Change Password view.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ChangePassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, Model model) {
		System.out.println("this is display method in UserCtl for Change Password");
		return "ChangePassword";
	}
	
	/**
	 * Submits Change Password data.
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 * @throws DuplicateRecordException
	 */
	@RequestMapping(value = "/ChangePassword", method = RequestMethod.POST)
	public String submitChangePassword(Locale locale, @RequestParam String operation, HttpSession session,
			@ModelAttribute("form") @Valid ChangePasswordForm form, BindingResult bindingResult, Model model)
			throws DuplicateRecordException {
		
		if (OP_CHANGE_MY_PROFILE.equalsIgnoreCase(operation)) {
			return "redirect:MyProfile";
		}
		
		passwordValidator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "ChangePassword";
		}
		
		if (OP_SAVE.equalsIgnoreCase(operation)) {
			// New password and confirm password must be same
			if (form.getNewPassword().equals(form.getConfirmPassword())) {

				UserDTO dto = (UserDTO) session.getAttribute("user");
				dto = service.findById(dto.getId());

				// Old password must be valid
				if (dto.getPassword().equals(form.getOldPassword())) {
					// Change Password
					dto.setPassword(form.getNewPassword());
					service.update(dto);
					String msg = messageSource.getMessage("message.success", null, locale);
					model.addAttribute("success", msg);
				} else {
					String msg = messageSource.getMessage("error.changepassword.message", null, locale);
					model.addAttribute("error", msg);
				}
				
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("login", dto.getLogin());
				map.put("password", dto.getPassword());
				map.put("firstName", dto.getFirstName());
				map.put("lastName", dto.getLastName());
				String message = EmailBuilder.getChangePasswordMessage(map);

				MimeMessage msg = mailSender.createMimeMessage();

				// use the true flag to indicate you need a multipart message
				MimeMessageHelper helper;
				try {
					helper = new MimeMessageHelper(msg, true);
					System.out.println("Email Id : "+dto.getLogin());
					helper.setTo(dto.getLogin());
					helper.setFrom(dto.getLogin());
					helper.setSubject("Password has been changed.");
					// use the true flag to indicate the text included is HTML
					helper.setText(message, true);
				} catch (MessagingException e) {
					System.out.println("Mail Sending Failed");
					e.printStackTrace();
				}
				mailSender.send(msg);
				
			} else {
				String msg = messageSource.getMessage("notmatch.changepassword.message", null, locale);
				model.addAttribute("error", msg);
			}
			
		}
		
		
		
		return "ChangePassword";
	}

}
