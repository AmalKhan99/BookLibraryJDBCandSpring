package com.amal.Service;

import com.amal.Entity.Book;

import java.util.Collection;

public interface BookService {

    Collection<Book> listAllBooks();

    Book searchBookId(int id);

    boolean addBook(Book book);
}
