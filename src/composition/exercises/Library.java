package composition.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 1. Create class Book with title and author.
 2. Create class Library that HAS-A List<Book>.
 3. Add methods addBook(), listBooks().
 4. In main(), add multiple books and print them.
*/

class Library
{
    private final Map<String, Book> bookCollection;

    public Library(){
        this.bookCollection = new HashMap<>();
    }
    public void addBook(String title, String author){
        this.bookCollection.put(title, new Book(title, author));
        System.out.println(title + " has been added to the library.");
    }
    public void  listBooks() {
        for(Book book:this.bookCollection.values()){
            System.out.println(book.printDetail());
        }
    }
}

class Book{
    String title;
    String author;

    public Book(){
        this("unknown","unknown");
    }
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
    public String printDetail(){
        return this.title + " | Author: " + this.author ;
    }
}
