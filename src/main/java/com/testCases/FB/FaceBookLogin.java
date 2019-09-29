package com.testCases.FB;

import java.lang.reflect.Method;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObject.FB.FaceBookPO;
import com.walletHub.BrowserHandler.BrowsersHandler;
import com.walletHub.DefaultTest.DefaultTest;

import junit.framework.Assert;

public class FaceBookLogin extends DefaultTest {

	@BeforeClass(description = "startTest Clss")
	public void beforeClss() {
		BrowsersHandler.setBrowser("chrome"); // firefox or chrome
		BrowsersHandler.setUrl("https://www.facebook.com/");// set url here
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	@Test(description = "FaceBook functionality Test")
	public void fbFunctionalityTest(Method method) {

		FaceBookPO fb = new FaceBookPO();

		fb.waitForReady();// waiting for page to be loaded

		Assert.assertTrue("Login page is not ready", fb.isLoginPageReady());

		// set credentials for login
		fb.email = "EMAIL@gmail.com";
		fb.passWord = "PASSWORD";

		// Fill the details in login screen and login to FB
		fb.fillEmailandPasswordThenClickOnLogin();

		// set "post" data
		fb.postString = "Hello World";

		// waiting for page to be loaded
		fb.waitForHomePageReady();
		// asserting whether Home page is loaded or not
		Assert.assertTrue("Login is not ready", fb.isHomePageReady());

		// posting the status
		fb.createFBPost();

	}

}
