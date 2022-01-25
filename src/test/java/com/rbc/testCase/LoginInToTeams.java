package com.rbc.testCase;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rbc.pageObjects.LoginPage;

public class LoginInToTeams extends BaseClass {

	@Test
	public void LoginTest() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.clickSignin();

		// Switch to child window
		String Parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			String child = it.next();
			if (!Parent.equals(child)) {
				driver.switchTo().window(child);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				lp.setEmail(username);
				lp.clickSignin1();

				Thread.sleep(3000);
				lp.setPassword(password);
				lp.ClickSignin2();

				lp.ClickSignin3();

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.titleContains("Navigator"));

				String title = driver.getTitle();
				System.out.println(title);
				if (title.equals("Navigator | Microsoft Teams")) {
					Assert.assertTrue(true);
				} else {
					captureScreen("LoginTest");
					Assert.assertTrue(false);
				}
			}
		}
	}

}
