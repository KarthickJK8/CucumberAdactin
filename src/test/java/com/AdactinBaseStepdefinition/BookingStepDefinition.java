package com.AdactinBaseStepdefinition;

import com.base.LibGlobal;
import com.pages.BookingPage;
import com.pages.CancelBooking;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BookingStepDefinition extends LibGlobal {
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	BookingPage bookingPage;
	CancelBooking cancelBooking;

	@Given("User should login in the adactin page using {string} and {string}")
	public void user_should_login_in_the_adactin_page_using_and(String userName, String password) {
		getDriver();
		loadUrl("http://adactinhotelapp.com/");
		loginPage = new LoginPage();
		loginPage.login(userName, password);

	}

	@When("User should search hotel by {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_search_hotel_by_and(String location, String hotel, String typeOfRoom, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		searchHotelPage = new SearchHotelPage();
		searchHotelPage.searchHotel(location, hotel, typeOfRoom, noOfRooms, checkInDate, checkOutDate, adultsPerRoom,
				childrenPerRoom);

	}

	@When("User should search hotel by {string},{string},{string},{string} and {string}")
	public void user_should_search_hotel_by_and(String location, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom) {

		searchHotelPage = new SearchHotelPage();
		searchHotelPage.searchHotelWithMandatory(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}

	@When("User should search hotel by {string},{string}")
	public void user_should_search_hotel_by(String checkInDate, String checkOutDate) {

		searchHotelPage = new SearchHotelPage();
		searchHotelPage.dateChecking(checkInDate, checkOutDate);
		searchHotelPage.dateVerify();
		searchHotelPage.locationVerify();

	}

	@When("User should search hotel")
	public void user_should_search_hotel() {

		searchHotelPage = new SearchHotelPage();
		searchHotelPage.searchHotelWithoutAnyFields();
		searchHotelPage.locationVerify();

	}

	@When("User should book a hotel by {string},{string},{string}")
	public void user_should_book_a_hotel_by(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) {
		bookingPage = new BookingPage();
		bookingPage.booking(firstName, lastName, address, dataTable);
		implicitWait();
		bookingPage.getGetOrderId();
	}

	@When("User should book a hotel")
	public void user_should_book_a_hotel() {
		bookingPage = new BookingPage();
		bookingPage.bookingWithoutAnyFields();
		bookingPage.verifyBooking();
	}

	@When("User Should Cancel booking")
	public void user_Should_Cancel_booking() {

		cancelBooking = new CancelBooking();
		cancelBooking.cancelBookingOrderId();
		cancelBooking.verifyCancel();

	}

	@When("User should cancel booking using existing order id")
	public void user_should_cancel_booking_using_existing_order_id() {

		cancelBooking = new CancelBooking();
		cancelBooking.cancelExistingBookingId();
		cancelBooking.verifyCancel();
	}

}
