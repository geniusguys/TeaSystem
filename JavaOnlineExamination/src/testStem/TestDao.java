package testStem;

import java.util.ArrayList;

public class TestDao {
	private TestQuery query=new TestQuery();
	private TestDelete delete=new TestDelete();
	private TestInsert insert=new TestInsert();
	private TestUpdate update=new TestUpdate();
	
	/**
	 * ��ѯ�Ծ�ȫ������
	 * @return����һ�������
	 */
	public ArrayList<Test> doSelectTestAll(){
		return query.queryTest();
	}
	/**
	 * �����Ծ�id�޸��Ծ���Ϣ
	 * @param id
	 * @return
	 */
	public int doUpdateTest(int id) {
		return update.updateTest(id);
	}
	/**
	 * �����Ծ�idɾ���Ծ���Ϣ
	 * @param id
	 * @return����һ����������
	 */
	public int doDeleteTest(int id) {
		return delete.deleteTest(id);
	}
	/**
	 * ��������idɾ���Ծ��е�����
	 * @param id
	 * @return����һ����������
	 */
	public int doDeleteTestQuestion(int id) {
		return delete.deleteTestQuestion(id);
	}
	/**
	 * ���һ���Ծ�
	 * @param test
	 * @return����һ����������
	 */
	public int doInsertTest(Test test) {
		
		return insert.insertTest(test);
	}
	
	
}
