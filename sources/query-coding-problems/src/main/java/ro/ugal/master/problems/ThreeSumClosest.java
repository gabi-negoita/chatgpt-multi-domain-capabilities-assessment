package ro.ugal.master.problems;

import java.util.Arrays;

/*
 Resolve the following coding problem using the Java language.
 Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

 Return the sum of the three integers.

 You may assume that each input would have exactly one solution.



 Example 1:

 Input: nums = [-1,2,1,-4], target = 1
 Output: 2
 Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 Example 2:

 Input: nums = [0,0,0], target = 1
 Output: 0
 Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


 Constraints:

 3 <= nums.length <= 500
 -1000 <= nums[i] <= 1000
 -10^4 <= target <= 10^4
*/

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(closestSum - target);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                    if (minDiff == 0) return target;
                }
                if (sum < target) left++;
                else right--;
            }
        }
        return closestSum;
    }

}
