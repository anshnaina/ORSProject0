package in.co.rays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.rays.proj0.dto.StudentDTO;

/**
 * 
 * Student DAO interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface StudentDAOInt {

	/**
	 * Adds a Student.
	 * 
	 * @param dto
	 * @return
	 */
	public long add(StudentDTO dto) throws DataAccessException;

	/**
	 * Updates a Student.
	 * 
	 * @param dto
	 */
	public void update(StudentDTO dto) throws DataAccessException;

	/**
	 * Deletes a Student.
	 * 
	 * @param dto
	 */
	public void delete(StudentDTO dto) throws DataAccessException;

	/**
	 * Finds Student by Email
	 */
	public StudentDTO findByEmail(String email);

	/**
	 * Finds Student by Primary Key.
	 * 
	 * @param pk
	 * @return
	 */
	public StudentDTO findByPK(long pk) throws DataAccessException;

	/**
	 * Searches Student with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List search(StudentDTO dto, int pageNo, int pageSize) throws DataAccessException;

	/**
	 * Seraches Student.
	 * 
	 * @param dto
	 * @return
	 */
	public List search(StudentDTO dto) throws DataAccessException;

}
