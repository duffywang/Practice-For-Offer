package chapter27;

import chapter18.BinaryTreeNode;

/*题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
不能创建任何新的结点，只能调整树中结点指针的指向*/
public class Problem27 {
	public BinaryTreeNode convert(BinaryTreeNode root)
	{
		BinaryTreeNode lastNodeList=null;
		convertNode(root,lastNodeList);
		while(lastNodeList!=null&&lastNodeList.left!=null)
		{
			lastNodeList=lastNodeList.left;
		}
		return lastNodeList;
		
	
		
	}
	private void convertNode(BinaryTreeNode root, BinaryTreeNode lastNodeList) {
		// TODO Auto-generated method stub
		if(root==null)return ;
		BinaryTreeNode current=root;
		if(current.left!=null)
			convertNode(current.left,lastNodeList);
		
		current.left=lastNodeList;
		if(lastNodeList!=null)
			lastNodeList.right=current;
		
		if(current.right!=null)
			convertNode(current.right,lastNodeList);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
