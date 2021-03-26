package com.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;

public class LibGlobal {
	public static WebDriver driver;

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GT AnnaNagar\\eclipse-workspace\\Cucumbermar25\\drivers\\chromedriver1.exe");
		return driver = new ChromeDriver();
	}

	public void loadUrl(String url) {
		driver.get(url);
		maximize();
		implicitWait();
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	public void type(WebElement element, String data) {
		if (isDisplayed(element) && isEnabled(element)) {
			element.sendKeys(data);
		} else {
			System.err.println("WebElement is hidden or Textbox is disabled");
		}
	}

	public void btnClick(WebElement element) {

		element.click();
	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	public void selectByValue(WebElement element, String data) {
		new Select(element).selectByValue(data);
	}

	public void selectByVisibleText(WebElement element, String data) {
		new Select(element).selectByVisibleText(data);
	}

	public void selectByIndex(WebElement element, int data) {
		new Select(element).selectByIndex(data);
	}

	public void closeAllwindows() {
		driver.quit();
	}

	public void closewindow() {
		driver.close();
	}

	public List<String> getOptions(WebElement element) {
		List<String> datas = new ArrayList<String>();
		List<WebElement> options = new Select(element).getOptions();
		for (WebElement data : options) {
			datas.add(data.getText());
		}
		return datas;
	}

	public void clickByJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("agruments[0].click()", element);
	}

	public void clickByJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("agruments[0].setAttribute('value','" + data + "')", element);
	}

	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	public void clear(WebElement element) {

		element.clear();

	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void confirmAlertAccept() {

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void confirmAlertDismiss() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

}
