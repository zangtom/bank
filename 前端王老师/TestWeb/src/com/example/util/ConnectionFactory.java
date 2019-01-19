package com.example.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionFactory {
	//添加四个成员变量，用于保存从属性文件中读取到的数据库配置信息
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private static final ConnectionFactory factory=new ConnectionFactory();
	private Connection conn;
	static{
		//用来保存属性文件中的键值对   该类方法主要处理属性文件中定义的键值对
		Properties prop=new Properties();
		//获取属性文件中的内容
		//class.getClassLoader()获取类加载器
		InputStream in=ConnectionFactory.class.getClassLoader().
				getResourceAsStream("db1.properties");
		try {
			//从输入流中读取属性列表
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将读取到的值赋给定义的变量
		driver=prop.getProperty("driver");
		dburl=prop.getProperty("dburl");
		user=prop.getProperty("user");
		password=prop.getProperty("password");
	}
	//定义构造函数
	private ConnectionFactory(){
		
	}
	//获取实例  单例模式
	public static ConnectionFactory getInstance(){
		return factory;
	}
	//创建一个获取数据库连接的方法
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
