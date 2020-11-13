package api.automation.rest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDrivenAPI {

	
	@Test
	public static ArrayList excelData(String sheetName,String rowName,String cellName) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("resources\\Resource\\ExcelDriven.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		ArrayList a=new ArrayList();

		int sheetcount = workbook.getNumberOfSheets();

		for (int i = 0; i < sheetcount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				int column=0;
				int k = 0;

				while (rows.hasNext()) {
					Iterator<Cell> cell = rows.next().cellIterator();

					while (cell.hasNext()) {
						if (cell.next().getStringCellValue().equalsIgnoreCase(rowName)) {
							column = k;
							break;
						}
						k++;
						
					}
					
					while(rows.hasNext())
					{
					
						Row r=rows.next();
							if (r.getCell(column).getStringCellValue().equalsIgnoreCase(cellName))
							{
				
								Iterator<Cell> c=r.cellIterator();
								
								while (c.hasNext())
								{
									
									Cell cv=c.next();
								if(cv.getCellTypeEnum()==CellType.STRING)
									{
									a.add(cv.getStringCellValue());
									
									}
								else
								{
						
									a.add(NumberToTextConverter.toText(cv.getNumericCellValue()));

								}
									
									
								}
								break;
							}
							
					}
				}
				
				
				
			}

		}
		System.out.println(a);
		return a;
	}
	
}
