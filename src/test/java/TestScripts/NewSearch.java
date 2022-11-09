package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewSearch {
  @Test(groups="FirstRequirement")
  public void SearchGoogle() {
	  WebDriverManager.chromedriver().setup();
	  	WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("W3C");
  }
  @Test(groups="SecondRequirement")
  public void SearchAPI() {
	  System.out.println("API");
  }
  @Test(groups="FirstRequirement")
  public void SearchBDD() {
	  System.out.println("BDD");
  }
  @Test(groups="ThirdRequirement")
  public void SearchKPMG() {
	  System.out.println("KPMG");
  }
}
