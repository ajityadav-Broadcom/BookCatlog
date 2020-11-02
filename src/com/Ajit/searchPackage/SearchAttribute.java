package com.Ajit.searchPackage;

import java.util.List;

public abstract class SearchAttribute {
    private String searchName;

    public SearchAttribute(String searchName) {
        this.searchName = searchName;
    }

    public abstract void addValue(final String attribute, final String value);

    public abstract List<String> getMatchingValue(final String attribute);

    public abstract List<String> getAllPrefixMatch(final String attribute);
}
