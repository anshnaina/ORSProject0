package in.co.rays.proj0.ctl;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.proj0.dto.CourseDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.form.CourseForm;
import in.co.rays.proj0.form.CourseValidator;
import in.co.rays.proj0.service.CourseServiceInt;

/**
 * Contains navigation logics for Course and Course List usecases.

 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Controller
@RequestMapping(value = "/ctl/Course")
public class CourseCtl extends BaseCtl {
	
	@Autowired
	private CourseServiceInt service;
	
	@Autowired
	private CourseValidator courseValidator;
	
	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;
	
	/**
     * Preload ,Course List
     */
    @Override
    public void preload(Model model) {
      model.addAttribute("courseList", service.search(null));
    }
	
	/**
	 * Displays Course View.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id,
			@ModelAttribute("form") CourseForm form, Model model) {
    	
    	System.out.println("this is display method in CourseCtl for Course");
    	if (id != null && id > 0) {
			form.populate(service.findById(id));
		}	
    	return "Course";
    }

	/**
	 * Submits Course data.
	 * 
	 * @param locale
	 * @param operation
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.POST })
	public String submit(Locale locale, @RequestParam(required = false) String operation,
			@ModelAttribute("form") @Valid CourseForm form, BindingResult bindingResult, Model model, HttpSession session) {

		System.out.println("this is submit (Post) method in CourseCtl for Course");
		
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Course";
		}
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Course/search";
		}

		courseValidator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "Course";
		}
		
		CourseDTO dto = (CourseDTO) form.getDto(session);

		try {
			if (OP_SAVE.equalsIgnoreCase(operation) || OP_UPDATE.equalsIgnoreCase(operation)) {

				if (dto.getId() > 0) {
					service.update(dto);
					String msg = messageSource.getMessage("message.success.update", null, locale);
					model.addAttribute("success", msg);
				} else {
					Long id = service.add(dto);
					String msg = messageSource.getMessage("message.success.add", null, locale);
					model.addAttribute("success", msg);
				}
			} else if (OP_DELETE.equalsIgnoreCase(operation)) {
				service.delete(form.getId());
				String msg = messageSource.getMessage("message.success", null, locale);
				model.addAttribute("success", msg);
				return "redirect:Course/search";
			}

		} catch (DuplicateRecordException e) {
			String msg = messageSource.getMessage("duplicate.message.course", null, locale);
			model.addAttribute("error", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Course";
	}

	/**
	 * Displays Course List view.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(Locale locale, @ModelAttribute("form") CourseForm form, Model model) {
		System.out.println("this is searchList (Get) method in CourseCtl for Course");
		List list = service.search(null, form.getPageNo(), form.getPageSize());
		if (list == null || list.size() == 0) {
			String msg = messageSource.getMessage("message.listNull", null, locale);
			model.addAttribute("error", msg);
		}
		model.addAttribute("list", list);
	
		return "CourseList";
	}

	/**
	 * Submits Course List data.
	 * 
	 * @param locale
	 * @param form
	 * @param operation
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = { RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") CourseForm form,
			@RequestParam(required = false) String operation, Model model, HttpSession session) {

		System.out.println("this is searchList (Post) method in CourseeCtl for Course");
		
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
			return "redirect:Course";
		}
		
		if (OP_BACK.equalsIgnoreCase(operation)) {
			return "redirect:search";
		}
		
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:CourseList";
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
		CourseDTO dto = (CourseDTO) form.getDto(session);

		List list = service.search(dto, pageNo, form.getPageSize());
		if (!OP_DELETE.equalsIgnoreCase(operation)) {
			if (list == null || list.size() == 0) {
				String msg = messageSource.getMessage("message.listNull", null, locale);
				model.addAttribute("error", msg);
			}
		}

		model.addAttribute("list", list);
		
		return "CourseList";
	}

}
