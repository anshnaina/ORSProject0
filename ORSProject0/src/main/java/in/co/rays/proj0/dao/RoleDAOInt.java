package in.co.rays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.rays.proj0.dto.RoleDTO;


/**
 * 
 * Role DAO interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface RoleDAOInt {
	
	/**
	 * Adds a Role.
	 * 
	 * @param dto
	 * @return
	 */
	public long add(RoleDTO dto) throws DataAccessException ;

	/**
	 * Updates a Role.
	 * 
	 * @param dto
	 */
	public void update(RoleDTO dto) throws DataAccessException ;

	/**
	 * Deletes a Role.
	 * 
	 * @param dto
	 */
	public void delete(RoleDTO dto) throws DataAccessException ;

	/**
	 * Finds Role by name.
	 * 
	 * @param roleName
	 * @return
	 */
	public RoleDTO findByRoleName(String roleName) throws DataAccessException ;

	/**
	 * Finds Role by Primary Key.
	 * 
	 * @param pk
	 * @return
	 */
	public RoleDTO findByPK(long pk) throws DataAccessException ;

	/**
	 * Searches Role with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List search(RoleDTO dto, int pageNo, int pageSize) throws DataAccessException ;

	/**
	 * Seraches Role.
	 * 
	 * @param dto
	 * @return
	 */
	public List search(RoleDTO dto) throws DataAccessException ;

}
