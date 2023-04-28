package utilities;

import java.util.Date;
import java.util.Random;

public class Utilitites_config {
	
	public static int impliciteTime = 10;
	public static int pageLoadTime = 100;
	public static int ScriptTime = 1000;
	public static String pathForConfigProperties = System.getProperty("user.dir")+"\\src\\main\\java\\config_properties\\Config_Properties";
	public static String pathForTestDataProperties = System.getProperty("user.dir")+ "\\src\\main\\java\\config_properties\\TestData_Properties";
	public static String pathForExcelSheet = System.getProperty("user.dir")+ "\\src\\main\\java\\utilities\\Register_Excel.xlsx";
	public static String pathForExtentReports = System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\Extent_Repots.html"; 
	
	
	
	public static String dateForEmail() {
		
		Date date = new Date();
		String time = date.toString().replace(" ", "").substring(9).replace(":", "");
		return "Abdu"+time+"@gmail.com";
	}
	
public static String forScreenshotName() {
		
		Date date = new Date();
		String Time = date.toString().replace(" ", "").replace(":", "");
		return Time;
	}
	
    public static String randomNumber() { 
        Random random = new Random(); 
        long randomNumber = Math.abs(random.nextLong()); 
        String randomString = Long.toString(randomNumber); 
        String telephone = randomString.substring(0, 10); 
        return telephone;
    } 
} 
	


