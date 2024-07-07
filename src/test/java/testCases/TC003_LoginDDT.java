package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends  BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups={"Datadriven","Master"})
 public void Verify_loginDDT(String email, String pwd,String exp) {
	 logger.info("/**starting TC003");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccout();
		hp.Loginbtn();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLoginbtn();
		
		
		//validation
		MyAccountPage ma=new MyAccountPage(driver); 
		boolean targetPage=ma.isMyaccountpageExists();
		//Assert.assertEquals(targetPage, true,"Login Failedl");
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				ma.clickLogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			ma.clickLogout();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
		logger.info("/**ended TC003");
 }
}
