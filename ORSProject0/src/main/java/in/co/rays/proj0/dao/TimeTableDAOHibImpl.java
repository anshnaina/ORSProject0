package in.co.rays.proj0.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.proj0.dto.StudentDTO;
import in.co.rays.proj0.dto.TimeTableDTO;

/**
 * Hibernate Implementation of TimeTable DAO
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository(value = "timetableDAO")
public class TimeTableDAOHibImpl implements TimeTableDAOInt{
	
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Adds a TimeTable
	 * 
	 * @param dto
	 * @throws DatabaseExceptiong
	 */
	public long add(TimeTableDTO dto) throws DataAccessException {
		System.out.println("This is Add method in TimeTable DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a TimeTable
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(TimeTableDTO dto) throws DataAccessException {
		System.out.println("This is Update method in TimeTable DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Deletes a TimeTable
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void delete(TimeTableDTO dto) throws DataAccessException {
		System.out.println("This is Delete method in TimeTable DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * findByCourseAndSubAndSem a TimeTable
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public TimeTableDTO findByCourseAndSubAndSem(Long courseId, Long subjectId, String sem) {
		TimeTableDTO dto = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TimeTableDTO.class);
		criteria.add(Restrictions.eq("courseId", courseId));
		criteria.add(Restrictions.eq("subjectId", subjectId));
		criteria.add(Restrictions.eq("semester", sem));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (TimeTableDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * findByDateAndCourseIdAndSem a TimeTable
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public TimeTableDTO findByDateAndCourseIdAndSem(Date examDate, Long courseId, String sem) {
		TimeTableDTO dto = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TimeTableDTO.class);
		criteria.add(Restrictions.eq("examDate", examDate));
		criteria.add(Restrictions.eq("courseId", courseId));
		criteria.add(Restrictions.eq("semester", sem));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (TimeTableDTO) list.get(0);
		}
		return dto;

	}

	/**
	 * Finds TimeTable by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public TimeTableDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in TimeTable DAO Hibernate Implementation");
		TimeTableDTO dto = null;
		dto = (TimeTableDTO) sessionFactory.getCurrentSession().get(TimeTableDTO.class, pk);
		return dto;
	}

	/**
	 * Searches TimeTable with pagination
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DatabaseException
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) throws DataAccessException {
		
		System.out.println("This is search (paginaton) method in TimeTable DAO Hibernate Implementation");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TimeTableDTO.class);
		
		if (dto != null) {
			
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}

			if (dto.getCourseId() != null) {
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}
			if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
			}

			if (dto.getSubjectId() != null) {
				criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
			}

			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
			}
			if (dto.getExamDate() != null) {
				criteria.add(Restrictions.eq("examDate", dto.getExamDate()));
			}

			if (dto.getExamTime() != null && dto.getExamTime().length() > 0) {
				criteria.add(Restrictions.like("examTime", dto.getExamTime() + "%"));
			}
			if (dto.getSemester() != null && dto.getSemester().length() > 0) {
				criteria.add(Restrictions.like("semester", dto.getSemester() + "%"));
			}
			
		}

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		List list = criteria.list();
		return list;
	}

	/**
	 * Searches TimeTable
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(TimeTableDTO dto) throws DataAccessException {
		System.out.println("This is search method in TimeTable DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

}
