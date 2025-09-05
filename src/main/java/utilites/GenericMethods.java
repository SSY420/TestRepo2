package utilites;

import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.sun.tools.sjavac.Log;

public class GenericMethods {
	
	private static int screenCount;
	
	@BeforeSuite(alwaysRun = true)
	public static void clearScreenShot() {
		
		screenCount =0;
		
		File dir = new File("./ExtendReports/Screenshots/");
		for (File f: dir.listFiles()) {
			if(!f.isDirectory()) {
				if(f.getName().equals("Do not Remove")) {
					continue;
				}
				f.delete();
			}
		}
		
		//Added by Me-- Loading the properties file
		Properties properties = new Properties();
		try{
			FileInputStream fis = new FileInputStream(new File("./Prop.properties"));
			properties.load(fis);
		}catch(Exception e) {
			Log.info("Failed inLoading file");
		}
	}
	
	@BeforeClass(alwaysRun = true)
	public static void launchBrowser() {
		
	}
	
	//By Me ----------
	
	public static void delay(WebElement ele) {
			
		
	}
	
	public static void takeScreenshot(WebDriver driver) {
		try {
			
			File File = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.FILE);
			File src = new File("path");
			FileUtils.copyFile(File,src);
		}catch(Exception e) {
			
		}
	}
	
	
	public static String dateFormat() {
		Date d =new Date();
		d.get
	}
	
	public static void selectValueByIndex(int index, WebElement sel) {
		Select s = new Select(sel);
		s.selectByIndex(index);
	}
	public static void selectValueByValue(String value, WebElement sel) {
		Select s = new Select(sel);
		s.selectByValue(value);
	}
	public static void selectValueByVisibleText(String value, WebElement sel) {
		Select s = new Select(sel);
		s.selectByVisibleText(value);;
	}
	
	public static List<String> dropDownOptions(WebElement sel) {
		Select s = new Select(sel);
		List<WebElement> allElements = s.getOptions();
		List<String> dropDownValues = new ArrayList<String>();
		for(WebElement e: allElements) {
			dropDownValues.add(getText(e));
		}
		return dropDownValues;
	}
	
	public static String defaultSelectedValues(WebElement sel) {
		Select s = new Select(sel);
		return getText(s.getFirstSelectedOption());
	}
	
	public static String getText(WebElement e) {
		return e.getText();
	}
	
	
	public static void switchToWindow() {LLL
		
	}
	
	public static void enterText(WebElement e, String Value) {
		e.sendKeys(Value);
	}
	
	public static void enterTextJSE(WebElement e, String Value) {
		JavascriptExecutor jseExecutor= (JavascriptExecutor)driver;
		jseExecutor.executeScript("document[], null)
	}
	
	public static void clickElementJSE(WebElement e, WebDriver driver) {
		JavascriptExecutor jseExecutor= (JavascriptExecutor)driver;
		jseExecutor.executeScript("document[], null)
	}
	
	public static String subString(String str,int startIndex, int endIndex) {
		return str.substring(startIndex, endIndex);
	}
		
	public static void checkBrokenLinks(List<WebElement> e) throws MalformedURLException {
	    URL url;
		for(WebElement we: e) {
			String urlLink= getText(we);
			try {
				url = new URL(urlLink);
				HttpURLConnection httpConnection =(HttpURLConnection )url.openConnection();
				httpConnection.connect().
			}catch(Exception E) {
				
			}
			
		}
	}
	
	public static void explicityWait(){}
}
