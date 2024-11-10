package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
	WebDriver driver;

	// ************************************************************************************************

	// locators

	@FindBy(xpath = "//header//a[text()=' Home']")
	public WebElement homeBtn;

	@FindBy(xpath = "//header//a[text()=' Products']")
	public WebElement productsBtn;

	@FindBy(xpath = "//header//a[text()=' Cart']")
	public WebElement cartBtn;

	@FindBy(xpath = "//header//a[text()=' Signup / Login']")
	public WebElement loginBtn;

	@FindBy(xpath = "//i[contains(@class,'fa-user')]/..")
	public WebElement userName;

	@FindBy(xpath = "//header//a[text()=' Logout']")
	public WebElement logOutBtn;

	@FindBy(xpath = "//header//a[text()=' Contact us']")
	public WebElement contactBtn;

	// *************************************************************************************************

	public Header(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
