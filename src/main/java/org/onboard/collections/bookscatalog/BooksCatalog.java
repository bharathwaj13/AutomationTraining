package org.onboard.collections.bookscatalog;

import java.util.*;

public class BooksCatalog {

    private Map<Author, List<Book>> catalog;

    public BooksCatalog() {
        catalog = new TreeMap<>();
    }

    public BooksCatalog(Map<Author, List<Book>> existingCatalog) {
        if (existingCatalog == null) {
            throw new NullPointerException("Existing catalog cannot be null");
        }
        this.catalog = new TreeMap<>(existingCatalog);
    }

    public List<Book> findByAuthor(Author author) {
        return catalog.getOrDefault(author, null);
    }

    public List<Author> findAuthorsByBook(Book book) {
        List<Author> authorsList = new ArrayList<>();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            if (entry.getValue().contains(book)) {
                authorsList.add(entry.getKey());
            }
        }
        return authorsList.isEmpty() ? null : authorsList;
    }

    public String getAllAuthors() {
        StringBuilder sb = new StringBuilder();
        for (Author author : catalog.keySet()) {
            sb.append(author).append("\n");
        }
        return sb.toString();
    }

    public Set<Book> findBooksByGenre(String pattern) {
        if (pattern == null) {
            throw new NullPointerException("Pattern cannot be null");
        }
        Set<Book> books = new TreeSet<>();
        for (List<Book> booksByAuthor : catalog.values()) {
            for (Book book : booksByAuthor) {
                if (book.getGenre().toLowerCase().contains(pattern.toLowerCase())) {
                    books.add(book);
                }
            }
        }
        return books.isEmpty() ? null : books;
    }

    public Map<Book, List<Author>> findAuthorsByBookTitle(String pattern) {
        if (pattern == null) {
            throw new NullPointerException("Pattern cannot be null");
        }
        Map<Book, List<Author>> result = new TreeMap<>();
        pattern = pattern.toLowerCase();
        for (Map.Entry<Author, List<Book>> entry : catalog.entrySet()) {
            for (Book book : entry.getValue()) {
                if (book.getTitle().toLowerCase().contains(pattern)) {
                    result.computeIfAbsent(book, k -> new ArrayList<>()).add(entry.getKey());
                }
            }
        }
        return result.isEmpty() ? null : result;
    }

    public void addBook(Author author, Book book) {
        List<Book> bookList = catalog.get(author);
        if (bookList == null) {
            bookList = new ArrayList<>();
        }
        bookList.add(book);
        catalog.put(author, bookList);
    }
}
