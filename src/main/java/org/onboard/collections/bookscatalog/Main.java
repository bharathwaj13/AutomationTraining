package org.onboard.collections.bookscatalog;

/**
 *
 * In this task, you will simulate work with a book catalog. The catalog can be represented as the TreeMap collection, where the author is the key and the list of published books is the value. You have the following description:
 * The Author class, which consists of the first and last name
 * The Book class, which consists of the title, genre, and cost
 *
 * Since the book catalog is an ordered map, the Author and Book classes must implement the Comparable interface. The BooksCatalog class must have two constructors: a default one and one with a parameter that creates a map based on an existing map.
 * Please proceed to the Author and Book classes and provide implementations of the compareTo() method.
 * Please, proceed to the BooksCatalog class and provide implementations of the following methods:
 * List<Book> findByAuthor(Author author)
 * Returns a list of books by the specified author or null if there is no such author in the catalog
 * List<Author> findAuthorsByBook(Book book)
 * Returns a list of the authors of the specified book or null if there is no such book in the catalog
 * String getAllAuthors()
 * Returns a list of all the authors as a String
 * Set<Book> findBooksByGenre(String pattern)
 * Returns a set of books of the specified genre or null if there are no books of this genre
 * Map<Book, List<Author>> findAuthorsByBookTitle(String pattern)
 * Returns the book/author pair map. The search is carried out based on the words in the book's title
 *
 * Details
 * To order the map by author, apply alphabetical order by first name and, if the names match, alphabetical order by last name.
 * To order the map by book title, apply alphabetical order by title and, if the titles match, by ascending cost.
 * The findAuthorsByBookTitle method searches for books based on a word pattern; it is case-insensitive.
 * The findBooksByGenre method searches for books of a certain genre specified as a search pattern; the matching pattern and name of the genre are case-insensitive; all the books found are sorted using natural ordering.
 * You can use a regular expression to match occurrences of a pattern in a book title or genre in the findBooksByGenre and findAuthorsByBookTitle methods.
 * The getAllAuthors method returns an alphabetical list of authors as a String, where the authors' names are separated by '\n'.
 * No methods of the BooksCatalog class accept null, and they must throw a NullPointerException if they do.
 * You can use the getData() method in the Util class to create the initial map.
 * You can add any private methods to the BooksCatalog class.
 *
 * Restrictions
 * You may not use lambdas or streams when implementing this task.
 */

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

