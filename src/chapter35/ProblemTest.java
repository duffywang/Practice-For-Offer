package chapter35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
/*�����ַ�������ִ���������ĸ������г��ֵĴ�����ͬ�򶼷���
 * ˼·һ��1.ת��Ϊchar[] array,��HashMap<Character,Integer> map�����ĸ-���ֵĴ���
 * 		2.��map.entrySet()�Ž�list��
 * 		3.Collection.sort(list,new Comparator<Map.Entry<Character,Integer>>()){...}��list����
 * ˼·����1.����TreeSet ͨ�����Ͽ����ҵ����г��ֵ��ַ���,����û���ظ���Ԫ��
 * 	2.����ArrayList,Ϊ�˿�������ʹ��Collection.sort(list);
 * 	3.ͨ��StringBuffer append���list(i),�л�������indexOf(),lastIndexOf()������TreeSetÿ�ַ������ֵ
 * 	4.���������ͬ����Ž�ͬһ���б�
 * 	5.��¼��һ�����ִ��������ַ�
 * 	6.*/
public class ProblemTest {
	public void doString(String input){
		char[] array=input.toCharArray();
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(char item:array)
		{
			if(map.containsKey(item))
				map.put(item, map.get(item)+1);
			else
				map.put(item, 1);
		}
		//Map.Entry< , >��һ����������
		List<Map.Entry<Character, Integer>> list=new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){

			@Override
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				
				return (o2.getValue()-o1.getValue());
			}
			
		});
		
		
		for(Map.Entry<Character, Integer> m:list)
		{
			System.out.println(m.getKey()+"-"+m.getValue());
		}
		
		Iterator<Entry<Character, Integer>> iter=map.entrySet().iterator();
//		while(iter.hasNext())
//		{
//			Map.Entry<Character,Integer> entry=(Map.Entry<Character,Integer>) iter;
//			Entry<Character, Integer> entryNext=iter.next();
//			System.out.println(entry.getValue());
//			if(entry.getValue()!=entryNext.getValue())
//				break;
//		}
		
	}
	
	//------------------------------------
	/*
	 * */
	public void doString2(String input){
		char[] chars=input.toCharArray();
		ArrayList<String> lists=new ArrayList<String>();
		TreeSet<String> set=new TreeSet<String>();
		for(int i=0;i<chars.length;i++)
		{
			lists.add(String.valueOf(chars[i]));
			//���ǰ������ŵ�
			set.add(String.valueOf(chars[i]));
		}
		System.out.println(set);
		Collections.sort(lists);
		System.out.println(lists);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<chars.length;i++){
			sb.append(lists.get(i));
		}
		input=sb.toString();
		System.out.println(input);
		int max=0;
		String maxString="";
		ArrayList<String> maxList=new ArrayList<String>();
		Iterator<String> iter=set.iterator();//set��iterator
		while(iter.hasNext())
		{
			String os=iter.next();
			int begin=input.indexOf(os);
			int end=input.lastIndexOf(os);
			int dif=end-begin+1;
			if(dif>max)
			{
				max=dif;
				maxString=os;
				maxList.add(os);
			}
			else if(dif==max){
				maxList.add(os);
				
			}
		}
		int index=0;
		for(int i=0;i<maxList.size();i++)
		{
			if(maxList.get(i).equals(maxString))
			{
				index=i;
				break;
			}
		}
		System.out.print("max data:");
		for(int i=0;i<maxList.size();i++)
			System.out.print(maxList.get(i)+" ");
		System.out.println();
		
		System.out.println("max="+maxString);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProblemTest test=new ProblemTest();
		test.doString2("asdfwetasdgaewaasasaasssstet");
	}

}
