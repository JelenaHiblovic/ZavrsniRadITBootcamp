package test;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;


public class TestStartFreeTrial1 {

	
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jelenin Dellic\\chrome driver\\ChromeDriver.exe");
		driver = new ChromeDriver();
		
	}

	@Test (priority=1)
	public void testcloseAdvertisment() {

		driver.navigate().to(HomePage.URL);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage.ADV1)));
		element1.click();
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage.ADV2)));
		element2.click();
		
	}

	@Test (priority=2)      //Start free trial levo + login 
	public void testTrial1() {
		
		
		driver.findElement(By.name("fullname")).sendKeys(HomePage.FULLNAME());
		driver.findElement(By.name("workemail")).sendKeys(HomePage.E_MAIL());
		driver.findElement(By.id("free-trial-link-01")).click();

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(By.xpath(HomePage.COMPANY_XPATH)).sendKeys(HomePage.COMPANY_NAME);

		WebElement drop1 = driver.findElement(By.xpath(HomePage.INDUSTRY));
		drop1.click();
		drop1.sendKeys(Keys.ARROW_DOWN);
		drop1.sendKeys(Keys.ARROW_DOWN);
		drop1.sendKeys(Keys.ARROW_DOWN);
		drop1.sendKeys(Keys.ENTER);

		WebElement drop2 = driver.findElement(By.xpath(HomePage.FUNCTIONAL_ROLE));
		drop2.click();
		drop2.sendKeys(Keys.ARROW_DOWN);
		drop2.sendKeys(Keys.ARROW_DOWN);
		drop2.sendKeys(Keys.ARROW_DOWN);
		drop2.sendKeys(Keys.ARROW_DOWN);
		drop2.sendKeys(Keys.ENTER);

		driver.findElement(By.name("phone")).sendKeys(HomePage.PHONE);
		driver.findElement(By.name("password")).sendKeys(HomePage.PASSWORD);
		driver.findElement(By.name("repeat_password")).sendKeys(HomePage.PASSWORD);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[2]/span/input")).click();
		
		driver.close();
		
	}
	
	
}
