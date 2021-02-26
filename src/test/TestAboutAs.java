package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestAboutAs {
	
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jelenin Dellic\\chrome driver\\ChromeDriver.exe");
		driver = new ChromeDriver();
		
	}

	@Test (priority = 1)
	public void testcloseAdvertisment() {

		driver.navigate().to(HomePage.URL);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage.ADV1)));
		element1.click();
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage.ADV2)));
		element2.click();
		
	}
	@Test (priority = 2)
	public void ScreenShotAboutAS() {
		driver.navigate().to(HomePage.URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a/p[1]")).click();
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshotFile , new File("C:\\Screenshot\\AboutAsScreenshot.png"));
		} catch (IOException e) {
			System.out.println("Screenshot did not take!");
			
			e.printStackTrace();
		}

		driver.close();
	}
}
