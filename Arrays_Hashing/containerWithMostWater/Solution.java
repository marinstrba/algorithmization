class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right)
		{
            int width = right - left;
            int minHeight = height[left] < height[right] ? height[left] : height[right];
            maxArea = maxArea > (width * minHeight) ? maxArea : (width * minHeight);
            left = height[left] < height[right] ? left + 1 : left;
            right = height[left] < height[right] ? right : right - 1;
        }
        return maxArea;
    }
}
