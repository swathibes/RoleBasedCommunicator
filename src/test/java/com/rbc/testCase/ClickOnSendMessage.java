package com.rbc.testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rbc.pageObjects.RBC_Chat;

public class ClickOnSendMessage extends BaseClass {

	@Test
	@Parameters({ "Role" })
	public void SendMessage(String Role) throws InterruptedException {
		RBC_Chat clock = new RBC_Chat(driver);
		WebElement sendmessage = clock.SendMessage();
		sendmessage.click();

	}

}
