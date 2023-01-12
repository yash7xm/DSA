// USING BACKTRACKING

class Solution {
    public static void permute(int[] nums, int l, List<List<Integer>> list){
        if(l==nums.length-1){
            List<Integer> temp=new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                temp.add(nums[i]);
            }
            list.add(temp);
            return;
        }
        for(int i=l; i<nums.length; i++){
            swap(nums,l,i);
            permute(nums,l+1,list);
            swap(nums,l,i);
        }
    }
    public static void swap(int[] nums, int l, int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        permute(nums,0,list);
        return list;
    }
}

// BY CONCATENATING SUBSTRINGS

import java.util.*;

public class Main
{
    public static void sub(String s, String p, List<String> list){
        if(s.length()==0){
            list.add(p);
            return;
        }
        for(int i=0; i<s.length(); i++){
            String ls=s.substring(0,i);
            String rs=s.substring(i+1);
            String res=ls+rs;
            sub(res,p+s.charAt(i),list);
        }
    }
	public static void main(String[] args) {
		String s="ABC";
		List<String> list=new ArrayList<>();
		sub(s,"",list);
		System.out.println(list);
	}
}
