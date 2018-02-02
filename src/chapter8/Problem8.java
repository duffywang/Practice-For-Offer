package chapter8;

public class Problem8 {
	public int FindMin(int [] nums){
		int left=0;
		int right=nums.length-1;
		int mid=left;
		while(nums[left]>=nums[right])
		{
			if(right-left==1){
				mid=right;
				break;}
			if(nums[left]==nums[right])
			{
				return findOrder(nums,left,right);
			}
			mid=(left+right)/2;
			if(nums[mid]>nums[left])
				left=mid;
			else if(nums[mid]<nums[right])
				right=mid;
		}
		return nums[mid];
	}

	public int findOrder(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		int key=nums[left];
		
		for(int i=left;i<right;i++)
		{
			if(nums[i]<key)
				return nums[i];
		}
		return nums[right];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem8 test=new Problem8();
		int []arrays={4,5,6,7,8,2,3,4};
		int res=test.FindMin(arrays);
		System.out.println(res);
	}

}
