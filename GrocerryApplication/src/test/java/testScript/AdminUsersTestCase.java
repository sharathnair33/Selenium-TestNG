package testScript;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.BaseTest;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcellUtilities;
import utilities.RandomDataUtility;

public class AdminUsersTestCase extends BaseTest{
	HomePage home;
	AdminUsersPage adminPage;
@Test(description="User is trying to add new user to AdminPage")
public void addNewUser() throws IOException {
	String userNameValue=ExcellUtilities.getStringData(0, 0, "LoginPage");
	String PasswordValue=ExcellUtilities.getStringData(0, 1, "LoginPage");	
	LoginPage loginpage= new LoginPage(driver);
	loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue);
	home=loginpage.login();
	adminPage=home.clickAdminUserPage();
	
	RandomDataUtility random=new RandomDataUtility();
	String userName=random.randomUserName();
	String Password=random.randomPassword();	
	adminPage.newUserRegistration().enterusername(userName).enteruserPassword(Password).selectUserTypedropdownforsearch().clickonSave();
	//adminPage.getAlertText();
	//boolean alertSuccess=adminPage.getAlertText();
	//Assert.assertTrue(alertSuccess,Constant.adminNewUserCreationerror);
}

/*public void createAdminUsers() throws IOException, InterruptedException {
	String userNameValue=ExcellUtilities.getStringData(0, 0, "LoginPage");
	String PasswordValue=ExcellUtilities.getStringData(0, 1, "LoginPage");	
	LoginPage loginpage= new LoginPage(driver);
	loginpage.enterUserNameField(userNameValue);
	loginpage.enterPassword(PasswordValue);
	loginpage.login();
	HomePage homepage=new HomePage(driver);
	homepage.clickAdminUserPage();	
	AdminUsersPage adminPage=new AdminUsersPage(driver);
	adminPage.searchUser();
	String searchUserName=ExcellUtilities.getStringData(0, 0, "userRegistration");
	adminPage.searchUserName(searchUserName);
	adminPage.selectUserType();
	adminPage.clickOnSearchAdminUser();
}*/
	@Test(description="User is trying to search new user added to the admin page")
	public void searchAdminUsers() throws IOException{
		String userNameValue=ExcellUtilities.getStringData(0, 0, "LoginPage");
		String PasswordValue=ExcellUtilities.getStringData(0, 1, "LoginPage");	
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue);
		home=loginpage.login();
		adminPage=home.clickAdminUserPage();	
		
		String searchUserName=ExcellUtilities.getStringData(0, 0, "userRegistration");
		adminPage.searchUser().searchUserName(searchUserName).selectUserType().clickOnSearchAdminUser();
	}

	@Test(description="User is trying to reset the admin Page")
		public void resetAdminUsers() throws IOException {
		//adminPage.clickOnSearchAdminUser();
		String userNameValue=ExcellUtilities.getStringData(0, 0, "LoginPage");
		String PasswordValue=ExcellUtilities.getStringData(0, 1, "LoginPage");	
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue);
		home=loginpage.login();
		adminPage=home.clickAdminUserPage();	
			adminPage.resetSearchAdminUsers();
		}
		
	}


