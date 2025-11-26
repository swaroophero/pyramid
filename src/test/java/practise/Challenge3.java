package practise;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Challenge3 {
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
	driver.findElement(By.xpath("//span[text()=\"Alerts\"]")).click();
	driver.findElement(By.id("promtButton")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert = driver.switchTo().alert();
	alert.sendKeys("naan than da leo leo das");
	alert.accept();
	
	}
	
}
