package in.com.rays.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransactionHandling {

	public static void main(String[] args) throws Exception {
		
		Connection conn=null;
		
		try {

		Class.forName("com.mysql.cj.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		
		conn.setAutoCommit(false);

		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into user values(5, 'jack', 'will', 'adbcd@gmail.com', '1213447', 'bhopal' )");
	
		 i = stmt.executeUpdate("insert into user values(5, 'tanziro', 'nakasaki', 'adbcdsds@gmail.com', '12123453447', 'gwalior' )");

		 i = stmt.executeUpdate("insert into user values(6, 'luffy', 'legend', 'adbcdasd@gmail.com', '1223413447', 'dewas' )");
		 
		 conn.commit();
		 System.out.println("data inserted = " + i);
		}catch (Exception e) {
			conn.rollback();
			System.out.println("exception = "+ e.getMessage());
		}finally {
			conn.close();
		}
	}

}
