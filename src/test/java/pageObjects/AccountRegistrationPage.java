package pageObjects;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-firstname']") WebElement FirstName ;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone ;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtconfirmpassword ;
	@FindBy(xpath="//input[@name='agree']") WebElement msgConfirmation;
	@FindBy(xpath="//input[@value='Continue']") WebElement continuebtn;

	
	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	public void setEmail(String emailtxt) {
		email.sendKeys(emailtxt);
	}
	public void setTelephone(String monumber) {
		txtTelephone.sendKeys(monumber);
	}
	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	public void ConfirmPass(String cpass) {
		txtconfirmpassword.sendKeys(cpass);
	}
	public void setPrivacyPolicy() {
		msgConfirmation.click();
	}
	public void clickContinue() {
		continuebtn.click();
	}
	public String getConfirmationMsg() {
		try {
			return(continuebtn.getText());
		}catch(Exception e) {
			return e.getMessage();
		}
	}
}
