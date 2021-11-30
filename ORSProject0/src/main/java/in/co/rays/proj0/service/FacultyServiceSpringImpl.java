package in.co.rays.proj0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.FacultyDAOInt;
import in.co.rays.proj0.dto.CollegeDTO;
import in.co.rays.proj0.dto.CourseDTO;
import in.co.rays.proj0.dto.FacultyDTO;
import in.co.rays.proj0.dto.StudentDTO;
import in.co.rays.proj0.dto.SubjectDTO;
import in.co.rays.proj0.dto.TimeTableDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Session facade of Faculty Service. It is transactional, apply delcarative
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

@Service("facultyService")
public class FacultyServiceSpringImpl implements FacultyServiceInt {
	
	@Autowired
	private FacultyDAOInt dao;
	
	@Autowired
	SubjectServiceInt subjectService;
	
	@Autowired
	CollegeServiceInt collegeService;

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(FacultyDTO dto) throws DuplicateRecordException {
		
		System.out.println("This is add method in Faculty Service Implementation");
		
		FacultyDTO dtoExist = dao.findByLoginId(dto.getLoginId());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Login Id is already exists");
		}
		
		SubjectDTO subjectDTO = subjectService.findById(dto.getSubjectId());
		dto.setSubjectName(subjectDTO.getSubjectName());
		
		CollegeDTO collegeDTO=collegeService.findById(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());

		long pk = dao.add(dto);
		
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(FacultyDTO dto) throws DuplicateRecordException {
		
		
		System.out.println("This is add method in Faculty Service Implementation");
		
		FacultyDTO dtoExist = dao.findByLoginId(dto.getLoginId());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Login Id is already exists");
		}
		
		SubjectDTO subjectDTO = subjectService.findById(dto.getSubjectId());
		dto.setSubjectName(subjectDTO.getSubjectName());
		
		CollegeDTO collegeDTO=collegeService.findById(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());

		dao.update(dto);
		
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete method in Faculty Service Implementation");
		FacultyDTO dtoExist = findById(id);
		dao.delete(dtoExist);
	}

	@Transactional(readOnly = true)
	public FacultyDTO findByLoginId(String loginId) {
		System.out.println("This is findByLogin method in Faculty Service Implementation");
		FacultyDTO dto = dao.findByLoginId(loginId);
		return dto;
	}

	@Transactional(readOnly = true)
	public FacultyDTO findById(long id) {
		System.out.println("This is FindByPK method in Faculty Service Implementation");
		FacultyDTO dto = dao.findByPK(id);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(FacultyDTO dto, int pageNo, int pageSize) {
		System.out.println("This is Search(Pagination) method in Faculty Service Implementation");
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(FacultyDTO dto) {
		System.out.println("This is Search method in Faculty Service Implementation");
		return dao.search(dto);
	}

}
