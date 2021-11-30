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

import in.co.rays.proj0.dto.MarksheetDTO;
import in.co.rays.proj0.dto.SubjectDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.form.MarksheetForm;
import in.co.rays.proj0.form.MarksheetValidator;
import in.co.rays.proj0.form.SubjectForm;
import in.co.rays.proj0.service.MarksheetServiceInt;
import in.co.rays.proj0.service.StudentServiceInt;

/**
 * Contains navigation logics for Marksheet, Marksheet List, Merit List, and
 * GetMarksheet Usecases.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Controller
@RequestMapping(value = "/ctl/Marksheet")
public class MarksheetCtl extends BaseCtl {

	@Autowired
	MarksheetServiceInt service;

	@Autowired
	StudentServiceInt studentService;

	/**
	 * i18n Message source
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MarksheetValidator marksheetValidator;

	/**
	 * Preload Student List
	 */
	@Override
	public void preload(Model model) {
		model.addAttribute("studentList", studentService.search(null));
		model.addAttribute("marksheetList", service.search(null));

	}

	/**
	 * Displays Marksheet View.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") MarksheetForm form,
			Model model) {

		System.out.println("this is display method in MarksheetCtl for Marksheet");

		if (id != null && id > 0) {
			form.populate(service.findById(id));
		}

		return "Marksheet";
	}

	/**
	 * Submits Marksheet data.
	 * 
	 * @param locale
	 * @param operation
	 * @param form
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid MarksheetForm form, BindingResult bindingResult, Model model, HttpSession session) {

		System.out.println("this is display method in MarksheetCtl for Marksheet List");

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Marksheet";
		}

		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Marksheet/search";
		}

		marksheetValidator.validate(form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "Marksheet";
		}

		MarksheetDTO dto = (MarksheetDTO) form.getDto(session);

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
				return "redirect:Marksheet/search";
			}

		} catch (DuplicateRecordException e) {
			String msg = messageSource.getMessage("duplicate.message.marksheet", null, locale);
			model.addAttribute("error", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Marksheet";
	}

	/**
	 * Displays Marksheet List View.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(Locale locale, @ModelAttribute("form") MarksheetForm form, Model model) {

		System.out.println("this is display method in MarksheetCtl for Marksheet List");

		List list = service.search(null, form.getPageNo(), form.getPageSize());
		if (list == null || list.size() == 0) {
			String msg = messageSource.getMessage("message.listNull", null, locale);
			model.addAttribute("error", msg);
		}
		model.addAttribute("list", list);

		return "MarksheetList";
	}

	/**
	 * Submits Marksheet List data.
	 * 
	 * @param locale
	 * @param form
	 * @param operation
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale, @ModelAttribute("form") MarksheetForm form,
			@RequestParam(required = false) String operation, Model model, HttpSession session) {

		System.out.println("this is searchList (Post) method in MarksheetCtl for Marksheet");

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
			return "redirect:Marksheet";
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
		MarksheetDTO dto = (MarksheetDTO) form.getDto(session);

		List list = service.search(dto, pageNo, form.getPageSize());

		if (!OP_DELETE.equalsIgnoreCase(operation)) {
			if (list == null || list.size() == 0) {
				String msg = messageSource.getMessage("message.listNull", null, locale);
				model.addAttribute("error", msg);
			}
		}

		model.addAttribute("list", list);

		return "MarksheetList";
	}

	/**
	 * Displays Merit list view.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/MeritList", method = RequestMethod.GET)
	public String getMeritList(@ModelAttribute("form") MarksheetForm form, Model model) {

		System.out.println("this is display method in MarksheetCtl for Merit List");

		List meritList = service.getMeritList(0, 10);
		model.addAttribute("list", meritList);

		return "GetMeritList";
	}

	/**
	 * Gets Marksheet.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/GetMarksheet", method = RequestMethod.GET)
	public String getMarksheet(@ModelAttribute("form") MarksheetForm form, Model model) {
		
		System.out.println("this is display method in MarksheetCtl for Get Marksheet");

		MarksheetDTO dto = service.findByRollNo(form.getRollNo());
		if (dto != null) {
			form.populate(dto);
		}

		return "GetMarksheet";
	}

	/**
	 * Gets Marksheet.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/GetMarksheet", method = RequestMethod.POST)
	public String getSubmitMarksheet(Locale locale, @ModelAttribute("form") @Valid MarksheetForm form, 
			BindingResult bindingResult, Model model) {
		
		System.out.println("this is submitMarksheetGet method in MarksheetCtl for Get Marksheet");
		
		
		if (!(form.getRollNo().isEmpty())) {
			MarksheetDTO dto = service.findByRollNo(form.getRollNo());
			if (dto != null) {
				form.populate(dto);
			} else {
				String msg = messageSource.getMessage("recordNotfound.message.marksheet", null, locale);
				model.addAttribute("error", msg);
			}
		}
		return "GetMarksheet";
	}

}
