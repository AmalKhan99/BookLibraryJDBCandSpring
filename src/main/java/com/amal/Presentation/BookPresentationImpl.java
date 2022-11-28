package com.amal.Presentation;
import com.amal.Entity.Book;
import com.amal.Service.BookService;

import java.util.Collection;
import java.util.Scanner;

public class BookPresentationImpl implements BookPresentation {

    private BookService bookService;
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    @Override
    public void showMenu() {
        System.out.println("====== Main Menu =====");
        System.out.println("Book LookUp System");
        System.out.println("1. List All Books");
        System.out.println("2. Search Book By Id");
        System.out.println("3. Add a Book");
        System.out.println("4. Exit");
    }
    @Override
    public void performMenu(int choice) {
        Scanner scn = new Scanner(System.in);
        switch (choice) {
            case 1 -> {
                Collection<Book> books = bookService.listAllBooks();
                for (Book book : books) {
                    System.out.println(book);
                }
            }
            case 2 -> {
                System.out.println("Enter Book ID : ");
                int id = scn.nextInt();
                Book book = bookService.searchBookId(id);
                if (book != null)
                    System.out.println(book);
                else
                    System.out.println("Book with id " + id + " does not exist");
            }
            case 3 -> {
                Book newBook = new Book();
                System.out.println("Enter Book id : ");
                newBook.setBookId(scn.nextInt());
                scn.nextLine();
                System.out.println("Enter Book Title: ");
                newBook.setBookName(scn.nextLine());
                System.out.println("Enter Author name: ");
                newBook.setAuthorName(scn.nextLine());
                System.out.println("Enter the number of copies you have: ");
                newBook.setNumberCopies(scn.nextInt());
                if (bookService.addBook(newBook))
                    System.out.println("Book added");
                else
                    System.out.println("Book with id " + newBook.getBookId() + " already exists in the system.");
            }
            case 4 -> {
                System.out.println("Thanks for using the book records system");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice!");
        }

    }

}
