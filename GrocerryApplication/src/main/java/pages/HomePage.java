package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

@FindBy(xpath = "(//a[@class='nav-link'])[2]") WebElement admin;
@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logout;
@FindBy(xpath ="(//a[@class='small-box-footer'])[1]") WebElement adminUsersMore;
@FindBy(xpath="(//a[@class='small-box-footer'])[7]") WebElement manageNewsMoreInfo;
@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement loginPageText;


public HomePage clickOnAdmin() {
	admin.click();
	return this;
	}
public AdminUsersPage clickAdminUserPage() {
	adminUsersMore.click();
	return new AdminUsersPage(driver);
}
public LoginPage clickOnLogout() {
	logout.click();
	return new LoginPage(driver);
}
public ManageNewsPage clickOnManageNewsMoreInfo() {
	manageNewsMoreInfo.click();
	return new ManageNewsPage(driver);
}
public void getTextFromLoginPage() {
	loginPageText.getText();
}
public boolean checkIfLogoutIsPerformed() {
	return loginPageText.isDisplayed();
	}
}
