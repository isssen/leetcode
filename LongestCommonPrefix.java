package leetcode;

/**
 * Created by isssen on 15-9-7.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String result="";
        int num=strs.length;
        if(num<1)return result;
        int shortest=Integer.MAX_VALUE;
        for(int i=0;i<num;i++){
            if(shortest>strs[i].length()){
                shortest=strs[i].length();
            }
        }
        for(int i=0;i<shortest;i++){
            char s=strs[0].charAt(i);
            for(int j=0;j<num;j++){
                if(s!=strs[j].charAt(i))
                    return result;
            }
            result+=s;
        }
        return result;
    }

    public static void main(String []args){
        String[] strs={"aba","a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
