package chapter45;

import java.util.ArrayList;
import java.util.List;

/*圆圈中最后剩下的数字
 *题目： 0,1， ...,n-1 这 n 个数排成一个圆圈，从数字 0 开始每次从这个圆圈里
删除第 m 个数字。求出这个圆圈里剩下的最后一个数字 */
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
		System.out.println("死了:"+count);
		
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
