package in.co.rays.proj0.service;

import java.util.List;

import in.co.rays.proj0.dto.StudentDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Student Service interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface StudentServiceInt {
	
	/**
     * Adds a Student.
     * 
     * @param dto
     * @return
     * @throws DuplicateRecordException
     */
    public long add(StudentDTO dto) throws DuplicateRecordException;

    /**
     * Updates a Student.
     * 
     * @param dto
     * @throws DuplicateRecordException
     */
    public void update(StudentDTO dto) throws DuplicateRecordException;

    /**
     * Deletes a Student
     * 
     * @param id
     */
    public void delete(long id);

    /**
     * Finds a Student by Login.
     * 
     * @param StudentName
     * @return
     */
    public StudentDTO findByEmail(String email);

    /**
     * Finds a Student by ID
     * 
     * @param id
     * @return
     */
    public StudentDTO findById(long id);

    /**
     * Searches Students with pagination.
     * 
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List search(StudentDTO dto, int pageNo, int pageSize);

    /**
     * Searches Students
     * 
     * @param dto
     * @return
     */
    public List search(StudentDTO dto);

}
