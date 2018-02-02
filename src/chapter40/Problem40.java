package chapter40;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*������ֻ����һ�ε����֡�
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д����
�ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ��� O�� n�����ռ临�Ӷ�Ϊ O�� 1��
1.˳��ɨ�跨ʱ�临�Ӷ�ΪO(n^2)
2.��ϣ��Ŀռ临�ӶȲ�ΪO(1)
˼·��ͨ��λ�ƶ�����������ֻ��һ��single����ô������һ��Ϳ��Եõ������
����������Ҫ�ڻ����Ϸֳ����飬��Ϊ0û�����ֶȿ�����1+1Ҳ������0+0�������ҵ���һ��1��λ
�����λ���Ϸֳ�����ÿһ����һ��single�ͳ�˫��*/
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
		//����������ʱ���ü��ױ�ʾ��������ȥarray[i]������ʾ
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
		// ����indexλ����0λ��0001�Ƚ��Ƿ��indexλ��1����0
		//�ֳ������indexλ��1�ĺ���0��
		
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
