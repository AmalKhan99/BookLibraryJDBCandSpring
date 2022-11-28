package com.amal.Persistence;
import com.amal.Entity.Book;

import java.util.Collection;

public interface BookDao {
    Collection<Book> listAllBooks();
    Book searchBookId(int id);
    Book addBook(Book book);

    int deleteBook(int id);
}