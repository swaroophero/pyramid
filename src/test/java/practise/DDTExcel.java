package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
        FileInputStream fis = new FileInputStream("./src/test/resources/testdata/VTigerTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Leads");
		sheet.createRow(9).createCell(4).setCellValue("xyz");		
		int lastRowNum = sheet.getLastRowNum();
		int firstRowNum = sheet.getFirstRowNum();
		String expected="LE_002";
		System.out.println(lastRowNum);
		System.out.println(firstRowNum);

		FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata/VTigerTestData.xlsx");
		wb.write(fos);
		for(int i= firstRowNum;i<=lastRowNum;i++) {
			boolean d =true;
			//System.out.println(cellType);
			try {
			String cell = sheet.getRow(i).getCell(0).toString();
			if(cell.equals(expected)) {
				int k = sheet.getRow(i).getLastCellNum();
				for(int j=1;j<k;j++) {
					//System.out.println(sheet.getRow(i).getCell(j).toString());
					DataFormatter df = new DataFormatter();
					
					Cell c = sheet.getRow(i).getCell(j);
					String formatCellValue = df.formatCellValue(c);
					System.out.println(formatCellValue);
				}
			}
//					else {
//				System.out.println("fail");
//			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
