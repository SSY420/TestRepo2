package TesPck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends Generic {

	WebDriver driver;
	public Home_Page(WebDriver driver) {

		PageFactory.initElements(driver, this );
		this.driver =driver;
	}

	@FindBy(xpath = "//b[.='You logged into a secure area!']")
	private WebElement SuccessMsg;

	public String LoginSuccessMsg() {
		return getText(SuccessMsg);
	}

}
