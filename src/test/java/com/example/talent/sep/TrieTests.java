package com.example.talent.sep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTests {

    @DisplayName("加入和查询")
    @Test
    public void testInsertAndQuery() {
        Trie trie = new Trie();
        assertFalse(trie.query(""));
        trie.insert("中文");
//        System.out.println(trie);
        trie.insert("Yes");
        trie.insert("邱张华");
        assertTrue(trie.query("中文"));
        assertFalse(trie.query("中"));
        assertTrue(trie.query("Yes"));
        assertFalse(trie.query("邱"));
        assertTrue(trie.query("邱张华"));
    }
}
