package chapter18;
/*树的子结构
 * 1.Tree1是否存在Tree2根节点
 * 2.Tree1是否存在Tree2一样结构
 * 判定都会用到递归*/
public class Problem18 {
	public boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2 )
	{
		boolean res=false;
		//递归不用写for、while循环
		if(root1!=null&&root2!=null)
		{
			if(root1.data==root2.data)
				res=doesTree1HaveTree2(root1,root2);
			if(!res)
				res=hasSubTree(root1.left,root2);
			if(!res)
				res=hasSubTree(root1.right,root2);
		}
		return res;
	}
	private boolean doesTree1HaveTree2(BinaryTreeNode root1,
			BinaryTreeNode root2) {
		// TODO Auto-generated method stub
		if(root2==null)
			return true;
		else if(root1==null)
			return false;
		if(root1.data!=root2.data)
			return false;
		
		return doesTree1HaveTree2(root1.left,root2.left)&&doesTree1HaveTree2(root1.right,root2.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
