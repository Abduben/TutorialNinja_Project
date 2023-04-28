package testBase;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageFactoring.FactoringTheMainpage;
import utilities.Utilitites_config;



public class TestBase {
	
	public  WebDriver driver;
	public  Properties pro;
	public  Properties prop;

	public TestBase () throws Exception  {
		
		pro = new Properties();
		FileInputStream file = new FileInputStream(Utilitites_config.pathForConfigProperties);
		pro.load(file);
		
		prop = new Properties();
		FileInputStream doc = new FileInputStream(Utilitites_config.pathForTestDataProperties);
		prop.load(doc);
		}

	public WebDriver openingTutorialNinja(String Browser) {
		
		if (Browser.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		} 
		else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilitites_config.impliciteTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilitites_config.pageLoadTime));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilitites_config.ScriptTime));
		driver.get(pro.getProperty("URL"));
		
		FactoringTheMainpage Mainpage = new FactoringTheMainpage(driver);
		Mainpage.clickOnMyAccount();
		Mainpage.clickOnRegister();
		
	    return driver;
		
	}
			
}
	


