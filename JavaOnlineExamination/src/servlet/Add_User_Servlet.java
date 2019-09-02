package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import subject.Subject;
import subject.SubjectDao;
import user.User;
import user.UserDao;

/**
 * Servlet implementation class Add_User_Servlet
 */
public class Add_User_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_User_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String account = request.getParameter("account");
		String  password = request.getParameter("password");
		String usertype;
		String  user_type = request.getParameter("user_type");
		if(user_type.equals("ѧ��")) {
			usertype = "2";
		}else{
			usertype = "1";
		}
		
		System.out.println();
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setUser_type(usertype);
		
		UserDao dao = new UserDao();
		boolean result = dao.doAddUser(user);
		if(result) {
			 JOptionPane.showMessageDialog(null, "��ӳɹ�!", "����",JOptionPane.WARNING_MESSAGE);
			 response.sendRedirect("all_manage/tab.jsp");
		}else {
			 JOptionPane.showMessageDialog(null, "���ʧ��!", "����",JOptionPane.WARNING_MESSAGE);
			 response.sendRedirect("all_manage/tab.jsp");
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
