package practise;

import java.awt.Window;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Challenge2 {
public static void main(String[] args) {
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("-incognito");
	WebDriver driver = new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demoqa.com/");
	WebElement element = driver.findElement(By.xpath("//h5[text()=\"Alerts, Frame & Windows\"]"));
	int y = element.getLocation().getY();
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,"+y+");");
	element.click();
	driver.findElement(By.xpath("//span[text()=\"Browser Windows\"]")).click();
	driver.findElement(By.id("messageWindowButton")).click();
	String parentID = driver.getWindowHandle();
	Set<String> windowHandles = driver.getWindowHandles();
	for (String winhand : windowHandles) {
		if(!winhand.equals(parentID)) {
			driver.switchTo().window(winhand);
			driver.close();
		}
		
	}
	
	
}
}
