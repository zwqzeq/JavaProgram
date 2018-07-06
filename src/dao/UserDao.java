package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {
	
	
	public ResultSet getID(String id, Connection con) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from Student where student_id='"+id+"'");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}
	
	
	public ResultSet getUsers(User user, Connection con) throws SQLException {
		StringBuffer sql = new StringBuffer("select * from Student ");
		if (user.getName() != null) {
			sql.append(" where name like '%" + user.getName() + "%'");
		}
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	public int delete(User user, Connection con) throws SQLException {
		String sql = "delete from Student where name='" + user.getName() + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public int add(User user, Connection con) throws SQLException {
		// 当表有多列时且要给某些列赋值时需要指定列如"insert into Student(name,faculty) values(?,?)"
		// 不能为"insert into Student values(?,?)"
		String sql = "insert into Student(name,faculty,student_id,sex) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, user.getName());
		ps.setString(2, user.getFaculty());
		ps.setString(3, user.getStudent_id());
		ps.setString(4, user.getSex());

		return ps.executeUpdate();
	}

	public int modify(User user, Connection con) throws SQLException {
		String sql = "update Student  set  name=?, faculty=?,student_id = ? ,sex=? where name = '" + user.getName()
				+ "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getFaculty());
		ps.setString(3, user.getStudent_id());
		ps.setString(4, user.getSex());
		return ps.executeUpdate();
	}
}
