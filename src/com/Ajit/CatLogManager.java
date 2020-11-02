package com.Ajit;

import com.Ajit.Constants.SearchQueryType;
import com.Ajit.Modal.Book;

import java.util.List;

public interface CatLogManager {
    public void addBook(Book book) throws Exception;

    public List<Book> searchBooksOrderBySoldCopies(final String attr, SearchQueryType searchQueryType);

    public List<Book> searchBookByPrefix(final String attr, SearchQueryType searchQueryType);
}
