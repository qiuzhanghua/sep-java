package com.example.talent.sep;

import java.util.HashMap;

public class Trie {
    Boolean is_leaf;
    HashMap<Character, Trie> nodes;

    @Override
    public String toString() {
        return "Trie{" +
                "is_leaf=" + is_leaf +
                ", nodes=" + nodes +
                '}';
    }

    public Trie() {
        is_leaf = false;
        nodes = new HashMap<>();
    }

    public void insert(String key) {
        Trie node = this;
        // inverse as data stream got reversely
        for (int i = key.length() - 1; i >= 0; i--) {
            Character ch = key.charAt(i);
            if (!node.nodes.containsKey(ch)) {
                node.nodes.put(ch, new Trie());
            }
            node = node.nodes.get(ch);
        }
        node.is_leaf = true;
    }

    public boolean query(String key) {
       Trie node = this;
       int i = key.length() - 1;
        while (i >= 0 && node != null) {
            Character ch = key.charAt(i);
            node = node.nodes.get(ch);
            if (node != null && node.is_leaf) {
                return true;
            }
            i -= 1;
        }
        return false;
    }
}
