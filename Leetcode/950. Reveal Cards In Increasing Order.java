//https://leetcode.com/problems/reveal-cards-in-increasing-order/

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] increasingOrderDeck = new int[deck.length];
        Queue<Integer> indexes = new LinkedList<>();
        for(int i = 0; i < deck.length; i++) {
            indexes.add(i);
        }
        
        for(int i = 0; i < deck.length; i++) {
            increasingOrderDeck[indexes.poll()] = deck[i];
            indexes.add(indexes.poll());     
        }
        return increasingOrderDeck;
    }
}

/*
    Time Complexity: O(nlog(n) + 2n)) -> O(nlog(n)) where n is the length of the input array deck
    Space Complexity: O(n) where n is the length of the input array deck
*/