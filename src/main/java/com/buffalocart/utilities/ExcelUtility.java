package com.buffalocart.utilities;

import com.buffalocart.constants.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtility {
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static FileInputStream f;
    public List<String> readDataFromExcel(String sheetName) throws IOException {
        DataFormatter formatter = new DataFormatter();
        f = new FileInputStream(Constants.TEST_DATA_EXCEL);
        wb = new XSSFWorkbook(f);
        sh = wb.getSheet(sheetName);
        ArrayList<String> excelRows = new ArrayList<String>();
        for(Row r : sh) {
            for (Cell c : r) {
                excelRows.add(formatter.formatCellValue(c));
            }
        }
        return excelRows;
    }

    public ArrayList<ArrayList<String>> readDataSFromExcel(String sheetName) throws IOException {
        DataFormatter formatter = new DataFormatter();
        ArrayList<ArrayList<String> > data = new ArrayList<ArrayList<String> >();
        f = new FileInputStream(Constants.TEST_DATA_EXCEL);
        wb = new XSSFWorkbook(f);
        sh = wb.getSheet(sheetName);
        int rowCount=sh.getLastRowNum()-sh.getFirstRowNum();
        ArrayList<String> excelRows = new ArrayList<String>();
        for(int i=0;i<rowCount+1;i++){
            int x=1;
            Row row=sh.getRow(i);
            String[] columnList=new String[row.getLastCellNum()];
            for(int j=0;j<columnList.length;j++){
                columnList[j]=formatter.formatCellValue(row.getCell(x));
                x++;
            }
            data.add(new ArrayList<>(Arrays.asList(columnList)));
        }
        return data;
    }

    public Object[][]  getData(String sheetName) throws IOException {
        DataFormatter formatter = new DataFormatter();
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        f = new FileInputStream(Constants.TEST_DATA_EXCEL);
        wb = new XSSFWorkbook(f);
        sh = wb.getSheet(sheetName);
        int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
        ArrayList<String> excelRows = new ArrayList<String>();
        for (int i = 1; i < rowCount + 1; i++) {
            int x = 0;
            Row row = sh.getRow(i);
            String[] columnList = new String[row.getLastCellNum()];
            for (int j = 0; j < columnList.length; j++) {
                columnList[j] = formatter.formatCellValue(row.getCell(x));
                x++;
            }
            data.add(new ArrayList<>(Arrays.asList(columnList)));
        }

        Object[][] arr = data.stream()
                .map(l -> l.toArray(new String[l.size()]))
                .toArray(Object[][]::new);

        return arr;
    }
}
