package in.co.rays.proj0.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.proj0.util.DataValidator;

/**
 * Contains Rolet form for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Component
public class RoleValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return RoleForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		RoleForm roleForm = (RoleForm) target;
		String roleName = roleForm.getName();

		if (!DataValidator.isNull(roleName)) {
			if (!DataValidator.isName(roleName)) {
				errors.rejectValue("name", "error.roleName.invalid");
			} else if (DataValidator.isWhiteSpace(roleName)) {
				errors.rejectValue("name", "error.roleName.alfabet");
			}
		}

	}

}
