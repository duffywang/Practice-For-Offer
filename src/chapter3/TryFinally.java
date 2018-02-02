package chapter3;

public class TryFinally {
	
	@SuppressWarnings("finally")
	public static int tryf(int a,int b) {
		
		//当finally中包含return语句时，这个返回值会覆盖原始的返回值
		try {
			return a+b;
			
		}finally {
			return a-b;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(TryFinally.tryf(1, 2));
	}

}
