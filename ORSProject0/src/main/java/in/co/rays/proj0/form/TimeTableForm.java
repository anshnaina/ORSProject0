package in.co.rays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.TimeTableDTO;
import in.co.rays.proj0.util.Util;

/**
 * Contains Time Table form elements and their declarative input validations.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class TimeTableForm extends BaseForm {
	
	/**
	 * courseId of TimeTable
	 */
	@NotNull
	private Long courseId;
	
	private String courseName;
	
	/**
	 * subjectId of TimeTable
	 */
	@NotNull
	private Long subjectId;
	
	private String subjectName;

	/**
	 * time of TimeTable
	 */
	@NotEmpty
	private String examTime;
	
	/**
	 * examDate of TimeTable
	 */
	@NotEmpty
	private String examDate;
	
	/**
	 * semester of TimeTable
	 */
	@NotEmpty
	private String semester;
	
	/**
	 * accessor
	 */

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	/**
	 * Override of getDto
	 */
	public BaseDTO getDto(HttpSession session) {
		
		TimeTableDTO dto = new TimeTableDTO();

		dto.setId(id);
		dto.setCourseId(courseId);
		dto.setSubjectId(subjectId);
		dto.setExamTime(examTime);
		dto.setExamDate(Util.getDate(examDate));
		dto.setSemester(semester);
		dto.setCourseName(courseName);
		dto.setSubjectName(subjectName);
		
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
	 * Override of Populate dto
	 */
	public void populate(BaseDTO bDto) {
		if (bDto == null) {
			return;
		}
		
		TimeTableDTO dto = (TimeTableDTO) bDto;

		id = dto.getId();
		courseId = dto.getCourseId();
		subjectId = dto.getSubjectId();
		examTime = dto.getExamTime();
		examDate = Util.getDate(dto.getExamDate());
		semester = dto.getSemester();		
		courseName=dto.getCourseName();
		subjectName=dto.getSubjectName();

		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();

		createdDatetime = dto.getCreatedDatetime().getTime();
		modifiedDatetime = dto.getModifiedDatetime().getTime();
	}	
		
}
