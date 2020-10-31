//https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(0, 0, n, new StringBuilder(), list);
        return list;
    }
    
    public void backtracking(int left, int right, int n, StringBuilder currentStr, List<String> list) {
        if(left == n && right == n) {
            list.add(currentStr.toString());
            return;
        }
        
        if(left < n) {
            backtracking(left + 1, right, n, currentStr.append("("), list);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
        if(right < left && right < n) {
            backtracking(left, right + 1, n, currentStr.append(")"), list);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
    }
}


/*
	Time Complexity: O(4^n/sqrt(n)) where n is the size of the input n 
	Space Complexity: O(4^n/sqrt(n)) where n is the size of the input n 
*/