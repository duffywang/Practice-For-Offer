package StackPushPop22;


import java.util.Stack;

/**
 * @author duffywang
 *输入两个整数序列，第一个序列表示栈的压入顺序，
 *请判断第二个序列是否为该栈的弹出顺序。
 *假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序
 *，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *（注意：这两个序列的长度是相等的）
 */
public class Problem22 {
	
	public boolean isPopOrder(int [] line1,int[] line2){
		if(line1==null&&line2==null)
			return false;
		int point1=0;

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
	/**利用辅助栈
	 * @param line1
	 * @param line2
	 * @return
	 */
	public boolean isPopOrder2(int[] line1,int[] line2)
	{
		int pushindex=0;
		int popindex=0;
		Stack<Integer> stack=new Stack<Integer>();
		while(popindex<line2.length)
		{	
			//当栈中没有找到与line2相对应的值时，继续push进栈，直到把全部元素添加进去
			//1.第一次肯定会进栈 2.以后是值不对应，找到第一个对应的值
			while(pushindex<line1.length&&(stack.isEmpty()||stack.peek()!=line2[popindex]))
			{
				stack.push(line1[pushindex]);
				pushindex++;
			}
			//当栈顶元素和line2对应时
			if(stack.peek()==line2[popindex])
			{
				stack.pop();
				popindex++;
			}
			//过界导致输出false
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
		int []line2={5,6,1,4,3,2};
		Problem22 test=new Problem22();
		boolean t=test.isPopOrder2(line1, line2);
		System.out.println(t);
	}

}
