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
import user.UserDao;

/**
 * Servlet implementation class Login_servlet
 */
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//��������
		/*response.setContentType("text/html ; charset = utf-8"); 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("urf-8");*/
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ServletContext application = this.getServletContext();
		
		String account = request.getParameter("account");

		String  password = request.getParameter("password");
		
		User user = new User();
		user.setAccount(account);
	
		UserDao dao = new UserDao();
		boolean flag = dao.isLogin(user, password);
		if(flag) {
			user = dao.doSelectByUsername(account);//���÷����жϵ�¼ 
			session.setAttribute("user",user);//���û��˺ű��浽session���� user��
			//user_type 0�� ����Ա  1����ʦ  2��ѧ��
			if(user.getUser_type().equals("0")) {
				response.sendRedirect("Main_exam.jsp");		
			
				 int count;
				 String count_user;//��ǰ��������
				 count_user = (String)application.getAttribute("count");//ǿ��ת��
				 System.out.println("��¼ǰ����Ϊ��"+count_user);
				 if(count_user == null) {
					 count=1;
				 }else {
					 int countt = Integer.parseInt(count_user);
					 Counter x= Counter.getinstance();
					 count = x.getvistorcount(countt); 
				 }
				 
				System.out.println("��¼������Ϊ��"+count);
				System.out.println();
				 application.setAttribute("count",String.valueOf(count));//����������
			 
			}else if(user.getUser_type().equals("2")) {
				
				 session.setAttribute("user",user);//���û��˺ű��浽session���� user��
				// response.sendRedirect("first.jsp");
			}else if(user.getUser_type().equals("1")) {
				session.setAttribute("user",user);//���û��˺ű��浽session���� user��
				 response.sendRedirect("Student.jsp");
			}
			   
   
			 
			
		 }else{
			 response.sendRedirect("error.html");
			 //JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ���");
			 
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
