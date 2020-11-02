package com.Ajit.Repository;

import com.Ajit.Constants.SearchQueryType;
import com.Ajit.Modal.Book;

import java.util.*;

public class BookRepositoryImpl implements BookRepository {
    private Map<String, Book> bookMap;
    private Search search;
    private PriorityQueue<Book> pq;

    public BookRepositoryImpl(Search search) {
        this.bookMap = new HashMap<>();
        this.search = search;
    }

    @Override
    public void addBook(Book book) throws Exception {
        bookMap.put(book.getId(), book);
        search.addData(book.getId(), book.getAuthor(), SearchQueryType.AUTHOR);
        search.addData(book.getId(), book.getCategory(), SearchQueryType.CATEGORY);
        search.addData(book.getId(), book.getTitle(), SearchQueryType.TITLE);
    }

    @Override
    public List<Book> searchBooksOrderBySoldCopies(final String attr, SearchQueryType searchQueryType) {
        List<String> result = search.completeSearchData(attr, searchQueryType);
        pq = new PriorityQueue<>(result.size(), new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getSoldCopies() - o1.getSoldCopies();
            }
        });
        result.forEach(e -> {
            pq.offer(bookMap.get(e));
        });
        List<Book> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        pq = null;
        return ans;
    }

    @Override
    public List<Book> searchBookByPrefix(final String attr, SearchQueryType searchQueryType) {
        List<String> result = new ArrayList<>();
        List<Book> ans = new ArrayList<>();
        result.forEach(e -> {
            ans.add(bookMap.get(e));
        });
        return ans;
    }
}
