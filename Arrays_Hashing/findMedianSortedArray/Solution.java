class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      double median = 0;
      double [] mergedArray = new double[nums1.length + nums2.length];
      int i = 0;
      int j = 0;
      int k = 0;
      
      while (i < nums1.length || j < nums2.length)
      {
          if (i < nums1.length && (j == nums2.length || nums1[i] <= nums2[j])) {
              mergedArray[k] = nums1[i];
              i++;
          }
          else if (j < nums2.length && (i == nums1.length || nums1[i] > nums2[j])) {
              mergedArray[k] = nums2[j];
              j++;
          }
          if ((i + j) == (((nums1.length + nums2.length) / 2) + 1) && ((nums1.length + nums2.length) % 2 == 1))
              return (double)mergedArray[k];
          if ((nums1.length + nums2.length) % 2 == 0 && ((i + j) == (((nums1.length + nums2.length) / 2) + 1)))
              return (double)((mergedArray[k] + mergedArray[k - 1]) / 2);
          k++;
      }
      return median;
  }
}