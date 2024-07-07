package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"sanity","Master"})
	public void VerifyLogin() {
		try {
		logger.info("/**starting TC002");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccout();
		hp.Loginbtn();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLoginbtn();
		
		
		//validation
		MyAccountPage ma=new MyAccountPage(driver); 
		boolean targetPage=ma.isMyaccountpageExists();
		Assert.assertTrue(targetPage);
	}catch(Exception e) {
		Assert.fail();
	}
		logger.info("Finished login test.....");
		
		

}
}
