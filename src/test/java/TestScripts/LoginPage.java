package TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	WebDriver driver;
	Properties prop;
	
//	@Parameters("browser")
	
	@BeforeMethod
	public void setupp() throws IOException {
		String strBrowser;
		prop=new Properties();
		String Path=System.getProperty("user.dir")+"//src//test//resources//ConfigFiles//config.properties";
		FileInputStream fin= new  FileInputStream(Path);
		prop.load(fin);
		strBrowser=prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
		  	driver = new EdgeDriver();
		}
	}
	@AfterMethod
	public void Teardown() {
		driver.close();
	}
	
	
//  @Parameters({"uname" , "pwd"})	
  @Test(dataProvider="loginData")
  public void validLogin(String strName, String strPwd) {
	  	driver.get(prop.getProperty("url"));
//		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(strName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPwd);
		driver.findElement(By.cssSelector("button")).click();
		boolean isValid=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isValid);
  }
  
  @DataProvider(name="loginData")
  public Object[][] getData() throws IOException, CsvValidationException{
	  String Path=System.getProperty("user.dir")+"//src//test//resources//testData//loginData.csv";
	  CSVReader reader= new CSVReader(new FileReader(Path));
	  String cols[];
	  ArrayList<Object> dataList = new ArrayList<Object>();
	  while((cols=reader.readNext())!=null) {
		  Object[] record= {cols[0],cols[1]};
		  dataList.add(record);
	  }
//	  Array list to Object[][]
	  return dataList.toArray(new Object[dataList.size()][]);
	  
  }
  
}
