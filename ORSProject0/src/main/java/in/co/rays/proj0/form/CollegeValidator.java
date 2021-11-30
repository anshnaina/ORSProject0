package in.co.rays.proj0.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.proj0.util.DataValidator;

/**
 * Contains College for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Component
public class CollegeValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return CollegeForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		CollegeForm collegeForm = (CollegeForm) target;
		String name = collegeForm.getName();
		String state = collegeForm.getState();
		String city = collegeForm.getCity();
		String phoneNo = collegeForm.getPhoneNo();

		if (!DataValidator.isNull(name)) {
			if (!DataValidator.isNameNumber(name)) {
				errors.rejectValue("name", "error.name.invalid");
			}
		}

		if (!DataValidator.isNull(state)) {
			if (!DataValidator.isNameNumber(state)) {
				errors.rejectValue("state", "error.state.invalid");
			}
		}

		if (!DataValidator.isNull(city)) {
			if (!DataValidator.isName(city)) {
				errors.rejectValue("city", "error.city.invalid");
			}
		}

		if (!DataValidator.isNull(phoneNo)) {
			if (DataValidator.isPhoneNo(phoneNo)) {
				errors.rejectValue("phoneNo", "error.phoneNo.invalid");
			}
		}
	}

}
