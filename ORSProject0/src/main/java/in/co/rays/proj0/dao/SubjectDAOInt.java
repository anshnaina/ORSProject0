package in.co.rays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.rays.proj0.dto.SubjectDTO;

/**
 * Data Access Object of Subject
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public interface SubjectDAOInt {
	
	/**
     * Add a Subject
     * 
     * @param dto
     *
     */
    public long add(SubjectDTO dto) throws DataAccessException;

    /**
     * Update a Subject
     * 
     * @param dto
    
     */
    public void update(SubjectDTO dto) throws DataAccessException ;

    /**
     * Delete a Subject
     * 
     * @param dto
     * @
     */
    public void delete(SubjectDTO dto) throws DataAccessException;

    /**
     * Find Subject by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     * @
     */
    public SubjectDTO findBySubjectName(String name) throws DataAccessException ;

    /**
     * Find Subject by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     * @
     */
    public SubjectDTO findByPK(long pk) throws DataAccessException ;

    /**
     * Search Subject with pagination
     * 
     * @return list : List of Subject
     * @param dto
     *            : Search Parameters
     * @param pageNo
     *            : Current Page No.
     * @param pageSize
     *            : Size of Page
     * @
     */
    public List search(SubjectDTO dto, int pageNo, int pageSize) throws DataAccessException ;

    /**
     * Search Subject
     * 
     * @return list : List of Subject
     * @param dto
     *            : Search Parameters
     * @
     */
    public List search(SubjectDTO dto) throws DataAccessException;
    
}
