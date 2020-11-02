package com.Ajit.Repository;

import com.Ajit.Constants.SearchQueryType;
import com.Ajit.searchPackage.SearchAttribute;
import com.Ajit.factory.SearchFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SearchImpl implements Search {
    private SearchFactory searchFactory;

    public SearchImpl(SearchFactory searchFactory) {
        this.searchFactory = searchFactory;
    }

    @Override
    public void addData(String bookId, String componentName, SearchQueryType searchQueryType) {
        try {
            List<SearchAttribute> objects = searchFactory.getObject(searchQueryType);
            for (SearchAttribute searchAttribute : objects) {
                searchAttribute.addValue(componentName, bookId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> completeSearchData(final String attr, SearchQueryType searchQueryType) {
        try {
            List<SearchAttribute> searchAttributes = searchFactory.getObject(searchQueryType);
            HashSet<String> result = new HashSet<>();
            for (SearchAttribute searchAttribute : searchAttributes)
                result.addAll(searchAttribute.getMatchingValue(attr));
            return new ArrayList<>(result);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<String> prefixSearchData(String attr, SearchQueryType queryType) {
        try {
            List<SearchAttribute> searchAttributes = searchFactory.getObject(queryType);
            HashSet result = new HashSet<String>();
            for (SearchAttribute searchAttribute : searchAttributes) {
                result.addAll(searchAttribute.getAllPrefixMatch(attr));
            }
            return new ArrayList<>(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
