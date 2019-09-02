package questionStem;

import java.util.ArrayList;



public class QuestionDao {

	private QuestionQuery query=new QuestionQuery();
	private QuestionDelete delete=new QuestionDelete();
	private QuestionInsert insert=new QuestionInsert();
	private QuestionUpdate update=new QuestionUpdate();
	
	/**
	 * ��ѯ�����������Ϣ
	 * @return һ�������
	 */
	public ArrayList<Question> queryAll() {
		
		return query.doSelectAll();
	}
	/**
	 * ���������Ϣ
	 * @param question
	 * @return����һ����������
	 */
	public int intsertQuestion(Question question) {
		
		return insert.questionInsert(question);
	}
	/**
	 * ��������idɾ��������Ϣ
	 * @param id
	 * @return����һ����������
	 */
	public int deleteQuestion(int id) {
		
		return delete.questionDelete(id);
	}
	/**
	 * ��������id�޸�������Ϣ
	 * @param id
	 * @return
	 */
	public int updateQuestion(int id) {
		
		return update.doUpdateQuestion(id);
	}
	
}
