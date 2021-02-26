package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
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

public class TestMyCompany {
	
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
	public void testDashboard() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath(MyCompany.DASHBOARD));

		String actual = driver.getTitle();
		String expected = "Dashboard - Dashboard - Humanity";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 4)
	public void testShiftPlaning() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath(MyCompany.SHIFT_PLANNING)).click();

		String actual = driver.getTitle();
		String expected = "ShiftPlanning - Humanity";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 5)
	public void testTimeClock() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath(MyCompany.TIME_CLOCK)).click();

		String actual = driver.getTitle();
		String expected = "Timeclock - Overview - Humanity";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 6)
	public void testLeave() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath(MyCompany.LEAVE)).click();

		assertTrue(driver.getTitle().contains("Leave - Vacation - Humanity"));
	}
	@Test(priority = 7)
	public void testTraining() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath(MyCompany.TRANING)).click();

		assertTrue(driver.getTitle().contains("Training - Overview - Humanity"));
	}
	
	@Test(priority = 8)
	public void testStaff() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.xpath(MyCompany.STAFF)).click();

		String actual = driver.getTitle();
		String expected = "Staff - Humanity";
		Assert.assertEquals(actual, expected);

	}
	
	@Test(priority = 9)
	public void testPayroll() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.id(MyCompany.PAYROLL)).click();

		assertTrue(driver.getTitle().contains("Payroll - Scheduled-hours - Humanity"));
	}
	
	@Test(priority = 10)
	public void testReports() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.id(MyCompany.REPORTS)).click();

		assertTrue(driver.getTitle().contains("Reports - Reports Home - Humanity"));
	}
	
	@Test(priority = 11)
	public void testAvailability() {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.id(MyCompany.AVAILABILITY)).click();

		assertTrue(driver.getTitle().contains("Humanity"));
	
		driver.close();
	}
	
}
