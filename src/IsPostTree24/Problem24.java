package IsPostTree24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chapter18.BinaryTreeNode;


public class Problem24 {

	public boolean verfiySequenceOfBST(int[] sequence)
	{	
		if(sequence==null||sequence.length==0)
			return false;
		int length=sequence.length;
		int root=sequence[length];
		int cut=0;
		for(int i=0;i<length-1;i++)
		{
			if(sequence[i]>root)
			{	
				cut=i+1;
				break;
			}
		}
		if(cut==0){
			verfiySequenceOfBST(Arrays.copyOfRange(sequence, 0, length-1));
			
		}
		else
		{
			for(int j=cut;j<length-1;j++)
				if(sequence[j]<root)
					return false;
		}
		boolean left=true;
		if(cut>0)
			left=verfiySequenceOfBST(Arrays.copyOfRange(sequence, 0, cut));
		boolean right=true;
		if(cut<length-1)
			right=verfiySequenceOfBST(Arrays.copyOfRange(sequence, cut, length-1));
		return (right&&left);
		
	}
	public boolean isPostOrder(int [] seq)
	{
		if(seq==null||seq.length==0)
			return false;
		return isPostOrder(seq,0,seq.length-1);
	}
	private boolean isPostOrder(int[] seq, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end)
			return true;
		int root=seq[end];
		int i=start;
		while(i<end)
		{
			if(seq[i]>root)
				break;
			i++;
		}
		int j=i;
		while(j<end)
		{
			if(seq[j]<root)
				break;
			j++;
		}
		boolean left=true;
		left=isPostOrder(seq,start,i-1);
		boolean right=true;
		right=isPostOrder(seq,j+1,end);
		return right&&left;
	}
	public boolean isPostOrder3(int [] sequence){
		int n=sequence.length;
		if(n==1||n==0)
		{
			return true;
		}
		int root=sequence[n-1];
		List<Integer> leftList=new ArrayList<Integer>();
		List<Integer> rightList=new ArrayList<Integer>();
		
		int i=0;
		for(;i<n-1;i++)
		{
			if(sequence[i]<=root)
				leftList.add(sequence[i]);
			else
				break;
		}
		for(;i<n-1;i++)
		{
			if(sequence[i]>root)
				rightList.add(sequence[i]);
			else
				break;
		}
		return false;

		
		
	}

	public List<Integer> printPostOrder(BinaryTreeNode root)
	{
		List<Integer> list=new ArrayList<Integer>();
		
		if(root.left!=null) printPostOrder(root.left);
		if(root.right!=null) printPostOrder(root.right);
		System.out.print(root.data+" ");
		list.add(root.data);
		return list;
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
		int[] seq={2,4,3,6,7,9,8,5};
		Problem24 test=new Problem24();
		System.out.println(test.isPostOrder(seq));
	}

}
