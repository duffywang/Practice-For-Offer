package DelExitNode57;

import chapter13.ListNode;

public class problem57_2 {
    public ListNode deleteDuplication(ListNode head)
    {
        if(head == null||head.next == null)return head;
        //重复值
        if(head.data == head.next.data){
            ListNode node = head.next;
            while(node != null&&node.data == head.data ){
                node = node.next;
            }
            return deleteDuplication(node);
            //不重复
        }else{
            head.next = deleteDuplication(head.next);
            return head;
        }


    }

}
