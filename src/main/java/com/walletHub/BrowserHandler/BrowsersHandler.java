package com.walletHub.BrowserHandler;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowsersHandler {

	private static String browser;
	private static String url;

	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browser) {
		BrowsersHandler.browser = browser;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		BrowsersHandler.url = url;
	}

	// **** Driver initialization method ****//
	public static WebDriver browserInitialize() {
		WebDriver driver = null;

		// Driver initialization
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/resources/files/software/geckodriver.exe");
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			firefoxProfile.setPreference("dom.webnotifications.enabled", false);

			FirefoxOptions options = new FirefoxOptions();

			options.setCapability("enableVNC", true);
			options.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
			options.setCapability("marionette", true);

			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/resources/files/software/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities);

		}
		driver.get(url);

		return driver;
	}
}
