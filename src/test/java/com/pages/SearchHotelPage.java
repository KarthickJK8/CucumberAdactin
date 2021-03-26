package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

import junit.framework.Assert;

public class SearchHotelPage extends LibGlobal {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement location;
	@FindBy(id = "hotels")
	private WebElement hotel;
	@FindBy(id = "room_type")
	private WebElement typeOfRoom;
	@FindBy(id = "room_nos")
	private WebElement noOfRooms;
	@FindBy(id = "datepick_in")
	private WebElement checkInDate;
	@FindBy(id = "datepick_out")
	private WebElement checkOutDate;
	@FindBy(id = "adult_room")
	private WebElement adultsPerRoom;
	@FindBy(id = "child_room")
	private WebElement childrenPerRoom;
	@FindBy(id = "Submit")
	private WebElement clickSubmit;

	@FindBy(id = "radiobutton_0")
	private WebElement select;
	@FindBy(id = "continue")
	private WebElement selectContinue;

	@FindBy(id = "checkin_span")
	private WebElement checkInError;
	@FindBy(id = "checkout_span")
	private WebElement checkOutError;
	@FindBy(id = "location_span")
	private WebElement locationError;

	public WebElement getCheckInError() {
		return checkInError;
	}

	public WebElement getCheckOutError() {
		return checkOutError;
	}

	public WebElement getLocationError() {
		return locationError;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getTypeOfRoom() {
		return typeOfRoom;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultsPerRoom() {
		return adultsPerRoom;
	}

	public WebElement getChildrenPerRoom() {
		return childrenPerRoom;
	}

	public WebElement getClickSubmit() {
		return clickSubmit;
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getSelectContinue() {
		return selectContinue;
	}

	public void searchHotel(String location, String hotel, String typeOfRoom, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		selectByVisibleText(getLocation(), location);
		selectByVisibleText(getHotel(), hotel);
		selectByVisibleText(getTypeOfRoom(), typeOfRoom);
		selectByVisibleText(getNoOfRooms(), noOfRooms);
		type(getCheckInDate(), checkInDate);
		type(getCheckOutDate(), checkOutDate);
		selectByVisibleText(getAdultsPerRoom(), adultsPerRoom);
		selectByVisibleText(getChildrenPerRoom(), childrenPerRoom);
		btnClick(clickSubmit);
		implicitWait();
		btnClick(select);
		btnClick(selectContinue);

	}

	public void searchHotelWithMandatory(String location, String noOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) {
		selectByVisibleText(getLocation(), location);
		selectByVisibleText(getNoOfRooms(), noOfRooms);
		type(getCheckInDate(), checkInDate);
		type(getCheckOutDate(), checkOutDate);
		selectByVisibleText(getAdultsPerRoom(), adultsPerRoom);
		btnClick(clickSubmit);

	}

	public void dateVerify() {

		String checkinText = getText(getCheckInError());
		Assert.assertEquals("CHECKIN ERROR", "Check-In Date shall be before than Check-Out Date", checkinText);
		String checkoutText = getText(getCheckOutError());
		Assert.assertEquals("CHECKOUT ERROR", "Check-Out Date shall be after than Check-In Date", checkoutText);

	}

	public void locationVerify() {
		String locationtext = getText(getLocation());
		Assert.assertEquals("LOCATION ERROR", "Please Select a Location", locationtext);

	}

	public void dateChecking(String checkInDate, String checkOutDate) {

		clear(getCheckInDate());
		type(getCheckInDate(), checkInDate);
		clear(getCheckOutDate());
		type(getCheckOutDate(), checkOutDate);
		btnClick(clickSubmit);

	}

	public void searchHotelWithoutAnyFields() {
		btnClick(clickSubmit);

	}
}
