package DelExitNode57;

import chapter13.ListNode;

/**
 * @author duffywang
 * @date 2018年3月16日
 * @version 1.0
 *在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 *重复的结点不保留，返回链表头指针。 
 *例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class problem57 {
	public ListNode deleteDuplication(ListNode head)
    {
		if(head == null||head.next == null)return head;
		//设定最后出发点，与head相连接
		ListNode first = new ListNode(-1);
		first.next = head;
		//
		ListNode p = head;
		ListNode last = first;
		//防止空指针异常
		while(p != null && p.next != null) {
			if(p.data == p.next.data) {
				int val = p.data;
				//一直连着重复，当p走到与val不同的时候
				while(p != null && p.data == val) {
					p = p.next;
				}
				//跳过中间将其删除
				last.next = p;
			}else {
				last = p;
				p = p.next;
			}
		}
		return first.next;

    }

}
