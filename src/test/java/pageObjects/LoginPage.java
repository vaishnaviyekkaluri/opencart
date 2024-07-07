package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']") WebElement emailid;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	
	public void setEmail(String mail) {
		emailid.sendKeys(mail);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickLoginbtn() {
		loginbtn.click();
	}

}
