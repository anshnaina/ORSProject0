package in.co.rays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.StudentDAOInt;
import in.co.rays.proj0.dto.CollegeDTO;
import in.co.rays.proj0.dto.StudentDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Session facade of Student Service. It is transactional, apply delcarative
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

@Service("StudentService")
public class StudentServiceSpringImpl implements StudentServiceInt {

	@Autowired
	private StudentDAOInt dao;
	
	@Autowired
	private CollegeServiceInt collegeService;

	private static Logger log = Logger.getLogger(StudentServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(StudentDTO dto) throws in.co.rays.proj0.exception.DuplicateRecordException {
		System.out.println("This is add method in Student Service Implementation");
		StudentDTO dtoExist = dao.findByEmail(dto.getEmail());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Student Name already exists");
		}
		CollegeDTO collegeDTO=new CollegeDTO();
		collegeDTO=collegeService.findById(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());
		
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(StudentDTO dto) throws in.co.rays.proj0.exception.DuplicateRecordException {
		System.out.println("This is Update method in Student Service Implementation");
		StudentDTO dtoExist = dao.findByEmail(dto.getEmail());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Student Name already exists");
		}
		CollegeDTO collegeDTO=new CollegeDTO();
		collegeDTO=collegeService.findById(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete method in Student Service Implementation");
		StudentDTO dtoExist = findById(id);
		dao.delete(dtoExist);
	}

	@Transactional(readOnly = true)
	public StudentDTO findByEmail(String email) {
		System.out.println("This is findByEmail method in Student Service Implementation");
		StudentDTO dto = dao.findByEmail(email);
		return dto;
	}

	@Transactional(readOnly = true)
	public StudentDTO findById(long id) {
		System.out.println("This is FindByPK method in Student Service Implementation");
		StudentDTO dto = dao.findByPK(id);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		System.out.println("This is Search(Pagination) method in Student Service Implementation");
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(StudentDTO dto) {
		System.out.println("This is Search method in Student Service Implementation");
		return dao.search(dto);
	}
	
}
