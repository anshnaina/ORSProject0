package in.co.rays.proj0.form;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.RoleDTO;


/**
 * Contains Role form elements and their declarative input validations.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class RoleForm extends BaseForm {

	/**
	 * Name of Role
	 */
	@NotEmpty
	private String name;

	/**
	 * Description of Description
	 */
	@NotEmpty
	private String description;

	/**
	 * Accessor
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
	 * Override of getDto
	 */
	public BaseDTO getDto(HttpSession session) {
		RoleDTO dto = new RoleDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		

		return dto;
	}

	/**
	 * Override of Populate dto
	 */
	public void populate(BaseDTO bDto) {
		if (bDto == null) {
			return;
		}
		RoleDTO dto = (RoleDTO) bDto;

		id = dto.getId();
		name = dto.getName();
		description = dto.getDescription();
	}

}
