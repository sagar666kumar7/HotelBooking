package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseClass.TestBaseClass;

public class successPage extends TestBaseClass {
	@FindBy(xpath="//h1")
	WebElement successPageHeading;
	
	public successPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSuccessPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getSuccessPageHeading() {
		return successPageHeading.getText();
	}
}