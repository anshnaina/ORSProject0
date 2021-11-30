package in.co.rays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.rays.proj0.dto.BaseDTO;
import in.co.rays.proj0.dto.MarksheetDTO;

/**
 * Contains MArksheet form elements and their declarative input validations.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

public class MarksheetForm extends BaseForm{
	
	@NotEmpty
	private String rollNo = null;

	/**
	 * Name of Student
	 */
	private String name = null;
	
	@NotNull
	private Long studentId;


	@NotEmpty
	private String physics;

	@NotEmpty
	private String chemistry;

	@NotEmpty
	private String maths;

	/**
	 * Accessor
	 *
	 */
	
	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getPhysics() {
		return physics;
	}

	public void setPhysics(String physics) {
		this.physics = physics;
	}

	public String getChemistry() {
		return chemistry;
	}

	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}

	public String getMaths() {
		return maths;
	}

	public void setMaths(String maths) {
		this.maths = maths;
	}
	
	/**
	 * Populate dto from form
	 */
	public BaseDTO getDto(HttpSession session) {
		
		MarksheetDTO dto = new MarksheetDTO();
		
		dto.setId(id);
		dto.setRollNo(rollNo);
		dto.setStudentId(studentId);
		dto.setName(name);
		dto.setPhysics(physics);
		dto.setChemistry(chemistry);
		dto.setMaths(maths);
		
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
		
		MarksheetDTO dto = (MarksheetDTO) bDto;
		
		id = dto.getId();
		rollNo = dto.getRollNo();
		studentId = dto.getStudentId();
		name = dto.getName();
		chemistry = dto.getChemistry();
		physics = dto.getPhysics();
		maths = dto.getMaths();

		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();

		createdDatetime = dto.getCreatedDatetime().getTime();
		modifiedDatetime = dto.getModifiedDatetime().getTime();

	}
	
}
