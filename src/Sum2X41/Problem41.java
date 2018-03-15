package Sum2X41;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author duffywang
 *输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
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
				System.out.println("");
				System.out.println(item+" "+(target-item));
				return true;
			}
		}
		System.out.println("");
		return false;
	}

	/**利用前后两个指针，若和大于目标值则前移后指针，否则后移前指针
	 * 结束条件为两指针相碰，或找到一对立即break;时间复杂度为O(n);
	 * 此办法找到一对挺直观，若需要找多对呢》？
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
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
		test.findNumberWithSum2(array, 20);
		
	}

}
