package org.onboard.collections.bookscatalog;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author implements Comparable<Author> {

    private String firstName;
    private String lastName;


    @Override
    public int compareTo(Author o) {
        if (this.firstName.compareTo(o.firstName) != 0) return this.firstName.compareTo(o.firstName);
        return this.lastName.compareTo(o.lastName);
    }
}
