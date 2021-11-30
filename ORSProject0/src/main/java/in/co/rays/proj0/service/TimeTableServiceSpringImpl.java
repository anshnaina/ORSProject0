package in.co.rays.proj0.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.TimeTableDAOInt;
import in.co.rays.proj0.dto.CourseDTO;
import in.co.rays.proj0.dto.FacultyDTO;
import in.co.rays.proj0.dto.MarksheetDTO;
import in.co.rays.proj0.dto.SubjectDTO;
import in.co.rays.proj0.dto.TimeTableDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Session facade of Timetable Service. It is transactional, apply delcarative
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

@Service("timetableService")
public class TimeTableServiceSpringImpl implements TimeTableServiceInt {

	@Autowired
	private TimeTableDAOInt dao;

	@Autowired
	SubjectServiceInt subjectService;

	@Autowired
	CourseServiceInt courseService;

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(TimeTableDTO dto) throws DuplicateRecordException {

		System.out.println("This is add method in TimeTable Service Implementation");

		TimeTableDTO dtoExist1 = dao.findByCourseAndSubAndSem(dto.getCourseId(), dto.getSubjectId(), dto.getSemester());
		TimeTableDTO dtoExist2 = dao.findByDateAndCourseIdAndSem(dto.getExamDate(), dto.getSubjectId(),
				dto.getSemester());

		if (dtoExist1 != null) {
			throw new DuplicateRecordException("Timetable is already exists");
		}
		if (dtoExist2 != null) {
			throw new DuplicateRecordException("Exam date already schedule for this course!");
		}

		SubjectDTO subjectDto = subjectService.findById(dto.getSubjectId());
		dto.setSubjectName(subjectDto.getSubjectName());

		CourseDTO courseDTO = courseService.findById(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());

		long pk = dao.add(dto);

		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(TimeTableDTO dto) throws DuplicateRecordException {
		
		System.out.println("This is Update method in TimeTable Service Implementation");

		TimeTableDTO dtoExist1 = dao.findByCourseAndSubAndSem(dto.getCourseId(), dto.getSubjectId(), dto.getSemester());
		TimeTableDTO dtoExist2 = dao.findByDateAndCourseIdAndSem(dto.getExamDate(), dto.getSubjectId(),
				dto.getSemester());

		if (dtoExist1 != null && dtoExist1.getId() != dto.getId()) {
			throw new DuplicateRecordException("Timetable is already exists");
		}
		if (dtoExist2 != null && dtoExist2.getId() != dto.getId()) {
			throw new DuplicateRecordException("Exam date already schedule for this course!");
		}

		SubjectDTO subjectDto = subjectService.findById(dto.getSubjectId());
		dto.setSubjectName(subjectDto.getSubjectName());

		CourseDTO courseDTO = courseService.findById(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());

		dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete method in TimeTable Service Implementation");
		TimeTableDTO dtoExist = findById(id);
		dao.delete(dtoExist);
	}

	@Transactional(readOnly = true)
	public TimeTableDTO findByCourseAndSubAndSem(Long courseId, Long subjectId, String sem) {
		System.out.println("This is findByCourseAndSubAndSem method in TimeTable Service Implementation");
		TimeTableDTO dto = dao.findByCourseAndSubAndSem(courseId, subjectId, sem);
		return dto;
	}

	@Transactional(readOnly = true)
	public TimeTableDTO findByDateAndCourseIdAndSem(Date examDate, Long courseId, String sem) {
		System.out.println("This is findByDateAndCourseIdAndSem method in TimeTable Service Implementation");
		TimeTableDTO dto = dao.findByDateAndCourseIdAndSem(examDate, courseId, sem);
		return dto;
	}

	@Transactional(readOnly = true)
	public TimeTableDTO findById(long id) {
		System.out.println("This is FindByPK method in TimeTable Service Implementation");
		TimeTableDTO dto = dao.findByPK(id);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(TimeTableDTO dto, int pageNo, int pageSize) {
		System.out.println("This is Search(Pagination) method in TimeTable Service Implementation");
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(TimeTableDTO dto) {
		System.out.println("This is Search method in TimeTable Service Implementation");
		return dao.search(dto);
	}

}
