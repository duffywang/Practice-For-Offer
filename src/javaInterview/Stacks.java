package javaInterview;

import java.util.Stack;
import java.util.Vector;

public class Stacks {
	static String[] months={"January","February","March","April","May","June","July","August","September","October","Novembwe","December"};
	
	public void printWithStack(){
		Stack<String> stack=new Stack<String>();
		for(int i=months.length-1;i>=0;i--)
		{
			stack.push(months[i]);
		}
		String s1=new String("asd");
		 s1=s1.intern();
		 String s2="asd";
		 System.out.println(s1==s2);
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
		}
	}
	public void printWithVecter()
	{
		Vector<String> vector=new Vector<String>();
		for(int i=0;i<months.length-1;i++)
		{
			vector.addElement(months[i]);
		}
		while(!vector.isEmpty())
		{
			System.out.print(vector.firstElement()+" ");
			vector.removeElementAt(0);
			//System.out.print(vector.remove(0)+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]array;
		int array1[][];
		int []array2[];
		int array3[][]=new int[2][];
		array3[0]=new int[3];
		array3[1]=new int[4];
		Stacks test=new Stacks();
		test.printWithStack();
		
	}

}
