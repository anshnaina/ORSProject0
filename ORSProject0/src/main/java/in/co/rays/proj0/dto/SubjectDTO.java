package in.co.rays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Subject JavaBean encapsulates Subject attributes
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Entity
@Table(name="st_subject")
public class SubjectDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Name of Course
	 */
	@Column(name = "Course_Name", length = 50)
	private String courseName;
	
	/**
	 *  ID of Course
	 */
	@Column(name = "Course_Id") 
	private long courseId;
	
	/**
	 *  Name of Subject
	 */
	@Column(name = "Subject_Name", length = 50)
	private String subjectName;

	/**
	 * Description
	 */
	@Column(name = "Description", length = 50)
	private String description;

	/**
	 * accessor
	 */

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

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
		return subjectName;
	}

}

