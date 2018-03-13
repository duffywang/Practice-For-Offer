package FindSingelNumbers40;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;



/**
 * @author duffywang
 *一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *方法一:使用hashMap,遇到存在的清除key，不存在的设为1
 */
public class Problem40 {
	
	public void findSingleNum(int [] array)
	{
		int n=array.length;
		if(n == 0)return ;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		Object object = new Object();
		HashSet<Object> set = new HashSet<>();
		
		for(int item:array)
		{
			if(map.containsKey(item)) {
				map.remove(item);
			}
			else
				map.put(item, 1);
		}
		for(int i:map.keySet())
		{
				System.out.println(i);
		}
	}
	public void findSingleNum2(int []array)
	{
		if(array==null || array.length == 0)return ;
		int number=0;

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
		test.findSingleNum(array);
	}

}
