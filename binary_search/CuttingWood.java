package binary_search;

// Given an array of the tree heights and a number k of total cutting length. Determine the highest possible cutting height H, so that at least k length of wood cutting is possible
public class CuttingWood {

    // Time complexity: O(n log m) where n is the number of trees and m is the maximum height of the trees
    // Space complexity: O(1)
    public int woodCut(int[] heights, int k) {
        
        if (heights == null || heights.length == 0) return 0;
        int left = 0, right = 0; 
      
        for (int height : heights) {
            right = Math.max(right, height);
        }
        while (left < right) {
            // Bias the midpoint to the right during the upper-bound binary search.
            int mid = (left + right) / 2 + 1; // to avoid infinite loop
            if (cutsEnoughWood(heights, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    private boolean cutsEnoughWood(int[] heights, int H, int k) {
        int woodCollected = 0;
        for (int height : heights) {
            if (height > H) {
                woodCollected += (height - H);
            }
        }
        return woodCollected >= k;
    }
}
