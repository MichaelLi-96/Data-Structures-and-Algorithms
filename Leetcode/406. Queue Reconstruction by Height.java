//https://leetcode.com/problems/queue-reconstruction-by-height/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) ->  {
            if(x[0] != y[0]) {
                return y[0] - x[0];
            }
            else {
                return x[1] - y[1];
            }
        });
        List<int[]> queue = new ArrayList<>();
        for(int[] person : people) {
            maxHeap.add(person);
        }
        while(!maxHeap.isEmpty()) {
            int[] person = maxHeap.poll();
            queue.add(person[1], person);
        }
        
        for(int i = 0; i < queue.size(); i++) {
            int[] person = queue.get(i);
            people[i] = person;
        }
        return people;
    }
}

/*
	Time Complexity: O(n) where n is the length of the input matrix people
	Space Complexity: O(n) where n is the length of the input matrix people
*/