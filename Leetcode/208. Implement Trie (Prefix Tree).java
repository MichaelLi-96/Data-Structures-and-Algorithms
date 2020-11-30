//https://leetcode.com/problems/implement-trie-prefix-tree/

class Node {
    Map<Character, Node> map;
    boolean end;
    public Node() {
        map = new HashMap<>();
        end = false;
    }
}

class Trie {
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node currentLetter = root;
        for(Character ch : word.toCharArray()) {
            Map<Character, Node> nextLetters = currentLetter.map;
            if(nextLetters.containsKey(ch)) {
                currentLetter = nextLetters.get(ch);
            }
            else {
                Node nextLetter = new Node();
                nextLetters.put(ch, nextLetter);
                currentLetter = nextLetter;
            }
        }
        currentLetter.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node currentLetter = root;
        for(Character ch : word.toCharArray()) {
            Map<Character, Node> nextLetters = currentLetter.map;
            if(nextLetters.containsKey(ch)) {
                currentLetter = nextLetters.get(ch);
            }
            else {
                return false;
            }
        }
        return currentLetter.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node currentLetter = root;
        for(Character ch : prefix.toCharArray()) {
             Map<Character, Node> nextLetters = currentLetter.map;
            if(nextLetters.containsKey(ch)) {
                currentLetter = nextLetters.get(ch);
            }
            else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


/*
    insert Method:

    Time Complexity: O(n) where n length of input string word
    Space Complexity: O(n) where n length of input string word

    search Method:

    Time Complexity: O(n) where n length of input string word
    Space Complexity: O(1)

    startsWith Method:

    Time Complexity: O(n) where n length of input string prefix
    Space Complexity: O(1)
*/