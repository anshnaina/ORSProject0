package in.co.rays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.rays.proj0.dto.FacultyDTO;

/**
 * Data Access Object of Faculty
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public interface FacultyDAOInt {
	
	/**
	 * Add a Faculty
	 * 
	 * @param dto
	 * 
	 */
	public long add(FacultyDTO dto) throws DataAccessException ;
 
	/**
	 * Update a Faculty
	 * 
	 * @param dto
	 * 
	 */
	public void update(FacultyDTO dto) throws DataAccessException ;

	/**
	 * Delete a Faculty
	 * 
	 * @param dto
	 * @
	 */
	public void delete(FacultyDTO dto) throws DataAccessException ;

	/**
	 * Find Faculty by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto @
	 */
	public FacultyDTO findByLoginId(String login) throws DataAccessException ;

	/**
	 * Find Faculty by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto @
	 */
	public FacultyDTO findByPK(long pk) throws DataAccessException ;

	/**
	 * Search Faculty with pagination
	 * 
	 * @return list : List of Faculty
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page @
	 */
	public List search(FacultyDTO dto, int pageNo, int pageSize) throws DataAccessException ;

	/**
	 * Search Faculty
	 * 
	 * @return list : List of Faculty
	 * @param dto
	 *            : Search Parameters @
	 */
	public List search(FacultyDTO dto) throws DataAccessException ;

}
