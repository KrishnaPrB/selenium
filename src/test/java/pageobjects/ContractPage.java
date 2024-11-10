package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractPage {
	WebDriver driver;

	// *************************************************************************************

	@FindBy(xpath = "//div[@class='contact-form']//input[@name='email']")
	private WebElement contractName;

	@FindBy(xpath = "//div[@class='contact-form']//input[@name='email']")
	private WebElement contractEmail;

	@FindBy(xpath = "//div[@class='contact-form']//input[@name='subject']")
	private WebElement contractSubject;

	@FindBy(xpath = "//div[@class='contact-form']//textarea[@id='message']")
	private WebElement contractMessage;

	@FindBy(xpath = "//div[@class='contact-form']//input[@name='upload_file']")
	private WebElement fileUpload;

	@FindBy(xpath = "//div[@class='contact-form']//input[@name='submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "(//div[contains(@class,'alert-success')])[1]")
	public WebElement successMessage;

	// *************************************************************************************

	public ContractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addContracts(String name, String email, String subject, String message, String filePath) {
		contractName.sendKeys(name);
		contractEmail.sendKeys(email);
		contractSubject.sendKeys(subject);
		contractMessage.sendKeys(message);
		fileUpload.sendKeys(filePath);

		submitBtn.click();

	}

}
