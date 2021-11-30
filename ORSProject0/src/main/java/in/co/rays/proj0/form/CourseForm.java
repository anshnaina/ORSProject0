package in.co.rays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.CourseDTO;

/**
 * Contains Course form elements and their declarative input validations.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */
public class CourseForm extends BaseForm {

	/**
	 * Name of Course
	 */
	@NotEmpty
	private String courseName;

	/**
	 * description of Course
	 */
	@NotEmpty
	private String description;
	/**
	 * duration of Course
	 */
	@NotEmpty
	private String duration;

	/*
	 * Accesor Methods
	 */

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * Populate dto from form
	 */
	public BaseDTO getDto(HttpSession session) {

		CourseDTO dto = new CourseDTO();

		dto.setId(id);
		dto.setCourseName(courseName);
		dto.setDuration(duration);
		dto.setDescription(description);
		
		getGeneric(session);

		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		
		if (this.createdDatetime > 0L) {
			dto.setCreatedDatetime(new Timestamp(this.createdDatetime));
		} else {
			dto.setCreatedDatetime(new Timestamp((new Date()).getTime()));
		}
		dto.setModifiedDatetime(new Timestamp((new Date()).getTime()));
		
		return dto;
	}

	/**
	 * Populate from from dto
	 */
	public void populate(BaseDTO bDto) {

		if (bDto == null) {
			return;
		}

		CourseDTO dto = (CourseDTO) bDto;

		id = dto.getId();
		courseName = dto.getCourseName();
		duration = dto.getDuration();
		description = dto.getDescription();

		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();

		createdDatetime = dto.getCreatedDatetime().getTime();
		modifiedDatetime = dto.getModifiedDatetime().getTime();
	}
}
