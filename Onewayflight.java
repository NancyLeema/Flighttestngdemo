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
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Onewayflight extends Login{
	@Test(groups="Regression")
	public void onewayFlights() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		///one way flight->from to
		driver.findElement(By.xpath("//span[contains(text(),'One Way')]")).click();
		WebElement From=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[1]/div/div[1]/input"));
		From.clear();
		From.sendKeys("MST");
		Thread.sleep(3000);
		From.sendKeys(Keys.ENTER);
		WebElement To=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[3]/div/div[1]/input"));
		To.clear();
		To.sendKeys("WHD");
		Thread.sleep(3000);
		To.sendKeys(Keys.ENTER);
		
	//	from to return
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[4]/div/div[1]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[6]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[4]/div/div[2]/div/input")).click();
		///passengers
	driver.findElement(By.xpath("//*[@id=\"passenger-list\"]")).click();
	
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[5]/div/div[2]/div[2]/div[1]/div[2]/span[3]")).click();
	
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[5]/div/div/div[6]/button/div")).click();
	
		//screenshot
		
		TakesScreenshot srcshot3=(TakesScreenshot)driver;
		File src3=srcshot3.getScreenshotAs(OutputType.FILE);
		File des3=new File("C:\\Users\\Admin\\Desktop\\screenshot\\picture3.jpg");
		FileHandler.copy(src3, des3);
		
		
		
		
}
}
