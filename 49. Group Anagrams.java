//https://leetcode.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] letters = new int[26];
        for(String str : strs) {
            Arrays.fill(letters, 0);
            for(int i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - 'a']++;
            }
            if(map.containsKey(Arrays.toString(letters))) {
                map.get(Arrays.toString(letters)).add(str);
            }
            else {
                List<String> mapList = new ArrayList<>();
                mapList.add(str);
                map.put(Arrays.toString(letters), mapList);
            }
        }
        
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}

/*
	Time Complexity: O(n * k) where n is the length of the input strs array and k is the length of the longest string in the input strs array
	Space Complexity: O(n) where n is the length of the input strs array
*/