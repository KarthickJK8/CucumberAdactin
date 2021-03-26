package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

import junit.framework.Assert;

public class CancelBooking extends LibGlobal {
	public CancelBooking() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement bookingOrderId;

	@FindBy(xpath = "//a[contains(text(),'Booked Itinerary')]")
	private WebElement bookedItinerary;

	@FindBy(id = "order_id_text")
	private WebElement orderIdText;

	@FindBy(id = "search_hotel_id")
	private WebElement searchHotelId;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement orderIdCheckBox;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement cancelButton;

	@FindBy(id = "search_result_error")
	private WebElement cancelErrorMessage;

	public WebElement getCancelErrorMessage() {
		return cancelErrorMessage;
	}

	public WebElement getBookingOrderId() {
		return bookingOrderId;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getOrderIdText() {
		return orderIdText;
	}

	public WebElement getSearchHotelId() {
		return searchHotelId;
	}

	public WebElement getOrderIdCheckBox() {
		return orderIdCheckBox;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public void cancelBookingOrderId() {

		String orderId = getAttribute(getBookingOrderId());
		btnClick(getBookedItinerary());
		type(getOrderIdText(), orderId);
		btnClick(getSearchHotelId());
		btnClick(getCancelButton());
		confirmAlertAccept();

	}

	public void verifyCancel() {

		String cancelMessage = getText(getCancelErrorMessage());
		Assert.assertEquals("The booking has been cancelled.", cancelMessage);
	}

	public void cancelExistingBookingId() {

		btnClick(getBookedItinerary());
		btnClick(getCancelButton());
		confirmAlertAccept();

	}

}
