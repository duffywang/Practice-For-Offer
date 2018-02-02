package chapter9;
/*ì³²¨ÄÇÆõÊýÁÐ*/
public class Problem9 {
	public long fibonacci(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem9 test=new Problem9();
		long res=test.fibonacci(6);
		System.err.println(res);
	}

}
