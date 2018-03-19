package ReConstructTree6;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import chapter18.BinaryTreeNode;

/**
 * @author duffywang
 * @date 2018年3月16日
 * @version 1.0
 *输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Problem6 {
	public static BinaryTreeNode constructCore(int []preorder,int[] inorder){
		if(preorder==null||inorder==null)
			return null;
		if(preorder.length!=inorder.length)
		{
			return null;
		}
		//
		BinaryTreeNode root=new BinaryTreeNode();
		for(int i=0;i<inorder.length;i++)
		{
			//中序找到第几个元素是根节点
			if(inorder[i]==preorder[0])
			{
				root.data = inorder[i];
				System.out.print(root.data+"  ");

				//Arrays.copyOfRange 左必有开
				root.left=constructCore(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
				root.right=constructCore(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
			}
			break;
		}
		
		return root;
	}
//	public static BinaryTreeNode constructCore2(int []preorder,int[] inorder){
//		if(preorder==null||inorder==null)
//			return null;
//		if(preorder.length!=inorder.length)
//			return null;
//		int n=preorder.length;
//		int rootIndex=0;
//		for(int i=0;i<n;i++)
//		{
//			if(preorder[0]==inorder[i]){
//				rootIndex=i;
//				break;
//			}
//		}
//		
//		return 
//	}
	public void printPostOrder(BinaryTreeNode root)
	{
		if(root.getLeftNode()!=null) printPostOrder(root.left);
		if(root.getRightNode()!=null) printPostOrder(root.right);
		if(root.getData()!=0)
			System.out.print(root.getData()+"  ");
	}
	public void print(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList();
		queue.offer(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();
			System.out.print(node.data+" ");
			if(node.left!=null)queue.offer(node.left);
			if(node.right!=null)queue.offer(node.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder={1,2,4,7,3,5,6,8};
		int[] inorder={4,7,2,1,5,3,8,6};
		Problem6 test=new  Problem6();
		BinaryTreeNode node=test.constructCore(preorder, inorder);
		System.out.println();

		test.printPostOrder(node);
		System.out.println();
		test.print(node);
		
	}

}
