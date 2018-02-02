package chapter29;

import java.util.Arrays;

/*�����г��ִ�������һ�������
 * */
public class Problem29 {
	//�������¸��Ӷ�ΪO(NlongN)��ȡ�м������ǳ���һ���������
	public int moreThanHalf(int[] array){
		if(array==null) return 0; 
		Arrays.sort(array);
		int n=array.length;
		int mid=array[n/2];
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(array[i]==mid)
				count++;
		}
		return count>n/2?mid:0;
	}
	//1.ͨ��ѭ�����ҵ�����������
	//2.��ѭ��ȷ���Ƿ��ǳ�������һ�����������
	//ʱ�临�Ӷ�ΪO(N)
	public int moreThanHalf2(int[] array){
		
		int n=array.length;
		if(n==0)return 0;
		int num=array[0];
		int count=0;
		for(int i=1;i<n;i++)
		{
			if(array[i]==num)
				count++;
			else
				count--;
			if(count==0){
				num=array[i];
				count=1;
			}
		}
		count=0;
		for(int i=0;i<n;i++)
		{
			if(array[i]==num)
				count++;
		}
		return count>n/2?num:0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem29 test=new Problem29();
		int[] array={1,2,1,2,1,2,2};
		
		System.out.println("�����д��ڴ����������һ�������Ϊ��"+test.moreThanHalf(array));
	}

}
