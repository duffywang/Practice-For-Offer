package onlineCode;

public class TwoArrayMid {

	public int midValueOfTwoArrays(int []array1,int []array2){
		int n1=array1.length;
		int n2=array2.length;
		//int []res=new int[n1+n2];
		int n=Index(n1,n2);
		int k=0,j=0;
		for(int i=0;i<n;i++)
		{
			if(j<n1&&k<n2)
			{
				if(array1[j]<array2[k])
					j++;
				else
					k++;
			}
			else if(j>=n1)
				k++;
			else if(k>=n2)
				j++;

		}
		if(k<n1&&j<n2)
			return array1[k]<array2[j]?array1[k]:array2[j];
		else if(k>=n1)
			return array2[j];
		else
			return array1[k];
	}
	private int Index(int n1, int n2) {
		// TODO Auto-generated method stub
		if((n1+n2)/2==0)
			return (n1+n2)/2;
		return (n1+n2)/2+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
