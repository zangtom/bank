package com.example.dao.imple;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.dao.UserDao;
import com.example.entity.User;
public class UserDaoImpl implements UserDao{
	//用来保存用户信息
	@Override
	public void save(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		//PreparedStatement  执行sql语句(参数化)  
		//  ?为占位符，代表具体的参数
		/*PreparedStatement ps=conn.prepareCall("insert into tbl_user"
				+ "(name,password,email)values(?,?,?)");
		//给?添加相应的值
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.execute();*/
	}
	//根据用户指定的Id更新用户信息
	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		// TODO Auto-generated method stub
	/*	PreparedStatement ps=conn.prepareStatement("update tbl_user set name=?,password=?,email=? where id=?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setLong(1, user.getId());
		ps.execute();*/
		
	}
	//删除指定的用户信息
	@Override
	public void delete(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
	/*	PreparedStatement ps=conn.prepareStatement("delete from tbl_user where id=?");
		ps.setLong(1, user.getId());
		ps.execute();*/
	}
	@Override
	public ResultSet get(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps=conn.prepareStatement("select * from tbl_user where name=? and password=?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.execute();
		//返回查询结果
		return ps.executeQuery();
	}
}
