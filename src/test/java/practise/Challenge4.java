package practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Challenge4 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("-incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.clinique.in/");
		driver.findElement(By.xpath("//button[@aria-label=\"Close\"]")).click();
		//driver.findElement(By.xpath("//button[@id='dismissBtn']")).click();
		WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'Skincare')])[2]"));
		
		//element.click();

	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
		
		List<WebElement> allSkincare = driver.findElements(By.xpath("(//a[contains(text(),'Skincare')])[2]/../following-sibling::div//descendant::a[contains(text(),'All Skincar')]/following-sibling::a"));
		for (WebElement items : allSkincare) {
			wait.until(ExpectedConditions.visibilityOf(items));
			System.out.println(items.getText());
			
		}
		
			
		
	}
}
