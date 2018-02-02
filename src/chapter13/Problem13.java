package chapter13;
/*
 * 只允许用O(1)的时间复杂度去实现链表删除其中某个节点
 * 如果遍历一遍通过两个指针previous和current去实现删除O(n)
 * 1.考虑是否存在head和deNode
 * 2.head==deNode?
 * 3.deNode是最后一个点
 * 4.一般情况在中间
 * 思路：把deNode.next的节点数据覆盖给deNode*/
public class Problem13 {
	public void deleteNode(ListNode head,ListNode deNode)
	{
		if(head==null||deNode==null) return ;
		if(head==deNode)
			head=null;
		else
		{
			if(deNode.next==null){
			while(head.next.next!=null)
				head=head.next;
			head.next=null;
			}
			else
			{
				deNode.data=deNode.next.data;
				deNode.next=deNode.next.next;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		Problem13 test=new Problem13();
		test.deleteNode(node1, node1);
		ListNode current=node1;
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
	}

}
