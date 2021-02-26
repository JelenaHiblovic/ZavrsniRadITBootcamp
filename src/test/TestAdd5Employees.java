package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.MyCompany;

public class TestAdd5Employees {

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
	public void testAddEmployed() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(By.id(MyCompany.ADDEMPLOYED)).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		List<WebElement> name = driver.findElements(By.className("_ns_fname"));
		List<WebElement> last_name = driver.findElements(By.className("_ns_lname"));
		List<WebElement> e_mail = driver.findElements(By.className("_ns_email"));

		File f = new File("Zaposleni.xlsx");

		try {
			InputStream inp = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			SoftAssert sa = new SoftAssert();

			for (int i = 1; i < 6; i++) {
				Row row = sheet.getRow(i);
				Cell c1 = row.getCell(1);
				Cell c2 = row.getCell(2);
				Cell c3 = row.getCell(3);

				name.get(i - 1).sendKeys(c1.toString());
				last_name.get(i - 1).sendKeys(c2.toString());
				e_mail.get(i - 1).sendKeys(c3.toString());

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				
			}

			sa.assertAll();

			wb.close();
			
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}
		
		driver.findElement(By.id(MyCompany.SAVE_EMPLOYEES)).click();
		
	}
	
	@Test (priority = 5)
	public void testAddCheck() {
		
	driver.findElement(By.xpath(MyCompany.STAFF)).click();
	
	try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {

		e.printStackTrace();
	}
	List<WebElement> e_mail = driver.findElements(By.className("_ns_email"));
	
	String actual = driver.findElement(By.partialLinkText("Jelena")).getText();
	String expected = "Jelena Hiblovic";

	Assert.assertEquals(actual, expected);
	driver.close();
	
	}
}
