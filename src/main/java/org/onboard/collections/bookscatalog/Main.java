package org.onboard.collections.bookscatalog;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author("Ravi", "Ashwin");
        Author author2 = new Author("Bharath", "A");


        Book book1 = new Book("I have the Streets", "Sports", 29.99);
        Book book2 = new Book("Advanced Java", "Education", 39.99);
        Book book3 = new Book("Learning Python", "Education", 24.99);


        BooksCatalog catalog = new BooksCatalog();


        catalog.addBook(author1, book1);
        catalog.addBook(author1, book2);
        catalog.addBook(author2, book3);


        System.out.println(catalog.getAllAuthors());
        System.out.println(catalog.findBooksByGenre("Education"));
    }
}

