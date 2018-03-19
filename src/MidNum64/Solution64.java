package MidNum64;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author duffywang
 * @date 2018年3月18日
 * @version 1.0
 *如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *没有排序的数组：O(1)	O(n)
 *排序的数组：O(n)		O(1)
 *排序的链表：O(n)		O(1)
 *二叉搜索树：O(n)orO(longN)	O(n)orO(longN)
 *平衡二叉树AVL：O(longN)		O(1)
 *最大堆和最小堆：O(longN)		O(1)
 */
public class Solution64 {

	private int count = 0;
	//优先队列，默认为最小堆，每次插入两个堆数据数目差不能超过1
	private PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
	//用优先队列实现最大堆，由最大堆最大数和最小堆最小数组成偶数的中位数
	private PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
		
	});
	public void insert(Integer num){
		//count第一次进来为0，所以奇次数进来多进行了一次count % 2 == 0操作，minheap比maxheap多一个数字，即输出minheap
		if(count % 2 == 0) {
			//新加入的元素先入大根堆，有大根堆筛选后最大元素进入小根堆
			maxheap.offer(num);
			Integer MaxNum = maxheap.poll();
			minheap.offer(MaxNum);
		}else {
			//新加入的元素先入小根堆，有小根堆筛选后最小元素进入大根堆
			minheap.offer(num);
			Integer MinNum = minheap.poll();
			maxheap.offer(MinNum);
		}
		count++;
	}
	public Double getmMedian() {
		
		if(count %2 == 0) {
			return new Double((minheap.peek()+maxheap.peek()))/2;
		}else {
			return new Double(minheap.peek());
		}
	}
	public static void main(String[] args) {
		Solution64 test = new Solution64();
		Integer[] arr = {5,2,3,4,1,6,7,0,8};
		for(Integer i:arr) {
			System.out.print(i+" ");
			test.insert(i);

			Double x = test.getmMedian();
			System.out.print(x+" ");
		}

	}
	
}
