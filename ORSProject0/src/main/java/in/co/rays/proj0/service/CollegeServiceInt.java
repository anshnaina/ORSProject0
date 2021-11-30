package in.co.rays.proj0.service;

import java.util.List;

import in.co.rays.proj0.dto.CollegeDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * College Service interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */
public interface CollegeServiceInt {
	
	/**
     * Adds a College
     * 
     * @param dto
     * @throws ApplicationException
     * @throws DuplicateRecordException
     *             : throws when College is already exists
     */
    public long add(CollegeDTO dto) throws DuplicateRecordException;

    /**
     * Updates a College
     * 
     * @param dto
     * @throws ApplicationException
     * @throws DuplicateRecordException
     *             : throws when updated College is already exists
     */
    public void update(CollegeDTO dto) throws DuplicateRecordException;

    /**
     * Deletes a College
     * 
     * @param id
     */
    public void delete(long id);

    /**
     * Finds College by Name
     * 
     * @param name
     *            : get parameter
     * @return dto
     */
    public CollegeDTO findByCollegeName(String name);

    /**
     * Finds College by primary key
     * 
     * @param name
     *            : get parameter
     * @return dto
     */
    public CollegeDTO findById(long id);

    /**
     * Searches Colleges
     * 
     * @return list : List of Colleges
     * @param dto
     *            : Search Parameters
     */
    public List search(CollegeDTO dto);

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
     */
    public List search(CollegeDTO dto, int pageNo, int pageSize);

}

