package in.co.rays.proj0.service;

import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.proj0.dao.UserDAOInt;
import in.co.rays.proj0.dto.RoleDTO;
import in.co.rays.proj0.dto.UserDTO;
import in.co.rays.proj0.exception.ApplicationException;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.exception.RecordNotFoundException;
import in.co.rays.proj0.util.EmailBuilder;

/**
 * Session facade of User Service. It is transactional, apply delcarative
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

@Service("userService")
public class UserServiceSpringImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	public void setDao(UserDAOInt dao) {
		System.out.println("This is @Autowired setDao method in User User Service Implementation");
		this.dao = dao;
	}

	@Autowired
	private SessionFactory sessionFactory = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("This is @Autowired setSessionFactory method in User User Service Implementation");
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private JavaMailSenderImpl mailSender;

	public void setMailSender(JavaMailSenderImpl mailSender) {
		System.out.println("This is @Autowired setMailSender method in User Service Implementation");
		this.mailSender = mailSender;
	}

	private static Logger log = Logger.getLogger(UserServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(UserDTO dto) throws DuplicateRecordException {
		long pk = 0;
		UserDTO dtoexist = findByLogin(dto.getLogin());
		if (dtoexist != null) {
			throw new DuplicateRecordException("Login Id is already exist");
		} else {
			pk = dao.add(dto);
		}
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long registerUser(UserDTO dto) throws DuplicateRecordException, ApplicationException {
		System.out.println("This is Register User method in User Service Implementation");

		long id = add(dto);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLogin());
		map.put("password", dto.getPassword());
		String message = EmailBuilder.getUserRegistrationMessage(map);
		MimeMessage msg = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(dto.getLogin());
			helper.setFrom(dto.getLogin());
			helper.setSubject("Registration is successful for ORS Project SUNRAYS Technologies.");
			// use the true flag to indicate the text included is HTML
			helper.setText(message, true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception msgInt) {
			throw new ApplicationException("Internet Connection Loss");
		}
		return id;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(UserDTO dto) throws DuplicateRecordException {
		System.out.println("This is Update User method in User Service Implementation");
		UserDTO dtoexist = findByLogin(dto.getLogin());
		if (dtoexist != null && dto.getId() != dto.getId()) {
			throw new DuplicateRecordException("LoginId is already exist");
		} else {
			dao.update(dto);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		System.out.println("This is Delete User method in User Service Implementation");
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		System.out.println("This is FindByLogin User method in User Service Implementation");
		UserDTO dto = dao.findByLogin(login);
		return dto;
	}

	@Transactional(readOnly = true)
	public UserDTO findById(long id) {
		System.out.println("This is FindByPK User method in User Service Implementation");
		UserDTO dto = dao.findByPK(id);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		System.out.println("This is search(Pagination) User method in User Service Implementation");
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto) {
		System.out.println("This is search User method in User Service Implementation");
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String login, String password) throws RecordNotFoundException {
		System.out.println("This is authenticate User method in User Service Implementation");
		UserDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		List list = criteria.list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		} else {
			dto = null;
			throw new RecordNotFoundException("Invalid Login Id And Password");
		}
		return dto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public boolean forgetPassword(String login) throws ApplicationException {
		System.out.println("This is forget Password User method in User Service Implementation");
		UserDTO dtoExist = dao.findByLogin(login);
		
		if (dtoExist != null) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("firstName", dtoExist.getFirstName());
			map.put("lastName", dtoExist.getLastName());
			map.put("login", dtoExist.getLogin());
			map.put("password", dtoExist.getPassword());
			String message = EmailBuilder.getForgetPasswordMessage(map);
			MimeMessage msg = mailSender.createMimeMessage();

			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg);
				helper.setTo(login);
				helper.setFrom(login);
				helper.setSubject("SunilOS ORS Password reset");
				// use the true flag to indicate the text included is HTML
				helper.setText(message, true);
				mailSender.send(msg);
			} catch (MessagingException e) {
				e.printStackTrace();
				return false;
			} catch (Exception msgInt) {
				throw new ApplicationException("Internet Connection Loss");
			}

		} else {
			return false;
		}
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean changePassword(Long id, String oldPassword, String newPassword)
			throws RecordNotFoundException, ApplicationException, DuplicateRecordException {

		System.out.println("This is Change Password User method in User Service Implementation");
		System.out.println("It is Implement in UserCtl");

		return false;
	}

	public boolean lock(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean resetPassword(String login) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	public RoleDTO getRole(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO updateAccess(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
