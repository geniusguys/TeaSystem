package testStem;

import common.DBUtil;

public class TestDelete {
	
	private DBUtil db=new DBUtil();
	
	/**
	 * �����Ծ�idɾ���Ծ���Ϣ
	 * @param id
	 * @return����һ����������
	 */
	public int deleteTest(int id) {
		String sql="delete from test_paper where test_id='"+id+"'";
		int row=db.executeUpdate(sql);
		db.Close();
		return row;
	}
	/**
	 * ��������idɾ���Ծ������
	 * @param id
	 * @return����һ����������
	 */
	public int deleteTestQuestion(int id) {
		String sql="delete from test_paper where ques_id='"+id+"'";
		int row=db.executeUpdate(sql);
		db.Close();
		return row;
	}
}
