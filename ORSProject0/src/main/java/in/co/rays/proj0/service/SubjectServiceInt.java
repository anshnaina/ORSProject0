package in.co.rays.proj0.service;

import java.util.List;

import in.co.rays.proj0.dto.SubjectDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Subject Service interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface SubjectServiceInt {

	/**
     * Add a Subject
     * 
     * @param dto
     *
     */
    public long add(SubjectDTO dto) throws DuplicateRecordException;

    /**
     * Update a Subject
     * 
     * @param dto
    
     */
    public void update(SubjectDTO dto) throws DuplicateRecordException;

    /**
     * Delete a Subject
     * 
     * @param dto
     * @
     */
    public void delete(long id);

    /**
     * Find Subject by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     * @
     */
    public SubjectDTO findBySubjectName(String name) ;

    /**
     * Find Subject by PK
     * 
     * @param pk
     *            : get parameter
     * @return dto
     * @
     */
    public SubjectDTO findById(long id) ;

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
    public List search(SubjectDTO dto, int pageNo, int pageSize);
    
    /**
     * Search Subject
     * 
     * @return list : List of Subject
     * @param dto
     *            : Search Parameters
     * @
     */
    public List search(SubjectDTO dto) ;

}

