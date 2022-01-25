package com.rbc.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageDlgBox {

	WebDriver driver;

	public MessageDlgBox(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class=\"ui-radiogroup am ao\"]")
	List<WebElement> types;

	public List<WebElement> getAlltypes() {
		return types;
	}

	public WebElement TypeOfMessage(String Type) {
		return driver.findElement(By.xpath("//span[contains(normalize-space(),'" + Type + "')]"));

	}

	@FindBy(xpath = "//div[@class=\"analytics-panel\"]//div[2]//iframe[@title=\"Role-based Communicator Task Module\"]")
	WebElement msgwindow;

	public WebElement MsgWd() {
		return msgwindow;
	}

	@FindBy(xpath = "//span[text() =\"Select one\"]")
	WebElement timeFrame;

	public WebElement TimeFrame() {
		return timeFrame;
	}

	public void clickTimeFrame() {
		timeFrame.click();
	}

	public WebElement TimeFrameopt(String opt) {
		return driver.findElement(By.xpath("//div[text()='" + opt + "']"));
	}

	@FindBy(xpath = "//div[@class=\"ui-flex ap\"]//textarea")
	WebElement details;

	public WebElement TxtDetails() {
		return details;
	}

	@FindBy(xpath = "(//div[@role=\"img\"]//span[@class=\"ui-icon fi ds fj\"])[1]")
	WebElement team;

	public WebElement Teamdropdown() {
		return team;
	}

	public void clickOnTeamDropDown() {
		team.click();
	}

	public WebElement clickOnTeamDropDownOptions(String teamopt) {
		return driver.findElement(By.xpath("//div[text()='" + teamopt + "']"));
	}

	public WebElement RdbtnUrgentClinicalReview(String kind) {
		return driver.findElement(By.xpath("//span[text()='" + kind + "']"));
	}

	@FindBy(xpath = "//input[@placeholder=\"Type patient's UR number here\"]")
	WebElement URNumber;

	public WebElement SetURNumber() {
		return URNumber;
	}

	@FindBy(xpath = "//input[@placeholder=\"Type patient's name here\"]")
	WebElement name;

	public WebElement SetName() {
		return name;
	}

	@FindBy(xpath = "//input[@placeholder=\"Type patient's date of birth here\"]")
	WebElement Dob;

	public WebElement SetDob() {
		return Dob;
	}

	@FindBy(xpath = "//input[@placeholder=\"Type patient's ward and bed information here\"]")
	WebElement Ward;

	public WebElement SetWard() {
		return Ward;
	}

	@FindBy(xpath = "//div[contains(@class,\"ui-flex ap\")]//button//span[text()=\"Send Message\"]")
	WebElement sendmsgbtn;

	public WebElement ClickSendmsgbtn() {
		return sendmsgbtn;
	}

	@FindBy(xpath = "//button[@title=\"Close\"]")
	WebElement closebtn;

	public WebElement btnClose() {
		return closebtn;
	}

	@FindBy(xpath = "(//span[contains(text(),\"Sent\")]/..//div[2]//div//div//div//div[contains(@class,\"msg-title\")])[1]")
	WebElement sentmsgrole;

	public WebElement SentMsgRole() {
		return sentmsgrole;
	}

	@FindBy(xpath = "(//p[contains(text(),\"I've sent your message\")])[last()]/strong")
	WebElement messagesentcard;

	public WebElement MessageSentCard() {
		return messagesentcard;
	}

	@FindBy(xpath = "(//div[@class=\"ac-textBlock\"]//p)[last()]")
	WebElement messagecardtext;

	public WebElement MessageCardText() {
		return messagecardtext;
	}

	@FindBy(xpath = "(//span[text()=\"Recall Message\"])[last()]")
	WebElement recallmsg;

	public WebElement Recallmsg() {
		return recallmsg;
	}

	@FindBy(xpath = "(//div[contains(@aria-label,\"recalled\")])[last()]//p")
	WebElement recallsuccessmsg;

	public WebElement RecallSuccessMsg() {
		return recallsuccessmsg;
	}

	@FindBy(xpath = "(//span[text()=\"Respond\"])[last()]")
	WebElement Respond;

	public WebElement Respondbtn() {
		return Respond;
	}

	@FindBy(xpath = "//input[contains(@placeholder,\"Type your\")]")
	WebElement respondtxtarea;

	public WebElement TextRespond() {
		return respondtxtarea;
	}

	@FindBy(xpath = "//button[@title=\"Add Comment\"]")
	WebElement addComment;

	public WebElement BtnAddComment() {
		return addComment;
	}

}
