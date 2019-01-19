package com.example.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.dao.UserDao;
import com.example.dao.imple.UserDaoImpl;
import com.example.entity.User;
import com.example.util.ConnectionFactory;
public class CheckUserService {
	private UserDao userDao=new UserDaoImpl();
	//登录校验的逻辑
	public boolean check(User user){
		Connection conn=null;
		try {
			//通过工厂类获取数据库连接
			conn=ConnectionFactory.getInstance().makeConnection();
			//关闭事务的自动提交
			conn.setAutoCommit(false);
			//查询是否有用户信息
			ResultSet resultset=userDao.get(conn, user);
			while(resultset.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			try {
				//关闭数据库连接
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
