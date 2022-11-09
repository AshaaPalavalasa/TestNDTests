package TestScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevToolProtocol {
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		devTools=driver.getDevTools();
		devTools.createSession();
		
	}
	
	
	  @Test
	  public void deviceModeTest() {
		  Map deviceMetrics= new HashMap() {{
			  put("width",600);
			  put("height",900);
			  put("mobile",true);
			  put("deviceScalarFactor",50);
			  
			  
		  }};
		  driver.executeCdpCommand(null, null);
	  
  
}
}
