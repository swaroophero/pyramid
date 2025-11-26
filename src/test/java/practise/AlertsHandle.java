package practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AlertsHandle {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("-incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(10000);
		WebElement element = driver.findElement(By.linkText("MNCs"));
		
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,400)");
		//element.click();
		driver.findElement(By.linkText("Internet")).click();
		driver.findElement(By.linkText("Manufacturing")).click();
		
		String parent = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String wh : windowHandles) {
			if(!wh.equals(parent)) {
				driver.switchTo().window(wh);
				@Nullable
				String title = driver.getTitle();
				System.out.println(title);
				driver.close();
			}
			
			
		}
		driver.switchTo().window(parent);
		System.out.println(driver.getCurrentUrl());
		

	
	}
}
