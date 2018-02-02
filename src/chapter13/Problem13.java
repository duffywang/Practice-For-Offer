package chapter13;
/*
 * ֻ������O(1)��ʱ�临�Ӷ�ȥʵ������ɾ������ĳ���ڵ�
 * �������һ��ͨ������ָ��previous��currentȥʵ��ɾ��O(n)
 * 1.�����Ƿ����head��deNode
 * 2.head==deNode?
 * 3.deNode�����һ����
 * 4.һ��������м�
 * ˼·����deNode.next�Ľڵ����ݸ��Ǹ�deNode*/
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
