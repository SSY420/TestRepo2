package TesPck;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Generic{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this );
		this.driver =driver;
	}
	
	@FindBy(id = "username" )
	private WebElement userName;
	
	@FindBy(id  = "password" )
	private WebElement pwd;
	
	@FindBy(xpath = "//button[.='Login']" )
	private WebElement loginBtn;
	
	public void enterUserName(String uName) {
		userName.sendKeys(uName);
	}
	
	public void enterPWD(String password) {
		pwd.sendKeys(password);
		
	}
	
	public void click_Login_Btn() {
		click_JSE(this.driver, loginBtn);
		
	}
}

