package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DDTmavn {
@Test
	public static void abc() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = System.getProperty("url");
		String un = System.getProperty("username");
		String pass = System.getProperty("password");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions act = new Actions(driver);
		act.sendKeys(un,Keys.TAB,pass,Keys.TAB,Keys.ENTER).perform();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
//		driver.findElement(By.cssSelector("input[name='accountname']")).sendKeys("ikart");
//		driver.findElement(By.cssSelector("input[name=\"button\"]")).click();
//		WebElement element = driver.findElement(By.xpath("//b[contains(text(),'Organization Information')]"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.visibilityOf(element));
//		driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
//		
	}
}
