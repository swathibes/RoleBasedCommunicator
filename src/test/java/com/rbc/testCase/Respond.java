package com.rbc.testCase;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.rbc.pageObjects.MessageDlgBox;

public class Respond extends BaseClass {

	@Test
	public void RespondToMsg() throws InterruptedException, IOException {
		chattab();
		Thread.sleep(3000);
		MessageDlgBox msg = new MessageDlgBox(driver);
		WebElement respond = msg.Respondbtn();
		WebElement textarea = msg.TextRespond();
		WebElement addcomment = msg.BtnAddComment();
		respond.click();
		Thread.sleep(3000);
		SwitchToMsgDlgBox();
		textarea.sendKeys("Hi Testing");
		addcomment.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		msg.btnClose().click();

	}

}
