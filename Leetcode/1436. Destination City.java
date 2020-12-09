//https://leetcode.com/problems/destination-city/

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> trips = new HashMap<>();
        for(List<String> trip : paths) {
            trips.put(trip.get(0), trip.get(1));
        }
        
        String currentCity = paths.get(0).get(0);
        while(trips.containsKey(currentCity)) {
            currentCity = trips.get(currentCity);
        }
        return currentCity;
    }
}

/*
	Time Complexity: O(2n) -> O(n) where n is the length of the input list paths
	Space Complexity: O(n) where n is the length of the input list paths
*/