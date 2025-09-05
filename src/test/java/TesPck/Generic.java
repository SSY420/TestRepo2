package TesPck;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic {

	public static void waitExplicitly(WebDriver driver) {
		
		Wait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	public static boolean isElementVisible(WebElement el) {
		boolean isVisibleflag= false;

		if(el.isEnabled()) {
			isVisibleflag=true;
		}
		return isVisibleflag;

	}// test
	
	public static boolean isElementEnable(WebElement el) {
		boolean isEnabledflag= false;

		if(el.isEnabled()) {
			isEnabledflag=true;
		}
		return isEnabledflag;

	}
	
	public static void click(WebElement ele) {
		if(isElementVisible(ele) && isElementEnable(ele)) {
			ele.click();
		}
		else {
//			throw 
		}
		
	}
	
	public static void click_JSE( WebDriver driver, WebElement el) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
	}
	
	public  String getText(WebElement ele) {
		String text = null;
		if(isElementVisible(ele) && isElementEnable(ele)) {
			return ele.getText();
		}
		return text;
	}
	
	public static boolean verifyText(String Actual, String expected) {
		boolean isTextMatching = false;
		
		
		
		
		return isTextMatching;
		
	}
	
	public static String toUpperCase(String str) {
		String in = "";
		if(str==null || str.isEmpty()|| str.isBlank()) {
			return null;
		}
		else {
//			if(str.charAt(0))
			in = str.toUpperCase();
		}
		return in;
		// adding test comment
	}//ettet
}
