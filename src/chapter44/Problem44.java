package chapter44;
/*扑克牌的顺子
 *题目：从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。
2-10 为数字本身， A 为 1， J 为 11， Q 为 12， K 为 13，而大小王可以看成任意的
数字。
思路：1.先排序 Arrays.sort()，统计0(大小王)的个数;
2.从间隔数和大小王下手 ，如果间隔数大于大小王的个数，则不连续；间隔数小于等于大小王数，则连续
*/
import java.util.Arrays;

public class Problem44 {
	public boolean isContionous(int [] number,int length)
	{
		if(number==null||length<5) return false;
		Arrays.sort(number);
		int zero_counts=0;
		int gap_counts=0;
		int i=0;
		while(i<length&&number[i]==0)
		{
			zero_counts++;
			i++;
		}
		//避过前面的0
		int prev=number[i++];
		for(;i<length;i++)
		{
			if(number[i]==prev)
				return false;
			//后一个数减前一个数再减1
			gap_counts+=(number[i]-prev-1);
			prev=number[i];
		}
		if(zero_counts>=gap_counts)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem44 test=new Problem44();
		int[] array={0,1,2,3,5};
		int[] array2={0,1,3,5,6};
		int[] array3={2,3,4,5,6};
		System.out.println("是否为顺子");
		System.out.println(test.isContionous(array, 5));
		System.out.println(test.isContionous(array2, 5));
		System.out.println(test.isContionous(array3, 5));
	}

}
