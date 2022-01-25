package com.rbc.testCase;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rbc.pageObjects.MessageDlgBox;

public class RecallMessage extends BaseClass {

	@Test
	public void Recallmsg() throws InterruptedException, IOException {
		chattab();
		Thread.sleep(3000);
		MessageDlgBox msg = new MessageDlgBox(driver);
		WebElement recallmsg = msg.Recallmsg();
		WebElement recallsuccessmsg = msg.RecallSuccessMsg();
		recallmsg.click();
		Thread.sleep(3000);

		if (recallsuccessmsg.getText().contains("All done! This message was successfully recalled.")) {
			Assert.assertTrue(true);
		} else {
			captureScreen("RecallMessage");
			Assert.assertTrue(false);
		}
	}

}
