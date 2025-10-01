package mavenforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UITest 
{

	@Parameters("Browser")
	@Test
	public void startBrowser(String browserName)
	{
		System.out.println("Parameter value is "+browserName);
		System.out.println("GIT commit from Jira");
		System.out.println("GIT commit from Jira for scrum 6");
		WebDriver driver=null;
		
		if(browserName.contains("Chrome"))
		{
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--headless");
			opt.addArguments("--no-sandbox");
			opt.addArguments("--disable-dev-shm-usage");
			driver=new ChromeDriver(opt);
		}
		else if(browserName.contains("Edge"))
		{
			 driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("Browser opened");
		Assert.assertTrue(driver.getTitle().contains("Orange"), "Title does not match");
		driver.quit();
		System.out.println("Browser closed");
	}
	
	
}
