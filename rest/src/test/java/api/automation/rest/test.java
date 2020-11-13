package api.automation.rest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class test {
	@Test
	public void invokeURL()
	{
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Etisalat\\Ravi\\Softwares\\chromedriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("www.emirates.com");
	WebElement arrivalAirport=driver.findElement(By.xpath("//input[@name='Arrival airport']"));
	arrivalAirport.sendKeys("MAA");
	arrivalAirport.sendKeys(Keys.TAB);
	}
	

}
