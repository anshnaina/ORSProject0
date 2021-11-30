package in.co.rays.proj0.form;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.proj0.util.DataValidator;

/**
 * Contains Change Password for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Component
public class ChangePasswordValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return ChangePasswordForm.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		ChangePasswordForm form = (ChangePasswordForm ) target;
		
		String oldPassword = form.getOldPassword();
		String newPassword = form.getNewPassword();
	    String confirmPassword = form.getConfirmPassword();
	    
	    if (!DataValidator.isNull(oldPassword)) {
			if (!DataValidator.isPassword(oldPassword)) {
				errors.rejectValue("oldPassword", "error.password");
			}
		}
	   
	    if (!DataValidator.isNull(newPassword)) {
			if (!DataValidator.isPassword(newPassword)) {
				errors.rejectValue("newPassword", "error.password");
			}
		}

		if (!DataValidator.isNull(confirmPassword)) {
			if (!newPassword.equals(confirmPassword) && !"".equals(confirmPassword)) {
				errors.rejectValue("confirmPassword", "error.confirmPassword");
			}
		}
	
}}
