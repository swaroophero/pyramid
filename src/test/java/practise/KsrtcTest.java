package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KsrtcTest {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
	    opt.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://ksrtc.in/");
		driver.findElement(By.id("departDate")).click();
		driver.findElement(By.xpath("//a[normalize-space()='27']")).click();
		driver.findElement(By.xpath("//span[text()='November']/ancestor::div[@class='ui-datepicker-group ui-datepicker-group-first']/descendant::a[text()='27']")).click();
		//dri
		
		
	}
}
