package com.example.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.entity.User;
import com.example.service.CheckUserService;
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CheckUserService cku=new CheckUserService();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("===进入doget方法===");
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("===进入doPost方法===");
		//doGet(request, response);
		//获取客户端提交的用户名和密码信息
		String uname=request.getParameter("uname");
		String passwd=request.getParameter("upwd");
		RequestDispatcher rd=null;
		String forward=null;
		if(uname==null || passwd==null){
			request.setAttribute("msg","用户名或者密码为空");
			rd=request.getRequestDispatcher("/01/error.jsp");
			rd.forward(request, response);
		}else{
			User user=new User();
			user.setName(uname);
			user.setPassword(passwd);
			boolean bool=cku.check(user);
			if(bool){
				forward="/01/success.jsp";
			}else{
				request.setAttribute("msg","用户名或者密码错误，请重新输入");
				forward="/01/error.jsp";
			}
			//请求的重定向
			rd=request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
	}
}
