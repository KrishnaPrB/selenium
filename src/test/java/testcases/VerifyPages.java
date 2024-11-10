package testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonmethods.PropertyValue;
import driversinit.Drivers;
import pageobjects.ContractPage;
import pageobjects.Header;

public class VerifyPages extends Drivers {

	@Test
	public void tc06_contractForm() throws IOException {

		// create object
		Header headerPage = new Header(driver);
		ContractPage contractPage = new ContractPage(driver);

		// Click on 'Contact Us' button
		headerPage.contactBtn.click();

		// Enter name, email, subject and message
		String name = PropertyValue.getProperty("username");
		String email = PropertyValue.getProperty("userID");
		String message = "Adding message";
		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\uploadfile.png";

		contractPage.addContracts(name, email, email, message, filepath);

		// click on 'OK'
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Verify success message 'Success! Your details have been submitted
		// successfully.' is visible

		wait.until(ExpectedConditions.visibilityOf(contractPage.successMessage));
		String successMessage = contractPage.successMessage.getText();
		String requiredMessage = "Success! Your details have been submitted successfully.";
		Assert.assertEquals(successMessage, requiredMessage);

		// Click 'Home' button and verify that landed to home page successfully
		headerPage.homeBtn.click();

		Assert.assertEquals(driver.getTitle(), "Automation Exercise");

	}

}
