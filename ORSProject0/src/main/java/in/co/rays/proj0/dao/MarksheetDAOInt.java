package in.co.rays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.rays.proj0.dto.MarksheetDTO;

/**
 * 
 * Marksheet DAO interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface MarksheetDAOInt {

	/**
	 * Adds a Marksheet.
	 * 
	 * @param dto
	 * @return
	 */
	public long add(MarksheetDTO dto) throws DataAccessException;

	/**
	 * Updates a Marksheet.
	 * 
	 * @param dto
	 */
	public void update(MarksheetDTO dto) throws DataAccessException;

	/**
	 * Deletes a Marksheet.
	 * 
	 * @param dto
	 */
	public void delete(MarksheetDTO dto) throws DataAccessException;

	/**
	 * Finds Marskheet by Roll No.
	 * 
	 * @param rollNo
	 * @return
	 */
	public MarksheetDTO findByRollNo(String rollNo) throws DataAccessException;

	/**
	 * Finds Marksheet by Primary Key.
	 * 
	 * @param pk
	 * @return
	 */
	public MarksheetDTO findByPK(long pk) throws DataAccessException;

	/**
	 * Searches Marksheet with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize) throws DataAccessException;

	/**
	 * Seraches Marksheet.
	 * 
	 * @param dto
	 * @return
	 */
	public List search(MarksheetDTO dto) throws DataAccessException;

	/**
	 * Gets Merit List.
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List getMeritList(int pageNo, int pageSize) throws DataAccessException;

}
