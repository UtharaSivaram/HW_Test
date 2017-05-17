/**
 * Summary : This test would submit correct values to form in all 3 browsers
 **/

package hwTestPack;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
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

public class SubmitForm {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumProjects\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "D:\\SeleniumProjects\\IEDriverServer.exe");
	}

	@Test
	public void chromeForm() {
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
		driver.findElement(By.name("phone")).sendKeys("1234567890");
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
	public void firefoxForm() {
		driver = new FirefoxDriver();
		driver.get("http://hw.test.hwuat.com/pages/homepage.html");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		driver.findElement(By.name("firstname")).sendKeys("TestFN");
		driver.findElement(By.name("lastname")).sendKeys("TestLN");
		driver.findElement(By.name("job")).sendKeys("TestJobTitle");
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
	public void ieForm() {
		driver = new InternetExplorerDriver();
		driver.get("http://hw.test.hwuat.com/pages/homepage.html");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		driver.findElement(By.name("firstname")).sendKeys("TestFN");
		driver.findElement(By.name("lastname")).sendKeys("TestLN");
		driver.findElement(By.name("job")).sendKeys("TestJobTitle");
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
	public void nullValues() {
		driver = new ChromeDriver(); // Launch Chrome Browser
		driver.get("http://hw.test.hwuat.com/pages/homepage.html"); // Navigate
																	// to URL
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		// Assert, Validate form name

		driver.findElement(By.name("firstname")).sendKeys(""); // Input Form
																// Data Start
		driver.findElement(By.name("lastname")).sendKeys("");
		driver.findElement(By.name("job")).sendKeys("");
		driver.findElement(By.name("phone")).sendKeys("");
		driver.findElement(By.name("email1")).sendKeys("");
		driver.findElement(By.name("email2")).sendKeys(""); // Input Form Data
															// Start
		driver.findElement(By.id("Radio1")).click(); // Select Check Box
		driver.findElement(By.xpath("//*[@id='contactForm']/div[5]/button")).click(); // Submit
																						// Form

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[1]/div[1]/div/p")).getText(),
				"Please enter your firstname");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[1]/div[2]/div/p")).getText(),
				"Please enter your last name");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[1]/div/p")).getText(),
				"Please enter your Job Title");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[2]/div/p")).getText(),
				"Please enter your phone number");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[1]/div/p")).getText(),
				"Please enter your email");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[2]/div/p")).getText(),
				"Please enter confirm email");

	}

	@Test
	public void multipleRadioSelect() {
		driver = new ChromeDriver(); // Launch Chrome Browser
		driver.get("http://hw.test.hwuat.com/pages/homepage.html"); // Navigate
																	// to URL
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		// Assert, Validate form name

		driver.findElement(By.name("firstname")).sendKeys("FN"); // Input Form
																	// Data
																	// Start
		driver.findElement(By.name("lastname")).sendKeys("LN");
		driver.findElement(By.name("job")).sendKeys("Tester");
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		driver.findElement(By.name("email1")).sendKeys("a@a.in");
		driver.findElement(By.name("email2")).sendKeys("b@b.in"); // Input Form
																	// Data
																	// Start
		driver.findElement(By.id("Radio1")).click(); // Select & Click Radio
														// Button
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement radio2 = driver.findElement(By.id("Radio2"));
		WebElement radio3 = driver.findElement(By.id("Radio3"));
		if (radio2.isEnabled() || radio3.isEnabled()) {
			Assert.fail("Multiple radio buttons are enabled to be selected");
		}

	}

		

}
