package EntryCircle56;

import chapter13.ListNode;

/**
 * @author duffywang
 * @date 2018年3月16日
 * @version 1.0
 *一个链表中包含环，请找出该链表的环的入口结点。
 *1 先判断是否链表中是否存在环，通过快慢两个指针，若两指针碰面则存在，碰面的肯定在环中
 *2 计算环中结点数，循环一圈
 *3 先让一个指针先走节点数的路程，慢指针与快指针相碰时则是环中头节点
 */
public class problom56 {
    public ListNode EntryNodeOfLoop(ListNode head)
    {
        ListNode meetNode = MeetingNode(head);
        if(meetNode == null)
            return null;
        int loopNodes = 1;
        ListNode p1 = meetNode;
        while(meetNode!=p1.next){
            p1 = p1.next;
            loopNodes++;
        }
        ListNode pre = head;
        ListNode end = head;
        for(int i=0;i<loopNodes;i++){
            end = end.next;
        }
        while(pre!=end){
            
            pre = pre.next;
            end = end.next;
        }
        return pre;
        
        
        
    }
    //判断是否存在环
    private ListNode MeetingNode(ListNode head){
        if(head == null)return null;
        ListNode pre = head.next;
        if(pre == null)return null;
        ListNode end = pre.next;
        while(end != null&&pre != null){
            if(end == pre)return end;
            pre = pre.next;
            end = end.next;
            if(end != null)
                end = end.next;
        }
        return null;
        
    }

}
