package Functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Helper {
	public String url;
	private WebDriver driver = null;
	private String rootPath = System.getProperty("user.dir");
	private final String referencesPath = "/src/test/resources/webdriver/";

	public Helper(String urlLink) {
		url = urlLink;
	}

	public void launchBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", rootPath + referencesPath + "chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", rootPath + referencesPath + "geckodriver");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Sorry, this browser is invalid");
			break;
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
	}

	public void loginFail() throws InterruptedException {
		driver.get(url);
		WebElement userName = driver.findElement(By.xpath("//input[@type ='text']"));
		userName.clear();
		userName.sendKeys("phuong.tt");
		WebElement passWord = driver.findElement(By.xpath("//input[@type ='password']"));
		passWord.clear();
		passWord.sendKeys("12345678");
		driver.findElement(By.xpath("//input[@class ='login-button']")).click();
		String StrActual = "";
		String StExpect = "Epic sadface: Username and password do not match any user in this service";
		StrActual = driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(StrActual, StExpect);
		System.out.println("Sign in Failed");
	}

	public void loginSuccess() throws InterruptedException {
		driver.get(url);
		WebElement userName = driver.findElement(By.xpath("//input[@type ='text']"));
		userName.clear();
		userName.sendKeys("standard_user");
		WebElement passWord = driver.findElement(By.xpath("//input[@type ='password']"));
		passWord.clear();
		passWord.sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@class ='login-button']")).click();
		String title = "";
		title = driver.findElement(By.className("header_label")).getText();
		if (title.contains("Swag Labs")) {
			System.out.println("Sign in successed");
		} else
			System.out.println("Sign in unsuccessed");
	}

	public void addToCard() {
		driver.findElement(By.xpath("//div[@class='inventory_list']/div[1]//button")).click();
		driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]//button")).click();
		System.out.println("Add to card success");
	}

}
