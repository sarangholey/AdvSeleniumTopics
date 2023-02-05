package BrokenImagesLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksHandling {
	
static WebDriver driver;
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void brokenImages()
	{
		List<WebElement> linkListWithImgTagEle = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Images found over the URL are -> " + linkListWithImgTagEle.size());
		
		
		for (int i = 0; i < linkListWithImgTagEle.size(); i++) {
			
			String SourceLink = linkListWithImgTagEle.get(i).getAttribute("href");
			
			try {
				// Created a URL
				URL url = new URL(SourceLink);
				// Create a URL Connection
				URLConnection urlConnection = url.openConnection();
				
				HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
				
				httpURLConnection.setConnectTimeout(4000);
				
				httpURLConnection.connect();
				
				if(httpURLConnection.getResponseCode() == 200)
				{
					System.out.println("The image source link " + SourceLink + " -> is " + httpURLConnection.getResponseCode());
				}
				else
				{
					System.out.println("The image source link " + SourceLink + " -> is " + httpURLConnection.getResponseCode());
				}
				httpURLConnection.disconnect();
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
