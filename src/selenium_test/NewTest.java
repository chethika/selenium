package selenium_test;

//import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTest {

	// Set Up Driver Path
	String driverpath = "C:\\eclips\\selenium\\GeckoDriver\\geckodriver.exe";

	@Test(priority = 1)
	public void Load_Ebay() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverpath);

		WebDriver TestClassParameterDriver = new FirefoxDriver();

		TestClassParameterDriver.manage().window().maximize();

		TestClassParameterDriver.manage().deleteAllCookies();
		TestClassParameterDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TestClassParameterDriver.get("https://www.google.com");

		// String expectedTitle = "google - Google Search";
		// String actualTitle = TestClassParameterDriver.getTitle();
		// Assert.assertEquals(actualTitle, expectedTitle);

		// Search Keyword= Ebay
		WebElement search = TestClassParameterDriver
				.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
		search.sendKeys("Ebay");
		search.sendKeys(Keys.ENTER);

		// Ebay Link Click
		WebElement ebay_Link = TestClassParameterDriver.findElement(
				By.xpath("/html/body/div[7]/div/div[9]/div[1]/div/div[1]/div[3]/div/div/div/div/div[1]/a/div[1]"));
		ebay_Link.click();

		new WebDriverWait(TestClassParameterDriver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/ul[1]/li[1]/span/a")));

		WebElement ebay_SignIn = TestClassParameterDriver
				.findElement(By.xpath("/html/body/header/div/ul[1]/li[1]/span/a"));
		ebay_SignIn.click();

		// Thread.sleep(100000);

		WebElement ebay_username = TestClassParameterDriver.findElement(By.name("userid"));
		ebay_username.sendKeys("chethikadithmal@gmail.com");

		WebElement ebay_continue_btn = TestClassParameterDriver.findElement(By.name("signin-continue-btn"));
		ebay_continue_btn.click();

		new WebDriverWait(TestClassParameterDriver, 20)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=password]")));

		WebElement ebay_Password = TestClassParameterDriver.findElement(By.xpath("//*[@id=\"pass\"]"));
		ebay_Password.sendKeys("chethi#365");

		WebElement load_ebay = TestClassParameterDriver.findElement(By.name("sgnBt"));
		Thread.sleep(4000);

		load_ebay.click();

		// Verify the user name
		String actualTitle = TestClassParameterDriver.getTitle();
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		assertEquals(expectedTitle, actualTitle);

		String actualUsername = TestClassParameterDriver
				.findElement(By.xpath("/html/body/header/div/ul[1]/li[1]/button/b[1]")).getText();
		String expectedUsername = "chethika";
		assertEquals(expectedUsername, actualUsername);
		// TestClassParameterDriver.quit();
	}
}
