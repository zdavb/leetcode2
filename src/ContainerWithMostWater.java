import java.util.ArrayList;
import java.util.List;

/**
 * Created by dave on 2015/10/6.
 * leetcode-11
 * ��ΪҪ��õĽ����max{min(height[i],height[j])*(i-j)}
 * ����һ��˼·�Ƿ����α�����һ�δ�ǰ���һ�δӺ���ǰ����һ�α���ʱ��ά��һ���б��б�Ϊ����
 *
 *
 * method2��
 * ���������ҵ������������i,j����ô��Ҫ������ֵΪ��min(height[i],height[j])*(j-i);
 * ��ô��˵���ˣ���������k<iʱ���������ܴ���height[k]>height[i]
 * ��֮��Ȼ��
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
