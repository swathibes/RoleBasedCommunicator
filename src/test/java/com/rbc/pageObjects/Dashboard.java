package com.rbc.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	WebDriver driver;

	public Dashboard(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class=\"ui-flex ap\"]//button[text()=\"Clock Off\"]/preceding-sibling::span")
	List<WebElement> clockoffmultipleroles;

	public List<WebElement> getclockoffmultipleroles() {
		return clockoffmultipleroles;
	}

	@FindBy(xpath = "//button[text()=\"Clock Off\"]")
	WebElement clockoffbtn;

	public WebElement ClickClockoffbtn() {
		return clockoffbtn;
	}
}
