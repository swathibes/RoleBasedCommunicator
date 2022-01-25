package com.rbc.testCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rbc.pageObjects.RBC_Chat;

public class RoleSelectValidation extends BaseClass {

	@Test
	@Parameters({ "Role" })
	public void SelectRoleValidation(String Role) throws InterruptedException, IOException {
		RBC_Chat clock = new RBC_Chat(driver);
		WebElement message = clock.getOutputmsg();
		String output = message.getText();
		String msg = "You are already clocked on as the " + Role + " and can't clock on the same role again!";

		if (!msg.equals(output)) {
			dashboardtab();
			String actualtxt = driver.findElement(By.xpath("//div[@class=\"shifts-details\"]/div/div[2]/span[2]"))
					.getText();
			if (actualtxt.contains(Role)) {
				Assert.assertTrue(true);
				logger.info(actualtxt);
				chattab();

			} else {
				captureScreen("SelectRole");
				Assert.assertTrue(false);
				logger.info(output);
			}

		}

	}
}
