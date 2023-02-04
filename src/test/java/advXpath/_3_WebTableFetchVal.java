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

public class _3_WebTableFetchVal {
	
	String desertName = "Gingerbread";
	
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
	public void webTableValFetch()
	{

		try {
			
			List<WebElement> listDesNutriValEle = driver.findElements(By.xpath("//td[text()='"+desertName+"']//following-sibling::td[text()]"));
			
			for (int i = 0; i < listDesNutriValEle.size(); i++) {
				System.out.println(listDesNutriValEle.get(i).getText());
			}
	
			
		} catch (NoSuchElementException e) {
			System.out.println("Unable to findOut the desert with name :-> " + desertName + " in the table");
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
