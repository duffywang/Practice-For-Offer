package chapter6;
/*重建二叉树
 * 输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设前
序遍历和中序遍历结果中都不包含重复的数字，例如输入的前序遍历序列
{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建出如图所示的二叉
树。
思路：先找到树的根节点，分成左子树和右子树，在左子树和右子树中继续找根节点，递归下去*/
import java.util.Arrays;

import chapter18.BinaryTreeNode;

public class Problem6 {
	public static BinaryTreeNode constructCore(int []preorder,int[] inorder){
		if(preorder==null||inorder==null)
			return null;
		if(preorder.length!=inorder.length)
		{
			return null;
		}
		BinaryTreeNode root=new BinaryTreeNode();
		for(int i=0;i<inorder.length;i++)
		{
			if(inorder[i]==preorder[0])
			{
				root.data=inorder[i];
				System.out.print(root.data+"  ");
				//递归Arrays.copyOfRange( , );
				//Copies the specified range of the specified array into a new array.
				//to - the final index of the range to be copied, exclusive. (This index may lie outside the array.)
				//不包含to的值，to的值不被复制
				root.left=constructCore(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
				root.right=constructCore(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
			}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder={1,2,4,7,3,5,6,8};
		int[] inorder={4,7,2,1,5,3,8,6};
		Problem6 test=new  Problem6();
		BinaryTreeNode node=test.constructCore(preorder, inorder);
		//System.out.println(node.data);
		System.out.println();
		test.printPostOrder(node);
		
	}

}
