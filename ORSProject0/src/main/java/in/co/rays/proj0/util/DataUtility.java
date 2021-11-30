package in.co.rays.proj0.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Data Utility for convet one format to another
 *
 */
public class DataUtility {
	
	/**
	 * Application Date Format
	 */	
	public static final String APP_DATE_FORMAT = "MM/dd/yyyy";
	public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	public static final String SEARCH_DATE_FORMAT="yyyy-MM-dd";
	
	/**
	 * Date formatter
	 */
	private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);
	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);
	private static final SimpleDateFormat searchFormatter=new SimpleDateFormat(SEARCH_DATE_FORMAT);
	
	/**
	 * Converts String into Date
	 * 
	 * @param val
	 * @return
	 */

	public static Date getDate(String val) {
		Date date = null;
		try {
			date = formatter.parse(val);
		} catch (Exception e) {

		}
		return date;
	}
	
	/**
	 * Converts a String into Integer
	 * 
	 * @param val
	 * @return
	 */
	public static int getInt(String val){
		if(DataValidator.isInteger(val)){
			return Integer.parseInt(val);
		}else{
			return 0;
		}
	}

}
