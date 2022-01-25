package com.rbc.testCase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.rbc.pageObjects.Dashboard;

public class ClockedOnRoleListFromDashboard extends BaseClass {

	public ArrayList<String> MultipleClockoff() throws InterruptedException {

		Dashboard clockoff = new Dashboard(driver);
		dashboardtab();
		Thread.sleep(4000);
		WebElement clockoffbtn = clockoff.ClickClockoffbtn();
		ArrayList<String> multipleroles = new ArrayList<>();
		try {
			if (clockoffbtn.isDisplayed()) {
				clockoffbtn.click();
				Thread.sleep(3000);
				List<WebElement> clockoffroles = clockoff.getclockoffmultipleroles();
				int size = clockoffroles.size();
				for (int i = 0; i < size; i++) {

					String role = clockoffroles.get(i).getText();
					multipleroles.add(role);

				}

			}
		} catch (Exception e) {
			chattab();
		}
		return multipleroles;

	}
}
