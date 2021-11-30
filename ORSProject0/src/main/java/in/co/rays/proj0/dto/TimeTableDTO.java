package in.co.rays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TimeTable JavaBean encapsulates TimeTable attributes
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Entity
@Table(name = "st_timetable")
public class TimeTableDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * courseName of TimeTable
	 */
	@Column(name = "course_name", length = 50)
	private String courseName;

	/**
	 * courseId of TimeTable
	 */
	@Column(name = "course_id")
	private Long courseId;

	/**
	 * subjectName of TimeTable
	 */
	@Column(name = "subject_name", length = 50)
	private String subjectName;

	/**
	 * subjectId of TimeTable
	 */
	@Column(name = "subject_id")
	private Long subjectId;

	/**
	 * examDate of TimeTable
	 */
	@Column(name = "exam_date")
	private Date examDate;

	/**
	 * time of TimeTable
	 */
	@Column(name = "exam_time", length = 50)
	private String examTime;

	/**
	 * semester of TimeTable
	 */
	@Column(name = "SEMESTER", length = 50)
	private String semester;
	
	/**
	 * accessor
	 */

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @Override public String getKey()
	 */
	public String getKey() {
		return id + "";
	}

	/**
	 * @Override public String getValue()
	 */
	public String getValue() {
		return examDate + "";
	}
	

}
