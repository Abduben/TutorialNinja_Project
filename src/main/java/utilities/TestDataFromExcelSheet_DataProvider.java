package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestDataFromExcelSheet_DataProvider {

	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	@DataProvider(name = "getTN/TC8ExcelData")
	public static Object[][] getTNExcelDataForTC8() throws Exception {
		Object[][] data = TestDataFromExcelSheet_DataProvider.readDataFromExcelTN("TestCase8");
		return data;
	}

	  @DataProvider(name = "getTN/TC9ExcelData") 
	  public static Object[][]  getTNExcelDataForTC9() throws Exception{
		  Object[][] data = TestDataFromExcelSheet_DataProvider.readDataFromExcelTN("TestCase9"); 
		  return data;  
	  }
	  
	  @DataProvider(name = "getTN/TC10ExcelData") 
	  public static Object[][]  getTNExcelDataForTC10() throws Exception{
		  Object[][] data = TestDataFromExcelSheet_DataProvider.readDataFromExcelTN("TestCase10"); 
		  return data;  
	  }
	 
	public static Object[][] readDataFromExcelTN(String sheetName) throws Exception {

		String Excelfilepath = Utilitites_config.pathForExcelSheet;
		ip = new FileInputStream(Excelfilepath);
		workbook = new XSSFWorkbook(ip);
		sheet = workbook.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);

				CellType cellofType = cell.getCellType();

				switch (cellofType) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;

				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;

				}
			}
		}

		return data;
	}
	
	
	@DataProvider (name= "testingInvalidPhoneNumber")
	public Object dataforinvalidphonenumber() {
		
		Object[][] data = {{"Abdu", "Mousssa","User"+Utilitites_config.randomNumber()+"@gmail.com","ABDHA","1234","1234"},
		                   {"Abdu", "Mousssa","User"+Utilitites_config.randomNumber()+"@gmail.com","12345","1234","1234"},
		                   {"Abdu", "Mousssa","User"+Utilitites_config.randomNumber()+"@gmail.com","AB99uueyu","1234","1234"}};
		
		return data;
	}

}
