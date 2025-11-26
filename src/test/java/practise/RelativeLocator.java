package practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RelativeLocator {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("-incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.w3schools.com/");
		
	
		Actions act =new Actions(driver);
		WebElement element = driver.findElement(By.id("search2"));
		//WebElement element2 = driver.findElement(By.id("products-dd-tab-3"));
		//act.click(element).sendKeys("a").build().perform();
		act.click(element).keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).build().perform();
		
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		
		
	}
}
