package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import baseClass.TestBaseClass;

public class BookingForm extends TestBaseClass {
	@FindBy(id = "txtFirstName")
	WebElement firstNameField;

	@FindBy(id = "txtLastName")
	WebElement lastNameField;

	@FindBy(id = "txtEmail")
	WebElement emailField;

	@FindBy(id = "txtPhone")
	WebElement mobileField;

	@FindBy(xpath = "//textarea")
	WebElement addressField;

	@FindBy(xpath = "//table//tbody//tr[6]//td")
	WebElement addressLabel;

	@FindBy(id = "btnPayment")
	WebElement confirmButton;

	@FindBy(name = "city")
	WebElement cityDropdown;

	@FindBy(name = "state")
	WebElement stateDropdown;

	@FindBy(name = "persons")
	WebElement peopleDropdown;

	@FindBy(id = "rooms")
	WebElement numberOfRooms;

	@FindBy(id = "txtCardholderName")
	WebElement cardHolderName;

	@FindBy(id = "txtDebit")
	WebElement debitCard;

	@FindBy(id = "txtCvv")
	WebElement cvv;

	@FindBy(id = "txtMonth")
	WebElement expirationMonth;

	@FindBy(id = "txtYear")
	WebElement expirationYear;

	public BookingForm() {
		PageFactory.initElements(driver, this);
	}

	public String getBookingFormTitle() {
		return driver.getTitle();
	}

	public String getBookingFormUrl() {
		return driver.getCurrentUrl();
	}

	public String confirmWithoutFirstName() {
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithoutLastName() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithoutEmail() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithIncorrectEmail() {
		emailField.sendKeys(prop.getProperty("incorrectEmail"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithoutMobile() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithIncorrectMobile() {
		mobileField.sendKeys(prop.getProperty("incorrectMobile"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String enterAddress() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		return addressField.getAttribute("value");
	}

	public String confirmWithoutCity() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithoutState() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		Select selCity = new Select(cityDropdown);
		selCity.selectByVisibleText(prop.getProperty("city"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String selectPeople() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		Select selCity = new Select(cityDropdown);
		selCity.selectByVisibleText(prop.getProperty("city"));
		Select selState = new Select(stateDropdown);
		selState.selectByVisibleText(prop.getProperty("state"));
		Select selPeople = new Select(peopleDropdown);
		selPeople.selectByVisibleText(prop.getProperty("persons"));
		return numberOfRooms.getText();
	}

	public String confirmWithoutCardHolder() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		Select selCity = new Select(cityDropdown);
		selCity.selectByVisibleText(prop.getProperty("city"));
		Select selState = new Select(stateDropdown);
		selState.selectByVisibleText(prop.getProperty("state"));
		Select selPeople = new Select(peopleDropdown);
		selPeople.selectByVisibleText(prop.getProperty("persons"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithoutDebitCard() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		Select selCity = new Select(cityDropdown);
		selCity.selectByVisibleText(prop.getProperty("city"));
		Select selState = new Select(stateDropdown);
		selState.selectByVisibleText(prop.getProperty("state"));
		Select selPeople = new Select(peopleDropdown);
		selPeople.selectByVisibleText(prop.getProperty("persons"));
		cardHolderName.sendKeys(prop.getProperty("cardHolderName"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithoutCVV() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		Select selCity = new Select(cityDropdown);
		selCity.selectByVisibleText(prop.getProperty("city"));
		Select selState = new Select(stateDropdown);
		selState.selectByVisibleText(prop.getProperty("state"));
		Select selPeople = new Select(peopleDropdown);
		selPeople.selectByVisibleText(prop.getProperty("persons"));
		cardHolderName.sendKeys(prop.getProperty("cardHolderName"));
		debitCard.sendKeys(prop.getProperty("debitCard"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithoutExpMonth() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		Select selCity = new Select(cityDropdown);
		selCity.selectByVisibleText(prop.getProperty("city"));
		Select selState = new Select(stateDropdown);
		selState.selectByVisibleText(prop.getProperty("state"));
		Select selPeople = new Select(peopleDropdown);
		selPeople.selectByVisibleText(prop.getProperty("persons"));
		cardHolderName.sendKeys(prop.getProperty("cardHolderName"));
		debitCard.sendKeys(prop.getProperty("debitCard"));
		cvv.sendKeys(prop.getProperty("cvv"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

	public String confirmWithoutExpYear() {
		expirationMonth.sendKeys(prop.getProperty("expirationMonth"));
		confirmButton.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}
	
	public void confirmWithAllDetails() {
		firstNameField.sendKeys(prop.getProperty("firstName"));
		lastNameField.sendKeys(prop.getProperty("lastName"));
		emailField.sendKeys(prop.getProperty("correctEmail"));
		mobileField.sendKeys(prop.getProperty("correctMobile"));
		addressField.sendKeys(prop.getProperty("address"));
		Select selCity = new Select(cityDropdown);
		selCity.selectByVisibleText(prop.getProperty("city"));
		Select selState = new Select(stateDropdown);
		selState.selectByVisibleText(prop.getProperty("state"));
		Select selPeople = new Select(peopleDropdown);
		selPeople.selectByVisibleText(prop.getProperty("persons"));
		cardHolderName.sendKeys(prop.getProperty("cardHolderName"));
		debitCard.sendKeys(prop.getProperty("debitCard"));
		cvv.sendKeys(prop.getProperty("cvv"));
		expirationMonth.sendKeys(prop.getProperty("expirationMonth"));
		expirationYear.sendKeys(prop.getProperty("expirationYear"));
		confirmButton.click();
	}
}
