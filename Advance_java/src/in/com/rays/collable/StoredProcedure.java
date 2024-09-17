package in.com.rays.collable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class StoredProcedure {

	public static void main(String[] args) throws Exception {

		// testIn();
		//testOut();
		 testInOut();

	}

	private static void testIn() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		java.sql.CallableStatement clstmt = conn.prepareCall("{CALL userIn(?)}");

		clstmt.setInt(1, 1);
		clstmt.execute();
		ResultSet rs = clstmt.getResultSet();

		while (rs.next()) {
			System.out.println(rs.getString(2));

		}
	}

	private static void testOut() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		java.sql.CallableStatement clstmt = conn.prepareCall("{CALL userOut(?)}");

		clstmt.registerOutParameter(1, Types.INTEGER);
		clstmt.execute();
		int i = clstmt.getInt(1);
		System.out.println("empOut :" + i);

	}

	private static void testInOut() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		java.sql.CallableStatement clstmt = conn.prepareCall("{CALL userInOut(?)}");
		
		clstmt.setInt(1, 1);

		clstmt.registerOutParameter(1, Types.INTEGER);
		clstmt.execute();
		int i = clstmt.getInt(1);
		System.out.println("empInOut :" + i);


	}

}
