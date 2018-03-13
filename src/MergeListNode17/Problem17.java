package MergeListNode17;
import chapter13.ListNode;
/**
 * @author duffywang
 *输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 *典型递归模式
 */

public class Problem17 {
	public ListNode mergelListNode(ListNode head1,ListNode head2)
	{
		if(head1==null)return head2;
		if(head2==null) return head1;
		ListNode mergehead=null;

			if(head1.data<head2.data){
				mergehead=head1;
				mergehead.next=mergelListNode(head1.next,head2);
			}
			else if(head1.data>=head2.data)
			{
				mergehead=head2;
				mergehead.next=mergelListNode(head1,head2.next);
		}
		return mergehead;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1=new ListNode(1);
		ListNode second1=new ListNode(3);
		ListNode head2=new ListNode(2);
		ListNode second2=new ListNode(4);
		ListNode third2=new ListNode(5);
		head1.next=second1;
		head2.next=second2;
		second2.next=third2;
		Problem17 test=new Problem17();
		ListNode res=test.mergelListNode(head1, head2);
		while(res!=null)
		{
			System.out.print(res.data+" ");
			res=res.next;
		}
		
	}

}
