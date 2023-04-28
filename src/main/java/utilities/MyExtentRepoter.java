package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentRepoter {
	
		public static ExtentReports extentReports = new ExtentReports();
		public static File enxtentReportsFile = new File (Utilitites_config.pathForExtentReports);
		public static ExtentSparkReporter sparkReporter = new ExtentSparkReporter(enxtentReportsFile);
		public static Properties config = new Properties();
		
	
		
		public static  ExtentReports createExtentReport() throws Exception {
			
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setReportName("My Porject Test Results");
			sparkReporter.config().setDocumentTitle("Test Results");
			sparkReporter.config().setTimeStampFormat("MM/DD/YYYY hh:mm:ss");
			extentReports.attachReporter(sparkReporter);
			
			FileInputStream file = new FileInputStream (Utilitites_config.pathForConfigProperties);
			config.load(file);
			
			extentReports.setSystemInfo("Website Url", config.getProperty("URL"));
			extentReports.setSystemInfo("Browser", config.getProperty("browser"));
			extentReports.setSystemInfo("Operating Sytem", System.getProperty("os.version"));
			extentReports.setSystemInfo("OS Name", System.getProperty("os.name"));
			extentReports.setSystemInfo("Tester Name", System.getProperty("user.name"));
			extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
			extentReports.setSystemInfo("Language", System.getProperty("user.language"));
			return extentReports;

		}
		


}
