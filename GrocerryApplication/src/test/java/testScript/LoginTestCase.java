package testScript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationCore.BaseTest;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcellUtilities;

public class LoginTestCase extends BaseTest{
	HomePage home;
@Test(priority=1,description="User is trying to login with valid credentials",groups= {"Smoke"})
public void validateUserloginWithValidCredentials() throws IOException {
String userNameValue=ExcellUtilities.getStringData(0, 0, "LoginPage");
String PasswordValue=ExcellUtilities.getStringData(0, 1, "LoginPage");	
LoginPage loginpage= new LoginPage(driver);
loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue);
home=loginpage.login();
boolean validate1=loginpage.validateLogin();
System.out.println(validate1);
Assert.assertTrue(validate1,Constant.validCredentialError);
}
@Test(priority=3,description="User is trying to login with valid username and inValid Password",retryAnalyzer=retry.Retry.class)
public void validateUserloginWithValidusernameInvalidpassword() throws IOException {
String userNameValue=ExcellUtilities.getStringData(1, 0, "LoginPage");
String PasswordValue=ExcellUtilities.getStringData(1, 1, "LoginPage");	
LoginPage loginpage=new LoginPage(driver);
loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue).login();
String expected="7rmart supermarket";
String actual=loginpage.istitledisplayed();
Assert.assertEquals(actual, expected,Constant.validUsernameInvalidPassword);
}
@Test(priority=4,description="User is trying to login with Invalid username and Valid Password")
public void validateUserloginWithInvalidusernameValidpassword() throws IOException {
String userNameValue=ExcellUtilities.getStringData(2, 0, "LoginPage");
String PasswordValue=ExcellUtilities.getStringData(2, 1, "LoginPage");	
LoginPage loginpage=new LoginPage(driver);
loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue).login();
boolean validate2=loginpage.validateLoginWithIncorrectCredentials();
System.out.println(validate2);
Assert.assertTrue(validate2,Constant.InvalidusernameValidpassword);
}
@Test(priority=2,description="User is trying to login with Invalid username and InValid Password",groups= {"Smoke"},dataProvider = "loginProvider")
public void validateUserloginWithInvalidusernameInvalidPassword(String userNameValue,String PasswordValue) throws IOException {
 //userNameValue=ExcellUtilities.getStringData(3, 0, "LoginPage");
//PasswordValue=ExcellUtilities.getStringData(3, 1, "LoginPage");	
LoginPage loginpage=new LoginPage(driver);
loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue).login();
boolean validate3=loginpage.validateLoginWithIncorrectCredentials();
System.out.println(validate3);
Assert.assertTrue(validate3,Constant.InvalidusernameInvalidPassword);

}
@DataProvider(name = "loginProvider")
public Object[][] getDataFromDataProvider() throws IOException {

return new Object[][] { new Object[] { "admin", "admin22" },new Object[] { "admin123", "123" }
// new Object[] {ExcelUtility.getStringData(3,
// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
};
}
}

