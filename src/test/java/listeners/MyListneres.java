package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.MyExtentRepoter;
import utilities.Utilitites_config;

public class MyListneres implements ITestListener {
	public ExtentReports extentReports;
	public ExtentTest extentTest; 
	
	@Override
	public void onStart(ITestContext context) {
		try {
			extentReports = MyExtentRepoter.createExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void onTestStart(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentReports.createTest(TestName);
		extentTest.log(Status.INFO, TestName+" Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentReports.createTest(TestName);
		extentTest.log(Status.PASS, TestName+" Successfully Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException |NoSuchFieldException |SecurityException e) {
			e.printStackTrace();
		} 
		String pathForScreenshot = System.getProperty("user.dir")+"\\test-output\\Screenshots\\Screenshot"+TestName+Utilitites_config.forScreenshotName()+".png";
		File Desti = new File (pathForScreenshot);
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(source, Desti);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(pathForScreenshot);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL,TestName + " Failed" );

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String TestName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP,TestName + " Skipped" );
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	

}
