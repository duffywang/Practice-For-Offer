package chapter26;
/*��������ĸ���
 * ʵ�ֺ�������һ�����������ڸ��������У�ÿ����������һ�� next
ָ��ָ����һ������⣬����һ��ָ��������������� null��
*/
import java.util.HashMap;

public class Problem26 {
	public ComplexListNode clone(ComplexListNode head){
		//���ƽڵ㹹��double��������
		ComplexListNode curNode=head;
		while(curNode!=null)
		{
			ComplexListNode cloneNode=new ComplexListNode();
			cloneNode.data=curNode.data;
			cloneNode.next=curNode.next;
			cloneNode.sibling=null;
			curNode.next=cloneNode;
			curNode=cloneNode.next;
		}
		//����ָ��ָ��
		curNode=head;
		while(curNode!=null)
		{
			ComplexListNode cloneNode=curNode.next;
			if(curNode.sibling!=null)
				cloneNode.sibling=curNode.sibling.next;
			curNode=curNode.next;
		}
		//��ֳ���
		curNode=head;
		ComplexListNode cloneNode=curNode.next;
		ComplexListNode tempNode;
		while(curNode!=null)
		{
			tempNode=curNode.next;
			curNode.next=tempNode.next;
			curNode=tempNode;//clone��һ�����ӣ��������
		}
		return cloneNode;
	}
	public ComplexListNode clone2(ComplexListNode head)
	{
		HashMap<ComplexListNode,ComplexListNode> map=new HashMap<ComplexListNode,ComplexListNode>();
		ComplexListNode curNode=head;
		while(curNode!=null)
		{
			map.put(curNode, curNode.sibling);
			curNode=curNode.next;
		}
		ComplexListNode cloneNode;
		curNode=head;
	
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
