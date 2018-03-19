package ReverseString42;

/**
 * @author duffywang
 * @date 2018年3月16日
 * @version 1.0
 *
 */
public class Problem42 {

	/**没有输出类型
	 * @param sentence
	 */
	public void reverseSentence(String sentence){

		String[] array=sentence.split(" ");
		int n=array.length;
		for(int i=n-1;i>=0;i--)
		{
			if(i>0) {
				//最后一个空格
			System.out.print(array[i]+" ");
			}else {
			System.out.print(array[i]);
			}
		}
	}
    public String ReverseSentence2(String str) {
    	if(str.trim().equals(""))return str;

        String[] arr = str.split(" ");
        int end = arr.length-1;
        int start = 0;
        if(end == start)return str;
  
        for(int i=0;i<(end+1)/2;i++)
            swap(arr,i,end-i);
        String res = "";
        for(String s:arr){
            res=res+s+" ";
        }
        return res.substring(0,str.length());
        
        
    }
    private  void swap(String[] arr,int start,int end){
        String temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem42 test=new Problem42();
		test.reverseSentence("    ");
		System.out.println(
				);
	}

}
