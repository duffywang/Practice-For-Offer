package chapter5;
//�ݹ�ʵ������ת
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
