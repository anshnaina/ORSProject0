package in.co.rays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.UserDTO;
import in.co.rays.proj0.util.Util;

/**
 * Contains My Profile for Custom Validation
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public class MyProfileForm extends BaseForm {

	/**
	 * First Name of User
	 */
	@NotEmpty
	private String firstName;
	/**
	 * Last Name of User
	 */
	@NotEmpty
	private String lastName;

	@Email
	@NotEmpty
	private String login;

	/**
	 * Date of Birth of User
	 */
	@NotEmpty
	private String dob;

	/**
	 * MobielNo of User
	 */
	@NotEmpty

	private String mobileNo;

	/**
	 * Gender of User
	 */
	@NotEmpty
	private String gender;

	/*
	 * Accesor Methods
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Override of getDto
	 */
	public BaseDTO getDto(HttpSession session) {

		UserDTO dto = new UserDTO();

		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setDob(Util.getDate(dob));
		dto.setMobileNo(mobileNo);
		dto.setGender(gender);

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

		UserDTO dto = (UserDTO) bDto;

		id = dto.getId();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		login = dto.getLogin();
		dob = Util.getDate(dto.getDob());
		mobileNo = dto.getMobileNo();
		gender = dto.getGender();

		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();

		createdDatetime = dto.getCreatedDatetime().getTime();
		modifiedDatetime = dto.getModifiedDatetime().getTime();

	}

}
