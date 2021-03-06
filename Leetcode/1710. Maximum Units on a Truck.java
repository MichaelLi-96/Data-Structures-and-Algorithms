//https://leetcode.com/problems/maximum-units-on-a-truck/

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] numberOfUnits = new int[1001];
        for(int i = 0; i < boxTypes.length; i++) {
            int units = boxTypes[i][1];
            int amount = boxTypes[i][0];
            numberOfUnits[units] += amount;
        }
        
        int total = 0;
        int currentSize = 0;
        for(int i = numberOfUnits.length - 1; i >= 0 && currentSize != truckSize; i--) {
            while(numberOfUnits[i] > 0 && currentSize != truckSize) {
                total += i;
                numberOfUnits[i]--;
                currentSize++;
            }
        } 
        return total;
    }
}


/*
    Time Complexity: O(n) where n is the length of the input matrix boxTypes 
    Space Complexity: O(1) 
*/