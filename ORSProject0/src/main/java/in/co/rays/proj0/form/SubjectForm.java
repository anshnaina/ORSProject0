package in.co.rays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.SubjectDTO;

/**
 * Contains Subject form elements and their declarative input validations.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class SubjectForm extends BaseForm {
	
	/**
	 * courseId of Subject
	 */
	@NotNull
	private Long courseId;

	/**
	 * Name of Subject
	 */
	@NotEmpty
	private String subjectName;

	/**
	 * description of Subject
	 */
	@NotEmpty
	private String description;

	/*
	 * Accesor Methods
	 */

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	/**
	 * Populate dto from form
	 */
	public BaseDTO getDto(HttpSession session) {

		SubjectDTO dto = new SubjectDTO();

		dto.setId(id);
		dto.setCourseId(courseId);
		dto.setSubjectName(subjectName);
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

		SubjectDTO dto = (SubjectDTO) bDto;

		id = dto.getId();
		courseId = dto.getCourseId();
		subjectName = dto.getSubjectName();
		description = dto.getDescription();

		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();

		createdDatetime = dto.getCreatedDatetime().getTime();
		modifiedDatetime = dto.getModifiedDatetime().getTime();
	}

}
