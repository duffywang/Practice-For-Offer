package chapter5;

import java.util.ArrayList;
import java.util.Collections;

public class PrintListReverse4 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(listNode!=null)
		{
			list.add(listNode.val);
			listNode=listNode.next;
		}
		//直接将list反转
		Collections.reverse(list);
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
			
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		PrintListReverse4 test=new PrintListReverse4();
		test.printListFromTailToHead(node1);
	}

}
