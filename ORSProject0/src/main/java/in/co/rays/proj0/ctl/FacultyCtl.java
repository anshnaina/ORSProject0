package in.co.rays.proj0.ctl;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import in.co.rays.proj0.dto.FacultyDTO;
import in.co.rays.proj0.dto.SubjectDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.form.FacultyForm;
import in.co.rays.proj0.form.FacultyValidator;
import in.co.rays.proj0.form.SubjectForm;
import in.co.rays.proj0.service.CollegeServiceInt;
import in.co.rays.proj0.service.CourseServiceInt;
import in.co.rays.proj0.service.FacultyServiceInt;
import in.co.rays.proj0.service.SubjectServiceInt;

/**
 * Contains navigation logics for Faculty and Faculty List usecases.
 * 
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Controller
@RequestMapping(value = "/ctl/Faculty")
public class FacultyCtl extends BaseCtl {

	@Autowired
	FacultyServiceInt service;

	@Autowired
	CourseServiceInt courseService;

	@Autowired
	SubjectServiceInt subjecService;

	@Autowired
	CollegeServiceInt collegeService;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FacultyValidator validator;

	/**
	 * Preload College,Student,Course List
	 */
	@Override
	public void preload(Model model) {
		model.addAttribute("collegeList", collegeService.search(null));
		model.addAttribute("courseList", courseService.search(null));
		model.addAttribute("subjectList", subjecService.search(null));
		model.addAttribute("facultyList", service.search(null));
	}

	/**
	 * Displays Faculty View.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") FacultyForm form,
			Model model) {

		System.out.println("this is display method in FacultyCtl for Faculty");

		if (id != null && id > 0) {
			form.populate(service.findById(id));
		}

		return "Faculty";
	}

	/**
	 * Submits Faculty data.
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
			@ModelAttribute("form") @Valid FacultyForm form, BindingResult bindingResult, Model model, HttpSession session) {

		System.out.println("this is submit (Post) method in FacultyCtl for Faculty");

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Faculty";
		}
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Faculty/search";
		}

		validator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "Faculty";
		}

		FacultyDTO dto = (FacultyDTO) form.getDto(session);

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
				return "redirect:Faculty/search";
			}

		} catch (DuplicateRecordException e) {
			String msg = messageSource.getMessage("duplicate.message.faculty", null, locale);
			model.addAttribute("error", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Faculty";
	}

	/**
     * Displays Faculty List view.
     * 
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchList(Locale locale,@ModelAttribute("form") FacultyForm form, Model model) {
    	
    	System.out.println("this is display method in FacultyCtl for Search");
    	
    	List list=service.search(null, form.getPageNo(), form.getPageSize());
        if(list==null||list.size()==0){
        	String msg = messageSource.getMessage("message.listNull", null, locale);
        	model.addAttribute("error", msg);
        }	
        model.addAttribute("list",list );
        		
        return "FacultyList";
    }
    
	/**
	 * Submits Faculty List data.
	 * 
	 * @param locale
	 * @param form
	 * @param operation
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale, @ModelAttribute("form") FacultyForm form,
			@RequestParam(required = false) String operation, Model model, HttpSession session) {

		System.out.println("this is searchList (Post) method in FacultyCtl for Faculty");

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
			return "redirect:Faculty";
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
		FacultyDTO dto = (FacultyDTO) form.getDto(session);
		
		List list = service.search(dto, pageNo, form.getPageSize());
		
		if (!OP_DELETE.equalsIgnoreCase(operation)) {
			if (list == null || list.size() == 0) {
				String msg = messageSource.getMessage("message.listNull", null, locale);
				model.addAttribute("error", msg);
			}
		}

		model.addAttribute("list", list);

		return "FacultyList";
	}

}
