package leetcode;

/**
 * Created by isssen on 15-9-7.
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        int result=0;
        int nums[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i=0;

        for(int j=0;j<roman.length;){
            if(i==s.length())break;
            if(s.substring(i,i+1).equals(roman[j])){
                result+=nums[j];
                i=i+1;
            }
            else if(i<s.length()-1&&s.substring(i,i+2).equals(roman[j])){
                result+=nums[j];
                i=i+2;
            }
            else {
                j++;
            }
        }
        return result;
    }

    public static void main(String []args){
        String s="MCMXCVIII";
        System.out.println(s.substring(0,1));
        System.out.println(romanToInt(s));
    }
}
