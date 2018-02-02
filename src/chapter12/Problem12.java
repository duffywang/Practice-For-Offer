package chapter12;
//��ӡ��1������Nλ������
//1,2,3,4,5......10^n-1����������������
//�ַ���������ģ��ӷ����ַ��������ֱ�ʾ����
public class Problem12 {
	public static void printToMax(int n){
		if(n!=1) {
			printToMax(n-1);
		System.out.print(n+" ");
		}
	}
	public static void printToMax2(int n)
	{
		int[] array=new int[n];
		if(n<0)
			return ;
		printArray(array,0);
	}
	private static void printArray(int[] array, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			if(n!=array.length)
			{
				array[n]=i;
				printArray(array,n+1);
			}
			else{
				boolean isFirstNo0=false;
				for(int j=0;j<array.length;j++){
					if(array[j]!=0)
						System.out.print(array[j]);
				if(!isFirstNo0)
					isFirstNo0=true;
				else
				{
					if(isFirstNo0)
						System.out.println(array[j]);
				}
					}
				System.out.println();
				return;
			}
		}
		
	}
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		Class<?> cls = Problem12.class;
//		Class<?> cls2 = Class.forName("Problem12");
//		Object object = cls.newInstance();
		
		Problem12 problem12 = new Problem12(); 
		problem12.printToMax(4);
		
	}

}
