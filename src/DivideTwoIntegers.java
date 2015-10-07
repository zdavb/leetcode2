/**
 * Created by dave on 2015/10/7.
 * leetcode-29
 */
public class DivideTwoIntegers {
    private int getBit(long dend,int index){
        if((dend & (1<<index))==0)
            return 0;
        return 1;
    }
    public int divide(int dividend, int divisor) {
        long dend = (long)dividend;
        long dsor = (long)divisor;

        boolean negative = false;
        if(dend<0){
            negative = !negative;
            dend = -dend;
        }
        if(dsor<0){
            negative = !negative;
            dsor = -dsor;
        }
        long prev = 0;
        long val = 0;
        int index = 31;
        long res = 0;

        while(index>=0){
            val = (prev<<1)+getBit(dend,index);
            if(val>=dsor){
                res = (res<<1)+1;
                val -= dsor;
            }else{
                res = res<<1;
            }
            prev = val;
            index--;
        }
        if(res>Integer.MAX_VALUE)
            return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        return negative?(int)-res:(int)res;
    }
    public void test(){
        System.out.println(divide(-2147483648,-1109186033));
//        System.out.println(1<<1+1);
        int val = Integer.MIN_VALUE+1;
        System.out.println(-val);
    }
}
