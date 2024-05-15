package io.ya;

import io.ya.model.Book;
import io.ya.model.Catalog;
import io.ya.model.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class LibraryAppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LibraryAppTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LibraryAppTest.class );
    }


    public void testQuantityOfBook(){
        Catalog catalog = new Catalog();
        Book book1 = new Book(1,"Dos Santos","The Einstein Enigma",1);
        catalog.add(book1);

        User user1 = new User(1,"Youssef","Abbadi");
        user1.borrow(catalog, book1);
        //the quantity of book1 after the user borrow the book should be 0
        assertEquals(0,book1.getQuantity());
    }


}
