package in.co.rays.proj0.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.proj0.util.DataValidator;

/**
 * Contains Subject form for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Component
public class SubjectValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return SubjectForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		SubjectForm subjectForm = (SubjectForm) target;
		String subjectName = subjectForm.getSubjectName();

		if (!DataValidator.isNull(subjectName)) {
			if (!DataValidator.isNameNumber(subjectName)) {
				errors.rejectValue("subjectName", "error.name.invalid");
			}
		}

	}
}