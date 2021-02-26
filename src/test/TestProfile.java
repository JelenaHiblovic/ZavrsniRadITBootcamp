package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyCompany;

public class TestProfile {

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
	public void testStaff() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath(MyCompany.STAFF)).click();
	}

	@Test(priority = 4)
	public void testChangeAddressAndGender() {

		driver.findElement(By.id("_fbody")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"7\"]/a")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(By.xpath(MyCompany.EDIT_DET)).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement drop1 = driver.findElement(By.id("gender"));
		drop1.click();
		drop1.sendKeys(Keys.ARROW_DOWN);
		drop1.sendKeys(Keys.ARROW_DOWN);
		drop1.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.name("city")).sendKeys("Beograd");

		driver.findElement(By.name("update")).click();
		driver.close();

	}

}
