package leetcode;

import java.util.*;

/**
 * Created by isssen on 15-9-11.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();

        if(nums.length<4)return result;
        Arrays.sort(nums);
        List<Integer> r;
        for(int i=0;i<=nums.length-4;i++){
            if(i!=0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<=nums.length-3;j++){
                if(j!=i+1&&nums[j]==nums[j-1])continue;
                int m=j+1,n=nums.length-1;

                while(m<n){
                    if(m!=j+1&&nums[m]==nums[m-1]){
                        m++;continue;
                    }
                    r=new ArrayList<Integer>();
                    int sum=nums[i]+nums[j]+nums[m]+nums[n];
                    if(sum==target){
                        r.add(nums[i]);r.add(nums[j]);r.add(nums[m]);r.add(nums[n]);
                        m++;n--;
                        result.add(r);
                    }
                    else if(sum<target){
                        m++;
                    }
                    else{
                        n--;
                    }
                }

            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length<4) return result;
        Arrays.sort(nums);
        List<Integer> r;
        for(int i=0;i<nums.length-3;i++){
            if(i!=0&&nums[i]==nums[i-1])continue;
            for(int j=nums.length-1;j>i+2;j--){
                if(j!=nums.length-1&&nums[j]==nums[j+1])continue;
                int m=i+1,n=j-1;
                while(m<n){
                    if(m!=i+1&&nums[m]==nums[m-1]){m++;continue;}
                    int sum=nums[i]+nums[j]+nums[m]+nums[n];
                    r=new ArrayList<Integer>();
                    if(sum==target){

                        r.add(nums[i]);
                        r.add(nums[m]);
                        r.add(nums[n]);
                        r.add(nums[j]);
                        result.add(r);
                        m++;n--;

                    }
                    else if(sum<target) m++;
                    else n--;
                }
            }
        }
        return result;
    }

    public static void main(String []args){
        int []nums={-5,5,4,-3,0,0,4,-2};
        int target=4;
        System.out.println(fourSum2(nums,target));
    }
}
