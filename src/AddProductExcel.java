import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class AddProductExcel {
    public static void AddProduct(Product product){
        String  filePath ="D:\\lanqiaoProjects\\src\\shopCart.xlsx";
        boolean flag =fileExist(filePath);
        System.out.println(flag);
        if(flag){
            writeExcel(product,filePath);
        }

    }
    public  static  boolean fileExist(String filePath){
        boolean flag =false;
        File file =new File(filePath);
        flag =file.exists();
        return  flag;

    }
    public static  void writeExcel(Product product,String filePath){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("shopCart");
        XSSFRow firstRow = sheet.createRow(0);//第一行表头
        XSSFCell cells[] = new XSSFCell[4];
        String[] titles =new String[]{"id","name","price","describe"};
        for (int i=0;i<4;i++){
            cells[0]=firstRow.createCell(i);
            cells[0].setCellValue(titles[i]);
        }
        XSSFRow row = null;

            XSSFCell cell =row.createCell(0);
            cell.setCellValue(product.getId());
            cell=row.createCell(1);
            cell.setCellValue(product.getName());
            cell=row.createCell(2);
            cell.setCellValue(product.getPrice());
            cell=row.createCell(3);
            cell.setCellValue(product.getDescribe());
        
        OutputStream out =null;
        try{
            out =new FileOutputStream(filePath);
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
