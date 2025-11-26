package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Challenge6 {
	
	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("-incognito");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement dragDrop = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		Point location = dragDrop.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println(x);
		System.out.println(y);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(\""+x+","+y+"\")");
		Actions act = new Actions(driver);
//		act.scrollByAmount(x, y).perform();
		
		driver.findElement(By.id("singleFileInput")).sendKeys("C:\\Users\\swaro\\Downloads\\SandhyaK_6.1_QA_Analyst.pdf");
		driver.findElement(By.id("comboBox")).click();
		driver.findElement(By.xpath("//div[text()='Item 10']")).click();
		
		
		//a[@title="Account"]/*[local-name()='svg']
	}

}
