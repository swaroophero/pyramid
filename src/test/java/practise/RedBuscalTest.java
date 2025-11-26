package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBuscalTest {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
	    opt.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//span[text()=\"Date of Journey\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='27']")).click();
		
		
	}
}
