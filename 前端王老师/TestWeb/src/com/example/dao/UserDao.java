package com.example.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.entity.User;
public interface UserDao {
	//保存用户信息
	public void save(Connection conn,User user)throws SQLException;
	public void update(Connection conn,Long id,User user)throws SQLException;
	public void delete(Connection conn,User user)throws SQLException;
	//根据用户名和密码获取用户信息
	public ResultSet get(Connection conn,User user)throws SQLException;
}
