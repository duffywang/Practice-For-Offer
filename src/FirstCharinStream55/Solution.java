package FirstCharinStream55;

/**
 * @author duffywang
 * @date 2018年3月18日
 * @version 1.0
 *请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *输入 : google
 *输出 : ggg#ll
 *用字符的ASCII码作为哈希表的键值，把字符对应的位置作为哈希表的值，有三种形式
 *-1：没有出现
 *-2:出现两次及以上
 *>=0:出现一次
 */
public class Solution {
    private int[] arr = new int[256];
    private int index ;
    //Insert one char from stringstream
    public Solution(){
        for(int i = 0;i < 256;i++){
            arr[i] = -1;
        }
        index = 0;
    }
    public void Insert(char ch)
    {
        if(arr[ch] == -1)
            //出现一次时先排序号
            arr[ch] = index;
        //出现两次的, 注意要大于0，因为第一个index为0
        else if(arr[ch] >= 0)
            arr[ch] = -2;
        //出现三次及以上不再处理
        index++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	//如果当前字符流没有存在出现一次的字符，返回#字符。
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        //选择排序
        for(int i=0;i<256;i++){
            if(arr[i] < minIndex && arr[i] >= 0){
                //int->char
                ch = (char)i;
                minIndex = arr[i];
            }
        }
        if(ch == '\0')
            return '#';
        return ch;
    
    }
}
