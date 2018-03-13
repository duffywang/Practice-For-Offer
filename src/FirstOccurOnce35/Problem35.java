package FirstOccurOnce35;

import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * @author duffywang
 *在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Problem35 {
	
	public Character firstOne(String str)
	{
		if(str==null)return null;
		
		char[] array=str.toCharArray();
		int n=array.length;
		if(n==1)return array[0];
		//LinkedHashMap use linkedhashmap to keep the order
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
