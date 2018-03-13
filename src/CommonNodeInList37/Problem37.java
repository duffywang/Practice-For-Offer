package CommonNodeInList37;

import java.util.Stack;

import chapter13.ListNode;


/**
 * @author duffywang
 *输入两个链表，找出它们的第一个公共结点。
 */
public class Problem37 {
	/**类似于求链表倒数第k个节点,计算两个链表长度，相减(前面部分不可能有相交点)
	 * 然后再比较直到第一个相同的点，如果存在公共节点则最后的几个节点一定归到一起，类似于Y型
	 * @param head1
	 * @param head2
	 * @return
	 */
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
	/**利用两个栈,先进后出，出后相比第一个不同的前一个数即为共同交点
	 * 时间复杂度为O(n+m),空间复杂度为O(m+n)
	 * @param head1
	 * @param head2
	 * @return
	 */
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
			//当出现第一个不同的节点时，返回上一个节点值
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
