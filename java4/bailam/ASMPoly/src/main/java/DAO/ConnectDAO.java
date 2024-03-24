package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDAO {
	
	protected Connection conn;
	
	public ConnectDAO() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=ASMJava4;encrypt=true;trustServerCertificate=true";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, "sa", "songlong");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
