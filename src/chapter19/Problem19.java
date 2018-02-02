package chapter19;
/*二叉树的镜像
 * 1.递归法，节点交换
 * 2.非递归栈法*/
import java.util.Stack;

import chapter18.BinaryTreeNode;

public class Problem19 {
	public BinaryTreeNode mirrorBinaryTree(BinaryTreeNode head)
	{
		if(head==null)
			return null;
		if(head.left==null&&head.right==null)
			return head;
		BinaryTreeNode temp=head.left;
		head.left=head.right;
		head.right=temp;
		if(head.left!=null) mirrorBinaryTree(head.left);
		if(head.right!=null) mirrorBinaryTree(head.right);
		return head;
		
	}
	public BinaryTreeNode mirrorBinaryTree2(BinaryTreeNode head){
		if(head==null)
			return null;
		if(head.left==null&&head.right==null)
			return head;
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		stack.push(head);
		while(!stack.isEmpty())
		{
			BinaryTreeNode node=stack.pop();
			if(node.left!=null||node.right!=null)
			{
				BinaryTreeNode temp=node.left;
				node.left=node.right;
				node.right=temp;
			}
			if(node.left!=null)
				stack.push(node.left);
			if(node.right!=null)
				stack.push(node.right);
		}
		return head;
		
		
	}
	public static void printProOrder(BinaryTreeNode head)
	{
		System.out.print(head.data+" ");
		if(head.left!=null)printProOrder(head.left);
		if(head.right!=null) printProOrder(head.right);
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
		BinaryTreeNode node7=new BinaryTreeNode(7);
		node2.right=node7;
		Problem19 test=new Problem19();
		BinaryTreeNode node=test.mirrorBinaryTree(root);
		printProOrder(node);
	}

}
