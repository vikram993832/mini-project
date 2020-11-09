package onlineShopingAutomation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelSheet extends AddSecondProductInCart {
	 public void getResultInExcel(WebDriver driver) throws Exception {
			
		 AddThirdProductInCart a = new AddThirdProductInCart();
			   String amountofthree = a.final_amount_for_product;
		 
			 
			    XSSFWorkbook workbook = new XSSFWorkbook();
		         XSSFSheet sheet = workbook.createSheet("TestCase");
		         Row first= sheet.createRow(0);
			       Cell T=first.createCell(0);
			       T.setCellValue("Serial No.");
			       Cell d=first.createCell(1);
			       d.setCellValue("No. Of Product");
			       Cell b=first.createCell(2);
			       b.setCellValue("Total Price");
			       
			       Row Second= sheet.createRow(1);
			       Cell T1=Second.createCell(0);
			       T1.setCellValue("1");
			       Cell d1=Second.createCell(1);
			       d1.setCellValue("2");
			       Cell b1=Second.createCell(2);
			       b1.setCellValue(amountoftwo);
			       
			       Row Third= sheet.createRow(2);
			       Cell T2=Third.createCell(0);
			       T2.setCellValue("2");
			       Cell d2=Third.createCell(1);
			       d2.setCellValue("3");
			       Cell b2=Third.createCell(2);
			       b2.setCellValue(amountofthree);
		         
		         FileOutputStream fileoutput = new FileOutputStream(new File("OnlineShopping.xlsx"));
		         workbook.write(fileoutput);
		         
		         System.out.println("Excel file is created");
			 
			  
							
	 }

	
	}
	 
            
			
			
		



