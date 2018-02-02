package chapter15;
/*
 * ����һ��ָ��������ͷָ�뿪ʼ������ǰ��k-1���ڶ���ָ�뱣�ֲ�����

�ӵ�k����ʼ���ڶ���ָ��Ҳ��ʼ�������ͷָ�뿪ʼ������

��������ָ��ľ��뱣����k-1������һ��������ǰ��ģ�ָ�뵽�������β���ʱ���ڶ���ָ�루���ں���ģ�ָ�������ǵ�����k����㡣
˼·����һ��ָ�벻���׽������ʱ������������ָ�������*/
import chapter13.ListNode;

public class Problem15 {
	public ListNode findKToTail(ListNode head,int k)
	{
		if(head==null||k==0)
			return null;
		ListNode resultNode=null;
		ListNode headListNode=head;
		//����k������
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
