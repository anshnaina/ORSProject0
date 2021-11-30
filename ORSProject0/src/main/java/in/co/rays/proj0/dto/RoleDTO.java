package in.co.rays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Role POJO class. It is persistent object.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * Predefined Role constants
	 */
	public static final int ADMIN = 1;
	public static final long STUDENT = 2;
	public static final int COLLEGE = 3;
	public static final int KIOSK = 4;
	public static final int FACULTY = 5;

	/**
	 * Name of Role
	 */
	@Column(name = "NAME", length = 50)
	private String name;

	/**
	 * Description of Role
	 */
	@Column(name = "DESCRIPTION", length = 100)
	private String description;

	/**
	 * accessor
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return name;
	}

}
