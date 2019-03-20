package dao.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JdbcConnexion {
	private static String url= "jdbc:mysql://localhost:3306/cache_01";
    
    private static String user = "root";
    private static String mdp = "";
    private static Connection connect;
    
    public static Connection getInstance(){
    if(connect == null){
    try {
    	
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, mdp);
    } catch (SQLException e) {
    e.printStackTrace();
  } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}      
return connect;
} 
}
