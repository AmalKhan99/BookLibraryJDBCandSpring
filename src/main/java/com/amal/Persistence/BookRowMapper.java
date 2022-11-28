package com.amal.Persistence;

import org.springframework.jdbc.core.RowMapper;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                String title = resultSet.getString("bookname");
                String aut = resultSet.getString("authorname");
                int id = resultSet.getInt("BOOKID");
                int copies = resultSet.getInt("numberCOPIES");

                Book books = new Book(id, title, aut, copies);
                return books;
        }
}

