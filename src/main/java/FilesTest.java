import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FilesTest {
	
	public static String base="C:\\Users\\lianglu\\Desktop\\";
	public static long maxSize=10*1024*1024;
	public static String charset="GBK" ;
	
	
	public static byte[] readAllBytes(String fileName) throws IOException {  
	    Path path = Paths.get(fileName);  
	    long size = Files.size(path);  
	    if (size > maxSize) {  
	        throw new IOException("file: " + path + ", size:" + size + "> " + maxSize);  
	    }  
	    return Files.readAllBytes(path);  
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
	
	public static void readfile(String fileName) throws IOException{
		Path path = Paths.get(fileName);
		try (InputStream in = Files.newInputStream(path)) {  
			in.read();
		}  
	}
	
	public static void main2() throws IOException {
		Path path=Paths.get(base, "test.txt");
		List<String> lines = new LinkedList<>(readAlllines(path.toString()));
		ListIterator<String> LI = lines.listIterator();
		while (LI.hasNext()){
			String line =LI.next().trim();
			if(line.isEmpty()||line.matches("\\w+")){
				LI.remove();
			}
		}
		File file=new File(base+"newtext.txt");   
	    if(!file.exists())   
	    {   
	        try {   
	            file.createNewFile();   
	        } catch (IOException e) {   
	            // TODO Auto-generated catch block   
	            e.printStackTrace();   
	        }   
	    }   
	    Charset cs=Charset.forName(charset);
	    

//	    	Files.write(file.toPath(), msg.getBytes("UTF-8"));
//	    	Files.write(file.toPath()," ".getBytes("UTF-8"));
	    	/**Files.write(Paths.get(base, "123.txt"), lines, cs);**/
	    	BufferedWriter bwriter = Files.newBufferedWriter(Paths.get(base, "234.txt"),  cs, StandardOpenOption.WRITE);
//	    	try (InputStream in = Files.newInputStream(path)) {  
//
//	    	}  
//	    	
		    Iterator<String> iterator = lines.iterator();
		    while (iterator.hasNext()){
		    	String msg=iterator.next();
		    	bwriter.write(msg);
		    	bwriter.newLine();
		    }
		    bwriter.flush();
	}
	
		public static void main3() throws IOException {
			Path path=Paths.get(base, "test.txt");
//			ByteChannel bc =Files.newByteChannel(path);
//			bc.read(dst);
			 Files.write(Paths.get(base, "12.txt"), readAlllines(path.toString()), Charset.forName("UTF-8"),StandardOpenOption.SPARSE,StandardOpenOption.CREATE);
		}
		
		public static void main6(String[] args) throws Exception {
			Path path=Paths.get(base, "test.txt");
			List<String> lines =readAlllines(path.toString());
			Pattern p = Pattern.compile("\\'[0-9]{4}[z7]|[0-9]{3}[a-z][z7]");
			List<String> print = new ArrayList<>();
			for(int i =0;i<lines.size();i++){
				 Matcher m = p.matcher(lines.get(i));
				if(m.find()){
					print.add(lines.get(i).substring(m.start(), m.end()+1));
				}
			}
			
			Files.write(Paths.get(base, "test.txt"), print, Charset.forName("UTF-8"), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
		}
		
		public static void main(String[] args) throws Exception {
			Path path=Paths.get(base, "test.txt");
			List<String> lines =readAlllines(path.toString());
			List<String> print = new ArrayList<>();
			for(int i =0;i<lines.size();i=i+3){
				print.add(lines.get(i));
			}
			
			Files.write(Paths.get(base, "test2.txt"), print, Charset.forName("UTF-8"), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
		}
		
		
		public static void main5(String[] args) {
			String str1=Paths.get("/asda" , "/def/").toString();
			String str2=Paths.get("/asda/" , "/def/").toString();
			String str3=Paths.get("/asda" , "def/").toString();
			String str4=Paths.get("/asda/" , "/def/").toString();
		}
}
