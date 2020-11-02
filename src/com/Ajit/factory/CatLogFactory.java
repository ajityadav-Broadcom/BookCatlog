package com.Ajit.factory;

import com.Ajit.CatLogManager;
import com.Ajit.CatLogService;
import com.Ajit.Repository.BookRepositoryImpl;
import com.Ajit.Repository.Search;
import com.Ajit.Repository.SearchImpl;

public class CatLogFactory {

    public CatLogFactory() {
    }

    public CatLogManager getCatLogManager(SearchFactory searchFactory) {
        return new CatLogService(new BookRepositoryImpl(new SearchImpl(searchFactory)));
    }
}
