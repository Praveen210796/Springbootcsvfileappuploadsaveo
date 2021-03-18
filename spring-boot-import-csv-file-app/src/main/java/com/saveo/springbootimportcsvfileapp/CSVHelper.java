package com.saveo.springbootimportcsvfileapp;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "c_name" , "c_batch_no", "d_expiry_date",
			                    "n_balance_qty" , "c_packaging","c_unique_code"
	                            ,"c_schemes=" ,"n_mrp","c_manufacturer","hsn_code"};
	
	public static boolean hasCSVFormat(MultipartFile file) {
		if (TYPE.equals(file.getContentType())
	    		|| file.getContentType().equals("application/vnd.ms-excel")) {
	      return true;
	    }

	    return false;
	  }
	
	public static List<ProductList> csvToList(InputStream is){
		try(BufferedReader fileReader = new BufferedReader (new InputStreamReader (is,"UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,CSVFormat.DEFAULT
						.withFirstRecordAsHeader()
						.withIgnoreHeaderCase().withTrim());){
							
            List<ProductList>productList = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				ProductList productLists = new ProductList(
						  csvRecord.get("c_name"),
			              csvRecord.get("c_batch_no"),
			              csvRecord.get("d_expiry_date"),
			              Integer.parseInt(csvRecord.get("n_balance_qty")),
			              csvRecord.get("c_packaging"),
			              csvRecord.get("c_unique_code"),
			              csvRecord.get("c_schemes"),
			              Float.parseFloat(csvRecord.get("n_mrp")),
			              csvRecord.get("c_manufacturer"),
			              Long.parseLong(csvRecord.get("hsn_code"))
						
						);
				
			           	 productList.add(productLists);
								
		}
			return productList;
		}catch(IOException e) {
			throw new RuntimeException("Fail to parse CSV File: " +e.getMessage());
		}
						
	}
	
	public static ByteArrayInputStream tutorialsToCSV(List<ProductList> productLists) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	    	
	    	for (ProductList productList : productLists) {
	    		List<Object> data = Arrays.asList(
	    				 String.valueOf(productList.getC_name()),
	    				 productList.getC_batch_no(),
	    				 productList.getD_expiry_date(),
	    				 productList.getN_balance_qty(),
	    				 productList.getC_packaging(),
	    				 productList.getC_unique_code(),
	    				 productList.getC_schemes(),
	    				 productList.getN_mrp(),
	    				 productList.getC_manufacturer(),
	    				 productList.getHsn_code() 
	    				 );
	    		        csvPrinter.printRecord(data);
	    		
	    }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }

	}

