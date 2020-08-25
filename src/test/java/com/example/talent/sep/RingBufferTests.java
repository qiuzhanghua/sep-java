package com.example.talent.sep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class RingBufferTests {

    @DisplayName("加入和获取")
    @Test
    public void testInsert() {
        RingBuffer buffer = new RingBuffer(3);
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        Iterator<Character> iterator = buffer.iterator();
        assertEquals(Character.valueOf('c'), iterator.next(), "最后的参数");
        assertEquals(Character.valueOf('b'), iterator.next(), "参数b");
        assertEquals(Character.valueOf('a'), iterator.next(), "参数a");
        assertEquals(Character.valueOf(' '), iterator.next(), "参数空");
        assertEquals(Character.valueOf('c'), iterator.next(), "循环的参数");
        assertEquals(Character.valueOf('b'), iterator.next(), "b again");
    }
}
