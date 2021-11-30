package in.co.rays.proj0.form;

import java.text.ParseException;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.proj0.util.DataValidator;

/**
 * Contains Student form for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Component
public class StudentValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return StudentForm.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		StudentForm studentForm = (StudentForm) target;
		String firstName=studentForm.getFirstName();
		String lastName=studentForm.getLastName();
		String dob=studentForm.getDob();
		String mobileNo=studentForm.getMobileNo();
		
		if (!DataValidator.isNull(firstName)) {
			if (!DataValidator.isName(firstName)) {
				errors.rejectValue("firstName" ,"error.firstName.invalid");
			}else if(DataValidator.isWhiteSpace(firstName)){
				errors.rejectValue("firstName", "error.firstName.alfabet");
				
			}
		}
		if (!DataValidator.isNull(lastName)) {
			if (!DataValidator.isName(lastName)) {
				errors.rejectValue("lastName" ,"error.firstName.invalid");
			}else if(DataValidator.isWhiteSpace(lastName)){
				errors.rejectValue("lastName", "error.firstName.alfabet");
				
			}
		}
		if (!DataValidator.isNull(dob)) {
			try {
				if (!DataValidator.isDOB(dob)) {
					errors.rejectValue("dob", "error.dob");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!DataValidator.isNull(mobileNo)) {
			 if (!DataValidator.isMobileNo(mobileNo)) {
				errors.rejectValue("mobileNo", "error.mobileNo.invalid");
			}
		}	
	}

}

