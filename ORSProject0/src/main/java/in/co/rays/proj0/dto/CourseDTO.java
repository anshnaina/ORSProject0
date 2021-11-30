package in.co.rays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Course JavaBean encapsulates Course attributes
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

@Entity
@Table(name="st_course")
public class CourseDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Name of Course
	 */
	@Column(name = "COURSENAME", length = 50)
	private String courseName;
	/**
	 * Description of Course
	 */
	@Column(name = "DESCRIPTION")
	private String description;
	
	/**
	 * duration of Course
	 */
	@Column(name = "DURATION")
	private String duration;

	/**
	 * Acceser
	 */
	
	public String getCourseName() {
		return courseName;
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
	 * @Override public String getKey()
	 */
	public String getKey() {
		return id + "";
	}

	/**
	 * @Override public String getValue()
	 */
	public String getValue() {
		return courseName;
	}

}

