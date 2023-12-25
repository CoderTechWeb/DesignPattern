package org.design.builder;

import java.time.Year;

public class BuilderMain {

    public static void main(String[] args) {

        Book.Builder bookBuilder = new Book.Builder("10. 939016626", "The Psychology Of Money")
                .author("Morgan Housel")
                .published(Year.of(2020))
                .description(
                        "Doing well with money isn't necessarily about what you know. " +
                                "It's about how you behave"
                );

        // Create a first Book object
        Book book = bookBuilder.build();

        System.out.println(book);

        // Create a second, slightly different, object reusing the same
        // Builder instance
        book = bookBuilder.published(Year.of(1952)).build();

        System.out.println(book);

    }
}
