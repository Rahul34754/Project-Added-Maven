package fbproject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
	@Test
public void browserLaunch() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://demoqa.com/automation-practice-form/");
			
			String ParentWindow =driver.getWindowHandle();
			System.out.println("ParentWindow "+ParentWindow);
			
			driver.switchTo().newWindow(WindowType.TAB);
			driver.navigate().to("https://www.facebook.com/");
			
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.navigate().to("https://twitter.com/?lang=en");
			
			Set <String> Set = driver.getWindowHandles();
			System.out.println("All Id  " +Set);
			Set.remove(ParentWindow);
			System.out.println("After Remove  " +Set);
			
			
			Iterator<String> itr= Set.iterator();
			while(itr.hasNext()){
				String Currentwindow = itr.next();
				driver.switchTo().window(Currentwindow);
				System.out.println("Current window Title " +driver.getTitle());

			}
			driver.switchTo().window(ParentWindow);
			System.out.println("Parent window Title  " +driver.getTitle());
		}
}

