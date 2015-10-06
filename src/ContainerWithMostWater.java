import java.util.ArrayList;
import java.util.List;

/**
 * Created by dave on 2015/10/6.
 * leetcode-11
 * 因为要求得的结果是max{min(height[i],height[j])*(i-j)}
 * 所以一个思路是分两次遍历，一次从前向后，一次从后向前。第一次遍历时，维护一个列表，列表为升序
 *
 *
 * method2：
 * 假设我们找到了最大容器边i,j，那么所要求的面积值为：min(height[i],height[j])*(j-i);
 * 那么就说明了，对于任意k<i时，都不可能存在height[k]>height[i]
 * 反之亦然。
 */
public class ContainerWithMostWater {
//    private int getArea(int[] height){
//        List<Integer> indexlist = new ArrayList<>();
//        List<Integer> heightlist = new ArrayList<>();
//
//        int max = 0;
//        heightlist.add(height[0]);
//        indexlist.add(0);
//
//        for(int i = 1;i<height.length;i++){
//            int top = heightlist.get(heightlist.size()-1);
//            if(height[i]>top){
//                heightlist.add(height[i]);
//                indexlist.add(i);
//            }
//            else{
//                for(int j = 0;j<heightlist.size();j++){
//                    int cur = heightlist.get(j);
//                    if(cur>height[i])
//                        break;
//                    int index = indexlist.get(j);
//                    int area = cur*(i-index);
//                    max = Math.max(area,max);
//                }
//            }
//        }
//        int lastIndex = indexlist.get(indexlist.size()-1);
//        for(int i = 0;i<heightlist.size()-1;i++){
//            int val = heightlist.get(i);
//            int curIndex = indexlist.get(i);
//            int area = val*(lastIndex-curIndex);
//            max = Math.max(area,max);
//        }
//        return max;
//    }
//    public int maxArea(int[] height) {
//        int max1 = getArea(height);
//        int[] height2 = new int[height.length];
//        for(int i = 0;i<height.length;i++){
//            height2[height.length-i-1] = height[i];
//        }
//        int max2 = getArea(height2);
//        return Math.max(max1,max2);
//    }

    //method2
    public int maxArea(int[] height){
        int max = 0;
        int left = 0;
        int right = height.length-1;

        int area = 0;
        while(left<right){
            if(height[left]<height[right]){
                area = height[left]*(right-left);
                left++;
            }else{
                area = height[right]*(right-left);
                right--;
            }
            max = Math.max(max,area);
        }
        return max;
    }
    public void test(){
        System.out.println(maxArea(new int[]{4,4,2,11,0,11,5,11,13,8}));
    }
}
