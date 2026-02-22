package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {
	
	public AccountRegisterPage(WebDriver driver)
	{
		super(driver);
	}

	//locators
	

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPrivacyPolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement configmsg;
	//Actions method
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telphn)
	
	{
		txtTelephone.sendKeys(telphn);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setConfPassword(String cpwd) {
		txtConfirmPassword.sendKeys(cpwd);
	}
	public void setPrivacyPolicy()
	{
		chkPrivacyPolicy.click();
	}
	public void clickContinue()
	{
		btnContinue.click();
	}
	public String getconfigMessage()
	{
		try {
			return(configmsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}





