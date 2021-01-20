//https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int array nums
    Space Complexity: O(n) where n is the length of the input int array nums
*/

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int visited = 0;
        for(int i = 0; visited < nums.length; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next]; 
                nums[next] = prev;
                prev = temp;
                current = next;
                visited++;
                
            } while(current != i);
        }
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int array nums
    Space Complexity: O(1)
*/
