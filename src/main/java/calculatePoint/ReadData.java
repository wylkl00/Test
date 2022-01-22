package calculatePoint;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;



public class ReadData {
	
	public static String base="C:\\Users\\lianglu\\Desktop\\";
	public static long maxSize=10*1024*1024;
	public static String charset="GBK" ;
	
	public static void main (String[] args) throws Exception {
		Path filePath = Paths.get(base, "成绩.txt");
		
		List<String> data = readAlllines(filePath.toString());
		java.util.ListIterator<String> i= data.listIterator();
		String year,no,name,type,point,total_grade,avg_point ="";
	while(i.hasNext()){
			year =  i.next();
			no = i.next();
			name = i.next();
			type = i.next();
			point = i.next();
			total_grade = i.next();
			while(i.hasNext()){
				if(i.next().matches("^201\\d-201\\d-\\d")){
					i.previous();
					avg_point = i.previous();
					i.next();
					break ;
				}else{
					avg_point="";
				}
			}
			if("".equals(avg_point)){
				avg_point=i.previous();
				i.next();
			}
			incData(year, no, name, point, total_grade, type, avg_point);
		}

	}
	
	public static boolean incData(String year,String no,String name,String type,String point,String total_grade, String avg_point){
		Connection conn = JDBC.getConnection();
		String sql ="insert into grade(year,no,name,point,total_grade,type,avg_point) values (?,?,?,?,?,?,?)";
		boolean flag =false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, no);
			ps.setString(3, name);
			ps.setString(4, type);
			ps.setString(5, point);//video_status 
			ps.setString(6, total_grade);
			ps.setString(7, avg_point);
			int i = ps.executeUpdate();
			if (i>0){
				flag =true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	
	public static List<String> readAlllines(String fileName) throws IOException {  
	    Path path = Paths.get(fileName);  
	    long size = Files.size(path);  
	    if (size > maxSize) {  
	        throw new IOException("file: " + path + ", size:" + size + "> " + maxSize);  
	    }   
	    Charset cs=Charset.forName(charset);
	    return Files.readAllLines(path, cs);  
	} 
	

	public static void main2 (String[] args) {
		incData("1.5", "1.5", "1.5", "1.5", "1.5", "1.5", "1.5");
	}
}
