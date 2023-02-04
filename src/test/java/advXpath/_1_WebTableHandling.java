package advXpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class _1_WebTableHandling {
	
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
	public void priceValidation()
	{
		List<WebElement> listpricesFrmTableEle = driver.findElements(By.xpath("//table[@id=\"shopping\"]//tbody/tr/td[2]"));
		
		WebElement finalTotalPriceEle = driver.findElement(By.xpath("//table[@id=\"shopping\"]//tfoot/td[2]/b"));
		
		int sum = 0;
		
		for (int i = 0; i < listpricesFrmTableEle.size(); i++) 
		{
			sum += Integer.parseInt(listpricesFrmTableEle.get(i).getText());
					
		}
		
		System.out.println(sum + " " + finalTotalPriceEle.getText() );

		if (sum == Integer.parseInt(finalTotalPriceEle.getText())) {
			Assert.assertTrue(true);
			System.out.println("Total is matching");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Total is not matching");
		}
		

	}
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
