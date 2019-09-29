package com.walletHubReview.testCases;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObject.wallethubRating.WalletHubReviewPage;
import com.walletHub.BrowserHandler.BrowsersHandler;
import com.walletHub.DefaultTest.DefaultTest;

import junit.framework.Assert;

public class WalletReviewTestCases extends DefaultTest {

	@BeforeClass(description = "startTest Clss")
	public void beforeClss() {
		BrowsersHandler.setBrowser("chrome"); // firefox or chrome
		BrowsersHandler.setUrl("http://wallethub.com/profile/test_insurance_company/");
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	@Test(description = "FaceBook functionality Test")
	public void whFunctionalityTest(Method method) {

		WalletHubReviewPage wh = new WalletHubReviewPage();

		wh.clicOnLoginLink();

		wh.waitForLoginPageReady();// waiting for page to be loaded
		Assert.assertTrue("Login page is not ready", wh.isLoginPageReady());

		// set credentials for login

		/******
		 * PLEASE NOTE THAT BELOW DETAILS ARE ALREADY USED IN MY TEST , so
		 * please use new for execution to avoid failure as system is allow to
		   give only one review.
		 * Just replace below username and password and run the file
		 ******/

		wh.email = "trinadh.work19@gmail.com";
		wh.passWord = "ND3nadh33!9";

		// Fill the details in login screen and login to wh
		wh.fillEmailandPasswordThenClickOnLogin();

		// waiting for page to be loaded
		wh.waitForHomePageReady();
		// asserting whether Home page is loaded or not
		Assert.assertTrue("Login is not ready", wh.isHomePageReady());

		// Mouse Hower on stars
		wh.mouseOverOnStars(4);

		// Click on Stars
		wh.clickOnStars(4);

		// Select policy dropDown
		wh.selectInsuranceDropDown("Health Insurance");

		// Enter text and sublit review
		wh.enterReviewAndSubmit();

		// verify the post
		wh.verifyReviewPost();

	}

}
