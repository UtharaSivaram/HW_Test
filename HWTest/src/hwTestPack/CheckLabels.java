/**
 *  Summary : This test will validate form labels
 **/

package hwTestPack;

import org.testng.annotations.Test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class CheckLabels {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumProjects\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "D:\\SeleniumProjects\\IEDriverServer.exe");
	}

	@Test
	public void chromeLabels() {
		driver = new ChromeDriver(); // Launch Chrome Browser
		driver.get("http://hw.test.hwuat.com/pages/homepage.html"); // Navigate
																	// to URL
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		// Assert, Validate form name
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/small")).getText(),
				"Fields marked with * are required");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[1]/div[1]/div/label")).getText(),
				"First name *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[1]/div[2]/div/label")).getText(),
				"Last name *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[1]/div/label")).getText(),
				"Job Title *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[2]/div/label")).getText(),
				"Phone *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[1]/div/label")).getText(),
				"Email *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[2]/div/label")).getText(),
				"Confirm Email *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/label")).getText(),
				"Would you like a pepsi?");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[1]/label")).getText(),
				"Yes");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[2]/label")).getText(),
				"No");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[3]/label")).getText(),
				"Maybe");

	}

	@Test
	public void firefoxLabels() {
		driver = new FirefoxDriver();
		driver.get("http://hw.test.hwuat.com/pages/homepage.html");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
				"Contact Doc Brown");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/small")).getText(),
				"Fields marked with * are required");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[1]/div[1]/div/label")).getText(),
				"First name *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[1]/div[2]/div/label")).getText(),
				"Last name *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[1]/div/label")).getText(),
				"Job Title *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[2]/div/label")).getText(),
				"Phone *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[1]/div/label")).getText(),
				"Email *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[2]/div/label")).getText(),
				"Confirm Email *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/label")).getText(),
				"Would you like a pepsi?");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[1]/label")).getText(),
				"Yes");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[2]/label")).getText(),
				"No");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[3]/label")).getText(),
				"Maybe");

	}

	@Test
	public void ieLabels() {
		driver = new InternetExplorerDriver();
		driver.get("http://hw.test.hwuat.com/pages/homepage.html");
		driver.manage().window().maximize();
	Assert.assertEquals(driver.findElement(By.xpath("//*[@id='pageBody']/section[5]/div[2]/h2")).getText(),
			"Contact Doc Brown");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/small")).getText(),
				"Fields marked with * are required");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[1]/div[1]/div/label")).getText(),
				"First name *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[1]/div[2]/div/label")).getText(),
				"Last name *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[1]/div/label")).getText(),
				"Job Title *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[2]/div[2]/div/label")).getText(),
				"Phone *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[1]/div/label")).getText(),
				"Email *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[3]/div[2]/div/label")).getText(),
				"Confirm Email *");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/label")).getText(),
				"Would you like a pepsi?");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[1]/label")).getText(),
				"Yes");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[2]/label")).getText(),
				"No");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactForm']/div[4]/div/span[3]/label")).getText(),
				"Maybe");

	}

	@AfterMethod
	public void tearDown()
	{ 		
		if (driver != null) 			
			driver.quit(); 	
		}
	
		
	}


