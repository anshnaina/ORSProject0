
package in.co.rays.proj0.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Data Valdiator for validate input data
 *
 */
public class DataValidator {
	
	/**
	 * 
	 * Checks if value is Null
	 * 
	 * @param val
	 * @return
	 */
	public static Boolean isNull(String value) {
		return value != null && value.trim().length() != 0 ? false : true;
	}
	
	/**
	 * 
	 * Checks if value is Null
	 * 
	 * @param val
	 * @return
	 */
	public static Boolean isEmpty(Integer physics) {
		return physics != null ? false : true;
	}
	
	/**
	 * 
	 * Checks if value is Not Null
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNotNull(String value) {
		return !isNull(value);
	}
	
	/**
	 * Checks if value is name
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isName(String val) {
		String name = "^[A-Za-z]{2,25}$";
		return val.matches(name) ? true : false;
	}
	
	/**
	 * Checks if value is name number
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNameNumber(String val) {
		String name = "^[a-zA-Z0-9._ ]{2,50}+$";
		return val.matches(name);
	}
	
	/**
	 * Checks if value contains White Space
	 * 
	 * @param val
	 * @return boolean
	 */
	public static boolean isWhiteSpace(String val) {
		if (val.matches(".*\\s+.*")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if value is Password
	 * 
	 * This regex will enforce these rules: At least one upper case English letter,
	 * (?=.*?[A-Z]) At least one lower case English letter, (?=.*?[a-z]) At least
	 * one digit, (?=.*?[0-9]) At least one special character, (?=.*?[#?!@$%^&*-])
	 * Minimum eight in length .{4,} (with the anchors)
	 * 
	 * @param val
	 * @return boolean
	 */

	public static boolean isPassword(String val) {
		// String passregex =
		// "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,}$";
		String passregex = "^[a-zA-Z0-9](?=.*?[#?!@$%^&*-]).{4,}$";
		return val.matches(passregex) ? true : false;
	}

	/**
	 * 
	 * Checks if value is valid Date
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isDate(String val) {
		Date d = null;
		if (isNotNull(val)) {
			d = DataUtility.getDate(val);
		}
		return d != null;
	}
	
	/**
	 * Checks if value is Mobile Number
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isMobileNo(String val) {
		String mobreg = "(0/91)?[6-9][0-9]{9}";
		return val.matches(mobreg) ? true : false;
	}
	
	/**
	 * Checks if value is Phone Number
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isPhoneNo(String val) {
		String phonereg = "(0/+91)?[0-9-][0-9-]{9,12}";
		return val.matches(phonereg);
	}
	
	/**
	 * Checks if value is valid Date of Birth
	 * 
	 * @param val
	 * @return boolean
	 */
	public static boolean isDOB(String val) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date userDate = format.parse(val);
		Date todayDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(todayDate);
		cal.add(Calendar.YEAR, -17);

		Date beforedate = cal.getTime();
		if (beforedate.compareTo(userDate) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 
	 * Checks if value is valid Email ID
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isEmail(String val) {
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (isNotNull(val)) {
			try {
				return val.matches(emailreg);
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if value contains any number
	 * 
	 * @param val
	 * @return boolean
	 */
	public static boolean isNumber(String val) {
		String reg = "[A-Za-z ~!@#$%^&*_=-|?/><.,]*";
		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Checks that value starts witn an alphabet and contains only alphabets and
	 * numbers
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isAlphanumericName(String val) {

		String name = "^[a-zA-Z][ .a-zA-Z]+[0-9]{0,2}$";
		if (isNotNull(val)) {
			try {

				return val.matches(name);

			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if value is within the required marks range(0-100)
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isMarks(String val) {
		int marks = DataUtility.getInt(val);
		if (marks >= 0 && marks <= 100) {
			return true;

		} else {
			return false;
		}
	}
	
	/**
	 * Checks if value is valid State Name
	 * 
	 * @param val
	 * @return boolean
	 */
	// old regex ([a-zA-Z]+(?:.|-| |'))*[a-zA-Z]*
	public static boolean isState(String val) {
		String reg = "([a-zA-Z]+(\\.| |))*[a-zA-Z]*";
		// [7-9][0-9]{9}$
		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Checks if value is a valid Integer value
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isInteger(String val) {

		if (isNotNull(val)) {
			try {
				int i = Integer.parseInt(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}



}
