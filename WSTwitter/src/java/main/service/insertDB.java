
package main.service;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

public class insertDB {

	public static Connection connectDB() {		
		// Declare the JDBC objects.
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			// Establish the connection. 
			/*SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(true);
			ds.setServerName("localhost");
			ds.setPortNumber(1433); 
			ds.setDatabaseName("twitterDB");
                        ds.setUser("sa");
                        ds.setPassword("nathan123");
			con = ds.getConnection();
                        System.out.println("success");*/
                        String azure = "jdbc:sqlserver://twittern.database.windows.net:1433;database=twitterDB;user=nsandi7@twittern;password=pa1@pato;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
                        con = DriverManager.getConnection(azure);
                         
	        }
	        
		// Handle any errors that may have occurred.
	    	catch (Exception e) {
	    		e.printStackTrace();
                        System.out.println("error");
	    	}
                return con;
	   	/*finally {
	    		if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (cstmt != null) try { cstmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
	    	}*/
	}
        public static ResultSet selectData(Connection con, String SQLIN) throws SQLException {		
		// Declare the JDBC objects.
             		Statement stmt = null;
		try{
                    ResultSet rs = null;

                    String SQL = SQLIN;
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(SQL);

                   return rs;
                }catch(Exception e){
                    e.printStackTrace();
                    return null;
                }
                    
	    
        }
}
