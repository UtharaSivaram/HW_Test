/**
 * Summary : This test would find the total broken/inaccessible images on the webpage
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenImages {
	public WebDriver driver;
	int invalidImageCount;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumProjects\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumProjects\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "D:\\SeleniumProjects\\IEDriverServer.exe");
		
	}
	
	@Test
	public void validateInvalidImagesIE() {
		try {
			driver = new InternetExplorerDriver();
			driver.get("http://hw.test.hwuat.com/pages/homepage.html");
			driver.manage().window().maximize();

			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void validateInvalidImagesFF() {
		try {
			driver = new FirefoxDriver();
			driver.get("http://hw.test.hwuat.com/pages/homepage.html");
			driver.manage().window().maximize();
	
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void validateInvalidImagesChrome() {
		try {
			driver = new ChromeDriver();
			driver.get("http://hw.test.hwuat.com/pages/homepage.html");
			driver.manage().window().maximize();
	
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
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