//https://leetcode.com/problems/minimum-index-sum-of-two-lists/submissions/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> resSum = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            resSum.put(list1[i], i);
        }
        List<String> currentRestuarants = new ArrayList<>();
        int currentSmallestSum = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++) {
            String restaurant = list2[i];
            if(resSum.containsKey(restaurant)) {
                int indexSum = resSum.get(restaurant) + i;
                if(indexSum == currentSmallestSum) {
                    currentRestuarants.add(restaurant);
                }
                if(indexSum < currentSmallestSum) {
                    currentRestuarants.clear();
                    currentSmallestSum = indexSum;
                    currentRestuarants.add(restaurant);
                }
            }
        }
        String[] restuarants = new String[currentRestuarants.size()];
        for(int i = 0; i < currentRestuarants.size(); i++) {
            restuarants[i] = currentRestuarants.get(i);
        }
        return restuarants;
    }
}

/*
    Time Complexity: O(n + m) where n is the length of input array list1 and m is the length of input array list2
    Space Complexity: O(2n) -> O(n) where n is the length of input array list1 
*/