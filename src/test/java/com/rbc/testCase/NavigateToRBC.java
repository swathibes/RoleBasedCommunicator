package com.rbc.testCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rbc.pageObjects.LoginPage;

public class NavigateToRBC extends BaseClass {

	@Test
	public void RoleBaseCommunicator() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.clickonRBC();

		// Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Role-based Communicator | Microsoft Teams"));

		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Role-based")) {
			Assert.assertTrue(true);
		} else {
			captureScreen("RoleBaseCommunicator");
			Assert.assertTrue(false);
		}

		Thread.sleep(3000);
		WebElement turnon = lp.ClickOnTurnOn();
		turnon.click();
		// driver.switchTo().alert().accept();

	}

}
