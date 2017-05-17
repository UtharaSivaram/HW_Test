/**
 * Summary : This test would do Boundary Value Analysis on phone number field which has max length of 20 as per the code.
 **/

package hwTestPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BVA {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
	
	}

	@Test
	public void phoneTwentyDigits() {
		driver = new ChromeDriver(); // Launch Chrome Browser
		driver.get("http://hw.test.hwuat.com/pages/homepage.html"); // Navigate
																	// to URL
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		// Assert, Validate form name
	
		driver.findElement(By.name("firstname")).sendKeys("TestFN"); // Input
																		// Form
																		// Data
																		// Start
		driver.findElement(By.name("lastname")).sendKeys("TestLN");
		driver.findElement(By.name("job")).sendKeys("TestJobTitle");
		driver.findElement(By.name("phone")).sendKeys("12345678901234567890");
		driver.findElement(By.name("email1")).sendKeys("test@a.com");
		driver.findElement(By.name("email2")).sendKeys("test@a.com"); // Input
																		// Form
																		// Data
																		// Start
		driver.findElement(By.id("Radio1")).click(); // Select Check Box
		driver.findElement(By.xpath("//*[@id='contactForm']/div[5]/button")).click(); // Submit
																						// Form
	
		WebDriverWait wait = new WebDriverWait(driver, 10); // Synchronisation,
															// wait for
															// destination page
															// to load
		By assertEle = By.id("hwsg-menuButton");
		By assertEle2 = By.className("hwsg-release");
	
		wait.until(ExpectedConditions.elementToBeClickable(assertEle2));
	
		WebElement assertionElement = driver.findElement(assertEle);
		String actualElement = assertionElement.getTagName();
		String expectedElement = "a";
		Assert.assertEquals(actualElement, expectedElement); // Check Elements
																// on
																// Destination
																// page
		String actualTitle = driver.getTitle();
		String expectedTitle = "HW Template Sandbox";
		Assert.assertEquals(actualTitle, expectedTitle); // Check Destination
															// page title
	}

	@Test
	public void phoneTwentyOneDigits() {
		driver = new ChromeDriver(); // Launch Chrome Browser
		driver.get("http://hw.test.hwuat.com/pages/homepage.html"); // Navigate
																	// to URL
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		// Assert, Validate form name
	
		driver.findElement(By.name("firstname")).sendKeys("TestFN"); // Input
																		// Form
																		// Data
																		// Start
		driver.findElement(By.name("lastname")).sendKeys("TestLN");
		driver.findElement(By.name("job")).sendKeys("TestJobTitle");
		driver.findElement(By.name("phone")).sendKeys("123456789012345678901");
		driver.findElement(By.name("email1")).sendKeys("test@a.com");
		driver.findElement(By.name("email2")).sendKeys("test@a.com"); // Input
																		// Form
																		// Data
																		// Start
		driver.findElement(By.id("Radio1")).click(); // Select Check Box
		driver.findElement(By.xpath("//*[@id='contactForm']/div[5]/button")).click(); // Submit
																						// Form
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "HW Template Sandbox";
		if (actualTitle.equals(expectedTitle)) {
			Assert.fail("Form cannot be submitted with more than 20 digits in the phone number field");
		} else {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[2]/div/p")).getText(),
					"Please enter valid phone number");

		}

	}

	@Test
	public void phoneNineteenDigits() {
		driver = new ChromeDriver(); // Launch Chrome Browser
		driver.get("http://hw.test.hwuat.com/pages/homepage.html"); // Navigate
																	// to URL
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		// Assert, Validate form name
	
		driver.findElement(By.name("firstname")).sendKeys("TestFN"); // Input
																		// Form
																		// Data
																		// Start
		driver.findElement(By.name("lastname")).sendKeys("TestLN");
		driver.findElement(By.name("job")).sendKeys("TestJobTitle");
		driver.findElement(By.name("phone")).sendKeys("1234567890123456789");
		driver.findElement(By.name("email1")).sendKeys("test@a.com");
		driver.findElement(By.name("email2")).sendKeys("test@a.com"); // Input
																		// Form
																		// Data
																		// Start
		driver.findElement(By.id("Radio1")).click(); // Select Check Box
		driver.findElement(By.xpath("//*[@id='contactForm']/div[5]/button")).click(); // Submit
																						// Form
	
		WebDriverWait wait = new WebDriverWait(driver, 10); // Synchronisation,
															// wait for
															// destination page
															// to load
		By assertEle = By.id("hwsg-menuButton");
		By assertEle2 = By.className("hwsg-release");
	
		wait.until(ExpectedConditions.elementToBeClickable(assertEle2));
	
		WebElement assertionElement = driver.findElement(assertEle);
		String actualElement = assertionElement.getTagName();
		String expectedElement = "a";
		Assert.assertEquals(actualElement, expectedElement); // Check Elements
																// on
																// Destination
																// page
		String actualTitle = driver.getTitle();
		String expectedTitle = "HW Template Sandbox";
		Assert.assertEquals(actualTitle, expectedTitle); // Check Destination
															// page title
	}

	@AfterMethod
	public void tearDown()
	{ 		
		if (driver != null) 			
			driver.quit(); 	
	}
}

