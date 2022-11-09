package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReports {
	WebDriver driver;
	ExtentReports extentReport;
	ExtentSparkReporter sparkReport;
	ExtentTest extentTest;
	
	
	@BeforeTest
	public void setupExtentReport() {
		extentReport=new ExtentReports();
		sparkReport=new ExtentSparkReporter("target/SparkReport.html");
		extentReport.attachReporter(sparkReport);
		
	}
	
	@BeforeMethod
	public void setupp() {
		WebDriverManager.chromedriver().setup();
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	@Test
	public void GoogleTest() {
		extentTest=extentReport.createTest("Search Google Test");
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("Google");
		scrhbox.submit();
	}
	@Test
	public void SeleniumTest() {
		extentTest=extentReport.createTest("Search Selenium Test");
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("Selenium");
		scrhbox.submit();
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	@AfterTest
	public void testteardown() {
		extentReport.flush();
	}
}
