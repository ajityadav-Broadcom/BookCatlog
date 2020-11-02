package com.Ajit;

import com.Ajit.Constants.SearchQueryType;
import com.Ajit.Modal.Book;
import com.Ajit.Repository.BookRepository;

import java.util.List;

public class CatLogService implements CatLogManager {
    private BookRepository bookRepository;

    public CatLogService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) throws Exception {
        bookRepository.addBook(book);
    }

    @Override
    public List<Book> searchBooksOrderBySoldCopies(String attr, SearchQueryType searchQueryType) {
        return bookRepository.searchBooksOrderBySoldCopies(attr, searchQueryType);
    }

    @Override
    public List<Book> searchBookByPrefix(String attr, SearchQueryType searchQueryType) {
        return bookRepository.searchBookByPrefix(attr, searchQueryType);
    }
}
