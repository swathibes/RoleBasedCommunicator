package com.rbc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RBC_Chat {

	WebDriver driver;

	public RBC_Chat(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//iframe[@class=\"embedded-electron-webview embedded-page-content\"]")
	WebElement frame;

	@FindBy(xpath = "//iframe[@class=\"embedded-iframe embedded-page-content\"]")
	WebElement Dashboardframe;

	@FindBy(xpath = "//li[@id=\"autocomplete-picker-item1\"]")
	WebElement clockon;

	@FindBy(xpath = "//li[@aria-label=\"Clock off a role\"]")
	WebElement clockoff;

	@FindBy(xpath = "//li[@aria-label=\"Get in touch with a role\"]")
	WebElement getintouch;

	@FindBy(xpath = "(//div[@id=\"roleContacted\"])[last()]")
	List<WebElement> roles;

	@FindBy(xpath = "(//div[contains(@class,\"actionSet\")]//button//span/parent::button)[last()]")
	WebElement multipleshifts;

	@FindBy(xpath = "(//p[text()=\"Looks like you're clocked into multiple shifts. What role/team would you want to send this message as?\"])[last()]")
	WebElement multipleshiftstitle;

	public WebElement title() {
		return multipleshiftstitle;
	}

	@FindBy(xpath = "//div[@class=\"shifts-details\"]/div/div[2]/span[2]")
	List<WebElement> DashBoardClockOnShifts;

	public List<WebElement> DashBoardShifts() {
		return DashBoardClockOnShifts;
	}

	@FindBy(xpath = "//div[@class=\"shifts-details\"]/div/div[2]/span[2]")
	WebElement DashBoardClockOnShift;

	public WebElement DashBoardShift() {
		return DashBoardClockOnShift;
	}

	@FindBy(xpath = "(//div[@id=\"roleContacted\"])[last()]")
	WebElement role;

	@FindBy(xpath = "//div[@role=\"textbox\"]")
	WebElement textbox;

	// cke_textarea_inline cke_editable cke_editable_inline cke_contents_ltr

	@FindBy(xpath = "(//span[contains(text(),\"Confirm\")])[last()]")
	WebElement confirm;

	@FindBy(xpath = "(//div/p[contains(text(),\"clocked on as the\")])[last()]")
	WebElement outputmsg;

	@FindBy(xpath = "//span[text()=\"Dashboard\"]")
	WebElement dashboard;

	@FindBy(xpath = "//div[@title=\"Chat\"]")
	WebElement Chat;

	@FindBy(xpath = "(//span[text() = \"Send Message\"])[last()]")
	WebElement sendmessage;

	@FindBy(xpath = "(//span[text()=\"Clock off\"])[last()]")
	WebElement btnclockoff;

	@FindBy(xpath = "(//p[contains(text(),\"Looks like you're clocked into multiple shifts\")]/parent::div")
	List<WebElement> multipleshiftsheader;

	@FindBy(xpath = "(//div[contains(@aria-label,\"clocked off \")])[last()]//p")
	WebElement clockoffmsg;

	public WebElement clockoffbtn(String Rolelist) {
		return driver.findElement(
				By.xpath("(//p[contains(text(),\"You are currently clocked on as the \")]//strong[text()='" + Rolelist
						+ "']/../../following-sibling::div[2]//button//span[text()=\"Clock off\"])[last()]"));
	}

	public WebElement Clockoffmsg() {
		return clockoffmsg;
	}

	public List<WebElement> MultipleShiftsHeader() {
		return multipleshiftsheader;
	}

	public WebElement Chat() {
		return Chat;
	}

	public WebElement BtnClockoff() {
		return btnclockoff;
	}

	public WebElement MultipleShifts() {
		return multipleshifts;
	}

	public WebElement SendMessage() {
		return sendmessage;
	}

	public WebElement getClockon() {
		return clockon;
	}

	public WebElement getClockoff() {
		return clockoff;
	}

	public WebElement getintouch() {
		return getintouch;
	}

	public WebElement gettextbox() {
		return textbox;
	}

	public WebElement getRole() {
		return role;
	}

	public List<WebElement> getAllRoles() {
		return roles;
	}

	public WebElement findElementUsingText(String Role) {
		return driver.findElement(
				By.xpath("(//ul[contains(@id,\"downshift\")])[last()]//li//div//div[contains(text(),'" + Role + "')]"));

		// (//ul[contains(@id,"downshift")])[last()]//li//div//div[contains(text(),'"+Role+"')]
	}

	public WebElement ClickConfirm() {
		return confirm;
	}

	public WebElement getOutputmsg() {
		return outputmsg;
	}

	public WebElement ClickDashboard() {
		return dashboard;
	}

	public void SwitchToFrame() {
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

		driver.switchTo().frame(frame);
		String Framet = driver.getTitle();
		System.out.println(Framet);
		// driver.switchTo().defaultContent();
	}

	public void SwitchToDashboard() {
		driver.switchTo().frame(Dashboardframe);
	}

	public void clockOnrole() {
		Actions act = new Actions(driver);
		act.moveToElement(clockon).click().perform();
		textbox.sendKeys(Keys.ENTER);

	}

	public void clockOffrole() {
		Actions act = new Actions(driver);
		act.moveToElement(clockoff).click().perform();
		textbox.sendKeys(Keys.ENTER);

	}

}
