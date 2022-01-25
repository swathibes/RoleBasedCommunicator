package com.rbc.testCase;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rbc.pageObjects.RBC_Chat;

public class RoleSelect extends BaseClass {

	@Test
	@Parameters({ "Role" })
	public void SelectRole(String Role) throws InterruptedException, IOException {
		RBC_Chat clock = new RBC_Chat(driver);
		Thread.sleep(8000);
		WebElement role = clock.getRole();
		role.click();
		Thread.sleep(3000);
		WebElement selectrole = clock.findElementUsingText(Role);
		selectrole.click();
		Thread.sleep(3000);
		WebElement BtnConfirm = clock.ClickConfirm();
		BtnConfirm.click();
		Thread.sleep(6000);

	}

}
