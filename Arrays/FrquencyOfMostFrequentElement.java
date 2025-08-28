package Arrays;
import java.util.*;

public class FrquencyOfMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, maxFreq = 1;
        long total = 0;
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            while ((long) nums[right] * (right - left + 1L) - total > k) {
                total = total - nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}

/*
 * Ah, this is a classic pattern once you think carefully about **what the
 * problem is really asking**. Let me break down my thought process step by
 * step:
 * 
 * ---
 * 
 * ### 1️⃣ Understand the problem deeply
 * 
 * You’re asked: *maximize the frequency of some number after incrementing
 * elements at most `k` times*.
 * 
 * Key observation: **You can only increment numbers**, not decrement.
 * So, the **target number** for any frequency must be one of the **existing
 * numbers or something bigger**.
 * Incrementing smaller numbers to match a bigger number is always optimal
 * (because incrementing bigger numbers wastes operations).
 * 
 * This hints at **sorting the array** first, so you deal with smaller → bigger
 * in order.
 * 
 * ---
 * 
 * ### 2️⃣ Think in terms of ranges
 * 
 * If you want `nums[i]` to appear `freq` times, you essentially want **some
 * consecutive numbers in the sorted array** to all become equal to `nums[i]`.
 * “Consecutive numbers in sorted order” naturally leads to a **window or
 * subarray**.
 * 
 * At this point, the problem starts looking like:
 * 
 * > Find the **longest subarray** where you can make all elements equal to the
 * largest element in the subarray using ≤ `k` operations.
 * 
 * ---
 * 
 * ### 3️⃣ Translate to a sum problem
 * 
 * To check if a subarray `[left, right]` can all be equal to `nums[right]`:
 * 
 * Operations needed = `(nums[right] * window_length) - sum_of_window`
 * 
 * If this ≤ `k`, the subarray is valid.
 * 
 * If not, shrink the window.
 * 
 * 💡 This is **sliding window + prefix sum trick**:
 * 
 * Sliding window → `[left, right]` range
 * Prefix sum → efficiently compute the sum of the window
 * 
 * ---
 * 
 * ### 4️⃣ Recognize the “sliding window” pattern
 * 
 * Once you’ve seen a few problems like:
 * 
 * Maximum length subarray under some sum condition
 * Making elements equal with limited operations
 * 
 * …you start noticing:
 * 
 * > Whenever the problem involves **“a range of consecutive elements in a
 * sorted array” + “a sum condition”**, it’s often **sliding window + prefix
 * sum**.
 * 
 * ---
 * 
 * ### TL;DR “How I spotted it”
 * 
 * 1. Only increments allowed → smaller → bigger → sort array.
 * 2. Frequency of equal elements → longest consecutive numbers after increments
 * → sliding window idea.
 * 3. Sum of increments needed → `(target_value * window_size) - window_sum` →
 * prefix sum trick.
 * 4. Maintain max frequency while moving window → classic “max subarray under
 * constraints” pattern.
 * 
 */