package org.onboard.collections.bookscatalog;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book implements Comparable<Book> {

    private String title;
    private String genre;
    private double cost;

    @Override
    public int compareTo(Book o) {
        if (this.title.compareTo(o.title) != 0) return this.title.compareTo(o.title);
        return Double.compare(this.cost, o.cost);
    }
}
