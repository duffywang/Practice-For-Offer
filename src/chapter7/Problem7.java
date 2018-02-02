package chapter7;
//用两个栈实现队列的功能，队列头删除，队列尾增加
import java.util.Stack;

public class Problem7 {
	private Stack<Integer> stack1=new Stack();
	private Stack<Integer> stack2=new Stack();
	public void appendTail(int i){
		stack1.push(i);
	}
	public int deleteHead() throws Exception{
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}
		if(stack2.isEmpty()) throw new Exception("队列为空");
		else
			return stack2.pop(); 
	}
	public static void main (String [] args) throws Exception
	{
		Problem7 test=new Problem7();
		test.appendTail(1);
		test.appendTail(2);
		test.appendTail(3);
		
		System.out.println(test.deleteHead());
		System.out.println(test.deleteHead());
	}
}
