//https://leetcode.com/problems/defuse-the-bomb/

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] decryptedArray = new int[code.length];
        for(int i = 0; i < code.length; i++) {
            if(k > 0) {
                int endingIndex = i + k;
                int sum = 0;
                if(endingIndex < code.length) {
                    for(int j = i + 1; j <= endingIndex; j++) {
                        sum += code[j];
                    }    
                }
                else {
                    for(int j = i + 1; j < code.length; j++) {
                        sum += code[j];
                    }  
                    for(int j = 0; j <= endingIndex - code.length; j++) {
                        sum += code[j];
                    }    
                }
                decryptedArray[i] = sum;
            }
            else if(k < 0) {
                int startingIndex = i + k;
                int sum = 0;
                if(startingIndex >= 0) {
                    for(int j = startingIndex; j < i; j++) {
                        sum += code[j];
                    }    
                }
                else {
                    for(int j = 0; j < i; j++) {
                        sum += code[j];
                    }  
                    for(int j = code.length + startingIndex; j < code.length; j++) {
                        sum += code[j];
                    }    
                }
                decryptedArray[i] = sum;
            }
            else {
                decryptedArray[i] = 0;
            }
        }
        return decryptedArray;
    }
}

/*
    Time Complexity: O(n * k) where n is the length of the code array and k is the input int k
    Space Complexity: O(1) not counting the output array, O(n) where n is the length of the code array counting the output array
*/