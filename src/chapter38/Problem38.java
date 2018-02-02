package chapter38;

import java.util.Arrays;

/*���������������г��ֵĴ���
 *ͳ��һ�����������������г��ֵĴ���������������������{1,2,3,3,3��
3,3,4,5}������ 3������ 3 ����������г����� 4 �Σ������� 4
˼·һ��ֱ��ʹ�ö��ַ����ң��ҵ�һ��������ǰ�������ͬ�����֣���ΪҪ���ҵ����ֿ��ܳ���O(N)�Σ��������
 	�㷨Ч�ʺʹ�ͷ��βɨ��һ��ͳ�Ƶ�Ч����һ����
 	˼·����һֱ�ö��ַ��������ҵ�һ�����ֵ�λ���������һ�γ��ֵ�λ����*/
public class Problem38 {
	public int getNumberOfK(int[] array,int target){
		Arrays.sort(array);
		int middle=getIndex(array,target);
		int count=0;
		while(true)
		{
			if(array[++middle]==target)
				count++;
			else
				break;
		}
		int middle2=getIndex(array,target);
		while(true)
		{
			if(array[++middle2]==target)
				count++;
			else
				break;
		}
		return count;
	}
	private int getIndex(int[] array, int target) {
		// TODO Auto-generated method stub
		int start=0;
		int end=array.length-1;
		int middle=0;
		while(start<end)
		{
			 middle=(start+end)/2;
			if(array[middle]==target)
				break;
			if(array[middle]>target)
				end=middle;
			else
				start=middle+1;
		}
		return middle;
	}
	public int getNumberOfK2(int[] array,int k)
	{
		int number=0;
		if(array!=null)
		{
			int first=getFirstK(array,k,0,array.length-1);
			int last=getLastK(array,k,0,array.length-1);
			//�����ڲſ��ԣ����������һ��Ŀ������ȥ��һ��Ŀ����+1λ���յĸ���
			if(first>-1&&last>-1)
				number=last-first+1;
		}
		return number;
		
	}
	private int getFirstK(int[] array, int k, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end)return -1;
		int middleIndex=(start+end)/2;
		int middleData=array[middleIndex];
		if(middleData==k)
		{
			if((middleIndex>0&&array[middleIndex-1]!=k)||middleIndex==0){
		
				return middleIndex;
			}
			else{
				end=middleIndex-1;
			}
		}
		else if(middleData>k)
			end=middleIndex-1;
		else
			start=middleIndex+1;
		return getFirstK(array,k,start,end);
		
	}
	private int getLastK(int[] array, int k, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end)return -1;
		int middleIndex=(start+end)/2;
		int middleData=array[middleIndex];
		if(middleData==k)
		{
			if((middleIndex<array.length-1&&array[middleIndex+1]!=k)||middleIndex==array.length-1)
				return middleIndex;
		}
		else if(middleData>k)
			end=middleIndex-1;
		else
			start=middleIndex+1;
		return getLastK(array,k,start,end);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={1,2,2,3,3,3,3,4,4,5};
		Problem38 test=new Problem38();
		int res=test.getNumberOfK(array, 2);
		System.out.println("Ŀ�����ֳ��ֵĴ���Ϊ��"+res);
	}

}
