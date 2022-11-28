package com.amal.Client;

import com.amal.Presentation.BookPresentation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public interface BookClient {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(BookConfig.class);

        BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("bookPresentation");
        while(true) {
            bookPresentation.showMenu();
            System.out.println("Enter choice: ");
            int choice = scn.nextInt();
            bookPresentation.performMenu(choice);

        }

    }
}
