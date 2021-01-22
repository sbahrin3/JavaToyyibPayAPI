/**
 * 
 */
package sbahrin.toyibbpay;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Shamsul Bahrin
 *
 */
public class Settings {
	
	private static ResourceBundle rb;
	
	public static String SECRET_KEY;
	public static String API_URL;
	public static String PAYMENT_URL;
	public static String CATEGORY_CODE;
	public static String RETURN_URL;
	public static String CALLBACK_URL;
		
    static {
    	init();
    }
    
    public static void init() {
    	readProperties();
    	
    	System.out.println("===");
		System.out.println("SECRET_KEY: " + Settings.SECRET_KEY);
		System.out.println("API_URL: " + Settings.API_URL);
		System.out.println("PAYMENT_URL: " + Settings.PAYMENT_URL);
		System.out.println("RETURN_URL: " + Settings.RETURN_URL);
		System.out.println("CALLBACK_URL: " + Settings.CALLBACK_URL);
		System.out.println("CATEGORY_CODE: " + Settings.CATEGORY_CODE);
		System.out.println("===");
    }
    
	public static void readProperties() {
		try {
			rb = ResourceBundle.getBundle("payment");
			readProps();
		} catch ( MissingResourceException e ) {
			e.printStackTrace();
		}
       
	}

	private static void readProps() {
		SECRET_KEY = rb.getString("SECRET_KEY");
		API_URL = rb.getString("API_URL");
		PAYMENT_URL = rb.getString("PAYMENT_URL");
		RETURN_URL = rb.getString("RETURN_URL");
		CALLBACK_URL = rb.getString("CALLBACK_URL");
		CATEGORY_CODE = rb.getString("CATEGORY_CODE");
	}
	
	public static void main(String[] args) {
		
		Settings.init();

		
	}
}
