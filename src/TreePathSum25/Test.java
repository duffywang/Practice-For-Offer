package TreePathSum25;

import java.util.ArrayList;

import chapter18.BinaryTreeNode;

public class Test {
    public ArrayList<ArrayList<Integer>> FindPath(BinaryTreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)return res;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        helper(res,list,target,sum,root);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int target,int sum,BinaryTreeNode root){
        if(sum == target&&root.right == null&&root.left == null){
            res.add(new ArrayList<Integer>(list));
        }else{
            list.add(root.data);
            if(root.left != null)helper(res,list,target,sum+root.left.data,root.left);
            if(root.right != null)helper(res,list,target,sum+root.right.data,root.right);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
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
		Test test = new Test();
		ArrayList<ArrayList<Integer>> path = test.FindPath(root, 11);
		System.out.println(path);
	
    }

}
