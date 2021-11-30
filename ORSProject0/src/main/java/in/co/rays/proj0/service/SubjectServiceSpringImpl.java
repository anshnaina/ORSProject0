package in.co.rays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.SubjectDAOInt;
import in.co.rays.proj0.dto.CourseDTO;
import in.co.rays.proj0.dto.RoleDTO;
import in.co.rays.proj0.dto.SubjectDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Session facade of Subject Service. It is transactional, apply delcarative
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

@Service("subjectService")
public class SubjectServiceSpringImpl implements SubjectServiceInt {

	@Autowired
	private SubjectDAOInt dao;

	@Autowired
	private CourseServiceInt courseModel;

	private static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

	/**
	 * Adds a Subject
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {
		System.out.println("This is add method in Subject Service Implementation");
		SubjectDTO dtoExist = dao.findBySubjectName(dto.getSubjectName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Subject Name already exists");
		}
		CourseDTO courseDTO = courseModel.findById(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());
		long pk = dao.add(dto);
		return pk;
	}

	/**
	 * Updates a Subject
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when updated Subject is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
		System.out.println("This is Update method in Subject Service Implementation");
		SubjectDTO dtoExist = dao.findBySubjectName(dto.getSubjectName());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Subject Name already exists");
		}
		CourseDTO courseDTO = courseModel.findById(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());
		dao.update(dto);
	}

	/**
	 * Deletes a Subject
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete method in Subject Service Implementation");
		SubjectDTO dtoExist = findById(id);
		dao.delete(dtoExist);
	}

	/**
	 * Finds Subject by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public SubjectDTO findBySubjectName(String name) {
		System.out.println("This is findBySubjectName method in Subject Service Implementation");
		SubjectDTO dto = dao.findBySubjectName(name);
		return dto;
	}

	/**
	 * Finds record by Primary Key
	 */
	@Transactional(readOnly = true)
	public SubjectDTO findById(long id) {
		System.out.println("This is findByPK method in Subject Service Implementation");
		SubjectDTO dto = dao.findByPK(id);
		return dto;
	}

	/**
	 * Searches Subjects with pagination
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		System.out.println("This is search (Pagination) method in Subject Service Implementation");
		return dao.search(dto, pageNo, pageSize);
	}

	/**
	 * Searches Subjects
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(SubjectDTO dto) {
		System.out.println("This is Search method in Subject Service Implementation");
		return dao.search(dto);
	}

}
