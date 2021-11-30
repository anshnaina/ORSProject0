package in.co.rays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.proj0.dto.RoleDTO;

/**
 * Hibernate Implementation of RoleDAO
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository("roleDAO")
public class RoleDAOHibImpl implements RoleDAOInt {

	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = Logger.getLogger(RoleDAOHibImpl.class);

	/**
	 * Adds a Role
	 * 
	 * @param dto
	 * @throws DatabaseExceptiong
	 */
	public long add(RoleDTO dto) throws DataAccessException {
		System.out.println("This is Add method in Role DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Role
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(RoleDTO dto) throws DataAccessException {
		System.out.println("This is Update method in Role DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Deletes a Role
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void delete(RoleDTO dto) throws DataAccessException {
		System.out.println("This is Delete method in Role DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds Role by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public RoleDTO findByRoleName(String name) throws DataAccessException {
		System.out.println("This is findByName method in Role DAO Hibernate Implementation");
		RoleDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class)
				.add(Restrictions.eq("name", name)).list();
		if (list.size() == 1) {
			dto = (RoleDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * Finds Role by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public RoleDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in Role DAO Hibernate Implementation");
		RoleDTO dto = null;
		dto = (RoleDTO) sessionFactory.getCurrentSession().get(RoleDTO.class, pk);
		return dto;
	}

	/**
	 * Searches Role with pagination
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
	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize) throws DataAccessException {
		
		System.out.println("This is search (paginaton) method in Role DAO Hibernate Implementation");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class);
		
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
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
	 * Searches Role
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(RoleDTO dto) throws DataAccessException {
		System.out.println("This is search method in Role DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

}
