package io.ya.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    private String author;
    private String title;
    private int quantity;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.quantity =1;

    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Book)) {
            return false;
        }

        Book book = (Book) obj;
        return this.getAuthor().equals(book.getAuthor())
                && this.getTitle().equals(book.getTitle());
    }

}
