package in.co.rays.proj0.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.rays.proj0.dto.TimeTableDTO;

/**
 * 
 * TimeTable DAO interface.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public interface TimeTableDAOInt {

	/**
	 * Adds a TimeTable.
	 * 
	 * @param dto
	 * @return
	 */
	public long add(TimeTableDTO dto) throws DataAccessException;

	/**
	 * Updates a TimeTable.
	 * 
	 * @param dto
	 */
	public void update(TimeTableDTO dto) throws DataAccessException;

	/**
	 * Deletes a TimeTable.
	 * 
	 * @param dto
	 */
	public void delete(TimeTableDTO dto) throws DataAccessException;

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
	public TimeTableDTO findByCourseAndSubAndSem(Long courseId, Long subjectId, String sem);

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
	public TimeTableDTO findByDateAndCourseIdAndSem(Date examDate, Long courseId, String sem);

	/**
	 * Finds TimeTable by Primary Key.
	 * 
	 * @param pk
	 * @return
	 */
	public TimeTableDTO findByPK(long pk) throws DataAccessException;

	/**
	 * Searches TimeTable with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List search(TimeTableDTO dto, int pageNo, int pageSize) throws DataAccessException;

	/**
	 * Seraches TimeTable.
	 * 
	 * @param dto
	 * @return
	 */
	public List search(TimeTableDTO dto) throws DataAccessException;

}
