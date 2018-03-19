package Str2Int49;

/**
 * @author duffywang
 * @date 2018年3月17日
 * @version 1.0
 *将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class problem49 {
    public int StrToInt(String str) {
        //不是字符串
        //空串  "" 只有一个+ -
        //负数 +正数 设定符号位 从第二位开始计算
        if(str == null || str.length() == 0 || str.trim().equals(""))return 0;
        int n = str.length();
        int s =1;
        int res = 0;
        if(str.charAt(0) == '-') s = -1;
        for(int i=(str.charAt(0) == '-'||str.charAt(0) == '+')?1:0;i<n;i++){
            if(str.charAt(i)<'0'||str.charAt(i)>'9')return 0;
            //res = 10*res+str.charAt(i)-'0';
            res = res<<1 + res<<3 +(str.charAt(i)&0xf);//位计算
        }
        
        return s * res;
    }

}
