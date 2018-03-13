package ReverseListNode16;

import java.util.ArrayList;

/**
 * @author duffywang
 *当链表长度很长时，导致函数调用层级很深，导致函数调用栈溢出
 *显示用栈基于循环代码鲁棒性更好一点
 */
public class PrintListReverse3 {
	
	public static void printListReverse3(ListNode head){
		if(head!=null)
		{
			if(head.next!=null)
			{
				printListReverse3(head.next);
			}
		}
		System.out.print(head.val+" ");
	}
	
	private static  ArrayList<Integer> res = new ArrayList<>();
	public static ArrayList<Integer> printListReverse_3(ListNode head){
		
		helper(head);
		return res;
	}
	private static void helper(ListNode head) {
		// TODO Auto-generated method stub
		if(head != null) {
			helper(head.next);
			res.add(head.val);
		}
	}
	
	public static void main(String[] args) {

		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		PrintListReverse3.printListReverse3(node1);
		
		System.out.println();
		ArrayList<Integer> list = PrintListReverse3.printListReverse_3(node1);
		for(Integer val:list) {
			System.out.println(val);
		}

		

	}

	
}
