package MinStack21;


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
		return minstack.peek();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}
}
