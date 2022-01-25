package com.rbc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='c-button f-secondary ow-mt-30 ow-bvr-signin']")
	WebElement SignIn;

	@FindBy(id = "idSIButton9")
	WebElement SignIn1;

	@FindBy(id = "i0116")
	WebElement Email;

	@FindBy(id = "i0118")
	WebElement Password;

	@FindBy(xpath = "//div[@class=\"win-button-pin-bottom\"]/div/div/div/div")
	WebElement SignIn2;

	@FindBy(xpath = "//div[@class=\"inline-block\"]/following-sibling::div[1]")
	WebElement SignIn3;

	@FindBy(xpath = "//span[contains(text(),\"Role-based Communicator\")]")
	WebElement Rbcbutton;

	@FindBy(xpath = "//div[@id=\"toast-container\"]")
	WebElement notification;

	public WebElement ClickOnTurnOn() {
		return notification;
	}

	// div[@id="toast-container"]

	public void setEmail(String email) {
		Email.sendKeys(email);
	}

	public void setPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickSignin() {
		SignIn.click();
	}

	public void clickSignin1() {
		SignIn1.click();
	}

	public void ClickSignin2() {
		SignIn2.click();
	}

	public void ClickSignin3() {
		SignIn3.click();
	}

	public void clickonRBC() {
		Rbcbutton.click();
	}

}
