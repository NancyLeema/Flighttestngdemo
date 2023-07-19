package testngdemoproject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;

public class Launchbrowser {
	@BeforeTest(groups="Regression")
	public void launchingApp() throws IOException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		TakesScreenshot srcshot1=(TakesScreenshot)driver;
		File src1=srcshot1.getScreenshotAs(OutputType.FILE);
		File des1=new File("C:\\Users\\Admin\\Desktop\\screenshot\\picture1.jpg");
		FileHandler.copy(src1, des1);


}
}
