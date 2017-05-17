/* 
 * Summary : This test would validate error message for incorrect email id format, check error message 
 * when email and confirm email are different 
 */

package hwTestPack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailChecks {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
	}

	@Test
	public void invalidEmail() {
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
		driver.findElement(By.name("email1")).sendKeys("a@");
		driver.findElement(By.name("email2")).sendKeys("a@"); // Input Form
																// Data
																// End
		driver.findElement(By.id("Radio1")).click(); // Select & Click Radio
														// Button
		driver.findElement(By.xpath("//*[@id='contactForm']/div[5]/button")).click();
	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "HW Template Sandbox";
		if (actualTitle.equals(expectedTitle)) {
			Assert.fail("Form Submitted with invalid email Id");
		} else {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[1]/div/p")).getText(),
					"Inavlid Email");
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[2]/div/p")).getText(),
					"Invalid confirm email");
	
		}
	
	}

	@Test
	public void confirmEmailCheck() {
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
		driver.findElement(By.name("email1")).sendKeys("a@a.com");
		driver.findElement(By.name("email2")).sendKeys("b@a.com"); // Input Form
																// Data
																// End
		driver.findElement(By.id("Radio1")).click(); // Select & Click Radio
														// Button
		driver.findElement(By.xpath("//*[@id='contactForm']/div[5]/button")).click();
	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "HW Template Sandbox";
		if (actualTitle.equals(expectedTitle)) {
			Assert.fail("Email and Confirm Email are not same");
		} else {
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[1]/div/p")).getText(),
					"Inavlid Email");
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[2]/div/p")).getText(),
					"Invalid confirm email");
	
		}
	
	}

	@AfterMethod
	public void tearDown()
	{ 		
		if (driver != null) 			
			driver.quit(); 	
	}
}

