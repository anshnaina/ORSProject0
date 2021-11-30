package in.co.rays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.FacultyDTO;
import in.co.rays.proj0.util.Util;

/**
 * Contains Faculty form elements and their declarative input validations.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class FacultyForm extends BaseForm {

	/**
	 * firstName of Faculty
	 */
	@NotEmpty
	private String firstName;

	/**
	 * lastName of Faculty
	 */
	@NotEmpty
	private String lastName;

	/**
	 * emailId of Faculty
	 */
	@NotEmpty
	@Email
	private String loginId;

	/**
	 * Date of joining of Faculty
	 */
	@NotEmpty
	private String doj;

	/**
	 * Mobile Number of Faculty
	 */
	@NotEmpty
	private String mobileNo;

	/**
	 * collegeId of Faculty
	 */
	@NotNull
	private Long collegeId;

	/**
	 * subjectId of Faculty
	 */
	@NotNull
	private Long subjectId;

	/**
	 * accessor
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * Populate dto from form
	 */
	public BaseDTO getDto(HttpSession session) {

		FacultyDTO dto = new FacultyDTO();

		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setDoj((Util.getDate(doj)));
		dto.setLoginId(loginId);
		dto.setMobileNo(mobileNo);
		dto.setCollegeId(collegeId);
		dto.setSubjectId(subjectId);

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

		FacultyDTO dto = (FacultyDTO) bDto;

		id = dto.getId();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		doj = Util.getDate(dto.getDoj());
		loginId = dto.getLoginId();
		mobileNo = dto.getMobileNo();
		collegeId = dto.getCollegeId();
		subjectId = dto.getSubjectId();

		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();

		createdDatetime = dto.getCreatedDatetime().getTime();
		modifiedDatetime = dto.getModifiedDatetime().getTime();
	}

}
