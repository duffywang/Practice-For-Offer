package KthInListNode15;



import chapter13.ListNode;

/**
 * @author duffywang
 *输入一个链表，输出该链表中倒数第k个结点。
 *使用双指针，中间相差k，当后面指针到达链表未时，前面指针是第k个节点
 *注意鲁棒性问题,和k的位置
 */
public class Problem15 {
	
	public ListNode findKToTail(ListNode head,int k)
	{
		if(head==null||k==0)
			return null;
		ListNode resultNode=head;
		ListNode headListNode=head;
		for(int i=0;i<k;i++)
		{
			if(headListNode.next!=null)
				headListNode=headListNode.next;
			//若k>n的情况下输出null
			else
				return null;
		}
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
