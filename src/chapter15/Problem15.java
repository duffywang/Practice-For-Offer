package chapter15;
/*
 * 　第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持不动；

从第k步开始，第二个指针也开始从链表的头指针开始遍历；

由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k个结点。
思路：当一个指针不容易解决问题时。考虑用两个指针来解决*/
import chapter13.ListNode;

public class Problem15 {
	public ListNode findKToTail(ListNode head,int k)
	{
		if(head==null||k==0)
			return null;
		ListNode resultNode=null;
		ListNode headListNode=head;
		//产生k个距离
		for(int i=0;i<k;i++)
		{
			if(headListNode.next!=null)
				headListNode=headListNode.next;
			else
			{
				return null;
			}
		}
		resultNode=head;
		while(headListNode!=null)
		{
			resultNode=resultNode.next;
			headListNode=headListNode.next;
		}
		return resultNode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		Problem15 test=new Problem15();
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		ListNode res=test.findKToTail(node1, 1);
		System.out.println(res.data);
		
	}

}
