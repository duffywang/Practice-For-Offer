package KthInListNode15;

import chapter13.ListNode;

/**判断一个单向链表是否形成环型结构
 * @author duffywang
 *
 */
public class IsCircle {
	public boolean isCircle(ListNode head) {
		if(head == null)return false;
		ListNode pre = head;
		ListNode end = head;
		while(pre!=null&&end.next!=null) {
			pre = pre.next;
			end = end.next.next;
			if(pre == end)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
	
		IsCircle circle = new IsCircle();
		boolean res = circle.isCircle(node1);
		System.out.println(res);
	}

}
