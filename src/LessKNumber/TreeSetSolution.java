package LessKNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class TreeSetSolution {
	public List<Integer> getLeastNumber(int []array,int k){
		if(array==null||k==0)return null;
		List<Integer> list=new ArrayList<Integer>(k);
		if(k>array.length)return list;
		
		TreeSet<Integer> set=new TreeSet<Integer>();
		for(int i=0;i<array.length;i++)
		{
			set.add(array[i]);
		}
		for(int i=0;i<k;i++)
		{
			list.add(set.pollFirst());
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSetSolution test=new TreeSetSolution();
		int[] array={4,5,1,6,2,7,3,8};
		List list=test.getLeastNumber(array, 4);
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
		}
	}

}
