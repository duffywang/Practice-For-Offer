package chapter41;

import java.util.Arrays;
import java.util.HashMap;

public class Problem41 {
	public boolean findNumberWithSum(int [] array,int target){
		if(array==null)return false;
		Arrays.sort(array);
		int n=array.length;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++)
		{
			map.put(i, array[i]);
		}
		for(int item:array)
		{
			if(map.containsValue(target-item)){
				System.out.println("找到了匹配的组合");
				System.out.println(item+" "+(target-item));
				return true;
			}
		}
		System.out.println("没有找到匹配的");
		return false;
	}
	//经典算法：双指针一前一后相互移动来匹配
	public boolean findNumberWithSum2(int[] array,int target){
		boolean found=false;
		if(array==null) return found;
		int num1=0;
		int num2=0;
		int start=0;
		int end=array.length-1;
		while(start<end)
		{
			int curSum=array[start]+array[end];
			if(curSum==target){
				num1=array[start];
				num2=array[end];
				found=true;
				break;
			}
			else if(curSum>target)
			{
				end--;
			}
			else
				start++;
		}
		System.out.println(num1);
		System.out.println(num2);
		return found;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem41 test=new Problem41();
		int []array={1,2,4,7,11,15};
		test.findNumberWithSum2(array, 15);
		
	}

}
