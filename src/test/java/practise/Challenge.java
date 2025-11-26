package practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Challenge {
	public static void main(String[] args) throws AWTException, InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("-incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://candymapper.com/");
		driver.findElement(By.xpath("//*[local-name()='svg' and @id='popup-widget307423-close-icon']")).click();
		Robot r = new Robot();
		for (int i = 0; i < 2; i++) {
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);	
		}
		WebElement ifram = driver.findElement(By.xpath("(//iframe[contains(@id,'iframe-undefined')])[1]"));
		driver.switchTo().frame(ifram);
		
		//driver.findElement(By.xpath("//select[@id=\"tCounty\"]")).click();
		WebElement element = driver.findElement(By.id("tCounty"));
	
		Select sel = new Select(element);
		sel.selectByVisibleText("Avon");


		
	}

}
