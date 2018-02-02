package chapter21;
/*��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min
�������ڸ�ջ�У�����min�� push��pop�¶�ʱ�临�Ӷȶ���O(1)
˼·��
1.������ջ��һ��ջ�洢���ݣ���һ��ջ�洢��С�����ݣ�ֻ�е����������С��mintopʱ����ѹ��minstack*/
import java.util.Stack;

public class Problem21 {
	private Stack<Integer> minstack=new Stack<Integer>();
	private Stack<Integer> datastack=new Stack<Integer>();
	
	public void push(int data)
	{
		datastack.push(data);
		if(minstack.isEmpty()||data<minstack.peek())
			minstack.push(data);
	}
	public Integer pop()
	{
		if(datastack==null)
			return null;
		return datastack.pop();
	}
	public Integer min(){
		return minstack.pop();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}
}
