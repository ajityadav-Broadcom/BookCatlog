package com.Ajit.Repository;

import com.Ajit.Constants.SearchQueryType;

import java.util.List;

public interface Search {
    public void addData(final String bookId, final String componentName, SearchQueryType searchQueryType) throws Exception;

    public List<String> completeSearchData(final String attr, SearchQueryType searchQueryType);

    public List<String> prefixSearchData(final String attr, SearchQueryType queryType);

}
