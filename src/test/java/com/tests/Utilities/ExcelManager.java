package com.tests.Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelManager {

    @DataProvider(name = "Logindata_Excel")
   public static Object[][] getExcelData() throws IOException {
       // 1. Load Excel file
       FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/LoginCredsDetails.xlsx");
       Workbook workbook = new XSSFWorkbook(fis); // use HSSFWorkbook for .xls
       Sheet sheet = workbook.getSheet("Sheet1");


       int rowCount = sheet.getLastRowNum();
       int colCount = sheet.getRow(0).getLastCellNum();

       //Creating Object array for data
       Object[][] data = new Object[rowCount][colCount];
       // 3. Loop through rows (skip header row at index 0)
       for (int i = 1; i <= rowCount; i++) {
           Row row = sheet.getRow(i);
           for (int j = 0; j < colCount; j++) {
               data[i - 1][j] = new DataFormatter().formatCellValue(row.getCell(j));
           }
       }
       workbook.close();
       fis.close();
       return data;
   }


}
