package com.poly.bai3;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Lists {
	
	public List<User> list(int shett_user) throws EncryptedDocumentException, InvalidFormatException, IOException{
		List<User> list = new ArrayList<User>();
		//Luồng lất file cần đọc
		FileInputStream inputstream = new FileInputStream(new File("TestData.xlsx"));
		Workbook workbook = WorkbookFactory.create(inputstream);
		Sheet sheet = workbook.getSheetAt(shett_user);

	
		//định dạng cột
		DataFormatter fmt = new DataFormatter();
		Iterator<Row> iterator = sheet.iterator();
		Row fRow = iterator.next();
		Cell fCell = fRow.getCell(0);
		
		  while(iterator.hasNext()) {
	    	   Row curr = iterator.next();
	    	   User test = new User();
	    		   test.setId(fmt.formatCellValue(curr.getCell(0)));
                    test.setPassword(fmt.formatCellValue(curr.getCell(1)));
                    test.setFullname(fmt.formatCellValue(curr.getCell(2)));
                    test.setAdmin(Boolean.parseBoolean( fmt.formatCellValue(curr.getCell(3))));
                    test.setEmail(fmt.formatCellValue(curr.getCell(4)));
	    	   list.add(test);
	    	     
	       }
	       
		return list;
	}
}
