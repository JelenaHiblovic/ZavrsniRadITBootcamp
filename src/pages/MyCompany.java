package pages;

import java.util.UUID;

public class MyCompany {

	public static final String DASHBOARD = "//*[@id=\"topMenu\"]/li[1]";
	public static final String SHIFT_PLANNING = "//*[@id=\"sn_schedule\"]";
	public static final String TIME_CLOCK = "//*[@id=\"sn_timeclock\"]/span";
	public static final String LEAVE = "//*[@id=\"sn_requests\"]/span";
	public static final String TRANING = "//*[@id=\"sn_training\"]/span";
	public static final String STAFF = "/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[6]/a";
	public static final String PAYROLL = "sn_payroll";
	public static final String REPORTS = "sn_reports";
	public static final String AVAILABILITY = "sn_availability";
	
	public static final String ADDEMPLOYED = "act_primary";
	public static final String FIRSTNAME = "_asf1";
	public static final String LASTNAME = "_asl1";
	public static final String EMAIL = "_ase1";
	public static final String FIRSTNAME_SEND = "Jovan ";
	public static final String LASTNAME_SEND = "Jovanovic";
	
	public static final String E_MAIL_SEND() {
		return UUID.randomUUID().toString() + "@gmail.com";
	}
	public static final String SAVE_EMPLOYEES= "_as_save_multiple";
	
	public static final String UPLOADPICTURE ="//*[@id=\"in-btn\"]";
	public static final String SAVE_BUT= "act_primary";
	public static final String EDIT_DET = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	
	
	
	
	
	
	
}
