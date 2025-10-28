package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;
public class LoginPage {
public WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="username") WebElement username;
@FindBy(name="password") WebElement password;
@FindBy(xpath="//button[@type='submit']") WebElement login;
@FindBy(xpath="//p[text()='Admin Users']") WebElement adminblock;
@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement headertext;
WaitUtility wait=new WaitUtility();

public LoginPage enterUserNameField(String userNameValue) {
	
	username.sendKeys(userNameValue);
return this;
}
public LoginPage enterPassword(String PasswordValue) {
	password.sendKeys(PasswordValue);
return this;
}
public HomePage login() {
	wait.waitUntilElementToBeClickable(driver, login);
	login.click();
	return new HomePage(driver);
}
public boolean validateLogin() {
	return adminblock.isDisplayed();
}
public String istitledisplayed() {
	return headertext.getText();
}
public boolean validateLoginWithIncorrectCredentials() {
	return headertext.isDisplayed();
	
}

}


