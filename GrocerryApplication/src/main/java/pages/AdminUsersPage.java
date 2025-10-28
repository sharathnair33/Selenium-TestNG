package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utilities.PageUtility;

public class AdminUsersPage {
public WebDriver driver;
public AdminUsersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newUser;
@FindBy(xpath = "//input[@id='username']") WebElement userNameFiled;
@FindBy(xpath = "//input[@id='password']") WebElement passwordField;
@FindBy(id = "user_type") WebElement userTypeField;
@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]") WebElement saveButton;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetButton;
@FindBy(xpath = "//option[@value='partner']") WebElement selectType;
@FindBy(xpath = "//td[text()='Sharath Nair']") WebElement newUserRegistered;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchButton;
@FindBy(xpath="//input[@id='un' and @type='text']") WebElement searchUserNameFiled;
@FindBy(xpath ="(//select[@class='form-control'])[2]") WebElement searchUserType;
@FindBy(xpath = "//select[@id='ut']//option[text()='Admin']") WebElement adminUserTypeField;
@FindBy(xpath="(//button[@class=\"btn btn-block-sm btn-danger\"])[1]") WebElement searchButtonsubmit;
@FindBy(xpath="//a[contains(@href,'com/admin/list-admin')and contains(@class,'btn-warning')]") WebElement resetSearchUser;
@FindBy(xpath = "//div[contains(@class, 'alert-success')]") WebElement alertText;

PageUtility pageutility=new PageUtility();
public AdminUsersPage newUserRegistration() {
	  newUser.click();
	  return this;
	}
	  public AdminUsersPage enterusername(String userName) {
	  userNameFiled.sendKeys(userName);
	  return this;
	  }
	  public AdminUsersPage enteruserPassword(String password) {
	  passwordField.sendKeys(password);
	  return this;
	  }
	  public AdminUsersPage selectdropdown() {
		  pageutility.selectByContainsVisibleText(adminUserTypeField, "Admin");
	   return this;
	  }
	  public AdminUsersPage selectUserTypedropdownforsearch() {
		  pageutility.selectByContainsVisibleText(userTypeField, "Admin");
		 return this;
		  }
	  
	  public AdminUsersPage clickonSave() {
	  saveButton.click();
	  return this;
	  }
	  public AdminUsersPage clockonReset() {
	  resetButton.click();
	  return this;
	}
	public AdminUsersPage searchUser() {
		searchButton.click();
		return this;
	}
	public AdminUsersPage searchUserName(String searchUserName)  {
		searchUserNameFiled.sendKeys(searchUserName);
		return this;
	}
	public AdminUsersPage selectUserType()  {
		adminUserTypeField.click();
		return this;
	}
	public AdminUsersPage clickOnSearchAdminUser() {
		searchButtonsubmit.click();	
		return this;
	}
	public AdminUsersPage resetSearchAdminUsers() {
		resetSearchUser.click();
		return this;
	}
	public boolean getAlertText() {
		//Alert alert=driver.switchTo().alert();
		//String alertText=alert.getText();
		return alertText.isDisplayed();
	}
}




