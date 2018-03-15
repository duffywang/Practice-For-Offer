package chapter44;


import java.util.Arrays;

/**
 * @author duffywang
 *LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,
 *看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 *他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 *LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0
 */
public class Problem44 {
	public boolean isContionous(int [] number,int length)
	{
		if(number==null||length<5) return false;
		Arrays.sort(number);
		int zero_counts=0;
		int gap_counts=0;
		int i=0;
		while(i<length&&number[i]==0)
		{
			zero_counts++;
			i++;
		}

		int prev=number[i++];
		for(;i<length;i++)
		{
			if(number[i]==prev)
				return false;
			//关键：求相邻点的gap值，正常为0
			gap_counts+=(number[i]-prev-1);
			prev=number[i];
		}
		if(zero_counts>=gap_counts)
			return true;
		else
			return false;
	}
	
	
    public boolean isContinuous(int [] numbers) {
        if(numbers == null||numbers.length != 5)return false;
        Arrays.sort(numbers);
        int zero = 0;
        int gap = 0;
        for(int n:numbers){
            if(n == 0) zero++;
        }
        //注意从zero点开始，eg:0 0 2 4 6;会计算开始时gap = 2-0;
        int i = zero;
        int pre = numbers[i++];
        for(;i<numbers.length;i++){
            if(numbers[i] == pre)
                return false;
            //注意累加gap
            gap += (numbers[i] - pre - 1);
            pre = numbers[i];
        }
        if(zero >= gap)return true;
        else{
            return false;
        }


    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem44 test=new Problem44();
		int[] array={0,1,2,3,5};
		int[] array2={0,2,3,4,6};
		int[] array3={2,3,4,5,6};
		System.out.println(" ");
		System.out.println(test.isContionous(array, 5));
		System.out.println(test.isContionous(array2, 5));
		System.out.println(test.isContionous(array3, 5));
	}

}
