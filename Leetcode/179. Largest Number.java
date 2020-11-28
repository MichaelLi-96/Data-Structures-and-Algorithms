//https://leetcode.com/problems/largest-number/

class Solution {
    public String largestNumber(int[] nums) {
        String curLargestNumber = "";
        String[] numbers = new String[nums.length];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numbers, (x, y) -> new String(y + x).compareTo(new String(x + y)));
        if(numbers[0].equals("0")) {
            return "0";
        }
        for(String num : numbers) {
            String str1 = curLargestNumber + num;
            String str2 = num + curLargestNumber;
            if(str1.compareTo(str2) > 0) {
                curLargestNumber = str1;
            }
            else {
                curLargestNumber = str2;
            }
        }
        return curLargestNumber;
    }
}

/*
    Time Complexity: O(nlog(n) + O(n)) -> O(nlog(n)) where n is the length of the input nums array
    Space Complexity: O(n) where n is the length of the input nums array