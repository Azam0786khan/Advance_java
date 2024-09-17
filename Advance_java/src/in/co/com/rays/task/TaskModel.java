package in.co.com.rays.task;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskModel {

	public Integer nextPk() throws Exception {

		Class.forName("com.mqsql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from task");

		ResultSet rs = pstmt.executeQuery();

		int pk = 0;
		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void add(TaskBean bean) throws Exception {

		Class.forName("com.mqsql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into task values()?, ?, ?, ?, ?, ?, ?");

		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getTaskName());
		pstmt.setString(3, bean.getDescription());
		pstmt.setString(4, bean.getAssignTo());
		pstmt.setDate(5, new java.sql.Date(bean.getDueDate().getTime()));
		pstmt.setString(6, bean.getPriority());
		pstmt.setString(7, bean.getStatus());

		int i = pstmt.executeUpdate();
		System.out.println("Data Inserted = " + i);

	}

	public void Update(TaskBean bean) throws Exception {

		Class.forName("com.mqsql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update task set task_name = ?, description = ?, assigned_to= ?, due_date = ?, priority = ?, status = ? where id = ? ");

		pstmt.setString(1, bean.getTaskName());
		pstmt.setString(2, bean.getDescription());
		pstmt.setString(3, bean.getAssignTo());
		pstmt.setDate(5, new java.sql.Date(bean.getDueDate().getTime()));
		pstmt.setString(6, bean.getPriority());
		pstmt.setString(7, bean.getStatus());

		int i = pstmt.executeUpdate();

		System.out.println("data updated = " + i);

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mqsql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from task where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("data deleted = " + i);
	}

	public List search(TaskBean bean) throws Exception {

		Class.forName("com.mqsql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		StringBuffer sql = new StringBuffer("select * from task where 1=1");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append("and id=" + bean.getId());

			}

			if (bean.getTaskName() != null) {
				sql.append("and taskName = " + bean.getTaskName());
			}

		}
	 ResultSet rs = pstmt.executeQuery();
	 
	 List list = new ArrayList();

	 while(rs.next()) {
		 bean = new TaskBean();
		 bean.setId(rs.getInt(1));
		 bean.setTaskName(rs.getString(2));
		 bean.setDescription(rs.getString(3));
		 bean.setAssignTo(rs.getString(4));
		 bean.setDueDate(rs.getDate(5));
		 bean.setPriority(rs.getString(6));
		 bean.setStatus(rs.getString(7));
	 }
	 return list;
	}
}
