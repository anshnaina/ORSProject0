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


/**
 * Hibernate Implementation of College
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository("collegeDAO")
public class CollegeDAOHibImpl implements CollegeDAOInt {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static Logger log = Logger.getLogger(CollegeDAOHibImpl.class);

	/**
	 * Adds a College
	 * 
	 * @param dto
	 * @throws DatabaseExceptiong
	 */
	public long add(CollegeDTO dto) throws DataAccessException {
		System.out.println("This is Add method in College DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(CollegeDTO dto) throws DataAccessException {
		System.out.println("This is Update method in College DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Deletes a College
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void delete(CollegeDTO dto) throws DataAccessException {
		System.out.println("This is Delete method in College DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds College by Name
	 * 
	 * @param name
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public CollegeDTO findByCollegeName(String name) throws DataAccessException {
		System.out.println("This is findByName method in College DAO Hibernate Implementation");
		CollegeDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class)
				.add(Restrictions.eq("name", name)).list();
		if (list.size() == 1) {
			dto = (CollegeDTO) list.get(0);
		}
		return dto;
	}

	/**
	 * Finds College by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public CollegeDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in College DAO Hibernate Implementation");
		CollegeDTO dto = null;
		dto = (CollegeDTO) sessionFactory.getCurrentSession().get(CollegeDTO.class, pk);
		return dto;
	}

	/**
	 * Searches College with pagination
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
	public List search(CollegeDTO dto, int pageNo, int pageSize) throws DataAccessException {
		
		System.out.println("This is search (paginaton) method in College DAO Hibernate Implementation");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class);
		
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}

			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}

			if (dto.getAddress() != null && dto.getAddress().length() > 0) {
				criteria.add(Restrictions.like("address", dto.getAddress() + "%"));
			}

			if (dto.getState() != null && dto.getState().length() > 0) {
				criteria.add(Restrictions.like("state", dto.getState() + "%"));
			}

			if (dto.getCity() != null && dto.getCity().length() > 0) {
				criteria.add(Restrictions.like("city", dto.getCity() + "%"));
			}

			if (dto.getPhoneNo() != null && dto.getPhoneNo().length() > 0) {
				criteria.add(Restrictions.like("phoneNo", dto.getPhoneNo() + "%"));
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
	 * Searches Colleges
	 * 
	 * @return list : List of Colleges
	 * @param dto
	 *            : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(CollegeDTO dto) throws DataAccessException {
		System.out.println("This is search method in College DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

}
