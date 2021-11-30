package in.co.rays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.CollegeDTO;

/**
 * Contains College form elements and their declarative input validations.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class CollegeForm extends BaseForm {

	/**
	 * Name of College
	 */
	@NotEmpty
	private String name;
	/**
	 * Address of College
	 */
	@NotEmpty
	private String address;
	/**
	 * State of College
	 */
	@NotEmpty
	private String state;
	/**
	 * City of College
	 */
	@NotEmpty
	private String city;
	/**
	 * Phoneno of College
	 */
	@NotEmpty
	private String phoneNo;

	/*
	 * Accesor Methods
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Populate dto from form
	 */
	public BaseDTO getDto(HttpSession session) {

		CollegeDTO dto = new CollegeDTO();

		dto.setId(id);
		dto.setName(name);
		dto.setAddress(address);
		dto.setState(state);
		dto.setCity(city);
		dto.setPhoneNo(phoneNo);

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

		CollegeDTO dto = (CollegeDTO) bDto;
		id = dto.getId();
		name = dto.getName();
		address = dto.getAddress();
		city = dto.getCity();
		phoneNo = dto.getPhoneNo();
		state = dto.getState();

		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		
		createdDatetime = dto.getCreatedDatetime().getTime();
		modifiedDatetime = dto.getModifiedDatetime().getTime();
	}

}
