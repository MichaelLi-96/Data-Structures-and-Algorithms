//https://leetcode.com/problems/check-if-n-and-its-double-exist/

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Double> halvesAndDoubles = new HashSet<>();
        for(int num : arr) {
            if(halvesAndDoubles.contains((double)num) || halvesAndDoubles.contains((double)num)){
                return true;
            }
            else {
                halvesAndDoubles.add(num / 2.0);
                halvesAndDoubles.add(num * 2.0);
            }
        }
        return false;
    }
}

/*
	Time Complexity: O(n) where n is the number of elements in the input array arr
	Space Complexity: O(n) where n is the number of elements in the input array arr 
*/