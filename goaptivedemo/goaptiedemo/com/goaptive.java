package goaptiedemo.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class goaptive {

 WebDriver dv;
 
	@Test
	@Parameters("browserTest")
	
	public void browserTest(String browserName) throws InterruptedException, EmailException, Exception
    
	{
	  File file = new File("./Driver/goaptive.properties");
	  FileInputStream fileinput = null;
	  try{
		  fileinput = new FileInputStream(file);
	  }
	  catch
	  (FileNotFoundException e)
	  {
		  e.printStackTrace();
	  }
	  Properties prop = new Properties();
	  {
		  prop.load(fileinput);
	 	  }
	 
if(browserName.equalsIgnoreCase("firefox")){
System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");


dv = new FirefoxDriver();
dv.manage().window().maximize();
dv.get(prop.getProperty("URL"));
Thread.sleep(10000);

dv.findElement(By.xpath(prop.getProperty("UserName"))).sendKeys(prop.getProperty("username"));//FirstName
Thread.sleep(2000);
dv.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("password"));//Last name
Thread.sleep(2000);
dv.findElement(By.xpath(prop.getProperty("Submit"))).click();
Thread.sleep(5000);
Screenshoot.goaptiedemo(dv, "LoginButton");
Thread.sleep(2000);


String actual_error = prop.getProperty("actual_Massage");
String expect_error = prop.getProperty("expect_Massage");
Assert.assertEquals(actual_error, expect_error);
Assert.assertTrue(actual_error.contains(prop.getProperty("error_Massage")));
Thread.sleep(5000);
}
//***********************************************************************************	
		     
	if(browserName.equalsIgnoreCase("firefox1")){
	 System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
	
dv = new FirefoxDriver();
dv.manage().window().maximize();
dv.get(prop.getProperty("URL"));
Thread.sleep(10000);
dv.findElement(By.xpath(prop.getProperty("UserName"))).sendKeys(prop.getProperty("username1"));//FirstName
Thread.sleep(5000);
dv.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("password1"));//Last name
Thread.sleep(5000);
dv.findElement(By.xpath(prop.getProperty("Submit"))).click();
Thread.sleep(5000);
Screenshoot.goaptiedemo(dv, "LoginButton1");

String actual_error1 = prop.getProperty("actual_Massage1");
String expect_error1 = prop.getProperty("expect_Massage1");
Assert.assertEquals(actual_error1, expect_error1);
Assert.assertTrue(actual_error1.contains(prop.getProperty("error_Massage1")));
Thread.sleep(5000);
	}

//************************************************************************************************	
if(browserName.equalsIgnoreCase("firefox2"))

{
System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
	
dv = new FirefoxDriver();
dv.manage().window().maximize();
dv.get(prop.getProperty("URL"));
Thread.sleep(20000);
dv.findElement(By.xpath(prop.getProperty("UserName"))).sendKeys(prop.getProperty("username2"));//FirstName
Thread.sleep(5000);
dv.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("password2"));//Last name
Thread.sleep(5000);
dv.findElement(By.xpath(prop.getProperty("Submit"))).click();
Thread.sleep(5000);
Screenshoot.goaptiedemo(dv, "LoginButton2");
dv.findElement(By.xpath(prop.getProperty("LeadButton"))).click();
Thread.sleep(5000);
dv.findElement(By.xpath(prop.getProperty("BlogButton"))).click();
Thread.sleep(5000);
{
  WebElement ele = dv.findElement(By.xpath(prop.getProperty("PhotoUPButton")));
  		Actions act = new Actions(dv);
  		act.moveToElement(ele).perform();
  		Thread.sleep(5000);
  		WebElement b = dv.findElement(By.xpath(prop.getProperty("EditButtonBlog")));
  		Thread.sleep(2000);
  		b.click();
  		Thread.sleep(2000);
  		Screenshoot.goaptiedemo(dv, "EditButtonBlog");
}
Thread.sleep(5000);
dv.findElement(By.xpath(prop.getProperty("navbarDropdownMenuLink"))).click();
Thread.sleep(2000);
dv.findElement(By.xpath(prop.getProperty("Password_dropdown-item"))).click();
Thread.sleep(5000);
Screenshoot.goaptiedemo(dv, "Password_dropdown-item");
String actual_error2 = prop.getProperty("actual_Massage2");
String expect_error2 = prop.getProperty("expect_Massage2");
Assert.assertEquals(actual_error2, expect_error2);
Assert.assertTrue(actual_error2.contains(prop.getProperty("error_Massage2")));
Thread.sleep(5000);
}
//****************************************************************************************************************************

else  if (browserName.equalsIgnoreCase("firefox3"))
		{
	 System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
  	
	dv = new FirefoxDriver();
	dv.manage().window().maximize();
	dv.get(prop.getProperty("URL"));
	Thread.sleep(20000);
   dv.findElement(By.xpath(prop.getProperty("UserName"))).sendKeys(prop.getProperty("username2"));//FirstName
 	Thread.sleep(5000);
 	dv.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("password2"));//Last name
   Thread.sleep(5000);
   dv.findElement(By.xpath(prop.getProperty("Submit"))).click();
   Thread.sleep(5000);
   Screenshoot.goaptiedemo(dv, "LoginButton2");
  dv.findElement(By.xpath(prop.getProperty("PageButton"))).click();
  Thread.sleep(2000);
  dv.findElement(By.xpath(prop.getProperty("navbarDropdownMenuLink"))).click();
  Thread.sleep(5000);
  dv.findElement(By.xpath(prop.getProperty("LogOutButton"))).click();
   Thread.sleep(2000);}

//****************************************************************************************************************************************************
 if (browserName.equalsIgnoreCase("EmailAttachment")){
   //public void EmailAttachment(String none , String emailDestinatario) throws EmailException{
    EmailAttachment attached = new EmailAttachment();
    Email email = new SimpleEmail();
	attached.setPath("E:/sw/Homework1/goaptiedemo.demo/test-output/emailable-report.html");
	System.out.println("Email Working..");
	attached.setDisposition(EmailAttachment.ATTACHMENT);
	attached.setDescription("report");
	attached.setName("goaptive");
	try{
		System.out.println("Email Send..");
		
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("subhradip.sinha06@gmail.com", "subhradip@1989"));
		email.setSSLOnConnect(true);
		System.out.println("Email gone..");
		email.setFrom("subhradip.sinha06@gmail.com");
		email.setSubject("TestMail");
		System.out.println("Email on the way..");
		email.setMsg("This is a test mail ... :-)");
		System.out.println("Email Attached Msg..");
		email.addTo("subhradip.sinha06@gmail.com");
		System.out.println("Email add Mail ID..");
		Thread.sleep(2000);
		
		
		
}
	catch (EmailException e){
	e.printStackTrace();
	    
}
	Thread.sleep(5000);
	email.send();
	System.out.println("Email sent");
 }
 
}}