
package api.automation.rest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Website {

	public static String getCode() throws InterruptedException {
		// TODO Auto-generated method stub

		String URL = "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Etisalat\\Ravi\\Softwares\\chromedriver.exe");
		 ChromeOptions chromeOptions = new ChromeOptions();

		 chromeOptions.addArguments("headless");
		 WebDriver driver = new ChromeDriver(chromeOptions);
		//WebDriver driver = new ChromeDriver();

		driver.get(URL);
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("automationforqa");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("9849456167");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String codeUrl = driver.getCurrentUrl();
		String codeSplit = codeUrl.split("code=")[1];
		String code = codeSplit.split("&scope=")[0];
		driver.close();
		return code;

	}

}
