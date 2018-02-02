package chapter30;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*最小的 k 个数。
 * 输入 n 个整数，找出其中最小的 k 个数。例如输入 4,5,1,6,2,7,3,8 这
8 个数字，则最少的 4 个数字是 1,2,3,4.
思路：可以先创建一个k的数据容器存储最小的数字
 用TreeSet输入数据自动按照升序排序，优点：不会改标原来的数组，适合处理海量数据
 缺点：不允许重复数据，TreeSet底层实现是TreeMap,将TreeSet添加的内容作为TreeMap的key值来存储
 其他思路：Arrays.sort()使用的是快排吧？冒泡但都会改变原有的输入数组*/
public class Problem30 {
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
		Problem30 test=new Problem30();
		int[] array={4,5,1,6,2,7,3,8};
		List list=test.getLeastNumber(array, 4);
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
		}
	}

}
