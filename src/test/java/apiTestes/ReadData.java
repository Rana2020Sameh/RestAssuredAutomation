package apiTestes;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadData {
    public String[][] readdata() throws IOException, InvalidFormatException {
    File file=new File("./testdata/rest testdata.xlsx");
    XSSFWorkbook wb=new XSSFWorkbook(file);
    XSSFSheet sheet=wb.getSheet("sheet1");
    int numofrow=sheet.getPhysicalNumberOfRows();
            int numofcoul=sheet.getRow(0).getLastCellNum();
            String [][] array=new String[numofrow-1][numofcoul];
            for(int i=1;i<numofrow ;i++)
           {
        for (int a=0;a<numofcoul;a++)
          {
            XSSFRow row=sheet.getRow(i);
            array[i-1][a]=row.getCell(a).toString();
          }

           }
    return array;
}
}