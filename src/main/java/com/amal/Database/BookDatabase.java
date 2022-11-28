package com.amal.Database;
import com.amal.Entity.Book;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookDatabase {

    static private Map<Integer, Book> bookList = new LinkedHashMap<Integer, Book>();

    static {
        bookList.put(101, new Book(101, "BookA", "Author1", 6));
        bookList.put(102, new Book(102, "BookB", "Author2", 9));
        bookList.put(103, new Book(103, "BookC", "Author1", 4));
        bookList.put(104, new Book(104, "BookD", "Author3", 7));
        bookList.put(105, new Book(105, "BookE", "Author4", 5));
        bookList.put(106, new Book(106, "BookF", "Author2", 4));
        bookList.put(107, new Book(107, "BookG", "Author5", 9));
        bookList.put(108, new Book(108, "BookH", "Author6", 2));

    }

    public static Map<Integer, Book> getBookList() {
        return bookList;
    }
}
