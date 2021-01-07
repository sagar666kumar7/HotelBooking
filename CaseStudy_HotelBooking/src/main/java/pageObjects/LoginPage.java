package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseClass.TestBaseClass;

public class LoginPage extends TestBaseClass {
	@FindBy(xpath="//h1[@align='center']")
	WebElement expectedLoginPageHeading;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@id='userErrMsg']")
	WebElement expectedErrorMessageWihoutUsername;
	
	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="userPwd")
	WebElement password;
	
    @FindBy(xpath="//div[@id='pwdErrMsg']")
	WebElement expectedErrorMessageWihoutPassword;
	
    public LoginPage() {
		PageFactory.initElements(driver, this);
	}
    
	public String getLoginPageHeading() {
		return driver.findElement(By.xpath("//h1[@align='center']")).getText();
	}
	
	public String loginWithoutUserName() {
		loginButton.click();
		return driver.findElement(By.xpath("//div[@id='userErrMsg']")).getText();
	}
	
	public String loginWithoutPassword() {
		username.sendKeys("admin");
		loginButton.click();
		return driver.findElement(By.xpath("//div[@id='pwdErrMsg']")).getText();
	}
	
	public String getExpectedHeading() {
		return expectedLoginPageHeading.getText();	
	}
	public String getExpectedErrorMessageWihoutUsername() {
		return expectedErrorMessageWihoutUsername.getText();	
	}
	
	public String getExpectedErrorMessageWihoutPassword() {
		return expectedErrorMessageWihoutPassword.getText();
	}
	
	public void login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
	}
}