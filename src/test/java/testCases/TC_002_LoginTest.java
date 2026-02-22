package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verifyLogin()
	
	{
		logger.info("******Starting TC_002_LoginTest*******");
	try

		{
           //homepage
			HomePage hp=new HomePage(driver);
		    hp.clickMyAccount();
			hp.clickLogin();
			
	     //loginpage
			LoginPage lp=new LoginPage(driver);
			lp.SetEmail(p.getProperty("email"));
			lp.SetPassword(p.getProperty("password"));
			lp.clickLogin();
			
	//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
	//boolean targetpage=	macc.isMyAccountPageExists();
		Assert.assertTrue(macc.isMyAccountPageExists());
		//Assert.assertEquals(targetpage, "My Account");
	}
	catch(Exception e)
	{
		Assert.fail(e.getMessage());
	}
		logger.info("*******Finished TC_002_LoginTest******");
		
}

}
