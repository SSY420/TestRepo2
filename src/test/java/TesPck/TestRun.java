package TesPck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

public class TestRun extends Generic{
	
 private static Properties prop;
 private static String urll;
 private static String env;

	
	@BeforeClass
	public static void fileLoad(){
		prop = new Properties();
		try{
			FileInputStream fis = new FileInputStream(new File("./Prop.properties"));
			prop.load(fis);
		}catch(Exception e) {
			Log.info("Failed in Loading file");
		}
	}

	@Test(invocationCount = 0)
	public  void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(prop.getProperty("ENV"));
		System.out.println("");
		//https://practice.expandtesting.com/
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(prop.getProperty("UserName"));
		lp.enterPWD(prop.getProperty("PWD"));
		lp.click_Login_Btn();
		Home_Page hp = new Home_Page(driver);
		verifyText(hp.LoginSuccessMsg(),prop.getProperty("LoginSuccessMessage"));
//		hp.LoginSuccessMsg()
	}
	
	@Test(invocationCount = 0)
	public static void A() throws Exception {
		
		File f= new File("E:\\TestData\\Book1.xlsx");
		FileInputStream fip= new FileInputStream(f);
		XSSFWorkbook xsswb= new XSSFWorkbook(fip);
		XSSFSheet sheet = xsswb.getSheet("Sheet1");

		int rowsCount = sheet.getPhysicalNumberOfRows();
		for(int a =1;a<rowsCount;a++) {
			XSSFRow rows = sheet.getRow(a);
			for(int col=0;col<rows.getPhysicalNumberOfCells();col++) {
				XSSFCell cell =rows.getCell(col);
				try {
					//System.out.print(cell.getStringCellValue());
					System.out.print("|| " +getCellValue(rows.getCell(col)));
				}
				catch(Exception e) {
					System.out.println("Value is Blank in Row : "+ a + "and column : "+ col);
				}
				
			}
			System.out.print("||");
			System.out.println();
		}
		
		xsswb.close();
		fip.close();
	}
	
	public static String getCellValue(XSSFCell cell) {
		String value =null;
		switch(cell.getCellType()) {
		case NUMERIC:
			value= String.valueOf(cell.getNumericCellValue());
			break;
		case BOOLEAN:
			value= String.valueOf(cell.getBooleanCellValue());
			break;
		case STRING:
			value= cell.getStringCellValue();
			break;
		default:
			break;
			
		}
		return value;
	}
	
	@Test(invocationCount = 1)
	public static void checkDupliacteValuesInDropdown() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebElement dropdown = driver.findElement(By.id("dropdowm-menu-1"));
		Select sel = new Select(dropdown);
		List<WebElement> allOption = sel.getOptions();
		StringBuilder str = new StringBuilder();
		for(WebElement e: allOption) {
			str.append(e.getText()+" ");
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement el = driver.findElement(By.id("fruit-selects"));
		Collections.scrollToElement(driver);
		Assert.assertTrue(Collections.duplicateString(str.toString())); // 
	}
	
	@Test(invocationCount = 0)
	public static void checkDropdownValuesSorted() { // need to check
		WebDriver driver = new ChromeDriver();
		driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebElement dropdown = driver.findElement(By.id("dropdowm-menu-1"));
		Select sel = new Select(dropdown);
		List<WebElement> allOption = sel.getOptions();
		List<String> values = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		for(WebElement e: allOption) {
			str.append(e.getText()+" ");
		}
		Assert.assertTrue(Collections.duplicateString(str.toString())); // 
	}
}
