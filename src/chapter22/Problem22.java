package chapter22;
/*
 * 栈的压入，弹出顺序
 * 1.下一个压入的和line2的元素一样*/
import java.util.Stack;

public class Problem22 {
	public boolean isPopOrder(int [] line1,int[] line2){
		if(line1==null&&line2==null)
			return false;
		int point1=0;
		//辅助栈
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
		{	//栈为空或栈的当前元素peek()与当前处理元素不同则入栈
			//直到找到一个与栈顶元素相同的元素，然后弹出
			//line1全部压入也没有碰到相同元素，则false
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
		System.out.println("是否为弹出顺序"+t);
	}

}
