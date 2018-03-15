package Sum2X41;

/**
 * @author duffywang
 *他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列
 */
public class Problem41_2 {
	
	/**双指针初始化为small=1,big=2，累计指针间序列和，若大于指定值去掉较小值，也就是增大small的值
	 * 若小于则增大big的值
	 * 序列至少有两个数，一直增加到small到(1+s)/2为止
	 * @param sum
	 */
	public void findContinuesSequence(int sum){
		if(sum<3) return;
		int small=1;
		int big=2;
	
		int middle=(1+sum)/2;
		int curSum=small+big;
		while(small<middle)
		{
			if(curSum==sum)
			{
				printContinueNum(small,big);
			}
	
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
		test.findContinuesSequence(15);
	}

}
