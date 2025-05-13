package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	 FileInputStream fis = new FileInputStream("./src/test/resources/testData01.xlsx");
	 Workbook workBook = WorkbookFactory.create(fis);
	 Sheet sheet = workBook.getSheet("studentdata");
	 Row row = sheet.getRow(3);
	 Cell cell = row.getCell(2);
	// long cellValue = (long)cell.getNumericCellValue();
	// System.out.println("cellValue = " + cellValue);
	 String cellValue = cell.getStringCellValue();
	 System.out.println("cellValue = " + cellValue);
}
}
