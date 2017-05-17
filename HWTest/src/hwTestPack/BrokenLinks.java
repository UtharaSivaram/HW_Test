/**
*Summary : This test would find the total broken/inaccessible links on the web page
**/

package hwTestPack;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenLinks {
	public WebDriver driver;
	int invalidLinksCount;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumProjects\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "D:\\SeleniumProjects\\IEDriverServer.exe");

	}

	@Test
	public void validateInvalidLinksIE() {

		try {
			driver = new InternetExplorerDriver();
			driver.get("http://hw.test.hwuat.com/pages/homepage.html");
			driver.manage().window().maximize();

			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
			System.out.println("Total no. of links are " + anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript")) {
						verifyURLStatus(url);
					} else {
						invalidLinksCount++;
					}
				}
			}

			System.out.println("Total no. of invalid links are " + invalidLinksCount);
			if(invalidLinksCount>0)
				Assert.fail("Invalid Links Found - Failing test");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void validateInvalidLinksFF() {
	
		try {
			driver = new FirefoxDriver();
			driver.get("http://hw.test.hwuat.com/pages/homepage.html");
			driver.manage().window().maximize();
	
			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
			System.out.println("Total no. of links are " + anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript")) {
						verifyURLStatus(url);
					} else {
						invalidLinksCount++;
					}
				}
			}
	
			System.out.println("Total no. of invalid links are " + invalidLinksCount);
			if(invalidLinksCount>0)
				Assert.fail("Invalid Links Found - Failing test");
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void validateInvalidLinksChrome() {
	
		try {
			driver = new ChromeDriver();
			driver.get("http://hw.test.hwuat.com/pages/homepage.html");
			driver.manage().window().maximize();
	
			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
			System.out.println("Total no. of links are " + anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript")) {
						verifyURLStatus(url);
					} else {
						invalidLinksCount++;
					}
				}
			}
	
			System.out.println("Total no. of invalid links are " + invalidLinksCount);
			if(invalidLinksCount>0)
				Assert.fail("Invalid Links Found - Failing test");
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void verifyURLStatus(String URL) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(request);
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			//// We can also check for 404 status code like
			// response.getStatusLine().getStatusCode() == 404
			if (response.getStatusLine().getStatusCode() != 200)
				invalidLinksCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	@AfterMethod
	public void tearDown()
	{ 		
		if (driver != null) 			
			driver.quit(); 
	
}
}
