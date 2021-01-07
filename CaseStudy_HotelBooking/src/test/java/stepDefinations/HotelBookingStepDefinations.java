package stepDefinations;

import org.testng.Assert;
import baseClass.TestBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.BookingForm;
import pageObjects.LoginPage;
import pageObjects.successPage;

public class HotelBookingStepDefinations extends TestBaseClass {
	LoginPage loginPage;
	BookingForm bookingForm;
	successPage successPageObj;
	String errorWithoutPassword;
	String errorWithoutUsername;
	String loginPageHeading;
	String alertMessage;
	String incorectAlertMessage;
	String address;
	String numberOfRooms;
	String alertMessageMonth;
	String alertMessageYear;

	@Given("^I am on Login page$")
	public void i_am_on_Login_page() throws Throwable {
		TestBaseClass.initialize();
	}

	@Given("^Heading of the Login page is matching the expectations$")
	public void heading_of_the_Login_page_is_matching_the_expectations() throws Throwable {
		loginPage = new LoginPage();
		loginPageHeading = loginPage.getLoginPageHeading();
		Assert.assertEquals(loginPage.getExpectedHeading(), loginPageHeading);
	}

	@Then("^Printing the heading of Login page and closing the browser$")
	public void printing_the_heading_of_Login_page_and_closing_the_browser() throws Throwable {
		System.out.println("Heading of Login Page: " + loginPageHeading);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on login without entering username$")
	public void clicking_on_login_without_entering_username() throws Throwable {
		loginPage = new LoginPage();
		errorWithoutUsername = loginPage.loginWithoutUserName();
		Assert.assertEquals(loginPage.getExpectedErrorMessageWihoutUsername(), errorWithoutUsername);
	}

	@Given("^Clicking on login without entering password$")
	public void clicking_on_login_without_entering_password() throws Throwable {
		loginPage = new LoginPage();
		errorWithoutPassword = loginPage.loginWithoutPassword();
		Assert.assertEquals(loginPage.getExpectedErrorMessageWihoutPassword(), errorWithoutPassword);
	}

	@Then("^Printing the error messages and closing the browser$")
	public void printing_the_error_messages_and_closing_the_browser() throws Throwable {
		System.out.println("Error message while trying to login without Username: " + errorWithoutUsername);
		System.out.println("Error message while trying to login without Password: " + errorWithoutPassword);
		TestBaseClass.closeBrowser();
	}

	@Given("^Entering the login credentials$")
	public void entering_the_login_credentials() throws Throwable {
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Given("^Getting redirected to Hotel Booking Form$")
	public void getting_redirected_to_Hotel_Booking_Form() throws Throwable {
		bookingForm = new BookingForm();
		Assert.assertEquals(bookingForm.getBookingFormUrl(),
				"file:///B:/Workspace/Casestudy_HotelBooking/hotelbooking.html");
	}

	@Then("^Printing the Hotel booking form URL and closing the browser$")
	public void printing_the_Hotel_booking_form_URL_and_closing_the_browser() throws Throwable {
		bookingForm = new BookingForm();
		Assert.assertEquals(bookingForm.getBookingFormTitle(), "Hotel Booking");
		System.out.println("Title of the Booking form: " + bookingForm.getBookingFormTitle());
		TestBaseClass.closeBrowser();
	}

	@Given("^I am on Booking form$")
	public void i_am_on_Booking_form() throws Throwable {
		TestBaseClass.initialize();
		loginPage = new LoginPage();
		bookingForm = new BookingForm();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(bookingForm.getBookingFormUrl(),
				"file:///B:/Workspace/Casestudy_HotelBooking/hotelbooking.html");
	}

	@Given("^Clicking on Confirm without entering First Name$")
	public void clicking_on_Confirm_without_entering_First_Name() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutFirstName();
		Assert.assertEquals(alertMessage, "Please fill the First Name");
	}

	@Then("^Printing the alert message for first name and closing the browser$")
	public void printing_the_alert_message_for_first_name_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for First Name: " + alertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without entering Last Name$")
	public void clicking_on_Confirm_without_entering_Last_Name() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutLastName();
		Assert.assertEquals(alertMessage, "Please fill the Last Name");
	}

	@Then("^Printing the alert message for Last name and closing the browser$")
	public void printing_the_alert_message_for_Last_name_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for Last Name: " + alertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without entering Email$")
	public void clicking_on_Confirm_without_entering_Email() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutEmail();
		Assert.assertEquals(alertMessage, "Please fill the Email");
	}

	@Given("^Clicking on Confirm by entering incorrect Email$")
	public void clicking_on_Confirm_by_entering_incorrect_Email() throws Throwable {
		bookingForm = new BookingForm();
		incorectAlertMessage = bookingForm.confirmWithIncorrectEmail();
		Assert.assertEquals(incorectAlertMessage, "Please enter valid Email Id.");
	}

	@Then("^Printing the alert messages for Email and closing the browser$")
	public void printing_the_alert_messages_for_Email_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for without Email: " + alertMessage);
		System.out.println("Alert message for incorrect Email: " + incorectAlertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without entering Mobile$")
	public void clicking_on_Confirm_without_entering_Mobile() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutMobile();
		Assert.assertEquals(alertMessage, "Please fill the Mobile No.");
	}

	@Given("^Clicking on Confirm by entering incorrect Mobile$")
	public void clicking_on_Confirm_by_entering_incorrect_Mobile() throws Throwable {
		bookingForm = new BookingForm();
		incorectAlertMessage = bookingForm.confirmWithIncorrectMobile();
		Assert.assertEquals(incorectAlertMessage, "Please enter valid Contact no.");
	}

	@Then("^Printing the alert messages for Mobile and closing the browser$")
	public void printing_the_alert_messages_for_Mobile_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for without Mobile: " + alertMessage);
		System.out.println("Alert message for incorrect Mobile: " + incorectAlertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Entering address in address field$")
	public void entering_address_in_address_field() throws Throwable {
		bookingForm = new BookingForm();
		address = bookingForm.enterAddress();
		Assert.assertEquals(prop.getProperty("address"), address);
	}

	@Then("^Printing the entered address in console$")
	public void printing_the_entered_address_in_console() throws Throwable {
		System.out.println("Address is: " + address);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without selecting City$")
	public void clicking_on_Confirm_without_selecting_City() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutCity();
		Assert.assertEquals(alertMessage, "Please select city");
	}

	@Then("^Printing the alert messages for City and closing the browser$")
	public void printing_the_alert_messages_for_City_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for City: " + alertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without selecting State$")
	public void clicking_on_Confirm_without_selecting_State() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutState();
		Assert.assertEquals(alertMessage, "Please select state");
	}

	@Then("^Printing the alert messages for State and closing the browser$")
	public void printing_the_alert_messages_for_State_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for state: " + alertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Selecting the number of people$")
	public void selecting_the_number_of_people() throws Throwable {
		bookingForm = new BookingForm();
		numberOfRooms = bookingForm.selectPeople();
	}

	@Then("^Printing the number of people and number of Rooms and closing the browser$")
	public void printing_the_number_of_people_and_number_of_Rooms_and_closing_the_browser() throws Throwable {
		System.out.println("Number of Rooms: " + numberOfRooms);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without entering Card holder Name$")
	public void clicking_on_Confirm_without_entering_Card_holder_Name() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutCardHolder();
		Assert.assertEquals(alertMessage, "Please fill the Card holder name");
	}

	@Then("^Printing the alert message for Card holder name and closing the browser$")
	public void printing_the_alert_message_for_Card_holder_name_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for card holder name: " + alertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without entering Debit card number$")
	public void clicking_on_Confirm_without_entering_Debit_card_number() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutDebitCard();
		Assert.assertEquals(alertMessage, "Please fill the Debit card Number");
	}

	@Then("^Printing the alert message for Debit card number and closing the browser$")
	public void printing_the_alert_message_for_Debit_card_number_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for Debit card number: " + alertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without entering CVV$")
	public void clicking_on_Confirm_without_entering_CVV() throws Throwable {
		bookingForm = new BookingForm();
		alertMessage = bookingForm.confirmWithoutCVV();
		Assert.assertEquals(alertMessage, "Please fill the CVV");
	}

	@Then("^Printing the alert message for CVV and closing the browser$")
	public void printing_the_alert_message_for_CVV_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for CVV: " + alertMessage);
		TestBaseClass.closeBrowser();
	}

	@Given("^Clicking on Confirm without entering Expiration Month$")
	public void clicking_on_Confirm_without_entering_Expiration_Month() throws Throwable {
		bookingForm = new BookingForm();
		alertMessageMonth = bookingForm.confirmWithoutExpMonth();
		Assert.assertEquals(alertMessageMonth, "Please fill expiration month");
	}

	@Given("^Clicking on Confirm without entering Expiration Year$")
	public void clicking_on_Confirm_without_entering_Expiration_Year() throws Throwable {
		bookingForm = new BookingForm();
		alertMessageYear = bookingForm.confirmWithoutExpYear();
		Assert.assertEquals(alertMessageYear, "Please fill the expiration year");
	}

	@Then("^Printing the alert messages for Expiration Month and Year and closing the browser$")
	public void printing_the_alert_messages_for_Expiration_Month_and_Year_and_closing_the_browser() throws Throwable {
		System.out.println("Alert message for Expiration Month: " + alertMessageMonth);
		System.out.println("Alert message for Expiration Year: " + alertMessageYear);
		TestBaseClass.closeBrowser();
	}
	
	@Given("^Clicking on Confirm after entering all details$")
	public void clicking_on_Confirm_after_entering_all_details() throws Throwable {
		bookingForm = new BookingForm();
		bookingForm.confirmWithAllDetails();
	}

	@Then("^I am redirected to success page$")
	public void i_am_redirected_to_success_page() throws Throwable {
		successPageObj = new successPage();
		Assert.assertEquals(successPageObj.getSuccessPageUrl(),
				"file:///B:/Workspace/Casestudy_HotelBooking/success.html");
		String successPageHeading = successPageObj.getSuccessPageHeading();
		System.out.println("Heading of Success page: " + successPageHeading);
		TestBaseClass.closeBrowser();
	}
}