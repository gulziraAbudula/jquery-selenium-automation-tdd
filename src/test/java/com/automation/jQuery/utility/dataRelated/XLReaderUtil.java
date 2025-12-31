package com.automation.jQuery.utility.dataRelated;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class XLReaderUtil {

    public ArrayList<Map<String, String>> parse(String fillPath, int i) {
        try {
            // Workbook wb = WorkbookFactory.create(stream);
            FileInputStream file = new FileInputStream(new File(fillPath));

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(i - 1);
            Iterator<Row> rows = sheet.rowIterator();

            // Create the Header Map
            List<String> headers = new ArrayList<String>();

            if (rows.hasNext()) {
                Row row = rows.next();
                for (Cell cell : row) {
                    headers.add(cell.getStringCellValue());
                }
            }

            ArrayList<Map<String, String>> contents = new ArrayList<Map<String, String>>();
            while (rows.hasNext()) {
                Row row = rows.next();
                Map<String, String> values = new HashMap<String, String>();
                for (Cell cell : row) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    values.put(headers.get(cell.getColumnIndex()), cell.getStringCellValue());
                }
                contents.add(values);

            }
            return contents;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Map<String, String>> Getdata(ArrayList<Map<String, String>> contents, String column,
                                                  String value) {
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        for (Map<String, String> content : contents) {
            if (content.get(column).equals(value)) {
                result.add(content);
            }
        }
        System.out.println(result.toString());
        return result;
    }

    /*
     * public static void main(String[] args) { XLReaderUtil xlread = new
     * XLReaderUtil(); ArrayList<Map<String, String>> DATA = xlread.parse(1);
     * ArrayList<Map<String, String>> finaldata = xlread.Getdata(DATA, "TestCaseID",
     * "TCID_01"); System.out.println(finaldata.get(0).get("username"));
     *
     * }
     */
}
