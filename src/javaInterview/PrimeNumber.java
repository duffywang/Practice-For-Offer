package javaInterview;

public class PrimeNumber {
	//想简单了：(,比如91=13*7;
//	public void primenumber(){
//		System.out.println("打印100以内的素数");
//		for(int i=1;i<100;i+=2)
//		{
//			if(i%3==0||i%5==0)
//				continue;
//			System.out.print(i+" ");
//		}
//	}
	
	public void primenumber2()
	{
		int k,j;
		for(int i=2;i<100;i++)
		{
			k=(int)Math.sqrt(i);
			//分解为一个大于开方数和小于开方数的乘机，若果除小于开方数可以除尽不是素数
			
			for( j=2;j<=k;j++)
			{
				if(i%j==0)
					break;
			}
			if(j>k)
				System.out.print(" "+i);
		}
		System.gc();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumber test=new PrimeNumber();
		//test.primenumber();
		System.out.println();
		test.primenumber2();
	}

}
