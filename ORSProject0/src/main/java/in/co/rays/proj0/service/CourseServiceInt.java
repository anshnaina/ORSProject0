package in.co.rays.proj0.service;

import java.util.List;

import in.co.rays.proj0.dto.CourseDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Course Service interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface CourseServiceInt {
	
	/**
	 * Add a Course
	 * 
	 * @param dto
	 * 
	 */
	public long add(CourseDTO dto) throws DuplicateRecordException;

	/**
	 * Update a Course
	 * 
	 * @param dto
	 * 
	 */
	public void update(CourseDTO dto) throws DuplicateRecordException ;

	/**
	 * Delete a Course
	 * 
	 * @param dto
	 * @
	 */
	public void delete(long id) ;

	/**
	 * Find Course by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @
	 */
	public CourseDTO findByCourseName(String name) ;

	/**
	 * Find Course by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @
	 */
	public CourseDTO findById(long pk) ;

	/**
	 * Search Course with pagination
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize) ;

	/**
	 * Search Course
	 * 
	 * @return list : List of Course
	 * @param dto
	 *            : Search Parameters
	 * @
	 */
	public List search(CourseDTO dto) ;

}

