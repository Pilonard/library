package io.ya.model;

import lombok.extern.java.Log;
import java.util.ArrayList;


@Log
public class Catalog extends ArrayList<Book> {

    @Override
    public boolean add(Book book) {
        int index = indexOf(book);
        if (index>=0) {
            Book returnedBook = this.get(index);
            int quantity = returnedBook.getQuantity();
            returnedBook.setQuantity(quantity + 1);
            return true;
        }
        else {
            return super.add(book);
        }
    }

}
