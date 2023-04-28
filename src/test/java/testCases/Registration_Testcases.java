package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageFactoring.AccountPage;
import pageFactoring.FactoringTheMainpage;
import pageFactoring.LoginPage;
import pageFactoring.RegisterPage;
import testBase.TestBase;
import utilities.ScreenRecorderUtil;
import utilities.Utilitites_config;

public class Registration_Testcases extends TestBase{
	
     public Registration_Testcases() throws Exception {
		super();
	}

	public WebDriver driver; 
	public SoftAssert soft = new SoftAssert();

	
	@BeforeSuite
	public void startRecordingThetTestes() throws Exception {
		ScreenRecorderUtil.startRecord("startRecordingThetTestes");
	}
	

	@BeforeMethod
	public void openNinjaTutorial(){
		driver = openingTutorialNinja(pro.getProperty("browser"));
		}
	
	@Test (priority = 1 ) // TC_RF_001-  Verify Registering an Account by providing only the Mandatory fields
	public void registeraccMandortoryfieds() {
		
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstname(prop.getProperty("first-name"));
		registerpage.enterLastname(prop.getProperty("last-name"));
		registerpage.enterEmail(Utilitites_config.dateForEmail());
		registerpage.enterPhoneNumber(Utilitites_config.randomNumber());
		registerpage.enterpassword(prop.getProperty("password"));
		registerpage.confirmPassword(prop.getProperty("re-password"));
		registerpage.clickOnPolicybutton();
		
	    soft.assertTrue(registerpage.isPolicyButtonChekedONot(), "Policy checkbox is not checked");
	    registerpage.clickOnContinue();
	    
	    String actualurl = pro.getProperty("createAccountUR");
	    String expectedurl = driver.getCurrentUrl();
	    Assert.assertEquals(actualurl, expectedurl);
	    soft.assertAll();
	    
	}
	
	@Test (priority = 2 )  // TC_RF_003 - Verify Registering an Account by providing all the fields
	public void rgisteraccProvideallfields() {
        RegisterPage registerpage = new RegisterPage(driver);
        AccountPage accountpage = new AccountPage(driver);
        
		registerpage.enterFirstname(prop.getProperty("first-name"));
		registerpage.enterLastname(prop.getProperty("last-name"));
		registerpage.enterEmail(Utilitites_config.dateForEmail());
		registerpage.enterPhoneNumber(Utilitites_config.randomNumber());
		registerpage.enterpassword(prop.getProperty("password"));
		registerpage.confirmPassword(prop.getProperty("re-password"));
		registerpage.clickOnPolicybutton();
	    registerpage.clickOnContinue();
	    
		soft.assertTrue(accountpage.isConfirmationTextisDisplayed());
		accountpage.clickOnContinue();
		soft.assertAll();
	}
	
	
	@Test (priority =3)  // TC_RF_004 - Verify proper notification messages are displayed for the mandatory fields, when you don't provide any fields in the 'Register Account' page and submit
	public void verifyProperNotificationMessages()  {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.clickOnContinue();
		  
		String WarningmessageForFname = prop.getProperty("firstname_warningmessage");
		String ExpectedMessageforFname= registerpage.firstNameWarningMessage();
		soft.assertEquals(WarningmessageForFname, ExpectedMessageforFname);
		  
		String WarningmessageForLname = prop.getProperty("lastname_warningmessage");
		String ExpectedMessageforlname= registerpage.lastNameWarningMessage();
		soft.assertTrue(ExpectedMessageforlname.contains(WarningmessageForLname));
		  
		soft.assertTrue(registerpage.isEmailWarningMessageDisplayed());
		  
		String WarningmessageForPhone = prop.getProperty("telephone_warningmessage");
		String ExpectedMessageforPhone= registerpage.telephoneeWarningMessage();
        soft.assertTrue(WarningmessageForPhone.equals(ExpectedMessageforPhone));
		  
		soft.assertTrue(registerpage.isPasswordWarningMessageDisplayed());
		soft.assertTrue(registerpage.isPolicyWarningMessageDisplayed());
		soft.assertAll();
		
	}
	
	@Test (priority = 4) // TC_RF_005 - Verify Registering an Account when 'Yes' option is selected for Newsletter field
	public void registerAccWithYes() {
	    RegisterPage registerpage = new RegisterPage(driver);
	    AccountPage accountpage = new AccountPage(driver);
	    
		registerpage.enterFirstname(prop.getProperty("first-name"));
		registerpage.enterLastname(prop.getProperty("last-name"));
		registerpage.enterEmail(Utilitites_config.dateForEmail());
		registerpage.enterPhoneNumber(Utilitites_config.randomNumber());
		registerpage.enterpassword(prop.getProperty("password"));
		registerpage.confirmPassword(prop.getProperty("re-password"));
		registerpage.newsletterSelectedYes();
		registerpage.clickOnPolicybutton();
		
		soft.assertTrue(registerpage.isNewsletterSelectedYesSelectedONot(), "The Yes radio button of Newsletter is not selected");
		registerpage.clickOnContinue(); 
		
		soft.assertTrue(accountpage.isConfirmationTextisDisplayed());
		accountpage.clickOnContinue();
		soft.assertAll();
	
	}
	
	@Test (priority = 5) // TC_RF_006 - Verify Registering an Account when 'No' option is selected for Newsletter field 
	public void registerAccWithNo() {
		RegisterPage registerpage = new RegisterPage(driver);
		AccountPage accountpage = new AccountPage(driver);
		
		registerpage.enterFirstname(prop.getProperty("first-name"));
		registerpage.enterLastname(prop.getProperty("last-name"));
		registerpage.enterEmail(Utilitites_config.dateForEmail());
		registerpage.enterPhoneNumber(Utilitites_config.randomNumber());
		registerpage.enterpassword(prop.getProperty("password"));
		registerpage.confirmPassword(prop.getProperty("re-password"));
		registerpage.newsletterSelectedNo();
		registerpage.clickOnPolicybutton();

		soft.assertTrue(registerpage.isNewsletterSelectedNoSelectedONot(), "The No radio button of Newsletter is not selected");
		registerpage.clickOnContinue();
		
		soft.assertTrue(accountpage.isConfirmationTextisDisplayed());
		accountpage.clickOnContinue();
		soft.assertAll();
		
	}
	
	@Test (priority = 6) // TC_RF_007 - Verify different ways of navigating to 'Register Account' page
	public void  navtoRegisterAccPage(){
		RegisterPage registerpage = new RegisterPage(driver);
		FactoringTheMainpage mainpage = new FactoringTheMainpage(driver);
		LoginPage loginpage = new LoginPage(driver);
		
		String actualtext = prop.getProperty("Title_of_the_page");
		String expectedtext = registerpage.titleOfRegisterPage();	
		soft.assertEquals(expectedtext,actualtext);
		
		mainpage.clickOnMyAccount();
		mainpage.clickOnLogin();
	
		String loginurl = pro.getProperty("LoginUrl");
		String expectedloginurl = driver.getCurrentUrl();
		if (loginurl.equals(expectedloginurl)) {
			soft.assertTrue(true, "you are at the corret page");
			loginpage.clickOnContinue();
		}else {
			soft.assertTrue(false, "you are at the wrong page");
		}
		
		registerpage.isPersonalDetailDisplayed();
		mainpage.clickOnMyAccount();
		mainpage.clickOnLogin();
		loginpage.clickOnRegister();
		soft.assertTrue(registerpage.isTitleDisplayed());
		soft.assertAll();
		
	}
	
	

	    @AfterMethod
	    public void closebrowser() {
	    	driver.quit();
	    	
	    }

}
