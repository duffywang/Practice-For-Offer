package chapter3;

public class Find {
	public boolean isFound(int[][] nums,int target){
		if(nums==null) return false;
		int row=0;
		int column=nums[0].length-1;
		while(row<nums.length&&column>=0)
		{
			if(nums[row][column]==target)
				return true;
			else if(nums[row][column]<target)
				row++;
			else
				column--;
		}
		return false;
		
	}

}
