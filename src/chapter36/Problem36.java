package chapter36;
/*�����е������
 * �������е������������ǰһ�����ִ��ں�һ�����֣����������������
һ������ԡ�����һ�����飬���������������Ե�����������������{7,5,6,4}
�У�һ������ 5 ������ԣ��ֱ��ǣ� 7,6������ 7�� 5������ 7�� 4������ 6�� 4����
�� 5�� 4����*/
public class Problem36 {
	static int count=0;
	public static  void mergeSort(int []array){
		int []temp=new int[array.length];
		//ΪʲôҪ��һ
		mergeSort(array,0,array.length-1,temp);
	}
	private static void mergeSort(int[] array, int first, int last, int[] temp) {
		// TODO Auto-generated method stub
		if(first<last){
		int mid=(first+last)/2;
		//16-8-4-2
		mergeSort(array,first,mid,temp);
		mergeSort(array,mid+1,last,temp);
		//2+2+4+8....
		mergearray(array,first,mid,last,temp);
		}
	}
	private static void mergearray(int[] array, int first, int mid, int last,
			int[] temp) {
		// TODO Auto-generated method stub
		int i=first;
		int j=mid+1;
		int m=mid,n=last;
		int k=0;
		while(i<=m&&j<=n)
		{
			if(array[i]<=array[j])
				temp[k++]=array[i++];
			else{
				temp[k++]=array[j++];
				//����a[i]�����Ұ��a[j],��ôi~mid-i+1������a[j];
				count=count+mid-i+1;}
		}
		while(i<=m)
		{
			temp[k++]=array[i++];
		}
		while(j<=n)
		{
			temp[k++]=array[j++];
		}
		for(i=0;i<k;i++)
			array[first+i]=temp[i];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem36 test=new Problem36();
		int [] array={1,-2,3,10,-4,7,2,-5};
		test.mergeSort(array);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
		System.out.println(count);
	}

}
