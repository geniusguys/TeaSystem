package questionStem;

import common.DBUtil;

public class QuestionUpdate {

	private DBUtil db=new DBUtil();
	private Question ques=null;
	
	public int doUpdateQuestion(int id) {
		//1,����sql����
		String sql = "update question_stem set ques_name='"+ques.getQ_name()+"', select_a='"+ques.getSelectA()+"',select_b='"+ques.getSelectB()+"'"
				+ "select_c='"+ques.getSelectC()+"',select_d='"+ques.getSelectD()+"',score='"+ques.getQ_score()+"',ques_right_answer='"+ques.getQ_right()+"' where ques_id='"+id+"';";
		//2���͵����ݿ���ȡִ��
		int row = db.executeUpdate(sql);
		//3,�ر����ݿ�
		db.Close();
		//4�����ؽ��
		return row;
	}
}
