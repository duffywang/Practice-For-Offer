package TreePathSum25;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import chapter13.ListNode;
import chapter18.BinaryTreeNode;

/**
 * @author duffywang
 *输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Problem25 {
    public ArrayList<ArrayList<Integer>> FindPath(BinaryTreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res,list,target,root);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int target,BinaryTreeNode root){
        if(root == null)return ;
        //先添加value
        list.add(root.data);
        //写符合条件 剩下的值与root.value相等，且必须为到达叶子节点
        if(target == root.data&&root.right == null&&root.left == null)
            res.add(new ArrayList<Integer>(list));
        helper(res,list,target-root.data,root.left);
        helper(res,list,target-root.data,root.right);
        list.remove(list.size()-1);
        
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
		System.out.println(test.FindPath(root, 11));
	
	}

}
