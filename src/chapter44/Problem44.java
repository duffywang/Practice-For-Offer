package chapter44;
/*�˿��Ƶ�˳��
 *��Ŀ�����˿���������� 5 ���ƣ��ж��ǲ���˳�ӣ����� 5 �����ǲ��������ġ�
2-10 Ϊ���ֱ��� A Ϊ 1�� J Ϊ 11�� Q Ϊ 12�� K Ϊ 13������С�����Կ��������
���֡�
˼·��1.������ Arrays.sort()��ͳ��0(��С��)�ĸ���;
2.�Ӽ�����ʹ�С������ �������������ڴ�С���ĸ������������������С�ڵ��ڴ�С������������
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
		//�ܹ�ǰ���0
		int prev=number[i++];
		for(;i<length;i++)
		{
			if(number[i]==prev)
				return false;
			//��һ������ǰһ�����ټ�1
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
		System.out.println("�Ƿ�Ϊ˳��");
		System.out.println(test.isContionous(array, 5));
		System.out.println(test.isContionous(array2, 5));
		System.out.println(test.isContionous(array3, 5));
	}

}
