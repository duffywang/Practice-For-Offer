package chapter23;


import java.util.LinkedList;
import java.util.Queue;

import chapter18.BinaryTreeNode;

/*从上往下打印二叉树
 * 多数据结构的结合 Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
 * if ...else if和 if...if...的区别
 * 	add(E e)
Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
	offer(E e)
Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
	poll()
Retrieves and removes the head of this queue, or returns null if this queue is empty.
	remove()
Retrieves and removes the head of this queue.*/
public class Problem23 {
	public void printTreeOrder(BinaryTreeNode root){
		if(root==null) return;
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			BinaryTreeNode node=queue.remove();
			System.out.println(node.data);
			if(node.left!=null){
				queue.offer(node.left);
			}
			 if(node.right!=null){
				queue.offer(node.right);
			}
		}
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
		Problem23 test=new Problem23();
		test.printTreeOrder(root);
		}

}
