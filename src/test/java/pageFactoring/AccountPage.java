package pageFactoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	
	
	
	
	public WebDriver driver;
	
	@FindBy (xpath = "//div[@id = 'content']/child::h1" )
	private WebElement confirmationText;
	
	@FindBy (xpath = "//a[contains(text(), 'Continue')]")
	private WebElement Continuebutton;
	
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public boolean isConfirmationTextisDisplayed() {
		boolean DispayStatus = confirmationText.isDisplayed();
		return DispayStatus;
	}
	
	public void clickOnContinue() {
		Continuebutton.click();
	}
	
	

}
