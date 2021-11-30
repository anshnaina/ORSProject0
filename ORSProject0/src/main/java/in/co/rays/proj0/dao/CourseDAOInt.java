package in.co.rays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.rays.proj0.dto.CourseDTO;

/**
 * Data Access Object of Course
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public interface CourseDAOInt {
	
	/**
	 * Add a Course
	 * 
	 * @param dto
	 * 
	 */
	public long add(CourseDTO dto) throws DataAccessException ;
 
	/**
	 * Update a Course
	 * 
	 * @param dto
	 * 
	 */
	public void update(CourseDTO dto) throws DataAccessException ;

	/**
	 * Delete a Course
	 * 
	 * @param dto
	 * @
	 */
	public void delete(CourseDTO dto) throws DataAccessException ;

	/**
	 * Find Course by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto @
	 */
	public CourseDTO findByCourseName(String name) throws DataAccessException ;

	/**
	 * Find Course by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto @
	 */
	public CourseDTO findByPK(long pk) throws DataAccessException ;

	/**
	 * Search Course with pagination
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page @
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize) throws DataAccessException ;

	/**
	 * Search Course
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters @
	 */
	public List search(CourseDTO dto) throws DataAccessException ;

}
