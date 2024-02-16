package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Yatrasite {
	WebDriver driver;
	
	By email=By.name("login-input");
	By passwrd=By.id("login-password");
	By clickcontinue=By.xpath("//*[@id=\"login-continue-btn\"]");
	By loginbutton=By.xpath("//*[@id=\"login-submit-btn\"]");
	
	
	
	public Yatrasite(WebDriver driver)
	{
		this.driver= driver;
		
	}
	public void setvalue(String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}
	public void continuelogin()
	{
		driver.findElement(clickcontinue).click();
	}
	public void setvalue1(String pswrd)
	{
		driver.findElement(passwrd).sendKeys(pswrd);
		
	}
	
public void login()
{
	driver.findElement(loginbutton).click();
}
}
