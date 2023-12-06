class Solution {
	public int removeDuplicates(int[] nums) {
		
	  int     k;
	  boolean foundDuplicate;
	  int[]   nonDuplicateArray = new int[nums.length];
  
	  k = 0;
	  for (int i = 0; i < nums.length; ++i)
	  {
		foundDuplicate = false;
		for (int j = 0; j < k; ++j)
		{
		  if (nums[i] == nonDuplicateArray[j])
			foundDuplicate = true;
		}
		if (!foundDuplicate)
		{
		  nonDuplicateArray[k] = nums[i];
		  k++;
		}
	  }
	  for (int i = 0; i < k; ++i)
		nums[i] = nonDuplicateArray[i];
	  return k;
	}
  }