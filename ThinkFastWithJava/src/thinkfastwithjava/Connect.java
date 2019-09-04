
package thinkfastwithjava;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Bayan Mamun ID: 434023821
 */
public class Connect {
   public static final String USER = "root";
   public static final String PASSWORD = "2181894805";
   public static final String URL = "jdbc:mysql://localhost:3306/think_fast_with_java";
   
   public static Connection getConnection(){
     Connection con = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception ex){
            System.out.println("Exception :"+ex.getMessage());
        }        
        try{                
                con =  DriverManager.getConnection(URL,USER,PASSWORD);
                System.out.println("Connected");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return con;   
   }
}
