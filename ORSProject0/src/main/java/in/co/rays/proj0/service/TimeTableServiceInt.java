package in.co.rays.proj0.service;

import java.util.Date;
import java.util.List;

import in.co.rays.proj0.dto.TimeTableDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * TimeTable Service interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface TimeTableServiceInt {
	
	/**
     * Adds a TimeTable.
     * 
     * @param dto
     * @return
     * @throws DuplicateRecordException
     */
    public long add(TimeTableDTO dto) throws DuplicateRecordException;

    /**
     * Updates a TimeTable.
     * 
     * @param dto
     * @throws DuplicateRecordException
     */
    public void update(TimeTableDTO dto) throws DuplicateRecordException;

    /**
     * Deletes a TimeTable
     * 
     * @param id
     */
    public void delete(long id);

    /**
 	 * Finds TimeTable by Course, Semester and Subject
 	 * 
 	 * @param courseId
 	 *            : get Course Id
 	 * @param subjectId
 	 *            : get ID of Subject
 	 * @return dto
 	 * 
 	 */
 	public TimeTableDTO findByCourseAndSubAndSem(Long courseId, Long subjectId,String sem)  ;
 	
 	/**
 	 * Finds TimeTable by Date and Course
 	 * 
 	 * @param examDate
 	 *            : get Exam Date
 	 * @param courseId
 	 *            : get ID of Course
 	 * @return dto
 	 * 
 	 */
 	public TimeTableDTO findByDateAndCourseIdAndSem(Date examDate, Long courseId ,String sem) ;

    /**
     * Finds a TimeTable by ID
     * 
     * @param id
     * @return
     */
    public TimeTableDTO findById(long id);

    /**
     * Searches TimeTables with pagination.
     * 
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List search(TimeTableDTO dto, int pageNo, int pageSize);

    /**
     * Searches TimeTables
     * 
     * @param dto
     * @return
     */
    public List search(TimeTableDTO dto);
    

}


