package in.com.rays.collable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestStoreFunction {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		java.sql.CallableStatement clstmt = conn.prepareCall("{?=CALL square(?)}");

		clstmt.setInt(2, 20);

		clstmt.registerOutParameter(1, Types.INTEGER);
		clstmt.execute();

		System.out.println("sum :" + clstmt.getInt(1));
	}

}
