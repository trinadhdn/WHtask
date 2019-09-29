package com.walletHub.SeleniumHandler;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walletHub.DefaultTest.DefaultTest;

public abstract class seleniumCommanMethods extends Thread {

	/**
	 * Components
	 */
	public long TIMEOUT = 25; // Seconds

	static Logger log = Logger.getLogger(seleniumCommanMethods.class);

	WebElement element;

	List<WebElement> elements;

	/**
	 * This method identifies element with id and returns element
	 */
	public WebElement getElementByElement(By byelement, long timeOut) {
		this.driverWait((byelement), timeOut);
		return element = DefaultTest.driver.findElement((byelement));
	}

	/**
	 * This method identifies element with id and returns element
	 */
	public List<WebElement> getElementsByElement(By byelement, long timeOut) {
		this.driverWait((byelement), timeOut);
		return elements = DefaultTest.driver.findElements((byelement));
	}

	/**
	 * This method identifies element with id and returns element
	 */
	public Actions mouseAndKeyBoardAction() {
		Actions actions = new Actions(DefaultTest.driver);
		return actions;
	}

	/**
	 * This method checks if a {@link WebElement} is displayed and visible for
	 * selenium. By Name
	 * 
	 * @param key
	 *            of the item to be selected. In the related selector file
	 *            should exists with key.name
	 * @param timeOut
	 *            limit for wait until appear.
	 * @return true if the element exists and it's visible.
	 */
	public boolean isElementVisibleByElement(By byelement, long timeOut) {
		boolean showed = false;
		WebElement element = this.getElementByElement(byelement, timeOut);
		if (!element.equals("")) {
			showed = true;
		}
		return showed;
	}

	/**
	 * This method checks is init wait method
	 */
	public void driverWait(By byelement, long seconds) {

		WebDriverWait w = new WebDriverWait(DefaultTest.driver, seconds);
		try {
			w.until(ExpectedConditions.presenceOfElementLocated(byelement));
		} catch (TimeoutException e) {
		}

	}

	/**
	 * This method wait for an element
	 */

	public void waitForByElement(By byelement, long timeOut) {

		this.driverWait(byelement, timeOut);

	}
	
	

	/**
	 * Method to select options from dropdown ByVisibleText
	 * 
	 * @param By
	 *            of the picklist/DropDown field
	 * @param PickList
	 *            name
	 */
	public void selecPickListByVisibleText(By xpathOfPickList, String visibleText) {

		List<WebElement> list = this.getElementsByElement(xpathOfPickList, TIMEOUT);

		for (WebElement item : list) {

			if (item.getText().equalsIgnoreCase(visibleText)) {

				item.click();
				break;
			}

		}

	}

}
