package com.example.talent.sep;

import java.util.Arrays;
import java.util.Iterator;

public class RingBuffer implements Iterable<Character>{
    char[] buffer;
    Integer pos;
    Integer len;

    public RingBuffer(Integer len) {// len = 2 ** n
        int i = 2;
        while (i < len) {
           i += i;
        }
        this.len = i;
        buffer = new char[this.len];
        Arrays.fill(buffer, ' '); // space as default
        pos = 0;
    }

    public void insert(char ch) {
        buffer[pos] = ch;
        pos += 1;
        pos &= len - 1;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            private Integer idx = pos;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Character next() {
                idx += len - 1;
                idx &= len - 1;
                return buffer[idx];
            }
        };
    }
}
