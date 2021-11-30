package in.co.rays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * College JavaBean encapsulates College attributes
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

@Entity
@Table(name = "st_college")
public class CollegeDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/**
	 * Name of College
	 */
	@Column(name = "NAME", length = 50)
	private String name;
	/**
	 * Address of College
	 */
	@Column(name = "ADDRESS", length = 50)
	private String address;
	/**
	 * State of College
	 */
	@Column(name = "STATE", length = 50)
	private String state;
	/**
	 * City of College
	 */
	@Column(name = "CITY", length = 50)
	private String city;
	/**
	 * Phoneno of College
	 */
	@Column(name = "PHONE_NO", length = 15)
	private String phoneNo;

	/**
	 * accessor
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

