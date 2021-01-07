//https://leetcode.com/problems/find-bottom-left-tree-value/

class Solution {
    public int arrangeCoins(int n) {
        int row = 1;
        while(row < n) {
            n -= row;
            row++;
        }
        if(n == row) {
            return row;
        }
        return row - 1;
    }
}

/*
    Time Complexity: O(n/2) -> O(n) is the input int n
    Space Complexity: O(1)
*/

// binary search, total coins in k rows so far: k(k + 1) / 2

class Solution {
    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long totalCoinsHere = mid*(mid + 1) / 2;
            if(n - totalCoinsHere == 0 || (n - totalCoinsHere > 0 && n - totalCoinsHere < mid + 1)) {
                return (int)mid;
            }
            else if(n - totalCoinsHere > 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}


/*
    Time Complexity: O(log(n)) is the input int n
    Space Complexity: O(1)
*/