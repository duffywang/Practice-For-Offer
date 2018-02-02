package chapter41;
/*
 * 输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含两个数）。
例如输入 15，由于 1+2+3+4+5=4+5+6=7+8=15，所以结果打印出 3 个连续序列 1-5、
4-6、和 7-8
思路：用前后两个指针，当前值大了减掉前面的值，小了加上后面的值
注意循环条件*/
public class Problem41_2 {
	public void findContinuesSequence(int sum){
		if(sum<3) return;
		int small=1;
		int big=2;
		//如果small>=middle,那么small+big>sum,不符合要求
		int middle=(1+sum)/2;
		int curSum=small+big;
		while(small<middle)
		{
			if(curSum==sum)
			{
				printContinueNum(small,big);
			}
			//curSum可以一直减，加值每次循环只有一次因为加的值较大
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
