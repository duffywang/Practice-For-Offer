package chapter27;

import chapter18.BinaryTreeNode;

/*��Ŀ������һ�ö��������������ö���������ת����һ�������˫������Ҫ��
���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��*/
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
