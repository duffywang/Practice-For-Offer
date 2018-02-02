package chapter5;
//递归实现链表反转
public class PrintListReverse3 {
	public void printListReverse3(ListNode head){
		if(head!=null)
		{
			if(head.next!=null)
			{
				printListReverse3(head.next);
			}
		}
		System.out.print(head.val+" ");
	}
}
