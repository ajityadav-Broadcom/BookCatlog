package com.Ajit.searchPackage;

import java.util.*;

class Trie {
    HashSet<String> value;
    boolean isEnd;
    Map<Character, Trie> childNode;

    public Trie() {
        this.value = new HashSet<>();
        this.childNode = new HashMap<>();
        this.isEnd = false;
    }
}
