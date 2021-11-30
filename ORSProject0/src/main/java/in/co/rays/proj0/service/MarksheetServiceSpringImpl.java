package in.co.rays.proj0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.MarksheetDAOInt;
import in.co.rays.proj0.dto.FacultyDTO;
import in.co.rays.proj0.dto.MarksheetDTO;
import in.co.rays.proj0.dto.StudentDTO;
import in.co.rays.proj0.dto.TimeTableDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Session facade of Marksheet Service. It is transactional, apply delcarative
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

@Service("marksheetService")
public class MarksheetServiceSpringImpl implements MarksheetServiceInt {

	@Autowired
	private MarksheetDAOInt dao = null;

	@Autowired
	StudentServiceInt studentService;

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(MarksheetDTO dto) throws DuplicateRecordException {

		System.out.println("This is add method in TimeTable Service Implementation");

		MarksheetDTO dtoExist = dao.findByRollNo(dto.getRollNo());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Roll No Is Already Exist");
		}

		StudentDTO studentDto = studentService.findById(dto.getStudentId());
		dto.setName(studentDto.getFirstName() + " " + studentDto.getLastName());

		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(MarksheetDTO dto) throws DuplicateRecordException {

		System.out.println("This is update method in TimeTable Service Implementation");

		MarksheetDTO dtoExist = dao.findByRollNo(dto.getRollNo());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Roll No Is Already Exist");
		}

		StudentDTO studentDto = studentService.findById(dto.getStudentId());
		dto.setName(studentDto.getFirstName() + " " + studentDto.getLastName());

		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete method in Marksheet Service Implementation");
		MarksheetDTO dtoExist = findById(id);
		dao.delete(dtoExist);
	}

	@Transactional(readOnly = true)
	public MarksheetDTO findByRollNo(String rollNo) {
		System.out.println("This is findByEmail method in Marksheet Service Implementation");
		MarksheetDTO dto = dao.findByRollNo(rollNo);
		return dto;
	}

	@Transactional(readOnly = true)
	public MarksheetDTO findById(long id) {
		System.out.println("This is FindByPK method in Marksheet Service Implementation");
		MarksheetDTO dto = dao.findByPK(id);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		System.out.println("This is Search(Pagination) method in Marksheet Service Implementation");
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(MarksheetDTO dto) {
		System.out.println("This is Search method in Marksheet Service Implementation");
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List getMeritList(int pageNo, int pageSize) {
		System.out.println("This is getMeritList method in Marksheet Service Implementation");
		return dao.getMeritList(pageNo, pageSize);
	}

}
