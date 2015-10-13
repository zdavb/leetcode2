import java.util.ArrayList;
import java.util.List;

/**
 * Created by dave on 2015/10/11.
 */
public class MultiString {
        private void multilist(List<Integer> list,int val,List<Integer> tmplist){
            int prev = 0;
            for(int i = list.size()-1;i>=0;i--){
                int value = list.get(i);
                int total = value*val+prev;
                tmplist.add(total%10);
                prev = total/10;
            }
            if(prev>0)
                tmplist.add(prev);

            //翻转tmplist
            int left = 0;
            int right = tmplist.size()-1;
            while(left<right){
                //swap two value
                int leftVal = tmplist.get(left);
                tmplist.set(left,tmplist.get(right));
                tmplist.set(right,leftVal);
                left++;right--;
            }
        }
        private void addlist(List<Integer> sumlist,List<Integer> list){
            List<Integer> reslist = new ArrayList<>();
            int leftIndex = sumlist.size()-1;
            int rightIndex = list.size()-1;
            int prev = 0;

            while(leftIndex>=0 && rightIndex>=0){
                int leftVal = sumlist.get(leftIndex);
                int rightVal = list.get(rightIndex);

                int total = leftVal+rightVal+prev;
                reslist.add(total % 10);
                prev = total/10;

                leftIndex--;rightIndex--;
            }
            while(leftIndex>=0){
                int total = sumlist.get(leftIndex)+prev;
                reslist.add(total % 10);
                prev = total / 10;
                leftIndex--;
            }
            while(rightIndex>=0){
                int total = list.get(rightIndex)+prev;
                reslist.add(total % 10);
                prev = total / 10;
                rightIndex--;
            }
            if(prev>0)
                reslist.add(prev);

            //reverse reslist to sumlist
            sumlist.clear();
            for(int i = reslist.size()-1;i>=0;i--)
                sumlist.add(reslist.get(i));
        }
        public String multiply(String num1, String num2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            //init list1
            for(int i = 0;i<chars1.length;i++){
                list1.add(chars1[i] - '0');
            }
            //init list2
            for(int i = 0;i<chars2.length;i++){
                list2.add(chars2[i] - '0');
            }
            //make sure list1 larger than list2
            if(chars1.length < chars2.length){
                List<Integer> tmplist = list1;
                list1 = list2;
                list2 = tmplist;
            }

            List<Integer> tmplist = new ArrayList<>();
            List<Integer> sumlist = null;

            int base = 0;//后面有多少0
            for(int i = list2.size()-1;i>=0;i--){
                int val = list2.get(i);
                multilist(list1,val,tmplist);

                if(sumlist == null){
                    sumlist = new ArrayList<>(tmplist);
                }else{
                    int n = 0;
                    while(n<base){
                        tmplist.add(0);
                        n++;
                    }
                    addlist(sumlist,tmplist);
                }
                base++;
                tmplist.clear();
            }
            //去0
            if(sumlist.get(0)==0){
                sumlist.clear();
                sumlist.add(0);
            }

            StringBuilder builder = new StringBuilder();
            //recover sumlist
            for(int i = 0;i<sumlist.size();i++){
                builder.append(sumlist.get(i));
            }
            return builder.toString();
        }
    public void test(){
        System.out.println(multiply("1","1"));
    }
}
