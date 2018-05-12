package excel;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel_Class 
{
	static Workbook wb;
	static Sheet sh;
	public static void excelconnection(String filename, String sheetname) throws BiffException, IOException
	{
		String filepath="C:\\Users\\Maktum\\eclipse-workspace\\framework.keyword.driven\\Data\\"+filename;
		File file=new File(filepath);
		wb=Workbook.getWorkbook(file);
		sh=wb.getSheet(sheetname);
		
	}
	public static int rcount()
	{
		return sh.getRows();
		
	}
	public static int ccount()
	{
		return sh.getColumns();
	}
	public static String readdata(int col,int row)
	{
		return sh.getCell(col, row).getContents();
	}

}
