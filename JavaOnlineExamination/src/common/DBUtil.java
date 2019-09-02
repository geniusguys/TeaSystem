package common;
/**
 * ���ݿ⹫����
 * @author ���г�
 * @date 2018-04-03
 */
import java.sql.*;
public class DBUtil {
	private Connection conn;
	private Statement stmt ;
	private ResultSet rs;
	
	
	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	/**
	 *1.���췽��������ʱ�������ݿ����
	 */
	public DBUtil(){
		String className ="com.mysql.jdbc.Driver";
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ����ʧ�ܣ�");
		}
			
	}
	
	/**
	 * 2.�������ݿ�
	 * @return ����һ�����ݿ�����
	 */
	public Connection getConn() {
		String url = "jdbc:mysql://localhost:3306/examdb?characterEncoding=utf-8";
		String user = "root";
		String password = "123456" ;
		try {
			 conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
		return conn;
		
	}
	
	/**
	 * 3.������������SQL�����Statement�Ķ���
	 * @return
	 */
	public Statement getStmt() {
		 try {
			 if(conn == null) {
				 conn = this.getConn();
			 }
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ���");
		}
		return stmt;
	}
	
      /**
       * 4.ִ��SQL���� ��insert ��update ��delete��
       * @param sql
       * @return -1 ����ִ��SQL����ʧ�ܣ�>=0�ɹ�
       */
	public  int  executeUpdate(String sql) {
		int result = -1;//����SQL����û�гɹ�
		try {
			if(stmt == null) {
				stmt = this.getStmt();
			}
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL����ִ��ʧ�ܣ�");
		}
		return result;
	}
	
	/**
	 * 5.ִ�в�ѯ����
	 * @param sql
	 * @return 
	 */
	
	public ResultSet executeQuery(String sql) {
		try {
			if(stmt == null) {
			   stmt = this.getStmt();
			}
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ѯSQL����ִ��ʧ�ܣ�");
		}
		return rs;
	}
	
	
	/**
	 * 6.�ر����ݿ�
	 */
	public void Close(){
		try{
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			
			if( conn != null){
				conn.close();
				conn = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.print("�ر����ݿ�ʧ�ܣ�");
		}
	}
}
