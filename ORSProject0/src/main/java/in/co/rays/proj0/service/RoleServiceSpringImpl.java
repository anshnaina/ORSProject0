package in.co.rays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.RoleDAOInt;
import in.co.rays.proj0.dto.RoleDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;

/**
 * Session facade of Role Service. It is transactional, apply delcarative
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

@Service("roleService")
public class RoleServiceSpringImpl implements RoleServiceInt {

	@Autowired
	private RoleDAOInt dao;

	private static Logger log = Logger.getLogger(RoleServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(RoleDTO dto) throws in.co.rays.proj0.exception.DuplicateRecordException {
		System.out.println("This is add method in Role Service Implementation");
		RoleDTO dtoExist = dao.findByRoleName(dto.getName());
		if (dtoExist != null) {
			throw new DuplicateRecordException("Role Name already exists");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(RoleDTO dto) throws in.co.rays.proj0.exception.DuplicateRecordException {
		System.out.println("This is Update method in Role Service Implementation");
		RoleDTO dtoExist = dao.findByRoleName(dto.getName());
		if (dtoExist != null && dtoExist.getId() != dto.getId()) {
			throw new DuplicateRecordException("Role Name already exists");
		}
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete method in Role Service Implementation");
		RoleDTO dtoExist = findById(id);
		dao.delete(dtoExist);
	}

	@Transactional(readOnly = true)
	public RoleDTO findByRoleName(String name) {
		System.out.println("This is findByRoleName method in Role Service Implementation");
		RoleDTO dto = dao.findByRoleName(name);
		return dto;
	}

	@Transactional(readOnly = true)
	public RoleDTO findById(long id) {
		System.out.println("This is FindByPK method in Role Service Implementation");
		RoleDTO dto = dao.findByPK(id);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(RoleDTO dto, int pageNo, int pageSize) {
		System.out.println("This is Search(Pagination) method in Role Service Implementation");
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(RoleDTO dto) {
		System.out.println("This is Search method in Role Service Implementation");
		return dao.search(dto);
	}

}
