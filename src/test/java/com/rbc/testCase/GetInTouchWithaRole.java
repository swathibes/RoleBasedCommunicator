package com.rbc.testCase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rbc.pageObjects.RBC_Chat;

public class GetInTouchWithaRole extends BaseClass {

	@Test
	@Parameters({ "SendMessageRole" })
	public void GetInTouch(String SendMessageRole) throws InterruptedException, IOException {
		RBC_Chat clock = new RBC_Chat(driver);
		RoleSelect selectrole = new RoleSelect();
		WebElement getintouch = clock.getintouch();
		WebElement textbox = clock.gettextbox();
		Thread.sleep(3000);
		textbox.sendKeys("Get in touch");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(getintouch).click().perform();
		textbox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		selectrole.SelectRole(SendMessageRole);
		Thread.sleep(5000);

	}

}
