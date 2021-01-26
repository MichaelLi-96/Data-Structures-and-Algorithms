//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return new ArrayList<>();
        }
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
        List<String> allCombos = new ArrayList<>();
        findCombos(0, new StringBuilder(), digits, map, allCombos);
        return allCombos;
    }
    
    public void findCombos(int currentIndex, StringBuilder currentString, String digits, Map<Character, Character[]> map, List<String> allCombos) {
        if(currentIndex == digits.length()) {
            allCombos.add(currentString.toString());
            return;
        }
        Character[] letters = map.get(digits.charAt(currentIndex));
        for(Character ch : letters) {
            currentString.append(ch);
            findCombos(currentIndex + 1, currentString, digits, map, allCombos);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}

/*
	Time Complexity: O(3^n * 4^m) where n is the number of digits that map to 3 digits and m is the number of digits that map to 4 digits in the input string digits
	Space Complexity: O(3^n * 4^m) where n is the number of digits that map to 3 digits and m is the number of digits that map to 4 digits in the input string digits
*/