package com.Ajit.searchPackage;

import java.util.ArrayList;
import java.util.List;

public class SearchByTitle extends SearchAttribute {
    private Trie root;

    public SearchByTitle(String searchName) {
        super(searchName);
        this.root = new Trie();
    }

    @Override
    public void addValue(String attribute, String value) {
        Trie node = root;
        for (char ch : attribute.toCharArray()) {
            if (!node.childNode.containsKey(ch)) {
                node.childNode.put(ch, new Trie());
                node.childNode.get(ch).value.add(value);
            }
            node = node.childNode.get(ch);
        }
        node.isEnd = true;
        node.value.add(value);
    }

    @Override
    public List<String> getMatchingValue(String attribute) {
        Trie node = root;
        for (char ch : attribute.toCharArray()) {
            if (!node.childNode.containsKey(ch)) return null;
            node = node.childNode.get(ch);
        }
        if (!node.isEnd) return null;
        return new ArrayList<>(node.value);
    }

    @Override
    public List<String> getAllPrefixMatch(String attribute) {
        Trie node = root;
        for (char ch : attribute.toCharArray()) {
            if (!node.childNode.containsKey(ch)) return null;
            node = node.childNode.get(ch);
        }
        return new ArrayList<>(node.value);
    }
}
