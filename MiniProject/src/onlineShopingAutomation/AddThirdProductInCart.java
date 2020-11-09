package onlineShopingAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddThirdProductInCart {
	
       public static String final_amount_for_product;
	  public static void homeApliances3 (WebDriver driver) throws Exception {
	   Properties prop = new Properties();
       InputStream input = new FileInputStream("C:\\Users\\nEW u\\workspace\\MiniProject\\src\\config\\config.poperties");
	   prop.load(input);
	   
	 //searching the 'Iron Press' in search text box
	  driver.findElement(By.xpath(prop.getProperty("searchtextbox"))).sendKeys(prop.getProperty("thirdproductname"));
   
	//clicking the search button
      driver.findElement(By.xpath(prop.getProperty("searchbutton"))).click();  
      try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
       //finding the product
      driver.findElement(By.xpath(prop.getProperty("thirdproductxpath"))).click(); 
      
      
      //handling the multiple windows
       Set<String> allWindows = driver.getWindowHandles();
  	  ArrayList<String> tabs= new ArrayList<>(allWindows);   
    driver.switchTo().window(tabs.get(3));
  	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	
      //adding the product in the cart by clicking 'add to cart' button
        driver.findElement(By.xpath(prop.getProperty("addtocart"))).click();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      //getting the price of three product
         final_amount_for_product= driver.findElement(By.xpath(prop.getProperty("price"))).getText();
         System.out.println("Price of all product:Rs "+final_amount_for_product.substring(1));
	  }

}
