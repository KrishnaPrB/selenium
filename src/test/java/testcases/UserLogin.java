package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonmethods.PropertyValue;
import driversinit.Drivers;
import pageobjects.Header;
import pageobjects.SignUpLogin;

public class UserLogin extends Drivers {

	@Test(groups = { "login" })
	public void tc03_incorrectEmailPassword() throws IOException {
		// declare objects

		Header header = new Header(driver);
		SignUpLogin loginPage = new SignUpLogin(driver);

		// Verify that home page is visible successfully
		homePageVisibility(header);

		// Click on 'Signup / Login' button
		header.loginBtn.click();

		// Verify 'Login to your account' is visible
		loginFormVisibility(loginPage);

		// Enter incorrect email address and password
		String emailString = PropertyValue.getProperty("userID");
		String invalidPasswordString = "invalid@password";
		loginPage.enterLoginForm(emailString, invalidPasswordString);

		// check "Your email or password is incorrect!" is visible

		WebElement message = loginPage.loginForm.findElement(By.xpath("//p"));
		wait.until(ExpectedConditions.visibilityOf(message));

		String messageString = message.getText();
		String messageColorString = message.getAttribute("style");

		Assert.assertEquals(messageString, "Your email or password is incorrect!");
		Assert.assertEquals(messageColorString, "color: red;");

	}

	@Test(groups = { "login" })
	public void tc04_logOut() throws IOException {
		// declare objects

		Header header = new Header(driver);
		SignUpLogin loginPage = new SignUpLogin(driver);

		// Verify that home page is visible successfully
		homePageVisibility(header);

		// Click on 'Signup / Login' button
		header.loginBtn.click();

		// Verify 'Login to your account' is visible
		loginFormVisibility(loginPage);

		// Enter incorrect email address and password
		String emailString = PropertyValue.getProperty("userID");
		String passwordString = PropertyValue.getProperty("password");
		loginPage.enterLoginForm(emailString, passwordString);

		// Verify that 'Logged in as username' is visible
		wait.until(ExpectedConditions.visibilityOf(header.userName));
		String userNameMessageString = header.userName.getText();
		String expectedNameString = "Logged in as " + PropertyValue.getProperty("username");
		Assert.assertEquals(userNameMessageString, expectedNameString);

		// Click 'Logout' button
		header.logOutBtn.click();

		// Verify that user is navigated to login page
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Automation Exercise - Signup / Login");
		Assert.assertTrue(loginPage.loginForm.isDisplayed());

	}

	@Test(groups = { "signup" })
	public void tc05_registerExitingUser() throws IOException {
		// declare objects

		Header header = new Header(driver);
		SignUpLogin loginPage = new SignUpLogin(driver);

		// Verify that home page is visible successfully
		homePageVisibility(header);

		// Click on 'Signup / Login' button
		header.loginBtn.click();

		// Verify 'New User Signup!' is visible
		signInFormVisibility(loginPage);

		// Enter name and already registered email address
		String userEmailString = PropertyValue.getProperty("userID");
		String userNameString = PropertyValue.getProperty("password");
		loginPage.enterSignInForm(userNameString, userEmailString);

		// Verify error 'Email Address already exist!' is visible
		wait.until(ExpectedConditions.visibilityOf(loginPage.signInHeaderText));
		String signIntext = loginPage.signInForm.findElement(By.xpath("//p")).getText();
		Assert.assertEquals(signIntext, "Email Address already exist!");

	}

	public void homePageVisibility(Header header) {
		String homeColorString = header.homeBtn.getAttribute("style");
		String getTitleString = driver.getTitle();
		Assert.assertEquals(homeColorString, "color: orange;");
		Assert.assertEquals(getTitleString, "Automation Exercise");

	}

	public void loginFormVisibility(SignUpLogin loginPage) {
		String loginHeaderTextString = loginPage.loginHeaderText.getText();
		Assert.assertEquals(loginHeaderTextString, "Login to your account");

	}

	public void signInFormVisibility(SignUpLogin signInPage) {
		String signInHeaderString = signInPage.signInHeaderText.getText();
		Assert.assertEquals(signInHeaderString, "New User Signup!");
	}

}
