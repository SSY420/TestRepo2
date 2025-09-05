package TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(how=How.ID,using ="username")
	private WebElement userName;
	
	@FindBy(how=How.ID,using ="password")
	private WebElement password;
	
	@FindBy(how=How.XPATH,using ="//button[text()='Login']")
	private WebElement loginBtn;
	
	
	WebDriver driver;
	
	LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String name) {
		 userName.sendKeys(name);
	}
	
   public void enterPwd(String pwd) {
	   password.sendKeys();
	}

   public void clickLoginBtn() {
	   loginBtn.click();
	
}
}
