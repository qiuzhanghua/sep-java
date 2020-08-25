package com.example.talent.sep;

import java.util.Iterator;

public class StreamAlerter {

    private RingBuffer ring;
    private Trie trie;

    public StreamAlerter(String[] keys) {
        this.trie = new Trie();
        int maxLen = 0;
        for (String key : keys) {
            if (key.length() > maxLen) maxLen = key.length();
            trie.insert(key);
        }
        ring = new RingBuffer(maxLen);
    }

    public boolean query(char ch) {
        ring.insert(ch);
        Trie node = trie;
        Iterator<Character> iterator = ring.iterator();
        while (node != null) {
            Character c = iterator.next();
            node = node.nodes.get(c);
            if (node != null && node.is_leaf) {
                return true;
            }
        }
        return  false;
    }
}
