package chapter45;

import java.util.ArrayList;
import java.util.List;

/*ԲȦ�����ʣ�µ�����
 *��Ŀ�� 0,1�� ...,n-1 �� n �����ų�һ��ԲȦ�������� 0 ��ʼÿ�δ����ԲȦ��
ɾ���� m �����֡�������ԲȦ��ʣ�µ����һ������ */
public class Problem45 {
	Boolean[] useJapa;
	public int lastRemaining(int n,int m){
		if(n<0||m<0)
			return -1;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			list.add(i);
		int index;
		int start;
		while(list.size()>0)
		{
			for(int i=1;i<m;i++)
			{
				index=(i+1)%list.size();
				list.remove(index);
			}
		}
		return list.get(0);
	}
	public void lastRemaining2(int n,int m)
	{
		Boolean[] useJapa=new Boolean[n];
		for(int i=0;i<useJapa.length;i++)
		{
			useJapa[i]=true;
		}
		int leftCount=useJapa.length;
		int countNum=0;
		int index=0;
		while(leftCount>15){
			countNum++;
			if(countNum==m)
			{
				countNum=0;
				isFalse(index)
				;
				leftCount--;
				
			}
			index++;
			if(index==useJapa.length)
				{
				index=0;
				}
				
		}
		int count=0;
		for(int i=0;i<useJapa.length;i++)
		{
			System.out.print(i+"="+useJapa[i]+" ");
			
			if(false==useJapa[i])
				count++;
			
		}
		System.out.println("����:"+count);
		
	}
	private void isFalse(int index) {
		// TODO Auto-generated method stub
		if(useJapa[index]!=false)
			useJapa[index]=false;
		else
			isFalse(index++);
			
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem45 test=new Problem45();
		test.lastRemaining2(30, 9);
	}

}
