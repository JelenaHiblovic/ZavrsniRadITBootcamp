package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.In_Settings;

public class TestSettings {
	
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jelenin Dellic\\chrome driver\\ChromeDriver.exe");
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void testcloseAdvertisment() {

		driver.navigate().to(HomePage.URL);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage.ADV1)));
		element1.click();
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage.ADV2)));
		element2.click();

	}

	@Test(priority = 2)
	public void testLogin() {

		driver.findElement(By.xpath(HomePage.LOGIN)).click();
		driver.findElement(By.id("email")).sendKeys(HomePage.EMAIL_LOGIN);
		driver.findElement(By.id("password")).sendKeys(HomePage.PASSWORD_LOGIN);
		driver.findElement(By.name("login")).click();

	}

	@Test(priority = 3)
	public void testChangeLanguage() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath(In_Settings.SETTINGS_BUTTON)).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement drop1 = driver
				.findElement(By.xpath(In_Settings.LANGUAGE));
		drop1.click();
		drop1.sendKeys(Keys.ARROW_DOWN);
		drop1.sendKeys(Keys.ARROW_DOWN);
		drop1.sendKeys(Keys.ARROW_DOWN);
		drop1.sendKeys(Keys.ENTER);

	}

	@Test(priority = 4)
	public void testNotifications() {

		driver.findElement(By.id(In_Settings.NOTIFICATION_EMAIL)).click();
		driver.findElement(By.id(In_Settings.NOTIFICATION_SMS)).click();
		driver.findElement(By.id(In_Settings.NOTIFICATION_MOB_PUSH)).click();

		driver.findElement(By.xpath(In_Settings.SAVE_SETTINGS));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.close();

	}
}
