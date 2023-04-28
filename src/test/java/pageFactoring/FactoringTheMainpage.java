package pageFactoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoringTheMainpage {
	
	public WebDriver driver;
	
	//Objects
	
	@FindBy (linkText = "My Account")
	private WebElement Accountlink;
	
	@FindBy (xpath = "//ul[contains(@class,'dropdown-menu dropdown-menu-right')]/descendant::a")
	private WebElement Registerlink;
	
	@FindBy (xpath = "//a[text()= 'Login']")
	private WebElement Loginlink;
	
	public FactoringTheMainpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, FactoringTheMainpage.class);
	}
	
	//Actions
	
	public void clickOnRegister() {
		Registerlink.click();
	}
	
	public void clickOnMyAccount() {
		Accountlink.click();
	}
	public void clickOnLogin() {
		Loginlink.click();
	}

}
