package configurations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class ShareDriver extends EventFiringWebDriver {

public static final WebDriver driver;
	
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrive\\chromedriver2.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown(Scenario scenario) {
		driver.quit();
	}
	
	//Constructor
	public ShareDriver() {
		super(driver);
			
	} 

}
