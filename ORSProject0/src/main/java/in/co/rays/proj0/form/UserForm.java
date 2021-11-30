package in.co.rays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.UserDTO;
import in.co.rays.proj0.util.Util;

/**
 * Contains User form elements and their declarative input validations.
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public class UserForm extends BaseForm {

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
	 * Password of User
	 */
	@NotEmpty
	private String password;

	/**
	 * confirm Password of User
	 */
	@NotEmpty
	private String confirmPassword;

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
	 * Role of User
	 */
	@NotNull
	private Long roleId;

	/**
	 * Gender of User
	 */
	@NotEmpty
	private String gender;

	private String unsuccessfulLogin;
	private long lastLogin;
	private String lock;
	private String registeredIP;
	private String lastLoginIP;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUnsuccessfulLogin() {
		return unsuccessfulLogin;
	}

	public void setUnsuccessfulLogin(String unsuccessfulLogin) {
		this.unsuccessfulLogin = unsuccessfulLogin;
	}

	public long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
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
		dto.setPassword(password);
		dto.setConfirmPassword(confirmPassword);
		dto.setDob(Util.getDate(dob));
		dto.setMobileNo(mobileNo);
		dto.setGender(gender);
		dto.setRoleId(roleId);

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
		password = dto.getPassword();
		confirmPassword = dto.getConfirmPassword();
		dob = Util.getDate(dto.getDob());
		mobileNo = dto.getMobileNo();
		gender = dto.getGender();
		roleId = dto.getRoleId();

		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();

		createdDatetime = dto.getCreatedDatetime().getTime();
		modifiedDatetime = dto.getModifiedDatetime().getTime();

	}

}
