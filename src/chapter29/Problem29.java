package chapter29;

import java.util.Arrays;

/*数组中出现次数超过一半的数组
 * */
public class Problem29 {
	//先排序导致复杂度为O(NlongN)，取中间点可能是超过一半个数的数
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
	//1.通过循环先找到出现最多的数
	//2.再循环确认是否是超过数组一半个数的数字
	//时间复杂度为O(N)
	public int moreThanHalf2(int[] array){
		
		int n=array.length;
		if(n==0)return 0;
		int num=array[0];
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
		
		System.out.println("数组中存在大于数组个数一半的数字为："+test.moreThanHalf(array));
	}

}
