package user;
/**
 *  Java���ģʽ��  ��������
 * @author ����
 *
 */
public class Counter {
	private static Counter instance = null;
	int  i = 0;
	
	private Counter() {
		
	}

	public int getvistorcount() {
		i++;
		return i;
	}
	
	public int getvistorcount(int count) {
		i++;
		return i;
	}
	public int getexitvistorcount(int count) {
		i--;
		return i;
	}
	
	
	public static Counter getinstance() {
		synchronized(Counter.class) {
			if( instance == null) {
				instance = new Counter();
			}
			return instance;
			
		}
		
	}
}
