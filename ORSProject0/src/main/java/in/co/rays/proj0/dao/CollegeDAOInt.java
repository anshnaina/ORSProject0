package in.co.rays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.rays.proj0.dto.CollegeDTO;

/**
 * College DAO interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public interface CollegeDAOInt {
	
	/**
	 * Adds a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public long add(CollegeDTO dto) throws DataAccessException ;

	/**
	 * Updates a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(CollegeDTO dto) throws DataAccessException ;

	/**
	 * Deletes a College
	 * 
	 * @param id
	 * @throws DatabaseException
	 */
	public void delete(CollegeDTO dto)  throws DataAccessException ;

	/**
	 * Finds College by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public CollegeDTO findByCollegeName(String name) throws DataAccessException ;

	/**
	 * Finds College by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public CollegeDTO findByPK(long pk) throws DataAccessException ;

	/**
	 * Searches Colleges with pagination
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DatabaseException
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize) throws DataAccessException ;;
	
	/**
	 * Searches Colleges
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(CollegeDTO dto) throws DataAccessException ;

}
