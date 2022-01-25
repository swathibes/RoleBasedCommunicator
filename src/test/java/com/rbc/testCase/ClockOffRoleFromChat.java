package com.rbc.testCase;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.rbc.pageObjects.RBC_Chat;

public class ClockOffRoleFromChat extends BaseClass {

	@Test
	public void ClockOffRoleeee() throws InterruptedException {
		RBC_Chat clock = new RBC_Chat(driver);
		WebElement textbox = clock.gettextbox();
		ClockedOnRoleListFromDashboard clockoffrole = new ClockedOnRoleListFromDashboard();
		List<String> list = clockoffrole.MultipleClockoff();
		for (int i = 0; i < list.size(); i++) {
			String rolelist = list.get(i);
			chattab();
			Thread.sleep(3000);
			textbox.sendKeys("Clock off a role");
			Thread.sleep(2000);
			textbox.sendKeys(Keys.ENTER);
			textbox.sendKeys(Keys.ENTER);
			// clock.clockOffrole();
			Thread.sleep(8000);
			WebElement multiplerole = clock.clockoffbtn(rolelist);
			multiplerole.click();

			// clock.BtnClockoff().click();
			Thread.sleep(6000);

			System.out.println(rolelist);
		}

	}

}
