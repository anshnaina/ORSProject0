package in.co.rays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.proj0.dto.StudentDTO;

/**
 * Hibernate Implementation of StudentDAO
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository("StudentDAO")
public class StudentDAOHibImpl implements StudentDAOInt {

	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = Logger.getLogger(StudentDAOHibImpl.class);

	/**
	 * Adds a Student
	 * 
	 * @param dto
	 * @throws DatabaseExceptiong
	 */
	public long add(StudentDTO dto) throws DataAccessException {
		System.out.println("This is Add method in Student DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Student
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(StudentDTO dto) throws DataAccessException {
		System.out.println("This is Update method in Student DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Deletes a Student
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void delete(StudentDTO dto) throws DataAccessException {
		System.out.println("This is Delete method in Student DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds Student by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public StudentDTO findByEmail(String email) throws DataAccessException {
		System.out.println("This is findByName method in Student DAO Hibernate Implementation");
		StudentDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(StudentDTO.class)
				.add(Restrictions.eq("email", email)).list();
		if (list.size() == 1) {
			dto = (StudentDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * Finds Student by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public StudentDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in Student DAO Hibernate Implementation");
		StudentDTO dto = null;
		dto = (StudentDTO) sessionFactory.getCurrentSession().get(StudentDTO.class, pk);
		return dto;
	}

	/**
	 * Searches Student with pagination
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
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) throws DataAccessException {
		
		System.out.println("This is search (paginaton) method in Student DAO Hibernate Implementation");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudentDTO.class);
		
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getCollegeId() > 0) {
				criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}

			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			
			if (dto.getCollegeName() != null && dto.getCollegeName().length() > 0) {
				criteria.add(Restrictions.like("collegeName", dto.getCollegeName() + "%"));
			}

			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}

			if (dto.getEmail() != null && dto.getEmail().length() > 0) {
				criteria.add(Restrictions.like("email", dto.getEmail() + "%"));
			}

			if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
				criteria.add(Restrictions.like("mobileNo", dto.getMobileNo() + "%"));
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
	 * Searches Student
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(StudentDTO dto) throws DataAccessException {
		System.out.println("This is search method in Student DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

}
