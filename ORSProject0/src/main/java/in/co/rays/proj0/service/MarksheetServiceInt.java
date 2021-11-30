package in.co.rays.proj0.service;

import java.util.List;

import in.co.rays.proj0.dto.MarksheetDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Marksheet Service interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface MarksheetServiceInt {
	
	/**
     * Adds a Marksheet.
     * 
     * @param dto
     * @return
     * @throws DuplicateRecordException
     */
    public long add(MarksheetDTO dto) throws DuplicateRecordException;

    /**
     * Updates a Marksheet.
     * 
     * @param dto
     * @throws DuplicateRecordException
     */
    public void update(MarksheetDTO dto) throws DuplicateRecordException;

    /**
     * Deletes a Marksheet
     * 
     * @param id
     */
    public void delete(long id);

    /**
     * Finds a Roll No by name.
     * 
     * @param MarksheetName
     * @return
     */
    public MarksheetDTO findByRollNo(String rollNo);

    /**
     * Finds a Marksheet by ID
     * 
     * @param id
     * @return
     */
    public MarksheetDTO findById(long id);

    /**
     * Searches Marksheets with pagination.
     * 
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List search(MarksheetDTO dto, int pageNo, int pageSize);

    /**
     * Searches Marksheets
     * 
     * @param dto
     * @return
     */
    public List search(MarksheetDTO dto);
    
    /**
     * Get merit list
     * 
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List getMeritList(int pageNo, int pageSize);

}

