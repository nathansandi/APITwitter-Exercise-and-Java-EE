
package main;
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
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(true);
			/*ds.setServerName("localhost");
			ds.setPortNumber(1433); 
			ds.setDatabaseName("twitterDB");
                        ds.setUser("sa");
                        ds.setPassword("nathan123");
			con = ds.getConnection();
                        */
                        //setting connection to azure
                        String azure = "jdbc:sqlserver://twittern.database.windows.net:1433;database=twitterDB;user=nsandi7@twittern;password=pa1@pato;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
                         con = DriverManager.getConnection(azure);
                        System.out.println("success");
                       
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
        public static String insertData(String hashtag, String user, String country, String language, int followers, String date, Connection con) {		
		// Declare the JDBC objects.
                CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
                        
	        	// Execute a stored procedure that returns some data.
            		cstmt = con.prepareCall("INSERT INTO [dbo].[tbTweetsData]\n" +
                        "           ([hashtag]\n" +
                        "           ,[data]\n" +
                        "           ,[userId]\n" +       
                        "           ,[followers]\n" +
                        "           ,[country]\n" +
                        "           ,[language])\n" +
                        "     VALUES\n" +
                        "           ('"+hashtag+"'\n" +                             
                        "           ,'"+date+"'\n" + //2012-01-05 15:05:23
                        "           ,'"+user+"'\n" +  
                        "           ,"+followers+"\n" +
                        "           ,'"+country+"'\n" +
                        "           ,'"+language+"')");
            		//cstmt.setInt(1, 50);
            		cstmt.executeUpdate();
                        return "Inserido com sucesso ";
                         
	        }
	        
		// Handle any errors that may have occurred.
	    	catch (Exception e) {
	    		e.printStackTrace();
                        System.out.println("error");
                        return "Erro";
	    	}
                
	   	/*finally {
	    		if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (cstmt != null) try { cstmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
	    	}*/
        }
}
