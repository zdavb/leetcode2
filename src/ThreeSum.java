import java.util.*;

/**
 * Created by dave on 2015/10/6.
 * �㷨:������Ȼ��̶�һ��ֵ��Ȼ�����ƶ���������ֵ���ֱ����������ƶ�
 * ȥ�صķ���ʹ��һ��hashset����Ϊ��������ظ�����ôһ����������ֵ��ȣ���������Ȼ��ȣ�
 * ���ͨ������nums[left]+&+nms[right]���д洢��
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
