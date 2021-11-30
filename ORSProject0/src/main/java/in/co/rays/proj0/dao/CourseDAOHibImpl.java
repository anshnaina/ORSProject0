package in.co.rays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.proj0.dto.CollegeDTO;
import in.co.rays.proj0.dto.CourseDTO;

/**
 * Hibernate Implementation of Course DAO
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository(value = "courseDAO")
public class CourseDAOHibImpl implements CourseDAOInt {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = Logger.getLogger(CourseDAOHibImpl.class);

	/**
	 * Adds a Course
	 * 
	 * @param dto
	 * @throws DatabaseExceptiong
	 */
	public long add(CourseDTO dto) throws DataAccessException {
		System.out.println("This is Add method in Course DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Course
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(CourseDTO dto) throws DataAccessException {
		System.out.println("This is Update method in Course DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Deletes a Course
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void delete(CourseDTO dto) throws DataAccessException {
		System.out.println("This is Delete method in Course DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds Course by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public CourseDTO findByCourseName(String name) throws DataAccessException {
		System.out.println("This is findByName method in Course DAO Hibernate Implementation");
		CourseDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(CourseDTO.class)
				.add(Restrictions.eq("courseName", name)).list();
		if (list.size() == 1) {
			dto = (CourseDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * Finds Course by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public CourseDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in College DAO Hibernate Implementation");
		CourseDTO dto = null;
		dto = (CourseDTO) sessionFactory.getCurrentSession().get(CourseDTO.class, pk);
		return dto;
	}

	/**
	 * Searches Course with pagination
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

	public List search(CourseDTO dto, int pageNo, int pageSize) throws DataAccessException {

		System.out.println("This is search (paginaton) method in Course DAO Hibernate Implementation");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CourseDTO.class);
		
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
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
	 * Searches Course
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(CourseDTO dto) throws DataAccessException {
		System.out.println("This is search method in Course DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

}
