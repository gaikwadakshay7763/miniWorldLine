package com.cybage.databaseConnection;
	import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

import com.cybage.model.Account;
import com.cybage.model.CardDetails;

import java.io.File;
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
	import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Component	
	public class ExcelDataHandler {
	    private String filePath;
	    private static Integer rowNumber;
	    private static String accountDBFile;
	    //private static Map<Integer,String> account = new HashedMap<>();
		private List<Account> objects = new ArrayList<>();
		
		
	    
	  
	    public ExcelDataHandler() throws FileNotFoundException, IOException {
//	        this.filePath = "accountData.xlsm";
	    	this.accountDBFile = "book1.xlsx";
	    	onInit();
	    }
	    private static void onInit() {
	    	
	    try {
	    	File newFile = new File(accountDBFile);
	    	
	    	
  			
  			if(newFile.createNewFile()) {
  				System.out.println("New file is ready to write Data ");
  				
  			}
  			else {
  				System.out.println("File is already present");
  			}}
  		catch(Exception e) {
  			e.printStackTrace();
  		}
//	    try {
//	    	 //XSSFWorkbook workbook;
//			FileInputStream fileInputStream = new FileInputStream(accountDBFile);
//			
//			String[] headers = new String[] { "Header1", "Header2", "Header3" };
//
//			Workbook workbook = new HSSFWorkbook(fileInputStream);
//			Sheet sheet = workbook.createSheet("EDR Raw Data");
//
//			for (int rn=0; rn<headers.length; rn++) {
//			   Row r = sheet.createRow(rn);
//			   r.createCell(0).setCellValue(headers[rn]);
//			}
//			}
//	    catch (Exception e) {
//				// TODO: handle exception
//			}
	
	    
	    }
	    
//	    private static void onInit() throws FileNotFoundException, IOException {
//	    	
//	    	 XSSFWorkbook workbook;
//	    	 
//	    	 try {
//		  			File newFile = new File(accountDBFile);
//		  			
//		  			if(newFile.createNewFile()) {
//		  				System.out.println("New file is ready to write Data ");
//		  				
//		  			}
//		  			else {
//		  				System.out.println("File is already present");
//		  			}}
//		  		catch(Exception e) {
//		  			e.printStackTrace();
//		  		}
//		        
//		        try (FileInputStream fis = new FileInputStream("accountData.xlsx")) {
//		            workbook = new XSSFWorkbook(fis);
//		        
//
//		        XSSFSheet sheet = workbook.getSheetAt(0);
//		        
//		        Row row = sheet.createRow(0);
//		        
//		        //creating the first row of data file
//		
//	            row.createCell(0).setCellValue("Account Number");
//	            row.createCell(1).setCellValue("Account Holder Name");
//	            row.createCell(2).setCellValue("Card Number");
//	            row.createCell(3).setCellValue("Card Holder Name");
//	            row.createCell(4).setCellValue("Card Expire Date");
//	            row.createCell(5).setCellValue("CVV");
//	           // row.createCell(6).setCellValue("Account Number");
//
//		       
//		        
//
//		        
//		     }
//		        try (FileOutputStream newData = new FileOutputStream("accountData.xlsx")) {
//		            workbook.write(newData);
//		        }
//		        // Close the workbook
//		        workbook.close();
//		        
//		        
//	    	
//	    }

	   
		

	    public List<Account> readData() throws IOException {
	        // Open the Excel file
	    	
//	    	List<Account> objects = new ArrayList<>();
	    	
//	    	accountDBFile = "accountData.xlsx";
//	    	
//	    	  try {
//	  			File newFile = new File(accountDBFile);
//	  			
//	  			if(newFile.createNewFile()) {
//	  				System.out.println("New file is ready to write Data ");
//	  				
//	  			}
//	  			else {
//	  				System.out.println("File is already present");
//	  			}}
//	  		catch(Exception e) {
//	  			e.printStackTrace();
//	  		}

	    	try (
	    			XSSFWorkbook workbook = new XSSFWorkbook("book1.xlsx")) {
	    		
	    	    XSSFSheet sheet = workbook.getSheetAt(0);
	    	    
	    	    Iterator<Row> rowIterator = sheet.iterator();

	    	    // Skip the first row (the header row)
	    	    rowIterator.next();

	    	    while (rowIterator.hasNext()) {
	    	        Row row = rowIterator.next();
	    	        Iterator<Cell> cellIterator = row.cellIterator();

	    	        String accountNumber = cellIterator.next().getStringCellValue();
	    	        String accountHolderName = cellIterator.next().getStringCellValue();
	    	        String cardNumber = cellIterator.next().getStringCellValue();
	    	        String cardHolderName = cellIterator.next().getStringCellValue();
	    	        Date cardExpirDate = cellIterator.next().getDateCellValue();
	    	        int cvv = (int) cellIterator.next().getNumericCellValue();

	    	       // Account account = new Account(accountNumber, accountHolderName, cardNumber, cardHolderName, cardExpirDate, cvv);
	    	       // objects.add(account);
	    	        CardDetails cardDetails = new CardDetails(cardNumber,cardHolderName,cardExpirDate,cvv);
	    	        Account account = new Account(accountNumber, accountHolderName, cardDetails);
	    	        objects.add(account);
	    	    }
	    	}
			return objects;
			
	    






	        
	    }

	    public void appendData(List<Account> accounts) throws IOException {
	        // Open the Excel file
	        XSSFWorkbook workbook;
	        
	        try (FileInputStream fis = new FileInputStream(accountDBFile)) {
	            workbook = new XSSFWorkbook(fis);
	        

	        XSSFSheet sheet = workbook.getSheetAt(0);
	        
	   
	        

	        // Write the data rows
	        int rowNum = sheet.getLastRowNum() + 1;
	        for (Account account : accounts) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(account.getAccountNumber());
	            row.createCell(1).setCellValue(account.getAccountHolderName());
	            row.createCell(2).setCellValue(account.cardDetails.getCardNumber());
	            row.createCell(3).setCellValue(account.cardDetails.getCardHoldersName());
	            row.createCell(4).setCellValue(account.cardDetails.getCardExpirDate());
	            row.createCell(5).setCellValue(account.cardDetails.getCvv());
	            
//	            row.createCell(2).setCellValue(account.getCardNumber());
//	            row.createCell(3).setCellValue(account.getCardHoldersName());
//	            Cell expirDateCell = row.createCell(4);
//	            expirDateCell.setCellValue(account.getCardExpirDate());
//	            //expirDateCell.setCellStyle(createDateCellStyle(workbook));
//	            row.createCell(5).setCellValue(account.getCvv());
	        }

	        // Autosize the columns
//	        for (int i = 0; i < 6; i++) {
//	            sheet.autoSizeColumn(i);
//	        }

	        // Write the file
	        try (FileOutputStream newData = new FileOutputStream("book1.xlsx")) {
	            workbook.write(newData);
	        }
	        // Close the workbook
	        workbook.close();
	    }
	}
	    }



