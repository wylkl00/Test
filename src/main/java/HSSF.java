import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class HSSF {

	public static String base ="C:\\Users\\lianglu\\Desktop\\";
	
    /** 
     * 锟矫碉拷Excel锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷 
     * @param file 
     * @throws FileNotFoundException 
     * @throws IOException 
     */  
    public static void getExcelAsFile() throws FileNotFoundException, IOException{  
        //1.锟矫碉拷Excel锟斤拷锟矫讹拷锟斤拷  
//      POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("d:/FTP/test.xls"));  
        POIFSFileSystem fs = new POIFSFileSystem(Paths.get(base,"123.xls").toFile());  
        //2.锟矫碉拷Excel锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷  
        HSSFWorkbook wb = new HSSFWorkbook(fs);  
        //3.锟矫碉拷Excel锟斤拷锟斤拷锟斤拷锟斤拷锟? 
        HSSFSheet sheet = wb.getSheetAt(0); 
        
        List<CellRangeAddress> list= sheet.getMergedRegions();
        
        //锟斤拷锟斤拷锟斤拷  
        int trLength = sheet.getPhysicalNumberOfRows();  
        //4.锟矫碉拷Excel锟斤拷锟斤拷锟斤拷锟斤拷锟? 
        HSSFRow row = sheet.getRow(0);  
        //锟斤拷锟斤拷锟斤拷  
        int tdLength = row.getPhysicalNumberOfCells();
        HSSFCell cell = row.getCell(0);
        //6.锟矫碉拷锟斤拷元锟斤拷锟斤拷式  
        CellStyle cellStyle = cell.getCellStyle();  
        for(int i=0;i<trLength;i++){  
            //锟矫碉拷Excel锟斤拷锟斤拷锟斤拷锟斤拷锟? 
            HSSFRow row1 = sheet.getRow(i);  
            for(int j=0;j<tdLength;j++){  
                  
            //锟矫碉拷Excel锟斤拷锟斤拷锟斤拷指锟斤拷锟叫的碉拷元锟斤拷  
            HSSFCell cell1 = row1.getCell(j);  
              
            /** 
             * 为锟剿达拷锟斤拷Excel锟届常Cannot get a text value from a numeric cell 
             * 锟斤拷锟斤拷锟斤拷锟斤拷锟叫碉拷锟斤拷锟捷讹拷锟斤拷锟矫筹拷String锟斤拷锟酵革拷式 
             */  
            if(cell1!=null){  
                  cell1.setCellType(CellType.STRING);
                  //锟斤拷锟矫恳伙拷锟斤拷械锟街? 
                  System.out.print(cell1.getStringCellValue()+"\t\t\t");  
                  }  
                  System.out.println();  
             }  
              

        }  
    }  
		
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	getExcelAsFile();
	}
    
	}
	
	 
