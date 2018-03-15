package UpDownTree23;


import java.util.LinkedList;
import java.util.Queue;

import chapter18.BinaryTreeNode;



/**从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author duffywang
 *本质上一种广度优先遍历二叉树的思想
 */
public class Problem23 {
	public void printTreeOrder(BinaryTreeNode root){
		if(root==null) return;
		//队列是LinkedList结构
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		//先把根节点放入队列中，接下来每一次从队列中取出先加的节点
		queue.add(root);
		while(!queue.isEmpty())
		{
			BinaryTreeNode node=queue.poll();
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
