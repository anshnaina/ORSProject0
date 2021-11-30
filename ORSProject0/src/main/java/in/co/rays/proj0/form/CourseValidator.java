package in.co.rays.proj0.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.proj0.util.DataValidator;

/**
 * Contains Course for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */


@Component
public class CourseValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return CourseForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		CourseForm courseForm = (CourseForm) target;
		String courseName = courseForm.getCourseName();

		if (!DataValidator.isNull(courseName)) {
			if (!DataValidator.isNameNumber(courseName)) {
				errors.rejectValue("courseName", "error.name.invalid");
			}
		}

	}

}
