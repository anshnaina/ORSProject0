package in.co.rays.proj0.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

/**
 * Contains login form elements and their declarative input validations.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Component
public class LoginForm  extends BaseForm {
	
	/**
	 * Email ID of User
	 */
	@NotEmpty
	@Email
	private String login;

	/**
	 * Password of User
	 */
	@NotEmpty
    private String password;
	
	/**
	 * Accessor
	 */
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
