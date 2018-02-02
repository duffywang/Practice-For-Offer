package chapter30;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*��С�� k ������
 * ���� n ���������ҳ�������С�� k �������������� 4,5,1,6,2,7,3,8 ��
8 �����֣������ٵ� 4 �������� 1,2,3,4.
˼·�������ȴ���һ��k�����������洢��С������
 ��TreeSet���������Զ��������������ŵ㣺����ı�ԭ�������飬�ʺϴ���������
 ȱ�㣺�������ظ����ݣ�TreeSet�ײ�ʵ����TreeMap,��TreeSet��ӵ�������ΪTreeMap��keyֵ���洢
 ����˼·��Arrays.sort()ʹ�õ��ǿ��Űɣ�ð�ݵ�����ı�ԭ�е���������*/
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
