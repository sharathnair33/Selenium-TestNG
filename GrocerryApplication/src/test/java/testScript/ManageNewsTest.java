package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseTest;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcellUtilities;

public class ManageNewsTest extends BaseTest{
	HomePage home;
	ManageNewsPage manageNews;
	@Test(description="User is trying to add new news to Manage newspage")
	public void addNewNewsText() throws IOException {
		String userNameValue=ExcellUtilities.getStringData(0, 0, "LoginPage");
		String PasswordValue=ExcellUtilities.getStringData(0, 1, "LoginPage");	
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue);
		home=loginpage.login();
		manageNews=home.clickOnManageNewsMoreInfo();
		manageNews=manageNews.clickOnNewNews();
		String Text=ExcellUtilities.getStringData(0, 0,"TextPage");
		manageNews.EnterTextForNews(Text).saveEnteredText();
		String actualText = manageNews.IsAlertDisplayedForNewsCreated(); 
		actualText = actualText.replace("×", "").trim();
		Assert.assertTrue(actualText.contains("Alert!") &&
		    actualText.contains("News Created Successfully"),Constant.manageNewUserError);
		
		 }
	
@Test(description="User is trying to search news added in ManageNews page")
public void searchNewsEntered() throws IOException {
	String userNameValue=ExcellUtilities.getStringData(0, 0, "LoginPage");
	String PasswordValue=ExcellUtilities.getStringData(0, 1, "LoginPage");	
	LoginPage loginpage= new LoginPage(driver);
	loginpage.enterUserNameField(userNameValue).enterPassword(PasswordValue);
	home=loginpage.login();
	
	home.clickOnManageNewsMoreInfo();
	manageNews=new ManageNewsPage(driver);
	manageNews.searchNews();
	String actual=ExcellUtilities.getStringData(0, 0,"TextPage");
	manageNews.inputtextIntoSearchField(actual).clickOnSearchButton();
	String Expected=manageNews.IsalertDisplayed();
	Assert.assertEquals(actual, Expected,Constant.SearchNewUserError);
}

}
