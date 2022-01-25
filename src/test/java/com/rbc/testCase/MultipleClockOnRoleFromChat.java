package com.rbc.testCase;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rbc.pageObjects.RBC_Chat;

public class MultipleClockOnRoleFromChat extends BaseClass {

	@Test
	@Parameters({ "role1", "role2", "role3", "role4" })
	public void ClockOnMultipleRoles(String role1, String role2, String role3, String role4)
			throws InterruptedException, IOException {
		ArrayList<String> listofroles = new ArrayList<>();
		listofroles.add(role1);
		listofroles.add(role2);
		listofroles.add(role3);
		listofroles.add(role4);
		int size = listofroles.size();
		RBC_Chat clock = new RBC_Chat(driver);
		WebElement textbox = clock.gettextbox();
		Thread.sleep(5000);
		clock.SwitchToFrame();
		Thread.sleep(3000);
		clock.clockOnrole();
		Thread.sleep(10000);

		for (int i = 0; i < size; i++) {

			String getRole = listofroles.get(i);

			WebElement role = clock.getRole();
			role.click();
			Thread.sleep(3000);
			WebElement selectrole = clock.findElementUsingText(getRole);
			selectrole.click();
			Thread.sleep(3000);
			WebElement BtnConfirm = clock.ClickConfirm();
			BtnConfirm.click();
			Thread.sleep(6000);
			WebElement message = clock.getOutputmsg();
			String output = message.getText();
			String msg = "You are already clocked on as the " + getRole + " and can't clock on the same role again!";

			if (!msg.equals(output)) {
				dashboardtab();
				String actualtxt = driver.findElement(By.xpath("//div[@class=\"shifts-details\"]/div/div[2]/span[2]"))
						.getText();
				if (actualtxt.contains(getRole)) {
					Assert.assertTrue(true);
					logger.info(actualtxt);
					chattab();
					Thread.sleep(3000);
					textbox.sendKeys("Clock on to a role");
					Thread.sleep(2000);
					textbox.sendKeys(Keys.ENTER);
					textbox.sendKeys(Keys.ENTER);
					Thread.sleep(8000);
				} else {
					captureScreen("SelectRole");
					Assert.assertTrue(false);
					logger.info(output);
				}

			}
		}
	}

}
