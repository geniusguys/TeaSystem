package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.Counter;
import user.User;

/**
 * Servlet implementation class Exit_Servlet
 */
public class Exit_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exit_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession session  = request.getSession();
		ServletContext application = this.getServletContext();
		
		 User user = (User)session.getAttribute("user");
		 System.out.println(user.getAccount());
		if(user.getUser_type().equals("2")) {
			session.setAttribute("user", null);//���session����
			
			int count;
			String count_user;//��ǰ��������
			count_user = (String)application.getAttribute("count");//ǿ��ת��
			
			System.out.println("�˳�������ǰ��"+count_user);
			
			Counter x= Counter.getinstance();
			count = x.getexitvistorcount(Integer.parseInt(count_user));
			if(count<0) {
				count=0;
			}
			System.out.println("�˳�������Ϊ��"+count);
			application.setAttribute("count",String.valueOf(count));//������������
			response.sendRedirect("Login_suprime/Login.jsp");
		}else {
			response.sendRedirect("Login_suprime/Login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
