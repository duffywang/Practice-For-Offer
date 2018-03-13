package TreeDepth;

import java.util.LinkedList;
import java.util.Queue;

import chapter18.BinaryTreeNode;

public class Problem39 {
	public int treeMaxDepth(BinaryTreeNode root){
		if(root==null)return 0;
		if(root.left==null&&root.right==null)return 1;
		int left=treeMaxDepth(root.left)+1;
		int right=treeMaxDepth(root.right)+1;
		return (left>right)?left:right;
		
		//return 1+Math.max(treeMaxDepth(root.left),treeMaxDepth(root.right));
		
		}
		
	public int treeMinDepth(BinaryTreeNode root){
		if(root==null)return 0;
		if(root.left==null)
			return treeMinDepth(root.right)+1;
		if(root.right==null)
			return treeMinDepth(root.left)+1;
		int leftDepth=treeMinDepth(root.left)+1;
		int rightDepth=treeMinDepth(root.right)+1;
		return leftDepth<rightDepth?leftDepth:rightDepth;
	}
	public int treeWidth(BinaryTreeNode root){
		if(root==null)return 0;
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		int maxWidth=1;
		queue.add(root);
		while(true)
		{
			int len=queue.size();
			if(len==0)
				break;

			while(len>0)
			{
				BinaryTreeNode node=queue.poll();
				len--;
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}
			maxWidth=Math.max(maxWidth, queue.size());
		}
		
		return maxWidth;
	}
	public boolean isBalanced(BinaryTreeNode root)
	{
		int depth=0;
		return isBalanced(root,depth);
	}
	private boolean isBalanced(BinaryTreeNode root, int depth) {
		// TODO Auto-generated method stub
		if(root==null){
			depth=0;
			return true;}
		int left=0;
		int right=0;
		if(isBalanced(root.left,left)&&isBalanced(root.right,right))
		{
			int diff=left-right;
			if(diff<=1&&diff>=-1)
			{
				depth=1+(left>right?left:right);
				return true;
			}
		}
		return false;
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
		Problem39 test=new Problem39();
		int maxDepth=test.treeMaxDepth(root);
		System.out.println("the depth of tree is :"+maxDepth);
		int minDepth=test.treeMinDepth(root);
		System.out.println(""+minDepth);
		int maxWidth=test.treeWidth(root);
		System.out.println(""+maxWidth);
	}

}
