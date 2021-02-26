package pages;

import java.util.UUID;

public class HomePage {

	public static final String URL = "https://www.humanity.com/";
	public static final String ADV1= "/html/body/div[2]/div/div/div[1]/button";
	public static final String ADV2= "/html/body/div[9]/div/div/div/div[2]/div[2]/div[1]/button/span";
	public static final String PASSWORD_LOGIN = "Zavrsnirad";
	public static final String EMAIL_LOGIN = "j.hiblovic@itbootcamp.com";
	public static final String FULLNAME () {
		
		return  "Jelena Hiblovic" + UUID.randomUUID().toString();
		
	}
	
	public static final String E_MAIL() {
		return UUID.randomUUID().toString() + "@gmail.com";
	}

	public static final String FULLNAME1 () {
		
		return  "Jelena Hiblovic" + UUID.randomUUID().toString();
	}
	
	public static final String E_MAIL1() {
		return UUID.randomUUID().toString() + "@gmail.com";
	}
	
	public static final String COMPANY_XPATH = "/html/body/div/div/div/form/div[1]/div/div[1]/div/div/input";
	public static final String COMPANY_NAME = "Try 123";
	public static final String INDUSTRY = "/html/body/div/div/div/form/div[1]/div/div[2]/div/div/span";
	public static final String FUNCTIONAL_ROLE = "//*[@id=\"root\"]/div/div/form/div[1]/div/div[3]/div/div";
	public static final String PHONE = "011502002";
	public static final String PASSWORD = "Zavrsnirad";
	
	public static final String START_RIGHT = "/html/body/div[1]/header/div[1]/div/div/div/nav/div[2]/div/a[3]";
	public static final String LOGIN = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";
}	
