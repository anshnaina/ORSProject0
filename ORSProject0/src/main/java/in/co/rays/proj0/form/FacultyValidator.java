package in.co.rays.proj0.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.proj0.util.DataValidator;

/**
 * Contains Faculty for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Component
public class FacultyValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return FacultyForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		FacultyForm form = (FacultyForm) target;
		String firstName = form.getFirstName();
		String lastName = form.getLastName();
		String doj = form.getDoj();
		String mobileNo = form.getMobileNo();

		if (!DataValidator.isNull(firstName)) {
			if (!DataValidator.isName(firstName)) {
				errors.rejectValue("firstName", "error.firstName.invalid");
			} else if (DataValidator.isWhiteSpace(firstName)) {
				errors.rejectValue("firstName", "error.firstName.alfabet");

			}
		}
		
		if (!DataValidator.isNull(lastName)) {
			if (!DataValidator.isName(lastName)) {
				errors.rejectValue("lastName", "error.lastName.invalid");
			} else if (DataValidator.isWhiteSpace(lastName)) {
				errors.rejectValue("lastName", "error.lastName.alfabet");

			}
		}
		
		if (!DataValidator.isNull(mobileNo)) {
			if (!DataValidator.isMobileNo(mobileNo)) {
				errors.rejectValue("mobileNo", "error.mobileNo.invalid");
			}
		}

	}

}
