package testData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import drivers.Config;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Data 
{
static String workingDir = System.getProperty("user.dir");
	
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
	public static XSSFRow Row;
	
	public static void setExcelFile(String Path) throws Exception {
		try{
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			System.out.println("Path :"+ Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Test_Data_Sheet");
			
			System.out.println("Excel Workbook:" +ExcelWBook);
			System.out.println("Excel sheet:" +ExcelWSheet);
		} 
		catch (Exception e) {
			throw (e);
		}
	}
	
	public static String getCellValue(String ColumnName, String ScenarioName) throws IOException {	

		Config config = new Config(workingDir+"//Configproperties//config.properties");
		String TestDataValue = null;
			try {				
				setExcelFile(workingDir+config.getObject("TestDataExcelPath"));
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			int RowNumber = getRowValue(ScenarioName);
			System.out.println("ScenarioName :" + ScenarioName );
			try{
				
				if(RowNumber<0){
					throw new Exception("Scenario not found in datasheet");
				}				
				int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();			
				String[] Headers = new String[noOfColumns];
		
				for (int j = 0; j < noOfColumns; j++) {
					Headers[j] = ExcelWSheet.getRow(0).getCell(j).getStringCellValue();				
				}
		
				for (int ColumnNum = 0; ColumnNum < noOfColumns; ColumnNum++) {
					if (Headers[ColumnNum].equals(ColumnName)) {
						XSSFCell cell =  ExcelWSheet.getRow(RowNumber).getCell(ColumnNum);
						//cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
						if(cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC) {
							TestDataValue = NumberToTextConverter.toText(cell.getNumericCellValue());
						}
						else
						{
							TestDataValue = cell.getStringCellValue();
						}
						break;
					}	
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
				Assert.fail();
			}			
			return TestDataValue;
		}

		public static int getRowValue(String TestCaseName) {
			System.out.println("Testcase Name :" + TestCaseName);
			int NoOfRows = ExcelWSheet.getLastRowNum();
			//System.out.println("Number of Rows in excel"+NoOfRows);
			int k;
			int RowValue=-1;
			int RowCount = NoOfRows + 1;		
			String[] TestCaseRow = new String[RowCount];
			for (int x = 0; x < (RowCount); x++) {
				TestCaseRow[x] = ExcelWSheet.getRow(x).getCell(0)
						.getStringCellValue();
			}		
			for (k = 1; k <= NoOfRows; k++) {
				if (TestCaseRow[k].trim().equals(TestCaseName)) {
					RowValue = ExcelWSheet.getRow(k).getRowNum();
					break;
				}
			}
			return RowValue;
		}

}
