package io.ya.model;

import lombok.Getter;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;


@Getter
@Log
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Book> bookBorrowed;

    public User(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookBorrowed= new ArrayList<>();
    }


    public boolean borrow(Catalog catalog,Book book)  {
        int index = catalog.indexOf(book);
        //book is present in the catalog
        if(index>=0){
            int quantity = catalog.get(catalog.indexOf(book)).getQuantity();
            // the book is available in the catalog
            if (quantity > 0) {
                catalog.get(index).setQuantity(quantity - 1);
                return bookBorrowed.add(book);
            } else {
                log.info("Book isn't available for the moment");
                return false;
            }
        }
        else {
            log.info("Book not in the catalog");
            return false;
        }
    }

    public boolean returnBook(Catalog catalog, Book book){
        if(this.bookBorrowed.contains(book)){
            //remove book from borrowed book
            bookBorrowed.remove(book);
            //return the book to the catalog
            return catalog.add(book);
        }
        else{
            log.info("the book that you want to return isn't from this catalog !");
            return false;
        }

    }
    public void printBorrowedBook(){
        log.info("the books Borrowed are : ");
        bookBorrowed.stream().forEach(x->log.info("Author : " + x.getAuthor() +" - Title: "+ x.getTitle()));

    }

}
