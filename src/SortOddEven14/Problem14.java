package SortOddEven14;


import java.util.Stack;

/**输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author duffywang
 *方法一利用两个栈，且也改变了数字间相对位置
 *
 *方法二改变了数字间相对顺序，快排交换的思想
 */
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
			nums[i++]=stackOdd.pop();
		while(!stackEven.isEmpty())
			nums[i++]=stackEven.pop();
	}
	public void reOrder2(int[] array){
		
        if(array == null || array.length == 0)return;
        int i = 0,j = array.length - 1;
        while(i < j){
            //前面找偶数，后面找奇数
            while(i<j&&!isEven(array[i]))i++;
            while(i<j&&isEven(array[j]))j--;
            exac(array,i,j);
        }
    }

    private void exac(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
		
	//解耦函数，封装，易于程序扩展
	private boolean isEven(int i) {
		// TODO Auto-generated method stub
		return i%2 == 0;
	}
	
	/**
	 * @param array
	 * 要想保证原有次序，则只能顺次移动或相邻交换。
	 * 2.i从左向右遍历，找到第一个偶数。
 	 * 3.j从i+1开始向后找，直到找到第一个奇数。
 	 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
 	 * 5.終止條件：j向後遍歷查找失敗。
	 */
	public void reOrder3(int[] array) {
		int n=array.length;
		if(array == null || n == 0)return ;
		int i = 0,j;
		while(i < n) {
			while(i < n && !isEven(array[i]))
				i++;
			j = i + 1;
			while(j < n && isEven(array[j]))
				j++;
			//第一种奇数太多导致j很大
			//第二种偶数太多导致j很大
			if(j < n) {
				int temp = array[j];
				for(int k = j-1;k>=i;k--) {
					array[k+1] = array[k];
				}
				array[i] = temp;
				
			}else {//找不到偶数
				break;
			}
			
		}
		
	}
	public static void main(String[] args) {
		int []array={2,4,6,8,0};
		Problem14 test=new Problem14();
		test.reOrder3(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}

	}

}
