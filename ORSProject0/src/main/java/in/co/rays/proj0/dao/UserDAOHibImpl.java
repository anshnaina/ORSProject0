package in.co.rays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.proj0.dto.UserDTO;

/**
 * * User Data Access Object provides Database CRUD operations. It is
 * implemented by plain Hibernate 3 API with Spring ORM.
 * 
 * All methods propagate unchecked DataAccessException. It is a generic
 * exception handling provided by Spring-DAO.
 * 
 * If DataAccessException is propagated from method then declarative transaction
 * is rolled back by Spring AOP.
 * 
 * This is plain Hibernate 3 API implementation of DAO
 * 
 * Hibernate Implementation of UserDAO
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository(value = "userDAO")
public class UserDAOHibImpl implements UserDAOInt {

	private static Logger log = Logger.getLogger(UserDAOHibImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("This is @Autowired setSessionFactory method in User DAO Hibernate Implementation");
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add a User
	 * 
	 * @param dto
	 * 
	 * 
	 */
	public long add(UserDTO dto) throws DataAccessException {
		System.out.println("This is Add method in User DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Update a User
	 * 
	 * @param dto
	 * 
	 */
	public void update(UserDTO dto) throws DataAccessException {
		System.out.println("This is Update method in User DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Delete a User
	 * 
	 * @param dto
	 * 
	 * 
	 */
	public void delete(long id) throws DataAccessException {
		System.out.println("This is Delete method in User DAO Hibernate Implementation");
		UserDTO dto = findByPK(id);
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Find User by Login
	 * 
	 * @param login
	 *            : get parameter
	 * @return dto
	 * @throws DataAccessException
	 */
	public UserDTO findByLogin(String login) throws DataAccessException {
		System.out.println("This is findByLogin method in User DAO Hibernate Implementation");
		UserDTO dto = null;
		List list = (List) sessionFactory.getCurrentSession().createCriteria(UserDTO.class)
				.add(Restrictions.eq("login", login)).list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * Find User by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DataAccessException
	 */
	public UserDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in User DAO Hibernate Implementation");
		UserDTO dto = null;
		dto = (UserDTO) sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		return dto;
	}

	/**
	 * Searches User
	 * 
	 * @param dto
	 *            : Search Parameters
	 * @throws DataAccessException
	 */
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) throws DataAccessException {
		System.out.println("This is search method (Pagination) in User DAO Hibernate Implementation");

		List list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);

		if (dto != null) {

			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				criteria.add(Restrictions.like("login", dto.getLogin() + "%"));
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				criteria.add(Restrictions.like("password", dto.getPassword() + "%"));
			}
			if (dto.getRoleId() != 0) {
				criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
			}
			if (dto.getGender() != null && dto.getGender().length() > 0) {
				criteria.add(Restrictions.eq("gender", dto.getLastName()));
			}
			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
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

		list = criteria.list();
		return list;
	}

	/**
	 * Searches Users with pagination
	 * 
	 * @return list : List of Users
	 * @param dto
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * 
	 * @throws DataAccessException
	 */
	public List<UserDTO> search(UserDTO dto) throws DataAccessException {
		System.out.println("This is search method in User DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

}
