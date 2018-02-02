package chapter5;

import java.util.Stack;

public class PrintListReverse2 {
	public  void printListReverse2(ListNode head){
		Stack <ListNode> stack=new Stack<ListNode>();
		while(head!=null)
		{
			stack.push(head);
			head=head.next;
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop().val+" ");
		}
		
	}
}
