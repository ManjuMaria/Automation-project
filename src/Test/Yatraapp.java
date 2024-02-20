package Test;
import org.testng.annotations.Test;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import Page.Yatrasite;


public class Yatraapp {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		//alert handling
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		
	}
@BeforeMethod
public void url()
{
	driver.get("https://www.yatra.com/");
}


@Test
public void test()
{
	//login validation
	Yatrasite ob=new Yatrasite(driver);
	Actions act=new Actions(driver);
	WebElement mouse=driver.findElement(By.xpath("//*[@id=\"userLoginBlock\"]/a"));
	act.moveToElement(mouse).perform();
	
			
	driver.findElement(By.xpath("//*[@id=\"signInBtn\"]")).click();
	ob.setvalue("manjumaria321@gmail.com");
	ob.continuelogin();
	driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
	ob.setvalue("Manju@123");
	driver.navigate().back();
}

@Test
public void scrensht() throws Exception
{
	//screenshot
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("D://image1.png"));
}
@Test
public void test2()
{
	//search&scroll down
	driver.findElement(By.xpath("//*[@id=\"booking_engine_hotels\"]/div/span")).click();
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	driver.findElement(By.xpath("//*[@id=\"js_yt_footer\"]/div/ul/li[3]/a")).click();


	//new window
		WebDriver driver1=driver.switchTo().newWindow(WindowType.TAB);
		driver1.get("https://www.google.com//");
		driver1.close();

		}
	
	}
