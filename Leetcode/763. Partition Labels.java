//https://leetcode.com/problems/partition-labels/

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitionLengths = new ArrayList<>();
        int[] lastIndexes = new int[26];
        for(int i = 0; i < S.length(); i++) {
            lastIndexes[S.charAt(i) - 'a'] = i;
        }
        
        int startOfPartition = 0;
        int endOfPartition = lastIndexes[S.charAt(0) - 'a'];
        
        for(int i = 0; i < S.length(); i++) {
            if(i == endOfPartition) {
                partitionLengths.add(endOfPartition - startOfPartition + 1);
                if(i != S.length() - 1) {
                    startOfPartition = i + 1;
                    endOfPartition = lastIndexes[S.charAt(i + 1) - 'a'];
                }
            }
            else {
                endOfPartition = Math.max(endOfPartition, lastIndexes[S.charAt(i) - 'a']);
            }
        }
        return partitionLengths;
    }
}

/*
	Time Complexity: O(2n) -> O(n) where n is the length of the input string S 
	Space Complexity: O(n) where n is the length of the input string S 
*/