package chpater10;

public class Problem10 {
	public static int numberOf1(int n)
	{
		int count=0;
		while(n!=0)
		{
			if(n%2==1)
				count++;
			n=n/2;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOf1(1024));
	}

}
