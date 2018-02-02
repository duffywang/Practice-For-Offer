package chapter37;

import java.util.Stack;

import chapter13.ListNode;

/*两个链表的第一个公共结点
 *输入两个链表，找出它们的第一个公共结点 
 *如果相交则最后的节点肯定一样，呈现Y的形状
 *思路一：1.先计算出两个链表的长度，并算出长度差值dif
 *2.长的先遍历dif的长度节点然后再一起遍历找到第一个一样的节点
 *思路二：1.反向思维，从尾部开始向前回找第一个不同的结点
 *2.用栈实现先push进栈然后pop(),注意记录第一个相同的点*/
public class Problem37 {
	public ListNode findFirstCommonNode(ListNode head1,ListNode head2)
	{
		int len1=getListLength(head1);
		int len2=getListLength(head2);
		ListNode longListNode=null;
		ListNode shortListNode=null;
		int dif=0;
		if(len1>len2)
		{
			longListNode=head1;
			shortListNode=head2;
			dif=len1-len2;
		}
		else
		{
			longListNode=head2;
			shortListNode=head1;
			dif=len2-len1;
		}
		for(int i=0;i<dif;i++)
		{
			longListNode=longListNode.next;
			
		}
		while(longListNode!=null&&shortListNode!=null&&longListNode!=shortListNode)
			
		{
			longListNode=longListNode.next;
			shortListNode=shortListNode.next;
			
		}
		return longListNode;
	}
	
	private int getListLength(ListNode head1) {
		// TODO Auto-generated method stub
		int result=0;
		if(head1==null)
			return result;
		ListNode point=head1;
		while(point!=null)
		{
			point=point.next;
			result++;
		}
		return result;
	}
	public ListNode findFirstCommonNode2(ListNode head1,ListNode head2){
		Stack<ListNode> stack1=new Stack<ListNode>();
		Stack<ListNode> stack2=new Stack<ListNode>();
		while(head1!=null)
		{
			stack1.push(head1);
			head1=head1.next;
		}
		while(head2!=null)
		{
			stack2.push(head2);
			head2=head2.next;
		}
		ListNode node1=null;
		ListNode node2=null;
		ListNode common=null;
		
		while(!stack1.isEmpty()&&!stack2.isEmpty())
		{
			node1=stack1.peek();
			node2=stack2.peek();
			if(node1.data==node2.data)
			{
				common=node1;
				stack1.pop();
				stack2.pop();
			}
			else
			{
				break;
			}
		}
		return common;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1=new ListNode(1);
		ListNode second1=new ListNode(2);
		ListNode third1=new ListNode(3);
		ListNode forth1=new ListNode(6);
		ListNode fifth1=new ListNode(7);
		ListNode head2=new ListNode(4);
		ListNode second2=new ListNode(5);
		ListNode third2=new ListNode(6);
		ListNode forth2=new ListNode(7);
		head1.next=second1;
		second1.next=third1;
		third1.next=forth1;
		forth1.next=fifth1;
		head2.next=second2;
		second2.next=forth1;
		third2.next=fifth1;
		
	}

}
