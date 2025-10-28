package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	public void selectByIndexWithValue(WebElement element, int value) {
		Select object=new Select(element);
		object.selectByIndex(value);
}
	public void selectByContainsVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByContainsVisibleText(value);
}	
	public void selectByContainsVisibleText(WebElement element, boolean value) {
		Select object=new Select(element);
		object.equals(value);
}
	
}