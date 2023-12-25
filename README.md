
# Design Patterns Overview

This project leverages a variety of design patterns to enhance flexibility, maintainability, and reusability in software design. The patterns are categorized into Creational, Structural, and Behavioral patterns.

## Creational Patterns

### Singleton Pattern

Ensures a class has only one instance and provides a global point of access to it.

### Factory Method Pattern

Defines an interface for creating an object, allowing subclasses to alter the type of objects that will be created.

### Abstract Factory Pattern

Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

### Builder Pattern

Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

### Prototype Pattern

Creates new objects by copying an existing object, known as the prototype.

## Structural Patterns

### Adapter Pattern

Allows the interface of an existing class to be used as another interface.

### Decorator Pattern

Attaches additional responsibilities to an object dynamically, providing a flexible alternative to subclassing.

### Proxy Pattern

Provides a surrogate or placeholder for another object to control access to it.

### Composite Pattern

Composes objects into tree structures to represent part-whole hierarchies.

### Facade Pattern

Provides a simplified interface to a set of interfaces in a subsystem, making it easier to use.

## Behavioral Patterns

### Observer Pattern

Defines a one-to-many dependency between objects, where changes in one object result in the automatic notification of others.

### Strategy Pattern

Defines a family of algorithms, encapsulates each one, and makes them interchangeable.

### Command Pattern

Encapsulates a request as an object, allowing for parameterization of clients with different requests.

### Chain of Responsibility Pattern

Passes requests along a chain of handlers, allowing each handler to decide either to process the request or to pass it to the next handler in the chain.

### State Pattern

Allows an object to alter its behavior when its internal state changes.

These patterns contribute to a well-organized and efficient design, offering solutions to common design problems and fostering best practices in software development. Feel free to explore and contribute to the project!

# Singleton Pattern

The Singleton Pattern is a design pattern that ensures a class has only one instance and provides a global point of access to that instance. It is particularly useful when exactly one object is needed to coordinate actions across the system.

## Overview

The pattern allows us to create a class for which only one object can be created, providing a global point of access to that instance throughout the application.

## Advantages

1. **Avoid Memory Overhead:**
   - By restricting the instantiation of a class to a single instance, the Singleton Pattern helps avoid unnecessary memory overhead associated with multiple instances.

2. **Maintain Consistency in Data:**
   - Ensures that there is a single source of truth, maintaining consistency in the data managed by the singleton instance.

## Common Use Cases

1. **Database Connection:**
   - In scenarios where establishing a database connection is resource-intensive, a singleton pattern can be used to ensure that only one connection is created and reused throughout the application.

2. **Logger:**
   - Logging is a common use case for the Singleton Pattern. A single logging instance can centralize log entries and control logging behavior.

3. **Configuration Manager:**
   - Managing configuration settings in a centralized manner, ensuring that configuration data is consistent across the application.

## Implementation Example

Here is a simple example of a thread-safe Singleton implementation in Java:

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation.
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

# Builder Design Pattern
## Overview
The Builder pattern provides a simple and safe way to build objects that have many optional parameters, addressing the telescoping constructor problem.

When we have too many parameter setting constructors for each field or a combination of many fields is cumbersome, leading to code complexity like below, which is called the telescoping constructor solution. This is not suitable

```java
public Book(String isbn, String title) {
        this(isbn, title, null);
    }

    public Book(String isbn, String title) {
        this(isbn, title, genre, null);
    }

    public Book(String isbn, String title, String author) {
        this(isbn, title, genre, author, null);
    }

    public Book(String isbn, String title, String author, Year published) {
        this(isbn, title, genre, author, published, null);
    }

    public Book(String isbn, String title, String author, Year published, String description) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.published = published;
        this.description = description;
    }
```

## Why Use the Builder Design Pattern?
1. **Flexible Object Construction:**
   - The pattern allows the construction of a complex object to be done step by step, enabling the creation of different representations of the same object.

2. **Clear Separation of Concerns:**
   - Separates the construction process from the actual representation, promoting a clear division of responsibilities between the director, builder, and product.

3. **Easier Maintenance and Extensibility:**
   - Makes it easier to introduce new variants of a product or make changes to the existing construction process without affecting the client code.

4. **Avoids Telescoping Constructors:**
   - Provides a more readable and maintainable alternative to telescoping constructors when dealing with a large number of optional parameters.
