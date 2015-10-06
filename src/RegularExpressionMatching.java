/**
 * Created by dave on 2015/10/5.
 */
public class RegularExpressionMatching {
//    private boolean pregMatch(char[] chars,char[] charp,int sIndex,int pIndex){
//        while(sIndex<chars.length && pIndex<charp.length && (chars[sIndex] == charp[pIndex]|| charp[pIndex] == '.')){
//            sIndex++;pIndex++;
//        }
//        if(sIndex == chars.length || pIndex == charp.length){
//            if(sIndex == chars.length && pIndex == charp.length)
//                return true;
//            if(pIndex == charp.length)
//                return false;
//        }
//        if(charp[pIndex] != '*'){
//            if(pIndex+1<charp.length && charp[pIndex+1] == '*')
//                return pregMatch(chars,charp,sIndex,pIndex+2);
//            return false;
//        }
//        int spregIndex = sIndex-1;
//        int len = 1;
//        while(sIndex<chars.length && (chars[sIndex] == charp[pIndex-1]||charp[pIndex-1] == '.')) {
//            sIndex++;
//            len++;
//        }
//        int index = 0;
//        while (index<=len){
//            boolean res = pregMatch(chars,charp,spregIndex+index,pIndex+1);
//            if(res)
//                return true;
//            index++;
//        }
//        return false;
//    }
//    public boolean isMatch(String s, String p) {
//        return pregMatch(s.toCharArray(),p.toCharArray(),0,0);
//    }
    private boolean pregMatch(char[] chars,char[] charp,int sleft,int pleft){
        while(sleft<chars.length && pleft<charp.length && (chars[sleft] == charp[pleft] || charp[pleft] == '.')){
            sleft++;pleft++;
        }
        if(sleft == chars.length && pleft == charp.length)
            return true;
        if(pleft == charp.length)
            return false;
        if(charp[pleft] != '*'){
            if(pleft+1<charp.length && charp[pleft+1] == '*')
                return pregMatch(chars,charp,sleft,pleft+2);
            return false;
        }
        int len = 1;//the number which * can repeat
        int index = 0;
        int spregIndex = sleft-1;
        while(sleft<chars.length && (chars[sleft] == charp[pleft-1] || charp[pleft-1] == '.')){
            sleft++;len++;
        }

        while(index<=len){
            if(pregMatch(chars,charp,spregIndex+index,pleft+1))
                return true;
            index++;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        return pregMatch(s.toCharArray(),p.toCharArray(),0,0);
    }
    public void test(){
        System.out.println(isMatch("ab",".*.."));

    }
}
