package in.com.rays.enrollment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.com.rays.marksheet.MarksheetBean;

public class EnrollmentModel {

	public Integer nextPk() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from enrollment");

		ResultSet rs = pstmt.executeQuery();

		int pk = 0;

		while (rs.next()) {

			pk = rs.getInt(1);
		}
		return pk + 1;

	}

	public void add(EnrollmentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into enrollment values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, nextPk());
		pstmt.setInt(2, bean.getStudentId());
		pstmt.setInt(3, bean.getCourseId());
		pstmt.setDate(4, new java.sql.Date(bean.getEnrollmentDate().getTime()));
		pstmt.setString(5, String.valueOf(bean.getGrade()));
		pstmt.setString(6, bean.getStatus());

		int i = pstmt.executeUpdate();

		System.out.println("inserted data = " + i);

	}

	public void update(EnrollmentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement(
				"update enrollment set StudentId = ?, CourseId = ?, enrollmentDate = ?, Grade = ?, Status = ? where Id = ?");

		pstmt.setInt(1, bean.getStudentId());
		pstmt.setInt(2, bean.getCourseId());
		pstmt.setDate(3, new java.sql.Date(bean.getEnrollmentDate().getTime()));
		pstmt.setString(4, bean.getGrade());
		pstmt.setString(5, bean.getStatus());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data updated = " + i);

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from enrollment where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted = " + i);

	}

	public EnrollmentBean findbypk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from enrollment where id = ?");

		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

		EnrollmentBean bean = null;

		while (rs.next()) {

			bean = new EnrollmentBean();
			bean.setId(rs.getInt(1));
			bean.setStudentId(rs.getInt(2));
			bean.setCourseId(rs.getInt(3));
			bean.setEnrollmentDate(rs.getDate(4));
			bean.setGrade(rs.getString(5));
			bean.setStatus(rs.getString(6));

		}
		return bean;

	}

	public List search(EnrollmentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		StringBuffer sql = new StringBuffer("select * from enrollment where 1=1");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		if (bean != null) {
			if (bean.getStudentId() > 0) {
				sql.append(" and StudentId =" + bean.getStudentId());
			}
		}

		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {

			bean = new EnrollmentBean();
			bean.setId(rs.getInt(1));
			bean.setStudentId(rs.getInt(2));
			bean.setCourseId(rs.getInt(3));
			bean.setEnrollmentDate(rs.getDate(4));
			bean.setGrade(rs.getString(5));
			bean.setStatus(rs.getString(6));
			list.add(bean);

		}
		return list;
	}
}
