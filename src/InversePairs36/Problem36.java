package InversePairs36;

/**
 * @author duffywang
 *在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P
 *并归
 */
public class Problem36 {
	static int count=0;
	public static  void mergeSort(int []array){
		int []temp=new int[array.length];

		mergeSort(array,0,array.length-1,temp);
	}
	private static void mergeSort(int[] array, int first, int last, int[] temp) {
	
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
				//统计？？？
				count=count+mid-i+1;
				}
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
		int [] array={1,2,3,4,5,6,0,-1};
		test.mergeSort(array);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
		System.out.println(count);
	}

}
