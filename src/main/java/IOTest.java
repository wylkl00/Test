import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class IOTest {
	
	public static String base="C:\\Users\\lianglu\\Desktop\\";
	public static long maxSize=10*1024*1024;
	public static String charset="UTF-8" ;
	
	public static void main1(){
		File root = new File("f://视频");
		String pattern="^.*[a-zA-Z]{2,6}-[0-9]{1,4}.*(?<!\\.jpg)$";
		String pattern2="^(?!.*?\\.jpg$).*[a-zA-Z]{2,6}-[0-9]{1,4}.*$";

		String targetFileName = "my.txt";
		List<String> list=new ArrayList<>();
		get(root,pattern,list);
		PatternTest.p(list);
		PatternTest.p(list.size());
	}

	private static void find(File file, String pattern) {
		File[] subFiles = file.listFiles();
		Pattern p=Pattern.compile(pattern);

		for( File f : subFiles ){
			if( f.isDirectory() ){
				find(f,pattern);
			}else{
				Matcher m= p.matcher( f.getName());
				if(m.find()){
					System.out.println("找到了:"+f.getAbsolutePath());
				}
			}
		}
	}


	private static void get(File file,String pattern,List<String> list){
		File[] subFiles = file.listFiles();
		for( File f : subFiles ){
			String path =f.getName();
			if (path.matches(pattern)){
				System.out.println("找到了:"+f.getAbsolutePath());
				list.add(f.getAbsolutePath());
			}
			if(f.isDirectory() ){
				get(f,pattern,list); 
			}
		}

	}
	
	public static void main2() {
		File root = new File("D:\\食戟之灵");
		File[] subFiles = root.listFiles();
		String keyword = "[YYDM-11FANS][ShokugekinoSouma]";
		for( File file : subFiles){
			String name= file.getName();
			if(name.indexOf(keyword)>=0){
				String i = name.substring(32,34);
				String newname ="[CASO&SumiSora][Shokugeki_no_Soma]["+i+"][x264_aac].ass";
				file.renameTo(new File("D:\\食戟之灵\\"+newname));
			}
		}
	}
	
	public static List<Character> readAllChars(String fileName) throws IOException {  
	    Path path = Paths.get(fileName);  
	    long size = Files.size(path);  
	    if (size > maxSize) {  
	        throw new IOException("file: " + path + ", size:" + size + "> " + maxSize);  
	    }  
//	    InputStreamReader fReader = new InputStreamReader(new FileInputStream(fileName),"UTF-8");	    
	    FileReader freader= new FileReader(path.toFile());
	    BufferedReader breader = new BufferedReader(freader);
	    List<Character> list =new ArrayList<>();	    
	    int thischar =-1;
	    while (( thischar = breader.read()) != -1) {
	    	
            list.add((char) thischar);
         }   
	    breader.close();
	    freader.close();
	    return list;
	    
	}  
	
	public static List<String> readAlllines(String fileName) throws IOException {  
	    Path path = Paths.get(fileName);  
	    long size = Files.size(path);  
	    if (size > maxSize) {  
	        throw new IOException("file: " + path + ", size:" + size + "> " + maxSize);  
	    }   
//	    InputStreamReader freader = new InputStreamReader(new FileInputStream(fileName),"UTF-8");
	    FileReader freader= new FileReader(path.toFile());
	    BufferedReader breader = new BufferedReader(freader);
	    String thisline = null;
	    List<String> list =new ArrayList<>();
	    while (( thisline = breader.readLine()) != null) {
            list.add(thisline);
         }   
	    breader.close();
	    freader.close();
	    return list;
	} 

	
	public static void main(String[] args) throws IOException {
		
		ArarryTest.printarray(readAllChars(base+"newtext.txt").toArray(new Character[0]));
		List <String>lines=readAlllines(base+"newtext.txt");
		 Iterator<String> iterator = lines.iterator();
		 	
		    FileWriter fwriter =new FileWriter(new File(base+"123.txt"));
		    BufferedWriter bwriter = new BufferedWriter(fwriter);
		    while (iterator.hasNext()){
		    	String msg=iterator.next();
//		    	Files.write(file.toPath(), msg.getBytes("UTF-8"));
//		    	Files.write(file.toPath()," ".getBytes("UTF-8"));

		    	bwriter.write(msg);
		    	bwriter.append(" ");
//		    	bwriter.newLine();//换行
		    }
		    	bwriter.flush();
		    	fwriter.close();
		
	}
}
   
