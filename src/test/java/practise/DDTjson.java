package practise;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DDTjson {
	
		@Test
		public static void abcd() throws IOException, InterruptedException, ParseException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			FileReader fileReader = new FileReader("./src/test/resources/testdata/td.json");
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(fileReader);
			JSONObject jsonObj = (JSONObject) obj;
			String url = jsonObj.get("url").toString();
			String un = jsonObj.get("username").toString();
			String pass = jsonObj.get("password").toString();


//			String pass = System.getProperty("password");
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Actions act = new Actions(driver);
			act.sendKeys(un,Keys.TAB,pass,Keys.TAB,Keys.ENTER).perform();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	}


}