package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
 
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[@title='My Account']") WebElement Myaccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")WebElement createacntlnk;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")WebElement Loginlnk;
	
	
	public void clickMyAccout() {
		Myaccount.click();
	}public void clickRegister() {
		createacntlnk.click();
	}
	
	public void Loginbtn() {
		Loginlnk.click();
	}

}
