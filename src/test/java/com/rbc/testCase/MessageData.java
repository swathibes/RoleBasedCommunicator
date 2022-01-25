package com.rbc.testCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rbc.pageObjects.MessageDlgBox;
import com.rbc.utilities.XLUtils;

public class MessageData extends BaseClass {
	String Path = "C:/Users/SwathiBestha/eclipse-workspace/SeleniumPractice/src/test/java/com/rbc/testData/Data.xlsx";
	String sheetName = "MessageData";
	XLUtils excel = null;

	@Test(dataProvider = "userData")
	public void MessageData1(String Type, String TimeFrame, String Details) throws InterruptedException {
		MessageDlgBox msg = new MessageDlgBox(driver);
		msg.TypeOfMessage(Type).click();
		msg.clickTimeFrame();
		msg.TimeFrameopt(TimeFrame).click();
		msg.TxtDetails().sendKeys(Details);
		Thread.sleep(3000);
	}

	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception {
		Object[][] data = testData(Path, sheetName);
		return data;
	}

	public Object[][] testData(String Path, String sheetName) throws Exception {
		Object[][] excelData = null;
		excel = new XLUtils();
		int rows = XLUtils.getRowCount(Path, "Sheet1");
		int columns = XLUtils.getCellCount(Path, "Sheet1", 1);

		excelData = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				excelData[i - 1][j] = XLUtils.getCellData(Path, "MessageData", i, j);
				;
			}

		}
		return excelData;
	}
}