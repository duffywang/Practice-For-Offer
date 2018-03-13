package ReverseListNode16;

import java.util.Stack;

/**
 * @author duffywang
 *没有改变标的结构，只是反转链表的值
 *先进后出，考虑用栈的结构
 */
public class PrintListReverse2 {
	
	public static void printListReverse2(ListNode head){
		Stack <ListNode> stack = new Stack<ListNode>();
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
	public static void main(String[] args) {

		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		PrintListReverse2.printListReverse2(node1);

	}
}
