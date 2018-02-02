package chapter25;
/*��Ŀ������һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ������������

��·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
1.�û���˼��(�ݹ�)���Ž�list����
����������(target==0&&root.left==null&&root.right==null)
listAll.add(new ArrayList(list))
2.�õݹ鷨����ӡ������*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import chapter18.BinaryTreeNode;

public class Problem25 {
	
		 private List<List<Integer>> listAll=new ArrayList<List<Integer>>();
		private List<Integer> list=new ArrayList<Integer>();
		
		public List<List<Integer>> findPath(BinaryTreeNode head,int target){
			if(head==null)return null;
			list.add(head.data);
			target=target-head.data;
			if(target==0&&head.right==null&&head.left==null)
			{
				listAll.add(new ArrayList<Integer>(list));
			}
			else
			{
				findPath(head.left,target);
				findPath(head.right,target);
				list.remove(list.size()-1);//ʧ�ܲ��ɹ���������
			}
			return listAll;
		}
		public void findPath2(BinaryTreeNode root,int target)
		{
			if(root==null)return ;
			Stack<Integer> stack=new Stack<Integer>();
			int currentSum=0;
			findPath2(root,target,stack,currentSum);
		}
	
	private void findPath2(BinaryTreeNode root, int target,
				Stack<Integer> stack, int currentSum) {
			// TODO Auto-generated method stub
		currentSum=currentSum+root.data;
		stack.push(root.data);
		if(currentSum==target&&root.left==null&&root.right==null)
		{
			System.out.println("�ҵ�һ��·��");
			while(!stack.isEmpty())
			{
				System.out.print(stack.pop()+" ");
			}
		}
		if(root.left!=null)findPath2(root.left,target,stack,currentSum);
		if(root.right!=null)findPath2(root.right,target,stack,currentSum);
		if(!stack.isEmpty())
			stack.pop();
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root=new BinaryTreeNode(0);
		BinaryTreeNode node1=new BinaryTreeNode(1);
		BinaryTreeNode node2=new BinaryTreeNode(2);
		BinaryTreeNode node3=new BinaryTreeNode(3);
		BinaryTreeNode node4=new BinaryTreeNode(4);
		BinaryTreeNode node5=new BinaryTreeNode(5);
		BinaryTreeNode node6=new BinaryTreeNode(6);
		root.left=node1;
		root.right=node2;
		node1.left=node3;
		node1.right=node4;
		node4.left=node5;
		node4.right=node6;
		Problem25 test=new Problem25();
		System.out.println(test.findPath(root, 11));
		test.findPath2(root, 11);
	}

}
