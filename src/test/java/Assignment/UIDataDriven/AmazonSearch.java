package Assignment.UIDataDriven;

import org.testng.annotations.Test;

import resources.ExcelUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AmazonSearch {

	private String sTestCaseName;

	private int iTestCaseRow;

	WebDriver driver;
	WebDriverWait wait;

	@Test(dataProvider = "ExternalData")
	public void TestAmazonSearch(String search, String min, String max) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("#APjFqb")))).sendKeys("amazon"); 
		driver.findElement(By.cssSelector("#APjFqb")).sendKeys(Keys.ENTER);
		Reporter.log("User is able to enter amazon in search bar");
		Thread.sleep(5000);
		List<WebElement> items = driver.findElements(By.xpath("//div[@id=\"search\"]//a"));
		System.out.println(items.size());
		Reporter.log("User will print all the serach result url as follows with total count: " + items.size());
		for (WebElement item : items) {
			String url = item.getAttribute("href");
			System.out.println(url);
			Reporter.log("Url:- "+ url);
		}
		
		for (WebElement item : items) {
			String url = item.getAttribute("href");
			if (url.contains("https://www.amazon.in/")) // data
			{
				item.click();
				break;
				
			}
		}
		Reporter.log("User is able to navigate to amazon.in website");

		driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/span[contains(text(),'All')]")).click(); // data

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(text(),'Electronics')])[1]")))
				.click();

		Thread.sleep(2000);

		Reporter.log("User is able to navigate ELectronics WebPage");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(search); // data
		Reporter.log("User is able to serach for: " + search);
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id=\"low-price\"]")).sendKeys(min); // data
		Reporter.log("User is able enter filter Min value as: " + min);
		
		driver.findElement(By.xpath("//*[@id=\"high-price\"]")).sendKeys(max); // data
		Reporter.log("User is able enter filter Max value as: " + max);

		driver.findElement(By.xpath("//input[@class=\"a-button-input\"]")).click();

		driver.findElement(By.xpath("//section[contains(@aria-label,'4')]")).click(); // data
		Reporter.log("User is able apply 4 star filter");

		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfAllElements(driver.findElements(By.xpath("//span[contains(@class,'a-text-normal')]"))));
		List<WebElement> productNames = driver.findElements(By.xpath("//span[contains(@class,'a-text-normal')]"));
		
		System.out.println(productNames.size());
		Reporter.log("User is able to get the all product name with total count as: " + productNames.size());
		
		for (WebElement productName : productNames) {
			String name = productName.getText();
			System.out.println(name);
			Reporter.log("Product Name:- " + name);
		}

	}

	@BeforeMethod
	public void beforeMethod() {

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

		// explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Reporter.log("User is able to Navigate to Google Search Page.");
	}

	@AfterMethod
	public void afterMethod() {

		driver.close();
		Reporter.log("User is able to close the browser");
	}

	@DataProvider
	public Object[][] ExternalData() throws Exception {
		
		// Setting up the Test Data Excel file
		String filePath = System.getProperty("user.dir") + "\\Data.xlsx";
		
		Object[][] testObjArray = ExcelUtility.getTableArray(filePath,"Sheet1");

		return (testObjArray);



	}



}
