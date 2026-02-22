package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class, groups="Datadriven")  //Data Provider name //getting data provider from different class	
  public void verifyLoginDDT(String email, String pwd, String exp)
	
	{
		logger.info("******Starting TC003_LoginDDT*******");
		
	
   
           //homepage
			HomePage hp=new HomePage(driver);
		    hp.clickMyAccount();
			hp.clickLogin();
			
	     //loginpage
			LoginPage lp=new LoginPage(driver);
			lp.SetEmail(email);
			lp.SetPassword(pwd);
			lp.clickLogin();
			
	//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
	    boolean targetpage=	macc.isMyAccountPageExists();
	    
	    /*Data is valid -login success -test pass - logout
	                    - login failed -test fail
	                    
	      Data is invalid -login success- test failed - logout
	                    - login failed -test pass */
	    
	    if(exp.equalsIgnoreCase("Valid"))
	    {
	    	if (targetpage==true) //login success for valid credentials
	    	{
	    		macc.clickLogout();
	    		Assert.assertTrue(true); // tc passed
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    if(exp.equalsIgnoreCase("Invalid"))
	    {
	    	if (targetpage==true)
	    	{
	    		macc.clickLogout(); //login success for invalid credentials
	    		Assert.assertTrue(false); //tc failed
	    	}
	    	else
	    	{
	    		Assert.assertTrue(true);//login not success tc passed
	    	}
	    }
	/*    catch (Exception e)
	    {
	    	Assert.fail();
	    }*/
	    }}
