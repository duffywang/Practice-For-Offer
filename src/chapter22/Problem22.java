package chapter22;
/*
 * ջ��ѹ�룬����˳��
 * 1.��һ��ѹ��ĺ�line2��Ԫ��һ��*/
import java.util.Stack;

public class Problem22 {
	public boolean isPopOrder(int [] line1,int[] line2){
		if(line1==null&&line2==null)
			return false;
		int point1=0;
		//����ջ
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<line2.length;i++)
		{
			if(!stack.isEmpty()&&stack.peek()==line2[i])
				stack.pop();
			else
			{
				if(point1==line1.length)
					return false;
				do{
				stack.push(line1[point1++]);
				}
				while(stack.peek()!=line2[i]&&point1!=line1.length);
					if(stack.peek()==line2[i])
						stack.pop();
					else
						return false;
			}
		}
			
		return true;
	}
	public boolean isPopOrder2(int[] line1,int[] line2)
	{
		int pushindex=0;
		int popindex=0;
		Stack<Integer> stack=new Stack<Integer>();
		while(popindex<line2.length)
		{	//ջΪ�ջ�ջ�ĵ�ǰԪ��peek()�뵱ǰ����Ԫ�ز�ͬ����ջ
			//ֱ���ҵ�һ����ջ��Ԫ����ͬ��Ԫ�أ�Ȼ�󵯳�
			//line1ȫ��ѹ��Ҳû��������ͬԪ�أ���false
			while(pushindex<line1.length&&(stack.isEmpty()||stack.peek()!=line2[popindex]))
			{
				stack.push(line1[pushindex]);
				pushindex++;
			}
			if(stack.peek()==line2[popindex])
			{
				stack.pop();
				popindex++;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []line1={1,2,3,4,5,6};
		int []line2={7,1,2,3,5,4};
		Problem22 test=new Problem22();
		boolean t=test.isPopOrder2(line1, line2);
		System.out.println("�Ƿ�Ϊ����˳��"+t);
	}

}
