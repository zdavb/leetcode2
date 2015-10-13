/**
 * Created by dave on 2015/10/11.
 */
public class WildCard {
    private boolean match(char[] char1,char[] char2,int leftIndex,int rightIndex){//leftIndex mean char1 index; while rightIndex mean char2
        while(leftIndex<char1.length && rightIndex<char2.length && (char1[leftIndex] == char2[rightIndex] || char2[rightIndex] == '?')){
            leftIndex++;rightIndex++;
        }
        //index;
        if(leftIndex == char1.length || rightIndex == char2.length){
            if(leftIndex == char1.length && rightIndex == char2.length)
                return true;
            return false;
        }
        if(char2[rightIndex] != '*')
            return false;
        else{
            for(int len = 0;len<char1.length-rightIndex;len++){
                if(match(char1,char2,leftIndex+len,rightIndex+1))
                    return true;
            }
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        char[] char1 = s.toCharArray();
        char[] char2 = p.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i<char2.length;i++){
            if(char2[i] == '*'){
                if(i-1>=0 && char2[i-1] == '*');
                else
                    builder.append(char2[i]);
            }else
                builder.append(char2[i]);
        }
        char2 = builder.toString().toCharArray();
        boolean res = match(char1,char2,0,0);
        return res;
    }
    public void test(){
        System.out.println(isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
        //System.out.println(isMatch("aaaa","c*a*a"));
    }
}
