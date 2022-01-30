package com.rbc.testCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeSuite;

import com.rbc.pageObjects.MessageDlgBox;
import com.rbc.pageObjects.RBC_Chat;
import com.rbc.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseurl = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public String edgepath = readconfig.getEdgePath();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeSuite
	public void SetUp() {
		logger = Logger.getLogger("RoleBasedCommunicator");
		PropertyConfigurator.configure("Log4j.properties");
		System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("-inprivate");
		driver = new EdgeDriver(edgeOptions);

		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	/*
	 * @AfterSuite public void tearDown() { driver.quit(); }
	 */

	public static void captureScreen(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public static void dashboardtab() throws InterruptedException {
		RBC_Chat clock = new RBC_Chat(driver);
		WebElement dashboardtab = clock.ClickDashboard();
		driver.switchTo().defaultContent();
		dashboardtab.click();
		Thread.sleep(3000);
		clock.SwitchToDashboard();

	}

	public static void chattab() throws InterruptedException {
		RBC_Chat clock = new RBC_Chat(driver);
		WebElement chattab = clock.Chat();
		driver.switchTo().defaultContent();
		chattab.click();
		Thread.sleep(3000);
		clock.SwitchToFrame();
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//html")).click();
		Thread.sleep(3000);

	}

	public static void SwitchToMsgDlgBox() throws InterruptedException {
		// String mainHandle = driver.getWindowHandle();
		String[] handles = driver.getWindowHandles().toArray(new String[0]);
		driver.switchTo().window(handles[handles.length - 1]);
		MessageDlgBox msg = new MessageDlgBox(driver);
		WebElement msgFrame = msg.MsgWd();
		driver.switchTo().frame(msgFrame);

	}

}
