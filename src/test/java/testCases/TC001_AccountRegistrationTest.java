package testCases;



import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import testBase.*;


public class TC001_AccountRegistrationTest extends BaseClass{


	@Test(groups={"Regression","Master"})
	
	public void verify_account_registration() throws InterruptedException {
		
		logger.info("** starting tc001**");
		HomePage p=new HomePage( driver);
		
		p.clickMyAccout();
		Thread.sleep(2000);
		p.clickRegister();
		logger.info("clicked on m register link");
		Thread.sleep(2000);
		AccountRegistrationPage page=new AccountRegistrationPage(driver);
		logger.info("providing customer details");
		page.setFirstName(randomString().toUpperCase());
		page.setLastName(randomString().toUpperCase());
		page.setEmail(randomString()+"@gmail.com");
		String both=randomalphanum();
		page.setTelephone(randomNum());
		page.setPassword(both);
		page.ConfirmPass(both);
		page.setPrivacyPolicy();
		page.clickContinue();
	String cnfrmmsg=page.getConfirmationMsg();
	//Assert.assertEquals(cnfrmmsg, "Your Account Has Been Created!");
	}
	
	
	
}
