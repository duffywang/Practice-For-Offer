package chapter18;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode right;
	public BinaryTreeNode left;
	public BinaryTreeNode(int i,BinaryTreeNode right,BinaryTreeNode left)
	{
		data=i;
		this.left=left;
		this.right=right;
	}
	public BinaryTreeNode(int i) {
		// TODO Auto-generated constructor stub
		data=i;
	}
	public BinaryTreeNode() {
		// TODO Auto-generated constructor stub
		data=0;
		
	}
	public int getData()
	{
		return this.data;
	}
	public BinaryTreeNode getLeftNode()
	{
		return this.left;
	}
	public BinaryTreeNode getRightNode()
	{
		return this.right;
	}
}
