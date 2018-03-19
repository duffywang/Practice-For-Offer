package MaxNumInSlidingWin65;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

/**
 * @author duffywang
 * @date 2018年3月18日
 * @version 1.0
 *给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 *那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
 */
public class Solution65 {
	public ArrayList<Integer> maxInWin(int[] num,int size){
		ArrayList<Integer> res = new ArrayList<>();
		if(size == 0)return res;
		int begin;
		//双向队列添加的是坐标
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i = 0;i < num.length;i++) {
			begin = i - size + 1;
			if(q.isEmpty()) {
				q.add(i);
				
			}else if(begin > q.peekFirst()){
				q.pollFirst();
			}
			//当新增加的值从队尾开始比较,把所有比他小的值丢掉
			while(!q.isEmpty() && num[q.peekLast()] <= num[i]) {
				q.pollLast();
			}
			q.add(i);
			//判断当前最大值是否过期
			if(begin >= 0)
				res.add(num[q.peekFirst()]);

		}
		return res;
	}
	public static void main(String[] args) {
		Solution65 test = new Solution65();
		int[] num = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> list = test.maxInWin(num, 3);
		Object json = JSON.toJSON(list);
		System.out.println(json);
	}

}
