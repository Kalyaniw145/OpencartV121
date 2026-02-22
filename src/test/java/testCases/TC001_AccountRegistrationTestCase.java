package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;




public class TC001_AccountRegistrationTestCase extends BaseClass {

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() 
	{
logger.info("started");

logger.info("*********Starting TC001_AccountRegistrationTestCase **********");
		HomePage hp=new HomePage(driver);//In homepage constructor is their ,constructor trying to invoke at run time, It needs a driver.we created driver in 1st method (Beforeclass) so we are passing driver here only
		hp.clickMyAccount();
		logger.info("Clicked My Account link");
		
		hp.clickRegister();
		logger.info("Clicked Register link");
		
		AccountRegisterPage regpage=new AccountRegisterPage(driver) ;
		logger.info("Providing customer details");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphanumeric();
		regpage.setPassword(password);
		regpage.setConfPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		String confmsg=regpage.getconfigMessage();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		logger.info("****** Finished TC_001_AccountRegistrationTest ********");
		
	}
		
		
		}
	

