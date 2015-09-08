package leetcode;
import java.util.*;

/**
 * Created by isssen on 15-9-7.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(nums.length<1)return result;
        Arrays.sort(nums);
       // mergesort(nums, 0, nums.length - 1);
        List<Integer> three;
        int sum;
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length;j++){
                if(j!=i+1&&nums[j]==nums[j-1])continue;
                for(int k=j+1;k<nums.length;){
                    if(k!=j+1&&nums[k]==nums[k-1]){
                        k++;
                        continue;
                    }
                    sum=nums[i]+nums[j]+nums[k];
                    if(sum==0){
                        three=new ArrayList<Integer>();
                        three.add(nums[i]);
                        three.add(nums[j]);
                        three.add(nums[k]);
                        result.add(three);
                        break;
                    }
                    else if(sum>0)break;
                    else{
                        k++;
                    }

                }
            }
        }
        return result;
    }

    public static List<List<Integer>> twoSum(int []nums){
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Set<Integer> set=new HashSet<Integer>();
        if(nums.length<1)return result;
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==0){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    List<Integer> r=new ArrayList<Integer>();
                    r.add(nums[i]);
                    r.add(nums[j]);
                    result.add(r);
                }
                ++i;--j;
            }
            else if(nums[i]+nums[j]<0){
                ++i;
            }
            else --j;
        }
        return result;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int small=Integer.MAX_VALUE;
        int result=0;
        int j=0,k=nums.length-1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int sum=0;
            j=i+1;
            k=nums.length-1;
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                if(sum>target)k--;
                else if(sum<target)j++;
                else {
                    k--;j++;
                }
                if(Math.abs(sum-target)<small){
                    small=Math.abs(sum-target);
                    result=sum;
                }
            }

        }
        return result;
    }
    public static void main(String []args){
        int []nums={-1, 2, 1,4};
        System.out.println(threeSumClosest(nums, 1));
       // mergesort(nums,0,6);
        List<List<Integer>> result=twoSum(nums);
            System.out.println(result.toString());

    }
}
