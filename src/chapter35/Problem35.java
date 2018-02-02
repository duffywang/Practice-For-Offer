package chapter35;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*第一个只出现一次的字符
 *题目：在字符串中找出第一个只出现一次的字符。如果输入“ abaccdeff”，则
输出‘ b’ 
运用hashmap ：hash.containsKey(key) hash.put(key,value) hash.get(key) keySet()*/
public class Problem35 {
	public Character firstOne(String str)
	{
		if(str==null)return null;
		
		char[] array=str.toCharArray();
		int n=array.length;
		if(n==1)return array[0];
		HashMap<Character,Integer> hash=new LinkedHashMap<Character,Integer>();
		for(char item:array)
		{
			if(hash.containsKey(item))
				hash.put(item, hash.get(item)+1);
			else
				hash.put(item,1);
		}
		for(char item:hash.keySet())
		{
			if(hash.get(item)==1)
				return item;
		}
		return null; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem35 test=new Problem35();
		String s="sdararseyad";
		System.out.println(test.firstOne(s));
	}

}
