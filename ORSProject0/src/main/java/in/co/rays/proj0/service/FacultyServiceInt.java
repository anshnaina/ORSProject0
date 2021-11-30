package in.co.rays.proj0.service;

import java.util.List;

import in.co.rays.proj0.dto.FacultyDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Faculty Service interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface FacultyServiceInt {
	
	/**
     * Adds a Faculty.
     * 
     * @param dto
     * @return
     * @throws DuplicateRecordException
     */
    public long add(FacultyDTO dto) throws DuplicateRecordException;

    /**
     * Updates a Faculty.
     * 
     * @param dto
     * @throws DuplicateRecordException
     */
    public void update(FacultyDTO dto) throws DuplicateRecordException;

    /**
     * Deletes a Faculty
     * 
     * @param id
     */
    public void delete(long id);

    /**
     * Finds a Faculty by Login.
     * 
     * @param FacultyName
     * @return
     */
    public FacultyDTO findByLoginId(String loginId);

    /**
     * Finds a Faculty by ID
     * 
     * @param id
     * @return
     */
    public FacultyDTO findById(long id);

    /**
     * Searches Facultys with pagination.
     * 
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List search(FacultyDTO dto, int pageNo, int pageSize);

    /**
     * Searches Facultys
     * 
     * @param dto
     * @return
     */
    public List search(FacultyDTO dto);

}

