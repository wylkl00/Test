/**
 * 
 */

/**
 * @author Administrator
 *
 */
import java.io.File;
import java.io.IOException;  
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;  
import java.nio.file.LinkOption;  
import java.nio.file.Path;  
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;  
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.util.Date;  
  
/** 
 * Files类主要是用来对文件的 
 * @author zKF57533 
 */  
public class FilesDemo {  
    /** 
     * 非常方便的对文件进行移动操作 
     * 将tt.txt从pathFrom文件夹位置移动到pathTo文件夹下 
     * <h1>此方法可以和copy这个方法相比较，用法相同，其他增删改查操作请参考api即可</h1> 
     * @throws IOException  
     */  
    public static void moveFile() {  
        Path pathFrom = Paths.get("e:/logs", "tt.txt");  
        //其中e:/logs/errorLog/tt.txt的tt.txt文件可以不存在，如果存在会被替换掉  
        Path pathTo = pathFrom.getParent().resolve("errorLog/dd.txt");  
        try {  
            //文件的大小bytes  
            System.out.println(Files.size(pathFrom));  
            //调用文件移动方法  
            Files.move(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);  
        } catch (IOException e) {  
            System.err.println("移动文件错误" + e.getMessage());  
        }  
    }  
      
    /** 
     * 测试文件的属性信息 
     * 包括文件的修改时间、是否是文件夹、创建时间等 
     */  
    @SuppressWarnings("deprecation")  
    public static void fileAttributes(){  
        Path path = Paths.get("e:/logs");  
        //1  
        System.out.println(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS));  
        //2  
        try {  
            //获得文件的基础属性  
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);  
            System.out.println(attributes.isDirectory());  
            System.out.println(new Date(attributes.lastModifiedTime().toMillis()).toLocaleString());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 创建文件夹 
     * 遍历文件夹下的文件 
     */  
    public static void createDir(){  
        Path path = Paths.get("D:/test");  
        try {  
            //创建文件夹  
            if(Files.notExists(path)){  
                Files.createDirectories(path);  
                System.out.println("create dir");  
            }else{  
                System.out.println("dir exists");  
            }  
            //在创建的文件夹下建几个txt文件,例如  
            //2.txt  
            //ff  文件夹  
            //java.bat  
            //_java.txt  
            //遍历文件夹下面的文件  
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);  
            for(Path p : paths){  
                System.out.println(p.getFileName());  
            }  
            System.out.println();  
            //创建一个带有过滤器,过滤文件名以java txt bat结尾的文件  
            DirectoryStream<Path> pathsFilter = Files.newDirectoryStream(path, "*.{java,txt,bat}");  
            for(Path p : pathsFilter){  
                System.out.println(p.getFileName());  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
    /**
     * 遍历文件树中的每个文件,深度优先遍历
     * @throws IOException
     */
    public static void filevist() throws IOException {
    	Path path = Paths.get("D:\\群星 mod");
    	//匿名内部类 构造一个FileVisitor的实现类
    	Files.walkFileTree(path, new FileVisitor<Path>(){  //        SimpleFileVisitor<Path>()         
    		@Override                
    		public FileVisitResult preVisitDirectory(Path dir,                       
    				BasicFileAttributes attrs) throws IOException {                   
    			//访问文件夹之前调用                    
    			System.out.println(dir);                     
    			return FileVisitResult.CONTINUE;               
    		}                
    		@Override                
    		public FileVisitResult visitFile(Path file,                        
    				BasicFileAttributes attrs) throws IOException {                    
    			// 访问文件调用                     
    			System.out.println(file);                   
    			return FileVisitResult.CONTINUE;               
    		}                
    		@Override                 
    		public FileVisitResult visitFileFailed(Path file, IOException exc)                         
    				throws IOException {                    
    			// 访问文件失败时调用                     
    			return FileVisitResult.CONTINUE;                
    		}                 
    		@Override                
    		public FileVisitResult postVisitDirectory(Path dir,                        
    				IOException exc) throws IOException {                    
    			// 访问文件夹之后调用
    			System.out.println("over"+dir);  
    			return FileVisitResult.CONTINUE;               
    		}                           
    	});        
    }   
}


