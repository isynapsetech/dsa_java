package binary_search;

/* Given a rotated sorted array with unique numbers and a target, return the index of the target if present. Return -1 if the target is not present.
Input: nums = [8, 9, 1, 2, 3, 4, 5, 6, 7], target = 1 Output: 2 */

public class RotatedSortedArray {
    // Time complexity: O(log n)
    // Space complexity: O(1)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Determine which side is sorted
            if (nums[left] <= nums[mid]) { // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left side
                } else {
                    left = mid + 1; // Target is in the right side
                }
            } else { // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right side
                } else {
                    right = mid - 1; // Target is in the left side
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        RotatedSortedArray solution = new RotatedSortedArray();
        int[] nums = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        int target = 1;
        int result = solution.search(nums, target);
        System.out.println("Index of target " + target + " is: " + result); // Expected output: 2
    }
    
}
