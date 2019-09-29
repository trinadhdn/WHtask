package com.PageObject.wallethubRating;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.walletHub.DefaultTest.DefaultTest;
import com.walletHub.SeleniumHandler.seleniumCommanMethods;

import junit.framework.Assert;

public class WalletHubReviewPage extends seleniumCommanMethods {

	static Logger log = Logger.getLogger(WalletHubReviewPage.class);

	public static String email = "";
	public static String passWord = "";

	private By loginLink = By.xpath("//nav[@class='burger-menu-right-menu brgm-guest-user']//*[text()='Login']");
	private By emailField = By.xpath("//input[@name='em']");
	private By pSWField = By.xpath("//input[@name='pw']");
	private By loginButton = By.xpath("//span[text()='Login']/parent::button");
	private By profileName = By.xpath("//*[@class='profile-name']");
	private By stars = By.xpath("//*[@class='rvs-svg']//*[@class='rating-box-wrapper']/*[@class='rvs-star-svg']/*/*");
	private By selectPolicyDropDownBtn = By.xpath("//div[contains(@class,'dropdown second')]/span");
	private By selectPolicyDropDownList = By.xpath("//div[contains(@class,'dropdown second')]/span/parent::*/ul/li");
	private By writeReviewText = By
			.xpath("//*[@class='textarea wrev-user-input validate' or contains(placeholder,'Write your review')]");

	private By submitBtn = By.xpath("//div[text()='Submit']");
	
	private By profileLink = By.xpath("//*[@class='brgm-button brgm-user brgm-list-box']");

	private By profileOptions = By.xpath("//*[@class='brgm-button brgm-user brgm-list-box']//*[@class='brgm-list-it']");
	
	private By reviewLinks = By.xpath("//div[@class='pr-rec-texts-container']/a");
	
	private By reviewText= By.xpath("//*[@class='rvtab-citem rvtab-item-user ng-enter-element']//div[@itemprop='description']");

	
	public String reviewString = "Good health insurance in the market . Recommend! Good health insurance in the market . Recommend! Good health insurance in the market . Recommend!Good health insurance in the market . Recommend! Good health insurance in the market . Recommend! Good health insurance in the market . Recommend!";

	private String policyName="Test Insurance Company";

	/**
	 * s Check if Home page is ready or not
	 *
	 * @return the WalletHub Review Home Page is ready or not
	 */

	public boolean isHomePageReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isHomePageReady method");

		boolean isReady = false;
		if (this.isElementVisibleByElement(profileName, TIMEOUT) && this.isElementVisibleByElement(stars, TIMEOUT)) {
			isReady = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - end isHomePageReady method");

		return isReady;
	}

	/**
	 * ClickOnLogin
	 *
	 */

	public void clicOnLoginLink() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clicOnLoginLink method");

		this.getElementByElement(loginLink, TIMEOUT).click();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - end clicOnLoginLink method");

	}

	/**
	 * Check if page is ready or not
	 *
	 * @return the WalletHub Review login page is ready or not
	 */

	public boolean isLoginPageReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isLoginPageReady method");

		boolean isReady = false;
		if (this.isElementVisibleByElement(emailField, TIMEOUT) && this.isElementVisibleByElement(pSWField, TIMEOUT)
				&& this.isElementVisibleByElement(loginButton, TIMEOUT)) {
			isReady = true;
		}
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - end isLoginPageReady method");

		return isReady;
	}

	/**
	 * Wait until the page is loaded well
	 */

	public void waitForHomePageReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start waitForHomePageReady method");

		this.waitForByElement(profileName, TIMEOUT);
		this.waitForByElement(stars, TIMEOUT);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End waitForHomePageReady method");
	}

	/**
	 * Wait until the page is loaded well
	 */

	public void waitForLoginPageReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start waitForLoginPageReady method");

		this.waitForByElement(emailField, TIMEOUT);
		this.waitForByElement(pSWField, TIMEOUT);
		this.waitForByElement(loginButton, TIMEOUT);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End waitForLoginPageReady method");
	}

	/**
	 * Fill login page details and click on Login
	 */

	public void fillEmailandPasswordThenClickOnLogin() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - Start fillEmailandPasswordThenClickOnLogin method");

		this.getElementByElement(emailField, TIMEOUT).clear();
		this.getElementByElement(emailField, TIMEOUT).sendKeys(email);
		this.getElementByElement(pSWField, TIMEOUT).clear();
		this.getElementByElement(pSWField, TIMEOUT).sendKeys(passWord);
		this.getElementByElement(loginButton, TIMEOUT).click();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName()
				+ " - End fillEmailandPasswordThenClickOnLogin method");
	}

	/**
	 * mouseOver on starts
	 */

	public void mouseOverOnStars(int number) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start mouseOverOnStars method");

		List<WebElement> list = this.getElementsByElement(stars, TIMEOUT);

		this.mouseAndKeyBoardAction().moveToElement(list.get(number - 1)).build().perform();

		list = this.getElementsByElement(stars, TIMEOUT);

		for (int i = 0; i <= list.size() - 1; i++) {
			try {

				if (i <= (number * 2) - 1) {
					if (!(list.get(i).getAttribute("stroke") == null)) {
						Assert.assertTrue("Stars are NOT filled with color",
								list.get(i).getAttribute("stroke").equals("#4ae0e1"));
					}
				} else {
					Assert.assertTrue("Stars are NOT filled with color ", list.get(i).getAttribute("stroke") == null
							&& list.get(i).getAttribute("fill").equals("#e4e9eb"));

				}

			} catch (Exception e) {
				e.printStackTrace();
				DefaultTest.driver.getPageSource();
				list = this.getElementsByElement(stars, TIMEOUT);
			}
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End mouseOverOnStars method");
	}

	/**
	 * mouseOver on starts
	 */

	public void clickOnStars(int number) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start clickOnStars method");

		int i = number - 1;
		List<WebElement> list = this.getElementsByElement(stars, TIMEOUT);

		if (list.size() > 5) {
			i = (number * 2) - 2;
		}
		this.mouseAndKeyBoardAction().click((list.get(i))).build().perform();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End clickOnStars method");
	}


	/**
	 * Enter review and submit
	 */

	public void enterReviewAndSubmit() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start selectInsuranceDropDown method");

		this.getElementByElement(writeReviewText, TIMEOUT).sendKeys(reviewString);

		this.getElementByElement(submitBtn, TIMEOUT).click();

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End selectInsuranceDropDown method");
	}

	/**
	 * Enter review and submit
	 */

	public void verifyReviewPost() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start selectInsuranceDropDown method");

		this.getElementByElement(profileLink, TIMEOUT).click();
		
		if(!this.getElementByElement(profileOptions, TIMEOUT).isDisplayed()){
			this.getElementByElement(profileLink, TIMEOUT).click();

		}

		this.selecPickListByVisibleText(profileOptions, "Profile");
		
		List<WebElement> list = this.getElementsByElement(reviewLinks, TIMEOUT);
		
		for(WebElement eachItem : list){
			
			if(eachItem.getText().equalsIgnoreCase(policyName)){
				
				eachItem.click();
			}
		}
		

		Assert.assertTrue("Review Not Found", this.isElementVisibleByElement(reviewText, TIMEOUT) && this.getElementByElement(reviewText, TIMEOUT).getText().equals(reviewString));
		

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End selectInsuranceDropDown method");
	}

	/**
	 * Select insurance dropDown
	 */

	public void selectInsuranceDropDown(String dropDownValue) {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start selectInsuranceDropDown method");

		this.getElementByElement(selectPolicyDropDownBtn, TIMEOUT).click();

		this.selecPickListByVisibleText(selectPolicyDropDownList, dropDownValue);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End selectInsuranceDropDown method");
	}
}
