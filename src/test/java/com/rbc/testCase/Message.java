package com.rbc.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rbc.pageObjects.MessageDlgBox;
import com.rbc.pageObjects.RBC_Chat;

public class Message extends BaseClass {

	@Test
	@Parameters({ "SendMessageRole", "Type", "Clinicalkind", "URNumber", "Name", "Dob", "Ward", "TimeFrame",
			"Details" })
	public void MessageDlg(String SendMessageRole, String Type, String Clinicalkind, String URNumber, String Name,
			String Dob, String Ward, String TimeFrame, String Details) throws InterruptedException, IOException {
		MessageDlgBox msg = new MessageDlgBox(driver);

		if (Type.equals("Question (Routine)") || Type.equals("Notification/Update (Routine)")
				|| Type.equals("Medical Discussion/Admission Referral (Routine)")) {
			msg.TypeOfMessage(Type).click();
			msg.clickTimeFrame();
			msg.TimeFrameopt(TimeFrame).click();
			Thread.sleep(3000);
			msg.TxtDetails().sendKeys(Details);
			Thread.sleep(3000);
			msg.ClickSendmsgbtn().click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			msg.btnClose().click();
			Thread.sleep(3000);

			RBC_Chat clock = new RBC_Chat(driver);
			clock.SwitchToFrame();
			Thread.sleep(3000);
			String messagecardtext_chat = msg.MessageCardText().getText();
			if (messagecardtext_chat.contains("I've sent your message to the " + SendMessageRole
					+ ". They'll respond to you directly with a chat message.")) {
				Assert.assertTrue(true);
				dashboardtab();
				String Sentmsg_role = msg.SentMsgRole().getText();
				if (Sentmsg_role.endsWith(SendMessageRole)) {
					Assert.assertTrue(true);
					chattab();
				} else {
					captureScreen("SendMessage");
					Assert.assertTrue(false);
				}
			} else {
				captureScreen("SendMessageCardChat");
				Assert.assertTrue(false);
			}

		}

		else if (Type.equals("Urgent Clinical Review (Urgent)")) {
			msg.TypeOfMessage(Type).click();
			msg.RdbtnUrgentClinicalReview(Clinicalkind).click();
			msg.SetURNumber().sendKeys(URNumber);
			msg.SetName().sendKeys(Name);
			msg.SetDob().sendKeys(Dob);
			msg.SetWard().sendKeys(Ward);
			msg.clickTimeFrame();
			msg.TimeFrameopt(TimeFrame).click();
			msg.TxtDetails().sendKeys(Details);
			msg.ClickSendmsgbtn().click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			msg.btnClose().click();
			Thread.sleep(3000);
			RBC_Chat clock = new RBC_Chat(driver);
			clock.SwitchToFrame();
			String messagecardtext_chat = msg.MessageCardText().getText();
			if (messagecardtext_chat.contains("I've sent your message to the " + SendMessageRole
					+ ". They'll respond to you directly with a chat message.")) {

				Assert.assertTrue(true);
				dashboardtab();
				String Sentmsg_role = msg.SentMsgRole().getText();
				if (Sentmsg_role.endsWith(SendMessageRole)) {
					Assert.assertTrue(true);
					chattab();
				} else {
					captureScreen("SendMessageCardChat");
					Assert.assertTrue(false);
				}

			} else {
				captureScreen("SendMessage");
				Assert.assertTrue(false);
			}
		}

		else {
			msg.TypeOfMessage(Type).click();
			msg.SetURNumber().sendKeys(URNumber);
			msg.SetName().sendKeys(Name);
			msg.SetDob().sendKeys(Dob);
			msg.SetWard().sendKeys(Ward);
			msg.clickTimeFrame();
			msg.TimeFrameopt(TimeFrame).click();
			msg.TxtDetails().sendKeys(Details);
			msg.ClickSendmsgbtn().click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			msg.btnClose().click();
			Thread.sleep(3000);
			RBC_Chat clock = new RBC_Chat(driver);
			clock.SwitchToFrame();
			String messagecardtext_chat = msg.MessageCardText().getText();
			if (messagecardtext_chat.contains("I've sent your message to the " + SendMessageRole
					+ ". They'll respond to you directly with a chat message.")) {
				Assert.assertTrue(true);
				dashboardtab();
				String Sentmsg_role = msg.SentMsgRole().getText();
				if (Sentmsg_role.endsWith(SendMessageRole)) {
					Assert.assertTrue(true);
					chattab();
				} else {
					captureScreen("SendMessageCardChat");
					Assert.assertTrue(false);
				}

			} else {
				captureScreen("SendMessage");
				Assert.assertTrue(false);
			}
		}

	}

}
