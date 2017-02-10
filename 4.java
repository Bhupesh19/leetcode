public class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double median = 0.0;
    if((nums1.length + nums2.length) % 2 == 1) {
      median = (double) findKthSmallestNum(nums1, nums2, (nums1.length+ nums2.length)/2);
    } else {
      int median_left = findKthSmallestNum(nums1, nums2, (nums1.length+nums2.length)/2-1);
      int median_right = findKthSmallestNum(nums1, nums2, (nums1.length+nums2.length)/2);
      median = (median_left + median_right) / 2.0;
    }
    return median;
  }

  public int findKthSmallestNum(int[] nums1, int[] nums2, int k) {
    if(nums1.length == 0) {
      return nums2[k];
    }
    if(nums2.length == 0) {
      return nums1[k];
    }
    int len1 = nums1.length;
    int len2 = nums2.length;
    if(k < (len1 + len2) / 2) {
      if(nums1[len1/2] < nums2[len2/2]) {
        int[] new_nums2 = new int[len2/2];
        for(int i = 0; i < len2/2; i++) {
          new_nums2[i] = nums2[i]; 
        }
        return findKthSmallestNum(nums1, new_nums2, k);
      } else {
        int[] new_nums1 = new int[len1/2];
        for(int i = 0; i < len1/2; i++) {
          new_nums1[i] = nums1[i]; 
        }
        return findKthSmallestNum(new_nums1, nums2, k);
      }
    } else {
      if(nums1[len1/2] < nums2[len2/2]) {
        int[] new_nums1 = new int[len1-len1/2];
        for(int i = len1/2; i < len1; i++) {
          new_nums1[i-len1/2] = nums1[i]; 
        }
        return findKthSmallestNum(new_nums1, nums2, k-len1/2);
      } else {
        int[] new_nums2 = new int[len2-len2/2];
        for(int i = len2/2; i < len2; i++) {
          new_nums2[i-len2/2] = nums2[i]; 
        }
        return findKthSmallestNum(nums1, new_nums2, k-len2/2);
      }      
    }
  }
}
