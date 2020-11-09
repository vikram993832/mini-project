package onlineShopingAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Main {
	 public static WebDriver driver;
	 public static String URL = "https://www.amazon.in/";
	 
	 // Selecting the browser driver
	 public static WebDriver browserNameSelect(String name) {
		  
	 try {
		 if(name.equalsIgnoreCase("Chrome")) {
			 ChromeOptions options = new ChromeOptions();
				 System.setProperty("webdriver.chrome.driver","C:\\Users\\nEW u\\workspace\\MiniProject\\drivers\\chromedriver.exe");
                driver = new ChromeDriver(options);
		 } else if (name.equalsIgnoreCase("Opera")){
				 OperaOptions options = new OperaOptions();
				 options.addArguments("--disable-notifications");
				 options.addArguments("--disable-infobars");
				 System.setProperty("webdriver.opera.driver","C:\\Users\\nEW u\\workspace\\MiniProject\\drivers\\operadriver.exe");
                driver = new OperaDriver(options);
			 
		 }else {
			 System.out.println("Please use suggested broswer");
		 }
		 
	 } catch(Exception e) { 
		 
	 }
		    driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			return driver;
	 }
	 
	 //Getting base URL of the website//
	 
	 public  void getURL(WebDriver driver)  {
		    driver.get(URL);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
		    System.out.println("Welcome to the amazon.in");
	 }
	//Use property file to set the type of browser type
		 public static String readPropertiesFile() throws IOException {
			 Properties prop = new Properties();
			 String browse=null;
			 try {
				InputStream input = new FileInputStream("C:\\Users\\nEW u\\workspace\\MiniProject\\src\\config\\config.poperties");
			    prop.load(input);
			     browse=prop.getProperty("browser");
			 } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 return browse;
			 
		 }
		
	
		


		public static void main(String[] args) throws Exception  {
			 
			
			 Main online =new Main();
			 
			 String browse = online.readPropertiesFile();
			 WebDriver driver = online.browserNameSelect(browse);
			 //Navigate to amazon website
			 online.getURL(driver);

	       
			 AddFirstProductInCart cart1= new AddFirstProductInCart();
			 cart1.homeApliances1(driver);
			 
			 AddSecondProductInCart cart2= new AddSecondProductInCart();
			 cart2.homeApliances2(driver);
			 
			 AddThirdProductInCart cart3=new AddThirdProductInCart();
			 cart3.homeApliances3(driver);
			 
			 //creating excel file and store it in exe
			 ExcelSheet exe = new ExcelSheet();
			 exe.getResultInExcel(driver);

			 //Quiting the browser
	         driver.quit();

}
}

