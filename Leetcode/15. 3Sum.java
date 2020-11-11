//https://leetcode.com/problems/3sum/submissions/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(nums[i]);
                        newList.add(nums[j]);
                        newList.add(nums[k]);
                        list.add(newList);
                        j++;
                        k--;
                        while(j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while(j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    else if(sum > 0) {
                        k--;
                    }
                    else {
                        j++;
                    }
                }   
            }
        }
        return list;
    }
}

/*
	Time Complexity: O(nlog(n) + n^2) -> O(n^2) where n is the length of input array nums
	Space Complexity: O(1) as the output list is not counted as auxiliary space
*/