package com.rbc.testCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rbc.pageObjects.MessageDlgBox;
import com.rbc.pageObjects.RBC_Chat;

public class GetInTouchWithaRoleValidation extends BaseClass {

	@Test
	@Parameters({ "Teamoption" })
	public void GetInTouchValidation(String Teamoption) throws InterruptedException {
		RBC_Chat chat = new RBC_Chat(driver);
		MessageDlgBox msg = new MessageDlgBox(driver);
		WebElement sendmessage1 = chat.SendMessage();
		WebElement options = chat.MultipleShifts();
		List<WebElement> dashboardshifts = chat.DashBoardShifts();
		WebElement dashboardshift1 = chat.DashBoardShift();
		dashboardtab();

		if (dashboardshifts.size() == 0) {
			chattab();
			sendmessage1.click();
			Thread.sleep(3000);
			SwitchToMsgDlgBox();
			msg.clickOnTeamDropDown();
			msg.clickOnTeamDropDownOptions(Teamoption).click();

		} else if (dashboardshift1.getText().endsWith("more")) {
			chattab();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement selectoptions = wait.until(ExpectedConditions.elementToBeClickable(options));
			selectoptions.click();
			Thread.sleep(10000);
			sendmessage1.click();
			Thread.sleep(3000);
			SwitchToMsgDlgBox();

		} else {
			chattab();
			Actions act = new Actions(driver);
			act.moveToElement(sendmessage1).click().perform();
			Thread.sleep(10000);
			SwitchToMsgDlgBox();

		}

	}
}
