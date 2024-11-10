package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLogin {
	private WebDriver driver;

	// ****************************************************************************************************************

	// login

	@FindBy(className = "login-form")
	public WebElement loginForm;

	@FindBy(xpath = "//div[@class='login-form']//input[@type='email']")
	private WebElement loginEmailInput;

	@FindBy(xpath = "//div[@class='login-form']//input[@type='password']")
	private WebElement loginPasswordInput;

	@FindBy(xpath = "//div[@class='login-form']//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//div[@class='login-form']//h2")
	public WebElement loginHeaderText;

	// Signup
	@FindBy(className = "signup-form")
	public WebElement signInForm;

	@FindBy(xpath = "//div[@class='signup-form']//input[@type='email']")
	public WebElement signInEmailInput;

	@FindBy(xpath = "//div[@class='signup-form']//input[@name='name']")
	private WebElement signInNameInput;

	@FindBy(xpath = "//div[@class='signup-form']//button[@type='submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@class='signup-form']//h2")
	public WebElement signInHeaderText;

	// ***************************************************************************************************************

	public SignUpLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterLoginForm(String userEmail, String userPassword) {
		loginEmailInput.sendKeys(userEmail);
		loginPasswordInput.sendKeys(userPassword);
		loginBtn.click();
	}

	public void enterSignInForm(String userName, String userEmail) {
		signInNameInput.sendKeys(userName);
		signInEmailInput.sendKeys(userEmail);
		submitBtn.click();
	}

}
