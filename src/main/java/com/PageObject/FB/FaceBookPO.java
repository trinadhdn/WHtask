package com.PageObject.FB;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.walletHub.SeleniumHandler.seleniumCommanMethods;

public class FaceBookPO extends seleniumCommanMethods {

	static Logger log = Logger.getLogger(FaceBookPO.class);

	public static String email = "";
	public static String passWord = "";

	private By emailOrPhone = By.id("email");
	private By facebook = By.cssSelector("a[title='Go to Facebook home']");
	private By login = By.xpath("//input[@type='submit' and @value='Log In']");
	private By forgottenAccount = By
			.cssSelector("a[href='https://www.facebook.com/recover/initiate?lwv=110&ars=royal_blue_bar']");
	private By password = By.id("pass");
	private By home = By.cssSelector("a[href='https://www.facebook.com/?ref=tn_tnmn']");
	private By welcome = By.cssSelector("a[title='Welcome']");
	private By createPost = By.xpath("//span[text()='Create post']");
	private By writePost = By.xpath(
			"//div[@role='presentation']//*[(text()='Write something here...')]/parent::div/following::*[@role='textbox']");
	private By postStory = By.xpath("//span[text()='Post']//parent::*[@type='submit']");

	public String postString;

	/**
	 * Check if Home page is ready or not
	 *
	 * @return the FaceBook Home Page is ready or not
	 */

	public boolean isHomePageReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isHomePageReady method");

		boolean isReady = false;
		if (this.isElementVisibleByElement(home, TIMEOUT) && this.isElementVisibleByElement(welcome, TIMEOUT)
				&& this.isElementVisibleByElement(createPost, TIMEOUT)) {
			isReady = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - end isHomePageReady method");

		return isReady;
	}

	/**
	 * Check if page is ready or not
	 *
	 * @return the FaceBook login page is ready or not
	 */

	public boolean isLoginPageReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isLoginPageReady method");

		boolean isReady = false;
		if (this.isElementVisibleByElement(emailOrPhone, TIMEOUT) && this.isElementVisibleByElement(facebook, TIMEOUT)
				&& this.isElementVisibleByElement(forgottenAccount, TIMEOUT)
				&& this.isElementVisibleByElement(password, TIMEOUT)
				&& this.isElementVisibleByElement(login, TIMEOUT)) {
			isReady = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - end isLoginPageReady method");

		return isReady;
	}

	/**
	 * Wait until the page is loaded well
	 */

	public void waitForReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start waitForReady method");

		this.waitForByElement(emailOrPhone, TIMEOUT);
		this.waitForByElement(facebook, TIMEOUT);
		this.waitForByElement(forgottenAccount, TIMEOUT);
		this.waitForByElement(password, TIMEOUT);
		this.waitForByElement(login, TIMEOUT);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End waitForReady method");
	}

	/**
	 * Wait until the page is loaded well
	 */

	public void waitForHomePageReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start waitForReady method");

		this.waitForByElement(home, TIMEOUT);
		this.waitForByElement(welcome, TIMEOUT);
		this.waitForByElement(createPost, TIMEOUT);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End waitForReady method");
	}

	/**
	 * Fill login page details and click on Login
	 */

	public void fillEmailandPasswordThenClickOnLogin() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start fillEmailandPassword method");

		this.getElementByElement(emailOrPhone, TIMEOUT).clear();
		this.getElementByElement(emailOrPhone, TIMEOUT).sendKeys(email);
		this.getElementByElement(password, TIMEOUT).clear();
		this.getElementByElement(password, TIMEOUT).sendKeys(passWord);
		this.getElementByElement(login, TIMEOUT).click();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End fillEmailandPassword method");
	}

	/**
	 * create a fb post
	 */

	public void createFBPost() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start createFBPost method");

		this.getElementByElement(createPost, TIMEOUT).click();
		this.getElementByElement(writePost, TIMEOUT).clear();
		this.getElementByElement(writePost, TIMEOUT).sendKeys(postString);
		this.getElementByElement(postStory, TIMEOUT).click();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End createFBPost method");
	}

}
