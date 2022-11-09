package TestScripts;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteDriverTest {
	WebDriver driver;
  @Test
  public void Remote() throws MalformedURLException {
	  ChromeOptions options= new ChromeOptions();
	  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//	  options.setCapability(CapabilityType.BROWSER_VERSION, 106);
	  String strHub="http://192.168.0.109:4444/";
	  driver= new RemoteWebDriver(new URL(strHub),options);
	  driver.get("https://www.google.com");
	  System.out.println(driver.getTitle());
		WebElement scrhbox=driver.findElement(By.xpath("//input[@title='Search']"));
		scrhbox.sendKeys("HelloWorld");
		Assert.assertEquals(driver.getTitle(),"Google");
		scrhbox.submit();
  }
}
