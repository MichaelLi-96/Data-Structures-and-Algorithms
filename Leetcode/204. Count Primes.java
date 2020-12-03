//https://leetcode.com/problems/count-primes/

class Solution {
    public int countPrimes(int n) {
        boolean[] multiples = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(multiples[i] == false) {
                count++;
            }
            for(int j = 2; i * j < n; j++) {
                multiples[i * j] = true;    
            }
        }
        return count;
    }
}

/*
	Time Complexity:  O(nlog(log(n))) where n is the input int n (Sieve of Eratosthenes Algorithm: https://cp-algorithms.com/algebra/sieve-of-eratosthenes.html)
	Space Complexity: O(n) where n is the input int n
*/