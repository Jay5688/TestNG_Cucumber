package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import common.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {
	//WebDriver driver;
	private BaseClass base;
	public Hooks(BaseClass base) {
		this.base=base;
	}
	@Before
		public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome_Driver\\chromedriver.exe");
		base.driver = new ChromeDriver();
		//base.driver.get("https://adactinhotelapp.com/");
		base.driver.manage().window().maximize();		
	           }
    @After
        public void teardown(Scenario scenario) 
     {
    	if (scenario.isFailed())
    	{
    		final byte[] screenshot=((TakesScreenshot) base.driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(screenshot, "image/png", scenario.getName());
    	}
    	base.driver.quit();
	
               }
    

}
