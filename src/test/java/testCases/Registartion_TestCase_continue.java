package testCases;




import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageFactoring.RegisterPage;
import testBase.TestBase;
import utilities.ScreenRecorderUtil;
import utilities.TestDataFromExcelSheet_DataProvider;
import utilities.Utilitites_config;




public class Registartion_TestCase_continue extends TestBase {
	
	
	public Registartion_TestCase_continue() throws Exception {
		super();
		
	}

	public WebDriver driver ;
	public SoftAssert soft = new SoftAssert();;
	
	@BeforeMethod
	public void setup() {
		driver = openingTutorialNinja(pro.getProperty("browser"));
		
	}
	
	@Test (priority = 1  , dataProvider = "getTN/TC8ExcelData", dataProviderClass = TestDataFromExcelSheet_DataProvider.class)
	public void registeringAccountWithUnmatchedPassandRepass(String FirstName, String LastName, String Email, String Telephone, String Password, String Re_Password) {
		//Verify Registering an Account by entering different passwords into 'Password' and 'Password Confirm' fields
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstname(FirstName);
		registerpage.enterLastname(LastName);
		registerpage.enterEmail(Email);
		registerpage.enterPhoneNumber(Telephone);
		registerpage.enterpassword(Password);
		registerpage.confirmPassword(Re_Password);
		registerpage.clickOnPolicybutton();
		
		soft.assertTrue(registerpage.isPolicyButtonChekedONot(), "Policy checkbox is not checked");
		registerpage.clickOnContinue();
	    
	    String actualText = prop.getProperty("unmatchedpassword");
	    String expectedText = registerpage.unmatchedPasswordWarningMessage();
	    soft.assertEquals(actualText, expectedText);
	    soft.assertAll();
	}

	
	  @Test (priority = 2 , dataProvider = "getTN/TC9ExcelData", dataProviderClass = TestDataFromExcelSheet_DataProvider.class) 
	  public void registeringAccountWithExistingAccountDetails(String FirstName, String LastName, String Email, String Telephone, String Password, String Re_Password) {
	  //Verify Registering an Account by providing the existing account details (i.e. existing email address)
		  
		 RegisterPage registerpage = new RegisterPage(driver);
		 registerpage.enterFirstname(FirstName);
		 registerpage.enterLastname(LastName);
		 registerpage.enterEmail(Email);
		 registerpage.enterPhoneNumber(Telephone);
		 registerpage.enterpassword(Password);
		 registerpage.confirmPassword(Re_Password);
		 registerpage.clickOnPolicybutton();
		 registerpage.clickOnContinue();
	     soft.assertTrue(registerpage.existingEmailWarningMessage());
	     soft.assertAll();
	}
	  
	  
	  @Test (priority = 3 , dataProvider = "getTN/TC10ExcelData", dataProviderClass = TestDataFromExcelSheet_DataProvider.class) 
	  public void registeringAccountWithInvalidEmail(String FirstName, String LastName, String Email, String Telephone, String Password, String Re_Password) {
		  //Verify Registering an Account by providing an invalid email address into the E-Mail field
		  
		  RegisterPage registerpage = new RegisterPage(driver);
		  registerpage.enterFirstname(FirstName);
		  registerpage.enterLastname(LastName);
		  registerpage.enterEmail(Email);
		  registerpage.enterPhoneNumber(Telephone);
		  registerpage.enterpassword(Password);
		  registerpage.confirmPassword(Re_Password);
		  registerpage.clickOnPolicybutton();
		  registerpage.clickOnContinue();
		  
		  String ActualUrl = pro.getProperty("RegisterUrl");
		  String ExpectedUrl = driver.getCurrentUrl();
		  soft.assertEquals(ActualUrl,ExpectedUrl );
		  soft.assertAll();
	  }
	  
	  @Test (priority = 4, dataProvider ="testingInvalidPhoneNumber", dataProviderClass = TestDataFromExcelSheet_DataProvider.class)
	  public void invalidPhoneNumber(String FirstName, String LastName, String Email, String Telephone, String Password, String Re_Password) {
		  //Verify Registering an Account by providing an invalid phone number
		  RegisterPage registerpage = new RegisterPage(driver);
			 registerpage.enterFirstname(FirstName);
			 registerpage.enterLastname(LastName);
			 registerpage.enterEmail(Email);
			 registerpage.enterPhoneNumber(Telephone);
			 registerpage.enterpassword(Password);
			 registerpage.confirmPassword(Re_Password);
			 registerpage.clickOnPolicybutton();
			 registerpage.clickOnContinue();
			 if (registerpage.isPhoneWarningMessageDisplayed()) {
				 Assert.assertTrue(true);
			 }else {
				 Assert.assertTrue(false);
			 }
		     soft.assertAll(); 
	  }
	 @Test(priority = 5)
	 public void  registeringAccountUsingKeyboardkeys() {
		 RegisterPage registerpage = new RegisterPage(driver);
			registerpage.enterFirstname(prop.getProperty("first-name"));
			registerpage.theTabKeyForFname();
			registerpage.enterLastname(prop.getProperty("last-name"));
			registerpage.theTabKeyForEmail();
			registerpage.enterEmail(Utilitites_config.dateForEmail());
			registerpage.theTabKeyForEmail();
			registerpage.enterPhoneNumber(Utilitites_config.randomNumber());
			registerpage.theTabKeyForTelephone();
			registerpage.enterpassword(prop.getProperty("password"));
			registerpage.theTabKeyForPaasword();
			registerpage.confirmPassword(prop.getProperty("re-password"));
			registerpage.theTabKeyForConPaasword();
			
			
			String actualurl = pro.getProperty("createAccountUR");
			String expectedurl = driver.getCurrentUrl();
			Assert.assertEquals(actualurl, expectedurl);
			soft.assertAll();
	 }
	
    @AfterMethod
    public void closebrowser() {
    	driver.quit();
    	
    }
    
    @AfterSuite
	public void stopRecordingThetTestes() throws Exception {
		ScreenRecorderUtil.stopRecord();
	}
}
