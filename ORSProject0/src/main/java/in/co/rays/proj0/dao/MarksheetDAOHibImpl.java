package in.co.rays.proj0.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.rays.proj0.dto.MarksheetDTO;

/**
 * Hibernate Implementation of Marksheet DAO
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

@Repository("marksheetDAO")
public class MarksheetDAOHibImpl implements MarksheetDAOInt {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Adds a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseExceptiong
	 */
	public long add(MarksheetDTO dto) throws DataAccessException {
		System.out.println("This is Add method in Marksheet DAO Hibernate Implementation");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	/**
	 * Updates a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void update(MarksheetDTO dto) throws DataAccessException {
		System.out.println("This is Update method in Marksheet DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().merge(dto);
	}

	/**
	 * Deletes a Marksheet
	 * 
	 * @param dto
	 * @throws DatabaseException
	 */
	public void delete(MarksheetDTO dto) throws DataAccessException {
		System.out.println("This is Delete method in Marksheet DAO Hibernate Implementation");
		sessionFactory.getCurrentSession().delete(dto);
	}

	/**
	 * Finds Marksheet by RollNo
	 * 
	 * @param name : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public MarksheetDTO findByRollNo(String rollNo) throws DataAccessException {
		System.out.println("This is findByRollNo method in Marksheet DAO Hibernate Implementation");
		MarksheetDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(MarksheetDTO.class)
				.add(Restrictions.like("rollNo", rollNo+ "%")).list();
		System.out.println(list.size() + "nksnnw");
		if (list.size() > 0) {
			dto = (MarksheetDTO) list.get(0);
		}
		return dto;
	}
	/**
	 * Finds Marksheet by PK
	 * 
	 * @param pk : get parameter
	 * @return dto
	 * @throws DatabaseException
	 */
	public MarksheetDTO findByPK(long pk) throws DataAccessException {
		System.out.println("This is findByPK method in Marksheet DAO Hibernate Implementation");
		MarksheetDTO dto = null;
		dto = (MarksheetDTO) sessionFactory.getCurrentSession().get(MarksheetDTO.class, pk);
		return dto;
	}

	/**
	 * Searches Marksheet with pagination
	 * 
	 * @return list : List of Colleges
	 * @param dto      : Search Parameters
	 * @param pageNo   : Current Page No.
	 * @param pageSize : Size of Page
	 * @throws DatabaseException
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize) throws DataAccessException {

		System.out.println("This is search (paginaton) method in Marksheet DAO Hibernate Implementation");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MarksheetDTO.class);

		if (dto != null) {

			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getRollNo() != null && dto.getRollNo().length() > 0) {
				criteria.add(Restrictions.eq("rollNo", dto.getRollNo()));
			}
			if (dto.getStudentId() != null) {
				criteria.add(Restrictions.eq("studentId", dto.getStudentId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getPhysics() != null && dto.getPhysics().length() > 0) {
				criteria.add(Restrictions.eq("physics", dto.getPhysics()));
			}
			if (dto.getChemistry() != null && dto.getChemistry().length() > 0) {
				criteria.add(Restrictions.eq("chemistry", dto.getChemistry()));
			}
			if (dto.getMaths() != null && dto.getMaths().length() > 0) {
				criteria.add(Restrictions.eq("maths", dto.getMaths()));
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
	 * Searches Marksheet
	 * 
	 * @return list : List of Colleges
	 * @param dto : Search Parameters
	 * @throws DatabaseException
	 */
	public List search(MarksheetDTO dto) throws DataAccessException {
		System.out.println("This is search method in Marksheet DAO Hibernate Implementation");
		return search(dto, 0, 0);
	}

	public List getMeritList(int pageNo, int pageSize) throws DataAccessException {

		String hql = "from MarksheetDTO where physics>=33 and chemistry>=33 and maths>=33 order by (physics + chemistry + maths) desc";
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setFirstResult((pageNo - 1) * pageSize);
		q.setMaxResults(pageSize);
		return q.list();

	}
}
