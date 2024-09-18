package in.com.rays.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbcDataSource {

	public static void main(String[] args) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from user where id = 1");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.println("\t" + rs.getString(3));
		}
	}

}
