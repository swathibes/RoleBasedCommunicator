package com.rbc.testCase;

import org.testng.annotations.Test;

import com.rbc.pageObjects.RBC_Chat;

public class ClockOnRoleFromChat extends BaseClass {

	@Test
	public void ClockOnRoleeee() throws InterruptedException {
		RBC_Chat clock = new RBC_Chat(driver);
		Thread.sleep(5000);
		clock.SwitchToFrame();
		Thread.sleep(6000);
		clock.clockOnrole();
		Thread.sleep(10000);

	}

}
