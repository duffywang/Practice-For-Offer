package chapter5;

public class PrintListReverse {
	 private ListNode head;
	public  ListNode printListReverse(ListNode head){
		if(head==null) return null;
		if(head.next==null) return head;
		ListNode previous=null;
		while(head!=null)
		{
			ListNode temp=head.next;
			head.next=previous;
			previous=head;
			head=temp;
		}

		return head;

	}
}
