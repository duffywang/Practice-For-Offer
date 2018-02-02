package chapter20;
/*顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。*/
public class Problem20 {
	public void printMatrixClockwisely(int [][] array){
		if(array==null)
			return;
		int start=0;
		
		int lenRow=array.length;
		int lenColumn=array[0].length;
		while(lenColumn>start*2&&lenRow>start*2)
		{
			printMatrixClockwisely(array,start);
			start++;
		}
	}
	private void printMatrixClockwisely(int[][] array, int start) {
		// TODO Auto-generated method stub
		for(int i=start;i<array[0].length-start;i++)
		{
			System.out.print(array[start][i]+" ");
		}
		if(array.length-1-start>start)
		{
			for(int i=start+1;i<array.length-start-1;i++)
			{
				System.out.println(array[i][array[0].length-1-start]+" ");
			}
		}
		if(array[0].length-start-1>start&&array.length-start-1>start)
		{
			for(int i=array.length-start-1;i>start;i--)
				System.out.print(array[array.length-start-1][i]+" ");
		}
		if(array.length-1-start>start&&array[0].length-1-start>start)
		{
			for(int i=array.length-start-1;i>start;i--)
				System.out.print(array[i][start]+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
