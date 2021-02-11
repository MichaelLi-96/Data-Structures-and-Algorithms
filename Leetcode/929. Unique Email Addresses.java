//https://leetcode.com/problems/unique-email-addresses/

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            String[] names = email.split("@");
            String localName = names[0];
            String domainName = names[1];
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < localName.length(); i++) {
                Character ch = localName.charAt(i);
                if(ch == '.') {
                    continue;
                }
                else if(ch == '+') {
                    break;
                }
                else {
                    str.append(ch);
                }
            }
            str.append("@");
            str.append(domainName);
            String newEmailAddress = str.toString();
            set.add(newEmailAddress);
        } 
        return set.size();
    }
}

/*
    Time Complexity: O(n * m) where n is the length of the input string array emails and m is the length of the longest localName of each email
    Space Complexity: O(n) where n is the length of the input string array emails
*/