package chapter35;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*��һ��ֻ����һ�ε��ַ�
 *��Ŀ�����ַ������ҳ���һ��ֻ����һ�ε��ַ���������롰 abaccdeff������
����� b�� 
����hashmap ��hash.containsKey(key) hash.put(key,value) hash.get(key) keySet()*/
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
