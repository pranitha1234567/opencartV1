package testCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration_Test extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void Verify_Account_Registration()
	{
		logger.info("***Starting TC_001_AccountRegistration_Test***");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		 AccountRegistrationPage regpage = new  AccountRegistrationPage(driver);
		 
		 logger.info("Providing customer details");
		 
		 regpage.setFirstName(randomString().toUpperCase());
		 regpage.setLastName(randomString().toUpperCase());
		 regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email
		 regpage.setTelephone(randomNumber());
			
		String Password=randomAlphaNumeric();
			
		regpage.setPassword(Password);
		regpage.setConfirmpassword(Password);
			
		regpage.setPrivacypolicy();
		regpage.clickContinue();
		
		//logger.info("Validating expected message");	
		/*String confmsg=regpage.getConformationmsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		*/
			
		}
		catch(Exception e)
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		logger.info("***Finished TC_001_AccountRegistration_Test***");
	}

}
