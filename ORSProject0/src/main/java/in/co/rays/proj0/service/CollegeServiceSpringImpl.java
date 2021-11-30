package in.co.rays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.CollegeDAOInt;
import in.co.rays.proj0.dto.CollegeDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Session facade of College Service. It is transactional, apply delcarative
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

@Service("collegeService")
public class CollegeServiceSpringImpl implements CollegeServiceInt {

	@Autowired
	private CollegeDAOInt dao;
	
	private static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);

	/**
	 * Adds a College
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(CollegeDTO dto) throws DuplicateRecordException {
		System.out.println("This is add method in College Service Implementation");
		CollegeDTO dtoExist = dao.findByCollegeName(dto.getName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("College Name already exist");
		}
		long pk = dao.add(dto);
		return pk;
	}

	/**
	 * Updates a College
	 * 
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when updated College is already exists
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(CollegeDTO dto) throws DuplicateRecordException {
		System.out.println("This is Update method in College Service Implementation");
		CollegeDTO dtoExist = dao.findByCollegeName(dto.getName());
		// Check if updated College is already exists
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("College Name already exist");
		}
		dao.update(dto);
	}

	/**
	 * Deletes a College
	 * 
	 * @param dto
	 * @throws ApplicationException
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete method in College Service Implementation");
		CollegeDTO dtoExist = findById(id);
		dao.delete(dtoExist);
	}

	/**
	 * Finds College by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public CollegeDTO findByCollegeName(String name) {
		System.out.println("This is findByName method in College Service Implementation");
		CollegeDTO dto = dao.findByCollegeName(name);
		return dto;
	}

	/**
	 * Finds record by Primary Key
	 */
	@Transactional(readOnly = true)
	public CollegeDTO findById(long id) {
		System.out.println("This is findByPK method in College Service Implementation");
		CollegeDTO dto = dao.findByPK(id);
		return dto;
	}

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
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		System.out.println("This is search (Pagination) method in College Service Implementation");
		return dao.search(dto, pageNo, pageSize);
		
	}
	
	/**
	 * Searches Colleges
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws ApplicationException
	 */
	@Transactional(readOnly = true)
	public List search(CollegeDTO dto) {
		System.out.println("This is Search method in College Service Implementation");
		return dao.search(dto);
	}

}
