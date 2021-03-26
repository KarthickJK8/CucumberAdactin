package com.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

import junit.framework.Assert;

public class BookingPage extends LibGlobal {
	public BookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement firstName;
	@FindBy(id = "last_name")
	private WebElement lastName;
	@FindBy(id = "address")
	private WebElement address;
	@FindBy(id = "cc_num")
	private WebElement cardNum;
	@FindBy(id = "cc_type")
	private WebElement dDncardType;
	@FindBy(id = "cc_exp_month")
	private WebElement dDnmonth;
	@FindBy(id = "cc_exp_year")
	private WebElement dDnyear;
	@FindBy(id = "cc_cvv")
	private WebElement cvv;

	@FindBy(id = "first_name_span")
	private WebElement firstNameVerify;
	@FindBy(id = "last_name_span")
	private WebElement lastNameVerify;
	@FindBy(id = "address_span")
	private WebElement addressVerify;
	@FindBy(id = "cc_num_span")
	private WebElement creditCardNumberVerify;
	@FindBy(id = "cc_type_span")
	private WebElement creditCardTypeVerify;
	@FindBy(id = "cc_exp_month")
	private WebElement monthVerify;
	@FindBy(id = "cc_exp_year")
	private WebElement yearVerify;
	@FindBy(id = "cc_cvv_span")
	private WebElement cvvVerify;

	public WebElement getYearVerify() {
		return yearVerify;
	}

	public WebElement getFirstNameVerify() {
		return firstNameVerify;
	}

	public WebElement getLastNameVerify() {
		return lastNameVerify;
	}

	public WebElement getAddressVerify() {
		return addressVerify;
	}

	public WebElement getCreditCardNumberVerify() {
		return creditCardNumberVerify;
	}

	public WebElement getCreditCardTypeVerify() {
		return creditCardTypeVerify;
	}

	public WebElement getMonthVerify() {
		return monthVerify;
	}

	public WebElement getCvvVerify() {
		return cvvVerify;
	}

	@FindBy(id = "book_now")
	private WebElement clickBooknow;

	@FindBy(id = "order_no")
	private WebElement getOrderId;

	public WebElement getGetOrderId() {
		return getOrderId;
	}

	public void setGetOrderId(WebElement getOrderId) {
		this.getOrderId = getOrderId;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardNum() {
		return cardNum;
	}

	public WebElement getdDnCardType() {
		return dDncardType;
	}

	public WebElement getdDnMonth() {
		return dDnmonth;
	}

	public WebElement getdDnYear() {
		return dDnyear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getClickBooknow() {
		return clickBooknow;
	}

	public void booking(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) {
		type(getFirstName(), firstName);
		type(getLastName(), lastName);
		type(getAddress(), address);
		java.util.List<Map<String, String>> emp = dataTable.asMaps();
		Map<String, String> c = emp.get(2);
		type(cardNum, c.get("creditCardNo"));
		selectByVisibleText(getdDnCardType(), c.get("creditCardType"));
		selectByVisibleText(getdDnMonth(), c.get("month"));
		selectByVisibleText(getdDnYear(), c.get("year"));
		type(getCvv(), c.get("cvvNumber"));

		btnClick(getClickBooknow());

	}

	public void bookingWithoutAnyFields() {

		btnClick(clickBooknow);

	}

	public void verifyBooking() {
		String firstNameVerify = getText(getFirstNameVerify());
		Assert.assertEquals("FIRSTNAME ERROR", "Please Enter your First Name", firstNameVerify);
		String lastNameVerify = getText(getLastNameVerify());
		Assert.assertEquals("LASTNAME ERROR", "Please Enter you Last Name", lastNameVerify);
		String addressVerify = getText(getAddressVerify());
		Assert.assertEquals("ADDRESS ERROR", "Please Enter your Address", addressVerify);
		String creditCardNumberVerify = getText(getCreditCardNumberVerify());
		Assert.assertEquals("CARDNUMBER ERROR", "Please Enter your 16 Digit Credit Card Number",
				creditCardNumberVerify);
		String creditCardTypeVerify = getText(getCreditCardTypeVerify());
		Assert.assertEquals("CARDTYPE ERROR", "Please Select your Credit Card Type", creditCardTypeVerify);
		String monthVerify = getText(getMonthVerify());
		Assert.assertEquals("MONTH ERROR", "Please Select your Credit Card Expiry Month", monthVerify);
		String yearVerify = getText(getYearVerify());
		Assert.assertEquals("YEAR ERROR", "Please Select your Credit Card Expiry Month", yearVerify);
		String cvvVerify = getText(getCvvVerify());
		Assert.assertEquals("CVV ERROR", "Please Enter your Credit Card CVV Number", cvvVerify);

	}
}
