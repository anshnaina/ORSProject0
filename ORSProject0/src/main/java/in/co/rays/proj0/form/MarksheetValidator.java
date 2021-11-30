package in.co.rays.proj0.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.co.rays.proj0.util.DataValidator;

/**
 * Contains Marksheet for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Component
public class MarksheetValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return MarksheetForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		MarksheetForm marksheetForm = (MarksheetForm) target;
		String rollNo = marksheetForm.getRollNo();
		long studentId = marksheetForm.getStudentId();
		String physics = marksheetForm.getPhysics();
		String chemistry = marksheetForm.getChemistry();
		String maths = marksheetForm.getMaths();
		
		if (studentId == 0L) {
			errors.rejectValue("studentId", "error.name.required");
		}


		if (!DataValidator.isNull(rollNo)) {
			if (!DataValidator.isNameNumber(rollNo)) {
				errors.rejectValue("rollNo", "error.rollNo.pattern");
			}
		}

		if (!DataValidator.isNull(physics)) {
			if (!DataValidator.isInteger(physics)) {
				errors.rejectValue("physics", "error.marks.integer");
			} else if (Integer.parseInt(physics) > 100) {
				errors.rejectValue("physics", "error.marks.max");
			} else if (Integer.parseInt(physics) < 0) {
				errors.rejectValue("physics", "error.marks.min");
			}
		}

		if (!DataValidator.isNull(chemistry)) {
			if (!DataValidator.isInteger(String.valueOf(chemistry))) {
				errors.rejectValue("chemistry", "error.marks.integer");
			} else if (Integer.parseInt(chemistry) > 100) {
				errors.rejectValue("chemistry", "error.marks.max");
			} else if (Integer.parseInt(chemistry) < 0) {
				errors.rejectValue("chemistry", "error.marks.min");
			}
		}

		if (!DataValidator.isNull(maths)) {
			if (!DataValidator.isInteger(String.valueOf(maths))) {
				errors.rejectValue("maths", "error.marks.integer");
			} else if (Integer.parseInt(maths) > 100) {
				errors.rejectValue("maths", "error.marks.max");
			} else if (Integer.parseInt(maths) < 0) {
				errors.rejectValue("maths", "error.marks.min");
			}
		}

	}
}
