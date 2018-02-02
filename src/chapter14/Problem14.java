package chapter14;
/*
 * 思路一：用栈实现，每个数据都动了，时间复杂度是O(n)
 * 思路二：用两个指针，前面的偶数和后面的奇数互换，更简单*/
import java.util.Stack;

public class Problem14 {
	Stack<Integer> stackEven=new Stack<Integer>(); 
	Stack<Integer> stackOdd=new Stack<Integer>();
	public void reOrder(int [] nums){
		
		int n=nums.length;
		if(n==0||nums==null)return;
		for(int i=0;i<n;i++)
		{
			if(nums[i]%2==1)
				stackOdd.push(nums[i]);
			else
				stackEven.push(nums[i]);
		}
		int i=0;
		while(!stackOdd.isEmpty())
		{
			nums[i++]=stackOdd.pop();
			
		}
		while(!stackEven.isEmpty())
			nums[i++]=stackEven.pop();
	}
	public void reOrder2(int[] array){
		int start=0;
		int end=array.length-1;
		while(end>start)
		{
			while(start<end&&!isEven(array[start]))
				start++;
			while(start<end&&isEven(array[end]))
				end--;
			if(start<end){//swap first even and last odd
				int temp=array[start];
				array[start]=array[end];
				array[end]=temp;
			}
		}
		
	}
	private boolean isEven(int i) {
		// TODO Auto-generated method stub
		if(i%2==0)
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array={1,2,3,4,5,6,7,8,2,1,3};
		Problem14 test=new Problem14();
		test.reOrder2(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}

	}

}
