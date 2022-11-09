package TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelData {
	WebDriver driver;
	Properties prop;

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
		
  
	  @Test
	  public void validLogin() throws IOException {
		  	driver.get(prop.getProperty("url"));
//			driver.get("https://the-internet.herokuapp.com/login");
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(readData("userName"));
//			driver.findElement(By.xpath(readObjPath("Username")).sendKeys(readData("userName"));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(readData("password"));
			driver.findElement(By.cssSelector("button")).click();
			boolean isValid=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
			Assert.assertTrue(isValid);
	  }

	  public static String readData(String colName) throws IOException {
		  String colValue="";
		  String Path=System.getProperty("user.dir")+"//src//test//resources//testData//LoginData.xlsx";
		  FileInputStream fin= new  FileInputStream(Path);
		  XSSFWorkbook workbook=new XSSFWorkbook(fin);
		  XSSFSheet sheet=workbook.getSheet("loginpageData");
		  int numRows= sheet.getLastRowNum();
		  System.out.println(numRows);
		  for(int i=1;i<=numRows;i++) {
			 XSSFRow row= sheet.getRow(i);
			 if( row.getCell(0).getStringCellValue().equalsIgnoreCase(colName)) {
			 colValue=row.getCell(1).getStringCellValue();
		  }
		  }
		  
		 
		  
		  return colValue;
		  
	  }
}
	  
	
	
