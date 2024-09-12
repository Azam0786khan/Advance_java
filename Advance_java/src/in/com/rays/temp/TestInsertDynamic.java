package in.com.rays.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsertDynamic {

	public static void main(String[] args) throws Exception {

		// testInsert1();
		testInsert2();

	}

	public static void testInsert1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(8, 18, 'emma', 60, 65, 80)");

		int i = pstmt.executeUpdate();

		System.out.println("data inserted = " + i);
	}

	public static void testInsert2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, 8);
		pstmt.setInt(2, 18);
		pstmt.setString(3, "emma");
		pstmt.setInt(4, 50);
		pstmt.setInt(5, 60);
		pstmt.setInt(6, 70);

		int i = pstmt.executeUpdate();

		System.out.println("data inserted = " + i);
	}
}
