package io.ya;


import io.ya.model.Book;
import io.ya.model.Catalog;
import io.ya.model.User;
import lombok.extern.java.Log;

@Log
public class LibraryApp
{
    public static void main( String[] args )
    {



        // create catalog with 3 books
        Catalog catalog = new Catalog();
        Book book1 = new Book(1,"Dos Santos","The Einstein Enigma",1);
        Book book2 = new Book(2,"Victor Hugo","les miserables",2);
        Book book3 = new Book(3,"Paulo Coelho","The Alchemist",3);
        catalog.add(book1);
        catalog.add(book2);
        catalog.add(book3);

        //create User
        User user1 = new User(1,"Youssef","Abbadi");

        log.info("all books " +catalog);


        // borrow first book
        user1.printBorrowedBook();
        user1.borrow(catalog, book1);
        user1.borrow(catalog, book2);
        user1.borrow(catalog, book3);
        log.info(" catalog should have -----" +catalog);

        // return book
        user1.printBorrowedBook();
        user1.returnBook(catalog,book1);

        // print borrowed books
        user1.printBorrowedBook();


        log.info("not in catalog");
        Book bookNotInCatalog = new Book(1,"noAuthor","noTitle");
        user1.borrow(catalog, bookNotInCatalog);





    }
}
