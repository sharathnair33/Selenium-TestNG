package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
public ManageNewsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement manageNewsNewNews;
@FindBy(xpath = "//textarea[@id='news']") WebElement TextAreaForNews;
@FindBy(xpath = "//button[@class='btn btn-danger']") WebElement saveTextNews;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchnews;
@FindBy(xpath = "//input[@class='form-control']") WebElement searchNewsTextField;
@FindBy(name = "Search") WebElement searchButtonClick;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetButtonClick;
@FindBy(xpath = "//div[contains(@class,'alert-success') and contains(.,'News Created Successfully')]") WebElement alertText;
@FindBy(xpath="//div[@class='col-sm-12 form-group']//input[@name='un']") WebElement SearchinputField;
@FindBy(xpath="//button[@class=\"btn btn-danger btn-fix\"]") WebElement clickOnSearchButtonforSearchingNews;
@FindBy(xpath="//table[@class=\"table table-bordered table-hover table-sm\"]//tbody//tr[1]//td[1]") WebElement SearchFirstEnteredText;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement NewsCreationAlert;
public ManageNewsPage clickOnNewNews() {
	manageNewsNewNews.click();
	return this;
	}
public ManageNewsPage EnterTextForNews(String Text) {
TextAreaForNews.sendKeys(Text);	
return this;
}
public ManageNewsPage saveEnteredText() {
	saveTextNews.click();
	return this;
}
public ManageNewsPage searchNews() {
	searchnews.click();
	return this;
}
public ManageNewsPage searchNewsTextfeild() {
	searchNewsTextField.click();
return this;	
}
public ManageNewsPage clickOnSearchButton() {
	searchButtonClick.click();
	return this;
}
public ManageNewsPage clickOnResetButton() {
	resetButtonClick.click();
	return this;
}

public String getAlertTitle() {
    return alertText.getText().trim();
}
public ManageNewsPage inputtextIntoSearchField(String inputNews) {
	SearchinputField.sendKeys(inputNews);
	return this;
}
	public ManageNewsPage ClickonSearchButtonForSearch() {
		clickOnSearchButtonforSearchingNews.click();
		return this;	
	}
	

public String IsalertDisplayed() {
	return SearchFirstEnteredText.getText();
	}
public String IsAlertDisplayedForNewsCreated() {
	
	String expectedText = NewsCreationAlert.getText().trim();
	return expectedText;
	
	
}

}