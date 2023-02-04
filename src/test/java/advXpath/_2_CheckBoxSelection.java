package advXpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_CheckBoxSelection {

	String userName = "Akash";
	
	static WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://letcode.in/table");
	}
	
	@Test
	public void checkBxSelection()
	{
		try {
			
			WebElement userChkBoxEle = driver.findElement(By.xpath("//td[text()='"+userName+"']//parent::tr//td/input[@type='checkbox']"));
			userChkBoxEle.click();
			Assert.assertTrue(userChkBoxEle.isSelected());
			
		} catch (NoSuchElementException e) {
			System.out.println("Unable to findOut the user with name :-> " + userName + " in the table");
			e.printStackTrace();
			e.getMessage();
		}

	}
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
