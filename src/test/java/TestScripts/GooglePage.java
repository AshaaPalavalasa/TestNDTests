package TestScripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePage {
	WebDriver driver;
	
	@BeforeMethod
	public void setupp() {
		WebDriverManager.chromedriver().setup();
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	
	@Test(alwaysRun=true,dependsOnMethods="SeleniumTest")	//using alwaysRun, even if selenium fails java does not skip
	public void JavaPointTest() {

	  	driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
//		################# SoftAssert ####################
		SoftAssert softAssert= new SoftAssert();
//		softAssert.assertEquals(driver.getTitle(),"GooglePage");		//Gets failed due to incorrect title
		softAssert.assertEquals(driver.getTitle(),"Google");
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("JavaPoint");
		scrhbox.submit();
		softAssert.assertEquals(driver.getTitle(),"JavaPoint - Google Search");
		softAssert.assertAll();		// Considers all the assert statments and returns as Test Failure, if any one assert gets failed
		
	}
//	@Test(priority=1)
	@Test
	public void GoogleTest() {
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("Google");
//		####################  Hard Assert ##############################
		Assert.assertEquals(driver.getTitle(),"Google");
		scrhbox.submit();
	}
	@Test(retryAnalyzer=RetryTest.class)
	public void W3CTest() {
//		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("W3C");
//		####################  Hard Assert ##############################
		Assert.assertEquals(driver.getTitle(),"Googgle");
		scrhbox.submit();
	}
	@Test
	public void SeleniumTest() {
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("Selenium");
//		####################  Hard Assert ##############################
		Assert.assertEquals(driver.getTitle(),"Google");
		scrhbox.submit();
	}
	@Test(enabled=false)
	public void TestToNotRun() {
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("Hello");
		scrhbox.submit();
		
		
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
}


//	TesttSuite--> Test-->Classes-->Methods