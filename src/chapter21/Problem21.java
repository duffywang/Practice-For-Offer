package chapter21;
/*题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
函数。在该栈中，调用min、 push及pop德尔时间复杂度都是O(1)
思路：
1.用两个栈，一个栈存储数据，另一个栈存储最小的数据，只有当传入的数据小于mintop时才能压入minstack*/
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
