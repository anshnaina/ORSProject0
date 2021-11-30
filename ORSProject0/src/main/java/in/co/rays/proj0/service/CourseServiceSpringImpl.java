package in.co.rays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.CourseDAOInt;
import in.co.rays.proj0.dto.CollegeDTO;
import in.co.rays.proj0.dto.CourseDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Session facade of Course Service. It is transactional, apply delcarative
 * transactions with help of Spring AOP.
 * 
 * If unchecked exception is propagated from a method then transaction will be
 * rolled back.
 * 
 * Default propogation value is Propagation.REQUIRED and readOnly = false
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Service("courseService")
public class CourseServiceSpringImpl implements CourseServiceInt {

	@Autowired
	private CourseDAOInt dao;

	private static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);

	/**
	 * Adds a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(CourseDTO dto) throws DuplicateRecordException {
		System.out.println("This is add method in Course Service Implementation");
		CourseDTO dtoExist = dao.findByCourseName(dto.getCourseName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Course Name already exists");
		}
		long pk = dao.add(dto);
		return pk;
	}

	/**
	 * Updates a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when updated Course is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		System.out.println("This is Update method in Course Service Implementation");
		CourseDTO dtoExist = dao.findByCourseName(dto.getCourseName());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Course Name already exists");
		}
		dao.update(dto);
	}

	/**
	 * Deletes a Course
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete method in Course Service Implementation");
		CourseDTO dtoExist = findById(id);
		dao.delete(dtoExist);
	}

	/**
	 * Finds Course by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public CourseDTO findByCourseName(String name) {
		System.out.println("This is findByName method in Course Service Implementation");
		CourseDTO dto = dao.findByCourseName(name);
		return dto;
	}

	/**
	 * Finds record by Primary Key
	 */
	@Transactional(readOnly = true)
	public CourseDTO findById(long pk) {
		System.out.println("This is findByPK method in Course Service Implementation");
		CourseDTO dto = dao.findByPK(pk);
		return dto;
	}

	/**
	 * Searches Courses with pagination
	 * 
	 * @return list : List of Courses
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(CourseDTO dto, int pageNo, int pageSize) {
		System.out.println("This is search (Pagination) method in Course Service Implementation");
		return dao.search(dto, pageNo, pageSize);
	}

	/**
	 * Searches Courses
	 * 
	 * @return list : List of Courses
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(CourseDTO dto) {
		System.out.println("This is Search method in Course Service Implementation");
		return dao.search(dto);
	}

}
