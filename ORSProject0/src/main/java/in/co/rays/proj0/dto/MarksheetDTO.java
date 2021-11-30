package in.co.rays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Marksheet JavaBean encapsulates Marksheet attributes
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 * 
 */

@Entity
@Table(name = "st_marksheet")
public class MarksheetDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * Rollno of Student
	 */
	@Column(name = "ROLL_NO", length = 20)
	protected String rollNo;

	/**
	 * ID of Student
	 */
	@Column(name = "STUDENT_ID")
	protected Long studentId;

	/**
	 * Name of Student
	 */
	@Column(name = "NAME", length = 50)
	protected String name;

	/**
	 * Physics marks of Student
	 */
	@Column(name = "physics", length = 50)
	protected String physics;
	/**
	 * Chemistry marks of Student
	 */
	@Column(name = "chemistry", length = 50)
	protected String chemistry;
	/**
	 * Mathematics marks of Student
	 */
	@Column(name = "maths", length = 50)
	protected String maths;
	
    /**
     * accessor
     */

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

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
	 * @Override public String getKey()
	 */
    public String getKey() {
        return id + "";
    }

    /**
	 * @Override public String getValue()
	 */
    public String getValue() {
        return rollNo;
    }

}
