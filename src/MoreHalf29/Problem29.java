package MoreHalf29;

import java.util.Arrays;


/**
 * @author duffywang
 *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Problem29 {

	public int moreThanHalf(int[] array){
		if(array==null) return 0; 
		Arrays.sort(array);
		int n=array.length;
		int mid=array[n/2];
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(array[i]==mid)
				count++;
		}
		return count>n/2?mid:0;
	}

	/**遍历数字，如果与保存的数字相同则次数加一
	 * 如果不同则次数减一，直到次数为零，需要把下一个数字保存且次数设为1
	 * 要找的数字一定是最后一次把次数设为1时对应的数字
	 * @param array
	 * @return
	 */
	public int moreThanHalf2(int[] array){
		
		int n=array.length;
		if(n==0)return 0;
		//需要保存的那个数字
		int num=array[0];
		//出现的次数
		int count=0;
		for(int i=1;i<n;i++)
		{
			if(array[i]==num)
				count++;
			else
				count--;
			if(count==0){
				num=array[i];
				count=1;
			}
		}
		count=0;
		for(int i=0;i<n;i++)
		{
			if(array[i]==num)
				count++;
		}
		return count>n/2?num:0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem29 test=new Problem29();
		int[] array={1,2,1,2,1,2,2};
		
		System.out.println(""+test.moreThanHalf(array));
	}

}
