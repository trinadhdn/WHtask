package com.walletHub.DefaultTest;

import java.lang.reflect.Method;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.walletHub.BrowserHandler.BrowsersHandler;
import com.walletHub.SeleniumHandler.seleniumCommanMethods;

public abstract class DefaultTest {
	public static WebDriver driver;
	protected String tcName = "";
	public seleniumCommanMethods seleniumCommanMethods;

	public void nameBefore(Method method) {
		this.tcName = method.getName();
	}

	public void before() {
		BasicConfigurator.configure();
		driver = BrowsersHandler.browserInitialize();

	}

	public void afterAllIsSaidAndDone() {

		if (driver != null) {
			try {
				driver.manage().deleteAllCookies();
				driver.quit();
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}

}
