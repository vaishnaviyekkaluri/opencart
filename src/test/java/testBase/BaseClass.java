package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup( ) throws IOException, InterruptedException {
		//loading config file
		FileReader file=new FileReader(".//src/test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
//		if(p.getProperty("eexecution_env").equalsIgnoreCase("remote")) {
//			DesidedX
//		}
//		
		
		
		
		logger=LogManager.getLogger(this.getClass());
		

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://localhost/opencart/upload/");
		
		//read from property file
		driver.get(p.getProperty("appURL"));
		Thread.sleep(10000);
		driver.manage().window().maximize();
	}

	@AfterClass(groups={"Sanity","Regression","Master"})
	public void teardown() {
		driver.close();

	}

	public String randomString() {
		String rand = RandomStringUtils.randomAlphabetic(5);
		return rand;
	}

	public String randomNum() {
		String rand = RandomStringUtils.randomNumeric(10);
		return rand;
	}

	public String randomalphanum() {
		String string = RandomStringUtils.randomAlphabetic(5);
		String rand = RandomStringUtils.randomNumeric(10);
		return string + "@" + rand;
	}
	
	public String captureScreen(String tname) {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

		//return null;
	}
	
	

}
