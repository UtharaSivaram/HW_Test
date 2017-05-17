 /**
  *  Summary : This test will test string fields for support of special characters
  **/

package hwTestPack;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class SubmitFormSpecialCharacters {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumProjects\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "D:\\SeleniumProjects\\IEDriverServer.exe");
	}

	@Test
	public void chromeSpecialCharacters() {
		driver = new ChromeDriver(); // Launch Chrome Browser
		driver.get("http://hw.test.hwuat.com/pages/homepage.html"); // Navigate
																	// to URL
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		// Assert, Validate form name

		driver.findElement(By.name("firstname")).sendKeys("TestFN!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``"); // Input
																		// Form
																		// Data
																		// Start
		driver.findElement(By.name("lastname")).sendKeys("TestLN!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``");
		driver.findElement(By.name("job")).sendKeys("TestJT!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``");
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		driver.findElement(By.name("email1")).sendKeys("test1@q.com");
		driver.findElement(By.name("email2")).sendKeys("test2@q.com"); // Input
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
		By assertEle2 = By.className("hwsg-client");

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
	public void firefoxSpecialCharacters() {
		driver = new FirefoxDriver();
		driver.get("http://hw.test.hwuat.com/pages/homepage.html");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		driver.findElement(By.name("firstname")).sendKeys("TestFN!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``");
		driver.findElement(By.name("lastname")).sendKeys("TestLN!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``");
		driver.findElement(By.name("job")).sendKeys("TestJT!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``");
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		driver.findElement(By.name("email1")).sendKeys("test@a.com");
		driver.findElement(By.name("email2")).sendKeys("test@a.com");
		driver.findElement(By.id("Radio1")).click();
		driver.findElement(By.xpath("//*[@id='contactForm']/div[5]/button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		By assertEle = By.id("hwsg-menuButton");
		By assertEle2 = By.className("hwsg-release");

		wait.until(ExpectedConditions.elementToBeClickable(assertEle2));

		WebElement assertionElement = driver.findElement(assertEle);
		String actualElement = assertionElement.getTagName();
		String expectedElement = "a";
		Assert.assertEquals(actualElement, expectedElement);
		String actualTitle = driver.getTitle();
		String expectedTitle = "HW Template Sandbox";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void ieSpecialCharacters() {
		driver = new InternetExplorerDriver();
		driver.get("http://hw.test.hwuat.com/pages/homepage.html");
		driver.manage().window().maximize();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
		         "Contact Doc Brown");
		driver.findElement(By.name("firstname")).sendKeys("TestFN!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``");
		driver.findElement(By.name("lastname")).sendKeys("TestLN!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``");
		driver.findElement(By.name("job")).sendKeys("TestJT!@#$%&*()_+}{:[\\\"]=-/.,\\\\`<>?:/.,;'~``");
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		driver.findElement(By.name("email1")).sendKeys("test@a.com");
		driver.findElement(By.name("email2")).sendKeys("test@a.com");
		driver.findElement(By.id("Radio1")).click();
		driver.findElement(By.xpath("//*[@id='contactForm']/div[5]/button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		By assertEle = By.id("hwsg-nav");
		By assertEle2 = By.className("hwsg-logo");

		wait.until(ExpectedConditions.elementToBeClickable(assertEle2));

		WebElement assertionElement = driver.findElement(assertEle);
		String actualElement = assertionElement.getTagName();
		String expectedElement = "a";
		Assert.assertEquals(actualElement, expectedElement);
		String actualTitle = driver.getTitle();
		String expectedTitle = "HW Template Sandbox";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod
	public void tearDown()
	{ 		
		if (driver != null) 			
			driver.quit(); 	
	}
}

