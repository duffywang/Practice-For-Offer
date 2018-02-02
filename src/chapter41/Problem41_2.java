package chapter41;
/*
 * ����һ������ s����ӡ�����к�Ϊ s �������������У����ٺ�����������
�������� 15������ 1+2+3+4+5=4+5+6=7+8=15�����Խ����ӡ�� 3 ���������� 1-5��
4-6���� 7-8
˼·����ǰ������ָ�룬��ǰֵ���˼���ǰ���ֵ��С�˼��Ϻ����ֵ
ע��ѭ������*/
public class Problem41_2 {
	public void findContinuesSequence(int sum){
		if(sum<3) return;
		int small=1;
		int big=2;
		//���small>=middle,��ôsmall+big>sum,������Ҫ��
		int middle=(1+sum)/2;
		int curSum=small+big;
		while(small<middle)
		{
			if(curSum==sum)
			{
				printContinueNum(small,big);
			}
			//curSum����һֱ������ֵÿ��ѭ��ֻ��һ����Ϊ�ӵ�ֵ�ϴ�
			while(curSum>sum&&small<middle)
			{
				curSum-=small;
				small++;
				if(curSum==sum)
					printContinueNum(small,big);
			}
			big++;
			curSum+=big;
		}
		
	}
	private void printContinueNum(int small, int big) {
		// TODO Auto-generated method stub
		int i;
		for(i=small;i<big;i++)
		{
			System.out.print(i+"+");
		}
		System.out.print(i);
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem41_2 test=new Problem41_2();
		test.findContinuesSequence(4);
	}

}
