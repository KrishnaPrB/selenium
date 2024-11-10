package driversinit;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import commonmethods.CommonMethods;

public class Drivers {

	public WebDriverWait wait;
	CommonMethods commonMethods;
	protected WebDriver driver;

	@BeforeMethod
	public void openDriver() {
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		commonMethods = new CommonMethods(driver);

	}

}
