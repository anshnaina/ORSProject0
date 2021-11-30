package in.co.rays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.proj0.dto.SubjectDTO;

/**
 * Hibernate Implementation of Subject DAO
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository(value = "subjectDAO")
public class SubjectDAOHibImpl  implements SubjectDAOInt {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = Logger.getLogger(SubjectDAOHibImpl.class);

	/**
	 * Adds a Subject
	 * 
	 * @param dto
	 * @throws DatabaseExceptiong
	 */
	public long add(SubjectDTO dto) throws DataAccessException {
		System.out.println("This is Add method in Subject DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Subject
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(SubjectDTO dto) throws DataAccessException {
		System.out.println("This is Update method in Subject DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Deletes a Subject
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void delete(SubjectDTO dto) throws DataAccessException {
		System.out.println("This is Delete method in Subject DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds Subject by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public SubjectDTO findBySubjectName(String name) throws DataAccessException {
		System.out.println("This is findByName method in Subject DAO Hibernate Implementation");
		SubjectDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(SubjectDTO.class)
				.add(Restrictions.eq("subjectName", name)).list();
		if (list.size() == 1) {
			dto = (SubjectDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * Finds Subject by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public SubjectDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in Subject DAO Hibernate Implementation");
		SubjectDTO dto = null;
		dto = (SubjectDTO) sessionFactory.getCurrentSession().get(SubjectDTO.class, pk);
		return dto;
	}

	/**
	 * Searches Subject with pagination
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DatabaseException
	 */

	public List search(SubjectDTO dto, int pageNo, int pageSize) throws DataAccessException {

		System.out.println("This is search (paginaton) method in Subject DAO Hibernate Implementation");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SubjectDTO.class);
		
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getCourseId() > 0L) {
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}

			if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName() + "%"));
			}

			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
			}
			
			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				criteria.add(Restrictions.like("description", dto.getDescription() + "%"));
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
	 * Searches Subject
	 * 
	 * @return list : List of Subjects
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(SubjectDTO dto) throws DataAccessException {
		System.out.println("This is search method in Subject DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

}
