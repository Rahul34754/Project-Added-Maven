package fbproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowserWD {
	@Test
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	}
}
