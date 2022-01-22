package calculatePoint;

import java.sql.* ;    
    
public class JDBC {    
  
    private static String url="jdbc:oracle:thin:@10.23.2.78:1521:hs08";    
    //system为登陆oracle数据库的用户名     
    private static String user="hs_acpt";    
    //manager为用户名system的密码     
    private static String password="hundsun";    
    public static Connection conn;    
    public static PreparedStatement ps;    
    public static ResultSet rs;    
    public static Statement st ;    
    //连接数据库的方法     
    public static Connection getConnection(){    
        try {    
            //初始化驱动包     
            Class.forName("oracle.jdbc.driver.OracleDriver");    
            //根据数据库连接字符，名称，密码给conn赋值     
            conn=DriverManager.getConnection(url, user, password);    
                
        } catch (Exception e) {    
            // TODO: handle exception     
            e.printStackTrace();    
        }    
        return conn;
    }    
    
     //测试能否与oracle数据库连接成功     
     public static void main(String[] args) {       
        JDBC.getConnection();    
        if(conn==null){    
            System.out.println("与oracle数据库连接失败！");    
        }else{    
            System.out.println("与oracle数据库连接成功！");    
        }  
        try {
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
     }    
}  


	
