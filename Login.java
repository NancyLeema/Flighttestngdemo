package testngdemoproject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
//round trip
public class Login extends Launchbrowser {
	@Test(groups="Regression")
	public void loginApp() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		///from to ->Roundtrip
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/nav/span[2]/span")).click();	
		WebElement From=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[1]/div/div[1]/input"));
		From.clear();
		From.sendKeys("BOM");
		Thread.sleep(3000);
		From.sendKeys(Keys.ENTER);
		WebElement To=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[3]/div/div[1]/input"));
		To.clear();
		To.sendKeys("HYD");
		Thread.sleep(3000);
		To.sendKeys(Keys.ENTER);
		
		///start date and return date
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[4]/div/div[1]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/table/tbody/tr[5]/td[3]/div[1]")).click();
		
		driver.findElement(By.xpath(" //body/div[@id='content']/div[1]/div[1]/div[5]/div[1]/div[1]/div[4]/div[1]/div[2]/div[2]/input[1]")).click();
		
		////No of passengers
		driver.findElement(By.id("passenger-list")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[5]/div/div[2]/div[2]/div[1]/div[2]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[5]/div/div[2]/div[2]/div[2]/div[2]/span[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[5]/div/div[2]/div[2]/div[3]/div[2]/span[2]")).click();
		
		WebElement Business=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[5]/div/div[2]/div[4]/span/div[2]/span[1]"));
		Business.click();
		driver.findElement(By.xpath("//body/div[@id='content']/div[1]/div[1]/div[5]/div[1]/div[1]/div[6]/button[1]/div[1]")).click();
		
		///check flights
		WebElement checkbox2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/div[1]/div/div[2]/div[1]/span/div[3]/span[1]/span"));
		checkbox2.click();
		
		WebElement checkbox1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[1]/div[3]/div/div[2]/span/div[1]/span[1]/span"));
		checkbox1.click();
		////Screenshot
		TakesScreenshot srcshot2=(TakesScreenshot)driver;
		File src2=srcshot2.getScreenshotAs(OutputType.FILE);
		File des2=new File("C:\\Users\\Admin\\Desktop\\screenshot\\picture2.jpg");
		FileHandler.copy(src2, des2);
		
		}
}
