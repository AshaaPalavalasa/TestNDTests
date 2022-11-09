package TestScripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Headless {
	WebDriver driver;
	
  @Test
  public void HeadlessTest() throws IOException {
	  driver= new HtmlUnitDriver();
	  driver.get("https://www.google.com");
	  System.out.println(driver.getTitle());
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("HelloWorld");
		Assert.assertEquals(driver.getTitle(),"Google");
		scrhbox.submit();
  }
}
