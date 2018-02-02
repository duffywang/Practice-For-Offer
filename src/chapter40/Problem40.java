package chapter40;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*数组中只出现一次的数字。
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
找出这两个只出现一次的数字。要求时间复杂度是 O（ n），空间复杂度为 O（ 1）
1.顺序扫描法时间复杂度为O(n^2)
2.哈希表的空间复杂度不为O(1)
思路：通过位移动异或来求，如果只是一个single数那么异或编译一遍就可以得到结果了
两个数就需要在基础上分成两组，因为0没有区分度可能是1+1也可能是0+0，所以找到第一个1的位
在这个位置上分成两组每一组有一个single和成双的*/
public class Problem40 {
	public void findSingleNum(int [] array)
	{
		HashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();
		int n=array.length;
		for(int item:array)
		{
			if(map.containsKey(item))
				map.put(item, map.get(item)+1);
			else
				map.put(item, 1);
		}
		for(int i:map.keySet())
		{
			if(map.get(i)==1)
				System.out.println(i);
		}
	}
	public void findSingleNum2(int []array)
	{
		if(array==null)return ;
		int number=0;
		//当出现数组时，用简易表示法可以免去array[i]繁琐表示
		for(int i:array)
			number=i^number;
		int index=findFirstBitsIs1(number);
		int number1=0;
		int number2=0;
		for(int i:array)
		{
			if(isBits(i,index))
				number1=i^number1;
			else
				number2=i^number2;
		}
		System.out.println(number1);
		System.out.println(number2);
	}
	private boolean isBits(int number, int index) {
		// 右移index位放在0位与0001比较是否第index位是1还是0
		//分成两组第index位是1的和是0的
		
		number=number>>index;
		
		return (number&1)==0;
	}
	private int findFirstBitsIs1(int number) {
		// TODO Auto-generated method stub
		int indexBit=0;
		while((number&1)==0){
			number=number>>1;
			++indexBit;
		}
		return indexBit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem40 test=new Problem40();
		int [] array={2,1,4,2,6,4,6,9};
		test.findSingleNum2(array);
	}

}
