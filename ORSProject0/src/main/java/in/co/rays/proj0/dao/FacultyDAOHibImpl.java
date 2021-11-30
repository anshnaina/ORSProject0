package in.co.rays.proj0.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.proj0.dto.FacultyDTO;

/**
 * Hibernate Implementation of FacultyDAO
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository(value = "facultyDAO")
public class FacultyDAOHibImpl implements FacultyDAOInt {
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Adds a Faculty
	 * 
	 * @param dto
	 * @throws DatabaseExceptiong
	 */
	public long add(FacultyDTO dto) throws DataAccessException {
		System.out.println("This is Add method in Faculty DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Faculty
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(FacultyDTO dto) throws DataAccessException {
		System.out.println("This is Update method in Faculty DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Deletes a Faculty
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void delete(FacultyDTO dto) throws DataAccessException {
		System.out.println("This is Delete method in Faculty DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds Faculty by login
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public FacultyDTO findByLoginId(String login) throws DataAccessException {
		System.out.println("This is findByName method in Faculty DAO Hibernate Implementation");
		FacultyDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(FacultyDTO.class)
				.add(Restrictions.eq("loginId", login)).list();
		if (list.size() == 1) {
			dto = (FacultyDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * Finds Faculty by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public FacultyDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in Faculty DAO Hibernate Implementation");
		FacultyDTO dto = null;
		dto = (FacultyDTO) sessionFactory.getCurrentSession().get(FacultyDTO.class, pk);
		return dto;
	}

	/**
	 * Searches Faculty with pagination
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
	public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize) throws DataAccessException {
		
		System.out.println("This is search (paginaton) method in Faculty DAO Hibernate Implementation");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FacultyDTO.class);
		
		if (dto != null) {
			
			if (dto.getId() > 0L) {
				criteria.add(Restrictions.eq("Id", dto.getId()));
			}

			if (dto.getCollegeId() > 0L) {
				criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
			}

			if (dto.getCollegeName() != null && dto.getCollegeName().length() > 0) {
				criteria.add(Restrictions.like("collegeName", dto.getCollegeName() + "%"));
			}

			if (dto.getDoj() != null) {
				criteria.add(Restrictions.eq("doj", dto.getDoj()));
			}

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}

			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}

			if (dto.getLoginId() != null && dto.getLoginId().length() > 0) {
				criteria.add(Restrictions.like("loginId", dto.getLoginId() + "%"));
			}

			if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
				criteria.add(Restrictions.like("mobileNo", dto.getMobileNo() + "%"));
			}

			if (dto.getSubjectId() > 0L) {
				criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
			}

			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
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
	 * Searches Faculty
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(FacultyDTO dto) throws DataAccessException {
		System.out.println("This is search method in Faculty DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

}
