/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.TECH;
import java.sql.*;


/**
 *
 * @author mokhtar
 */
public class MyConnection {
     private static final String url = "jdbc:mysql://localhost:3306/mydb";
     private static final String user = "root" ;
     private static final String pwd= "" ;
      private static Connection con ;
      
      
       public static Connection getInstance() {
        if (con ==null) {
            new MyConnection().etablirConnection();
            
        }
        return con;
    }

 
      
    private MyConnection() {
 
    }
  public Connection etablirConnection(){
      try {
          con = DriverManager.getConnection(url, user, pwd);
          System.out.println("EDU.PI.TECH.MYCONX.etablirConnection()");
      }
      catch (SQLException ex){
          System.out.println("you are out");
      }
       return con ;
       
  }  
    
    
    
}
