package testScript;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.BaseTest;
import constants.Constant;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcellUtilities;

public class HomeTest extends BaseTest{
HomePage logout;
 
@Test(description="User is trying to login and logout of the web page")
public void logout() throws IOException, InterruptedException{
	String userNameValue=ExcellUtilities.getStringData(0, 0, "LoginPage");
	String PasswordValue=ExcellUtilities.getStringData(0, 1, "LoginPage");	
	LoginPage loginpage= new LoginPage(driver);
	loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue);
	logout=loginpage.login().clickOnAdmin();
	loginpage=logout.clickOnLogout();
boolean validateHomePageLogout=logout.checkIfLogoutIsPerformed();
System.out.println(validateHomePageLogout);
Assert.assertTrue(validateHomePageLogout,Constant.homePageLogoutError);
	}
}
