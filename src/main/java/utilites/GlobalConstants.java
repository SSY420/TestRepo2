package utilites;

public class GlobalConstants {
	
	
	public static String URL_QA1 = "TestUrl";
	public static String URL_QA2 = "TestUrl";
	public static String URL_Q3 = "TestUrl";
	public static String URL_5 = "TestUrl";
	
	
	
	//Browser details
	public static final String BROWSER= retrieveBbrowser();
	public static final String URL= retrieveURL();
	
	//Firefox Configuration
	//Need to add
	
	String time= System.getProperty("time");
	
	public static String retrieveBbrowser() {
		
		String browser= System.getProperty(BROWSER);
		
		if( browser.isEmpty() || browser == null) {
			browser ="chrome";
		}
		switch(browser) {
		
		    case "firefox":
		    	  browser= "chrome";
		    	  break;
		    	  
		    case "edge":
		    	  browser="edge";
		    	  break;
		    default:
				browser= "chrome";
		}
		return browser;
		
	}
	
	public static String retrieveDatafile() {
		
		String filePath= "./AviallTestData/"; //Need to Add.
		String fileName = "";
		String envName = System.getProperty("env");
		
		if( envName.isEmpty() || envName == null) {
			return "./AviallTestData_TestDara_Q2.xlsx";
		}
		 
		switch(envName) {
		
		case "D2":
			fileName ="D2.xlsx";
			break;
		}
		
		return new StringBuilder(envName).append(filePath).toString();
	}
		
	
	public static String retrieveURL() {
		String URL="";
		String envName = System.getProperty("env");
		
		if(null == envName || envName.isEmpty()) {
			return URL_QA1;
		}
		
		switch(envName) {
		case "QA2":
			  URL =URL_QA2;
			  break;
		case "QA3":
			URL =URL_Q3;
			break;
		default:
			URL = URL_5;
				
		}
		
		return URL;
	}
}
