package pageFactoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy (xpath = "//a[contains(@class, 'btn btn-primary')]")
	private WebElement ContinueButton;
	
	@FindBy(css = "div.list-group a+a")
	private WebElement Registerbutton;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnContinue() {
		ContinueButton.click();
	}
	
	public void clickOnRegister() {
		Registerbutton.click();
	}
}
