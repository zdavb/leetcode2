import java.util.*;

/**
 * Created by dave on 2015/10/6.
 * 算法:先排序，然后固定一个值，然后再移动另外两个值，分别向左向右移动
 * 去重的方法使用一个hashset，因为如果存在重复，那么一定是有两个值相等（第三个自然相等）
 * 因此通过构造nums[left]+&+nms[right]进行存储。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> sets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    if (!sets.contains(nums[left] + "&" + nums[right])) {
                        sets.add(nums[left] + "&" + nums[right]);
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
