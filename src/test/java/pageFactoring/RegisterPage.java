package pageFactoring;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy (id = "input-firstname")
	private WebElement Fname;
	
	@FindBy (id = "input-lastname")
	private WebElement Lname;
	
	@FindBy (xpath = "//input[@id='input-email']")
	private WebElement Email;
	
	@FindBy (id = "input-telephone")
	private WebElement Tphone;
	
	@FindBy (id = "input-password")
	private WebElement Password;
	
	@FindBy (id = "input-confirm")
	private WebElement Conf_Password;
	
	@FindBy (name = "agree")
	private WebElement Policycheck;
	
	@FindBy (css = "input.btn.btn-primary")
	private WebElement Continuebutton;
	
	
	@FindBy (xpath = "//input[@id = 'input-firstname']/following-sibling::div")
	private WebElement firstnamewarningmessage;
	
	@FindBy (xpath = "//input[@id = 'input-lastname']/following-sibling::div")
	private WebElement lastnamewarningmessage;
	
	@FindBy (xpath = "//input[@id = 'input-email']/following-sibling::div")
	private WebElement emailwarningmessage; 
	
	@FindBy (xpath = "//input[@id = 'input-telephone']/following-sibling::div")
	private WebElement Telephonewarningmessage; 
	
	@FindBy (xpath = "//input[@id = 'input-password']/following-sibling::div")
	private WebElement Passwordwarningmessage; 
	
	@FindBy (xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement Policywarningmessage; 
	
	@FindBy (css = "input#input-confirm+div")
	private WebElement Unmatchedpasswordwarning;
	
	@FindBy (xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement NewsletterSelectedYes ;
	
	@FindBy (xpath = "//input[@name = 'newsletter' and @value = '0']")
	private WebElement NewsletterSelectedNo ;
	
	@FindBy (xpath = "//div[@id = 'content']/child::h1" )
	private WebElement PageTitle;
	
	@FindBy (xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement ExistingEmailwarning; 
	
	
	@FindBy (css = "fieldset#account legend")
	private WebElement Personaldetails;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFirstname(String firstname) {
		Fname.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		Lname.sendKeys(lastname);
	}
	
	public void enterEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void enterPhoneNumber(String PhoneNum) {
		Tphone.sendKeys(PhoneNum);
	}
	
	public void enterpassword(String password) {
		Password.sendKeys(password);
	}
	
	public void confirmPassword(String C_password) {
		Conf_Password.sendKeys(C_password);
	}
	
	public void clickOnPolicybutton() {
		Policycheck.click();
	}
	
	public boolean isPolicyButtonChekedONot() {
		boolean CheckedStatus = Policycheck.isSelected();
		return CheckedStatus;
	}

	public void clickOnContinue() {
		Continuebutton.click();
	}
	
	public String firstNameWarningMessage() {
		 String WarningmessageforFname = firstnamewarningmessage.getText();
		 return WarningmessageforFname;
	}
	
	public String lastNameWarningMessage() {
		 String WarningmessageforLname = lastnamewarningmessage.getText();
		 return WarningmessageforLname;
	}
	
	public boolean isEmailWarningMessageDisplayed() {
		boolean DisplayStatus = emailwarningmessage.isDisplayed();
		return DisplayStatus;
	}
	
	public String telephoneeWarningMessage() {
		 String Warningmessagefortelephone = Telephonewarningmessage.getText();
		 return Warningmessagefortelephone;
	}
	
	public boolean isPasswordWarningMessageDisplayed() {
		boolean DisplayStatus = Passwordwarningmessage.isDisplayed();
		return DisplayStatus;
	}
	
	public boolean isPolicyWarningMessageDisplayed() {
		boolean DisplayStatus = Policywarningmessage.isDisplayed();
		return DisplayStatus;
	}
	
	public String unmatchedPasswordWarningMessage() {
		 String Warningmessageforunmachedpassword = Unmatchedpasswordwarning.getText();
		 return Warningmessageforunmachedpassword;
	}
	
	public void newsletterSelectedYes() {
		NewsletterSelectedYes.click();
	}
	
	public void newsletterSelectedNo() {
		NewsletterSelectedNo.click();
	}
	
	public boolean isNewsletterSelectedYesSelectedONot() {
		boolean CheckedStatus = NewsletterSelectedYes.isSelected();
		return CheckedStatus;
	}
	
	public boolean isNewsletterSelectedNoSelectedONot() {
		boolean CheckedStatus = NewsletterSelectedNo.isSelected();
		return CheckedStatus;
	}
	
	public String titleOfRegisterPage () {
		 String Title = PageTitle.getText();
		 return Title;
	}
	
	public boolean existingEmailWarningMessage() {
		boolean DisplayStatus = ExistingEmailwarning.isDisplayed();
		return DisplayStatus;
	}
	
	public boolean isPersonalDetailDisplayed() {
		boolean DisplayStatus= Personaldetails.isDisplayed();
		return DisplayStatus;
	}
	public boolean isTitleDisplayed() {
		boolean DisplayStatus= PageTitle.isDisplayed();
		return DisplayStatus;
		
	}
	
	public boolean isPhoneWarningMessageDisplayed() {
		boolean Displaystatus = Telephonewarningmessage.isDisplayed();
		return Displaystatus;
	}
	
	public void theTabKeyForFname() {
		Fname.sendKeys(Keys.TAB);
	}
	public void theTabKeyForLname() {
		Lname.sendKeys(Keys.TAB);
	}
	public void theTabKeyForEmail() {
		Email.sendKeys(Keys.TAB);
	}
	public void theTabKeyForTelephone() {
		Tphone.sendKeys(Keys.TAB);
	}
	public void theTabKeyForPaasword() {
		Password.sendKeys(Keys.TAB);
	}
	public void theTabKeyForConPaasword() {
		Conf_Password.sendKeys(Keys.TAB);
		Policycheck.click();
		Conf_Password.sendKeys(Keys.ENTER);
	}




}
