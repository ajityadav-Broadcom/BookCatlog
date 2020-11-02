package com.Ajit.factory;

import com.Ajit.searchPackage.SearchAttribute;
import com.Ajit.searchPackage.SearchByAuthor;
import com.Ajit.searchPackage.SearchByCategory;
import com.Ajit.searchPackage.SearchByTitle;
import com.Ajit.Constants.SearchQueryType;

import java.util.*;

public class SearchFactory {
    Map<SearchQueryType, SearchAttribute> searchQueryTypeObjectMap;

    public SearchFactory() {
        this.searchQueryTypeObjectMap = new HashMap<>();
        searchQueryTypeObjectMap.put(SearchQueryType.AUTHOR, new SearchByAuthor("SEARCH_BY_AUTHOR"));
        searchQueryTypeObjectMap.put(SearchQueryType.TITLE, new SearchByTitle("SEARCH_BY_TITLE"));
        searchQueryTypeObjectMap.put(SearchQueryType.CATEGORY, new SearchByCategory("SEARCH_BY_CATEGORY"));
    }

    public List<SearchAttribute> getObject(SearchQueryType searchQueryType) throws Exception {
        if (searchQueryType == SearchQueryType.ALL) {
            return new ArrayList<SearchAttribute>(Arrays.asList(
                    searchQueryTypeObjectMap.get(SearchQueryType.TITLE)
                    , searchQueryTypeObjectMap.get(SearchQueryType.AUTHOR)
                    , searchQueryTypeObjectMap.get(SearchQueryType.CATEGORY)
            ));
        } else if (searchQueryTypeObjectMap.containsKey(searchQueryType)) {
            return new ArrayList<SearchAttribute>(Arrays.asList(searchQueryTypeObjectMap.get(searchQueryType)));
        } else {
            throw new Exception("no such attribute we have added in our database");
        }
    }
}
