package com.amal.Persistence;

import com.amal.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("dao")
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Book> listAllBooks() {

        String query = "SELECT * FROM BOOKS";
        List<Book> bookList = jdbcTemplate.query(query, new BookRowMapper());
        return bookList;
    }

    @Override
    public Book searchBookId(int bookID) {
        Book books=null;
        try {
            String query = "SELECT*FROM BOOK WHERE BOOKID=?";
            books = jdbcTemplate.queryForObject(query, new BookRowMapper(), bookID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
        return books;
    }

    @Override
    public int addBook(Book book) {
        try {
            String query = "INSERT INTO BOOKS VALUES(?,?,?,?)";
            int rows = jdbcTemplate.update(query, book.getBookId(), book.getBookName(), book.getAuthorName(), book.getNumberCopies());
            return rows;
        } catch (DuplicateKeyException ex) {
            return 0;
        }


    }


    @Override
    public int deleteBook(int id) {
        String query = "DELETE FROM BOOK WHERE BOOKID=?";
        int rows = jdbcTemplate.update(query, id);
        return rows;
    }

    @Override
    public int updateCopies(int id, int copies) {
        String query = "UPDATE BOOKS SET NUMBERCOPIES=? WHERE BOOKID=?";

        int rows = jdbcTemplate.update(query, copies, id);
        return rows;
    }


}
