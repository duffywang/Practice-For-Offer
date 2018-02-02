package chapter38;

import java.util.Arrays;

/*数字在排序数组中出现的次数
 *统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3，
3,3,4,5}和数字 3，由于 3 在这个数组中出现了 4 次，因此输出 4
思路一：直接使用二分法查找，找到一个后再向前向后找相同的数字，因为要查找的数字可能出现O(N)次，因此这种
 	算法效率和从头到尾扫描一遍统计的效率是一样的
 	思路二：一直用二分法，来查找第一个出现的位置数和最后一次出现的位置数*/
public class Problem38 {
	public int getNumberOfK(int[] array,int target){
		Arrays.sort(array);
		int middle=getIndex(array,target);
		int count=0;
		while(true)
		{
			if(array[++middle]==target)
				count++;
			else
				break;
		}
		int middle2=getIndex(array,target);
		while(true)
		{
			if(array[++middle2]==target)
				count++;
			else
				break;
		}
		return count;
	}
	private int getIndex(int[] array, int target) {
		// TODO Auto-generated method stub
		int start=0;
		int end=array.length-1;
		int middle=0;
		while(start<end)
		{
			 middle=(start+end)/2;
			if(array[middle]==target)
				break;
			if(array[middle]>target)
				end=middle;
			else
				start=middle+1;
		}
		return middle;
	}
	public int getNumberOfK2(int[] array,int k)
	{
		int number=0;
		if(array!=null)
		{
			int first=getFirstK(array,k,0,array.length-1);
			int last=getLastK(array,k,0,array.length-1);
			//都存在才可以，数组中最后一个目标数减去第一个目标数+1位最终的个数
			if(first>-1&&last>-1)
				number=last-first+1;
		}
		return number;
		
	}
	private int getFirstK(int[] array, int k, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end)return -1;
		int middleIndex=(start+end)/2;
		int middleData=array[middleIndex];
		if(middleData==k)
		{
			if((middleIndex>0&&array[middleIndex-1]!=k)||middleIndex==0){
		
				return middleIndex;
			}
			else{
				end=middleIndex-1;
			}
		}
		else if(middleData>k)
			end=middleIndex-1;
		else
			start=middleIndex+1;
		return getFirstK(array,k,start,end);
		
	}
	private int getLastK(int[] array, int k, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end)return -1;
		int middleIndex=(start+end)/2;
		int middleData=array[middleIndex];
		if(middleData==k)
		{
			if((middleIndex<array.length-1&&array[middleIndex+1]!=k)||middleIndex==array.length-1)
				return middleIndex;
		}
		else if(middleData>k)
			end=middleIndex-1;
		else
			start=middleIndex+1;
		return getLastK(array,k,start,end);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={1,2,2,3,3,3,3,4,4,5};
		Problem38 test=new Problem38();
		int res=test.getNumberOfK(array, 2);
		System.out.println("目标数字出现的次数为："+res);
	}

}
