package chapter28;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/*字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列*/
public class Problem28 {
	public void permutation(String str){

		
		List<List<Character>> listAll=new ArrayList<List<Character>>();
		List<Character> list=new ArrayList<Character>();
		boolean []used=new boolean[str.length()];
		helper(listAll,list,str,used);
		for( List<Character> listp:listAll)
		{
			System.out.println(listp);
		}
	}
	private void helper(List<List<Character>> listAll, List<Character> list,
			String str, boolean []used) {
		// TODO Auto-generated method stub
		
		if(list.size()==str.length())
		{
			listAll.add(new ArrayList<Character>(list));
		}
		for(int i=0;i<str.length();i++)
		{
			if(i>0||used[i])
					continue;
			used[i]=true;
			list.add(str.charAt(i));
			helper(listAll,list,str,used);
			used[i]=false;
			list.remove(list.size()-1);
		}
		
	}
//	public static void permutation2(char[] str){
//		if(str==null)
//			return ;
//		permutation2(str,str,0);
//	}
//
//	
//	private static void permutation2(char[] str, char[] begin, int startindex) {
//		
//		// TODO Auto-generated method stub
//		if(startindex==str.length)
//		{
//			
//		}
//		else{
//			for(int i=startindex;i<str.length;i++)
//			{
//				char temp=begin[i];
//				begin[i]=begin[i+1];
//			}
//		}
//		
//	}
	//全排列，交换值
	public void helper2(String str){
		int count=0;
		if(str==null)return ;
		char[] array=str.toCharArray();
		int point=0;
		//print(array+"")默认array是String，[C@15db9742
		System.out.print(array);
		System.out.print(" ");
		count++;
		char temp=array[point];
		array[point]=array[++point];
		array[point]=temp;
		while(!String.valueOf(array).equals(str))
		{
			System.out.print(array);
			System.out.print(" ");
			count++;
			if(point==array.length-1)
			{
				char temp2=array[point];
				array[point]=array[0];
				array[0]=temp2;
				point=0;
			}
			else
			{
				char temp2=array[point];
				array[point]=array[++point];
				array[point]=temp;
			}
		}
		System.out.println(count);
	}
	public void Combination(String str)
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem28 test=new Problem28();
		test.helper2("abc");
	}

}
