//https://leetcode.com/problems/spiral-matrix/submissions/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();
        int top = 0;
        int bot = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int dir = 1;
        while(top <= bot && left <= right) {
            // 1 = left -> right
            if(dir == 1) {
                for(int i = left; i <= right; i++) {
                    spiralOrder.add(matrix[top][i]);
                }
                top++;
                dir = 2;
            }
            // 2 = top -> bottom
            else if(dir == 2) {
                for(int i = top; i <= bot; i++) {
                    spiralOrder.add(matrix[i][right]);
                }
                right--;
                dir = 3;
            }
            // 3 = right -> left
            else if(dir == 3) {
                for(int i = right; i >= left; i--) {
                    spiralOrder.add(matrix[bot][i]);
                }
                bot--;
                dir = 4;
            }
            // 4 = bottom -> top
            else if(dir == 4) {
                for(int i = bot; i >= top; i--) {
                    spiralOrder.add(matrix[i][left]);
                }
                left++;
                dir = 1;
            }
        }
        return spiralOrder;
    }
}

/*
    Time Complexity: O(n) where n is the number of elements in the input matrix
    Space Complexity: O(1) not counting output arraylist, otherwise O(n)
*/