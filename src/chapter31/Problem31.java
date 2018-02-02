package chapter31;
/*连续子数组的最大和*/
public class Problem31 {
	public int findGreatestSubArray(int [] array){
		if(array==null)return 0;
		int currentSum=0;
		int GreatestSum=0;
		for(int i=0;i<array.length;i++)
		{
			if(currentSum<=0)
				currentSum=array[i];
			else
			{
				currentSum+=array[i];
			}
			if(currentSum>GreatestSum)
				GreatestSum=currentSum;
		}
		return GreatestSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
