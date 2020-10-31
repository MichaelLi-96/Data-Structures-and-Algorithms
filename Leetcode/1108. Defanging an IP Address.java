//https://leetcode.com/problems/defanging-an-ip-address/

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < address.length(); i++) {
            Character ch = address.charAt(i);
            if(ch == '.') {
                str.append("[.]");
            }
            else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}

/*
    Time Complexity: O(n) where n is the length of the input address string
    Space Complexity: O(n) where n is the length of the input address string
*/