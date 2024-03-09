package SampleWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DD_formExcel {
    @Test
    public void datadriven() throws IOException {

        WebDriverManager.chromedriver().setup();

       Map<String,Object> data = new TreeMap<>();
       data.put("1",new Object[]{"LoginID","Email","Password"});
        data.put("2",new Object[]{"1","erer@gmail.com","Password"});
        data.put("3",new Object[]{"2","Admin","Pass1223"});

         Set<String> Keyset = data.keySet();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");
         int rownum=0;


         for(String key : Keyset){
             Row r = sheet.createRow(rownum++);
             Object[] obj = (Object[]) data.get(key);
             int celnum =0;
             for(Object o : obj){

                 Cell cell = r.createCell(celnum++);
                 cell.setCellValue((String) o);
             }


         }

        FileOutputStream file = new FileOutputStream(new File("Testdata.xlsx"));
        workbook.write(file);
        file.close();


    }
}
