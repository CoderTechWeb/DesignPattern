
# Design Patterns Overview

This project leverages a variety of design patterns to enhance flexibility, maintainability, and reusability in software design. The patterns are categorized into Creational, Structural, and Behavioral patterns.

## Creational Patterns

## Purpose: 
Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

## Focus: 
They focus on how objects are instantiated and composed to form larger structures.

## Examples:

1. **Singleton Pattern:**
   - Ensures a class has only one instance and provides a global point of access to it.
   
2. **Factory Method Pattern:**
   - Defines an interface for creating an object but leaves the choice of its type to the subclasses.
   
3. **Abstract Factory Pattern:**
   - Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

4. **Builder Pattern:**
   - Separates the construction of a complex object from its representation.
   
5. **Prototype Pattern:**
   - Creates new objects by copying an existing object, known as the prototype.

## Structural Patterns

### Purpose: 
Structural patterns deal with object composition, creating relationships between objects to form larger structures.

### Focus: 
They focus on simplifying the composition of classes and objects to create more flexible and reusable systems.

1. **Adapter Pattern:**
   - Allows the interface of an existing class to be used as another interface.

2. **Bridge Pattern:**
   - Separates an object’s abstraction from its implementation so that the two can vary independently.

3. **Composite Pattern:**
    - Composes objects into tree structures to represent part-whole hierarchies.

4. **Decorator Pattern:**
    - Attaches additional responsibilities to an object dynamically.

5. **Facade Pattern:**
    - Provides a simplified interface to a set of interfaces in a subsystem.

6. **Flyweight Pattern:**
    - Minimizes memory usage or computational expenses by sharing as much as possible with related objects.

## Behavioral Patterns

### Purpose: 
Behavioral patterns deal with the interaction and responsibilities of objects, defining patterns for how they collaborate and communicate.

### Focus: 
They focus on how objects interact and communicate with each other, encapsulating the patterns of communication between objects.

# Singleton Pattern

The Singleton Pattern is a design pattern that ensures a class has only one instance and provides a global point of access to that instance. It is particularly useful when exactly one object is needed to coordinate actions across the system.

### Shopping cart
 - If the ShoppingCart bean were configured as a singleton, a single instance of the ShoppingCart would be shared among all users of the application. This would lead to undesirable behavior in the context of a shopping cart, where each user should have their own isolated cart.

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

### Resource
 https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java]

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

# Prototype Pattern

The Prototype Design Pattern is a creational design pattern that involves creating new objects by copying an existing object, known as the prototype. This pattern is useful when the cost of creating a new object is more expensive than copying an existing one.

```Java

/**
 * Prototype Design Pattern Example
 */

// Step 1: Create a prototype interface
interface PersonPrototype {
    PersonPrototype clone();

    void customize(String name, int age);
    void display();
}

// Step 2: Implement concrete prototype class
class ConcretePerson implements PersonPrototype {
    private String name;
    private int age;

    public ConcretePerson() {
        // Default constructor
    }

    private ConcretePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public PersonPrototype clone() {
        return new ConcretePerson(this.name, this.age);
    }

    @Override
    public void customize(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Step 3: Client code
public class PrototypeExample {
    public static void main(String[] args) {
        // Create a prototype person
        PersonPrototype prototypePerson = new ConcretePerson();

        // Customize and clone
        PersonPrototype person1 = prototypePerson.clone();
        person1.customize("Alice", 30);

        // Customize and clone again
        PersonPrototype person2 = prototypePerson.clone();
        person2.customize("Bob", 25);

        // Display customized persons
        System.out.println("Person 1:");
        person1.display();

        System.out.println("\nPerson 2:");
        person2.display();
    }
}
```
# Prototype with Registry

## Overview
The Prototype Design Pattern involves creating new objects by copying an existing object, while the Prototype Registry centralizes the management of prototypes. This combination is useful when creating objects involves a costly or complex initialization process.

## Prototype Pattern:
The Prototype Pattern is a creational design pattern that involves creating new objects by copying an existing object, known as the prototype. Instead of using a constructor, objects are cloned to create new instances. This pattern is useful when the cost of creating a new object is more expensive than copying an existing one.

## Prototype Registry (or Prototype Manager) Pattern:
The Prototype Registry Pattern involves using a registry or manager to keep track of various prototypes. This registry provides a central place to store and retrieve prototype objects. Instead of creating and maintaining instances directly, clients can request instances from the registry.

# Factory Pattern:

The Factory Pattern provides an interface for creating objects in a super class but allows subclasses to alter the type of objects that will be created. It involves a single interface or abstract class with a method for creating objects, and multiple concrete classes that implement this interface to create different types of objects.

# Abstract Factory Pattern:

The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. It involves multiple interfaces or abstract classes (one for each type of object), each with multiple concrete implementations. The concrete factories produce families of related objects.

## When to use each

Factory Pattern is suitable for creating a single type of object, while the Abstract Factory Pattern is suitable for creating families of related objects with multiple variations. The choice between them depends on the complexity and structure of the objects you need to create in your application.

# Behavioral Patterns

## Observer Pattern

The Observer Pattern is a behavioral design pattern where an object, known as the subject, maintains a list of its dependents, called observers, that are notified of any state changes, typically by calling one of their methods.

This pattern is useful in scenarios where multiple objects need to be informed about changes in another object's state without coupling the sender to its recipients.

Read more: https://javarevisited.blogspot.com/2011/12/observer-design-pattern-java-example.html#ixzz8OFHalr9y

### Example
1. Company updates all its shareholders for any decision they make here Company is Subject and Shareholders are Observers, any change in the policy of company and the Company notifies all its Shareholders or Observer.

2. When interest rate of Loan is subject to change and when it changes, Loan notifies to Newspaper or Internet media to display a new loan interest rate.

## How it Works

### Components
1. **Subject:** The object that holds a list of observers and notifies them of state changes.

2. **Observer:** An interface or abstract class that defines the update method. Concrete observers implement this method to react to changes.

## Implementation Example

we have a Subject interface that contains methods for adding, removing and notifying Observers and an Observer interface which contains update(int interest) method which will be called by the Subject implementation when the interest rate changes.

1. **Define Subject Interface/Class:**
   - Create an interface or class that represents the subject. This should include methods for attaching, detaching, and notifying observers.

```Java
   public interface Subject {
      void registerObserver(Observer observer);
      void removeObserver(Observer observer);
      void notifyObserver();
   }
```

2. **Define Observer Interface/Class:**
   - Create an interface or class for observers. This should include the update method.

```Java
    public interface Observer {
        void update(float interest);
    }
```

3. **Implement Concrete Classes:**
   - Create concrete classes for the subject and observers.

```Java
    public class Loan implements  Subject{
      // Implementation of Subject methods
    }
    
    public class Newspaper implements Observer{
       // Implementation of Subject methods
    }
```

4. **Use Observer Pattern:**
   - In your application, instantiate the subject and observers, and demonstrate how changes in the subject trigger updates in the observers.

```Java
   public class ObserverTest {
   
       public static void main(String[] args) {
           Newspaper newspaper = new Newspaper();
           Internet internet = new Internet();
   
           Loan loan = new Loan("Personal Loan", 12.5f, "Standard Charterd");
           loan.registerObserver(newspaper);
           loan.registerObserver(internet);
           loan.setInterest(3.5f);
   
          loan.notifyObserver();
           System.out.println();
       }
   }
```

### Benefits
1. **Loose Coupling:** The subject and observers are decoupled, allowing for easier maintenance and extension of the system.

2. **Flexibility:** It supports a one-to-many dependency relationship between objects, enabling dynamic runtime changes.

## Strategy Pattern

The Strategy Design Pattern is a behavioral design pattern. It allows you to dynamically change the behavior of an object by encapsulating it into different strategies.

This pattern is particularly useful when there are multiple ways to perform a task, and the algorithm can vary independently from the client that uses it.

### Example

1. **Sorting algorithms:** Different sorting algorithms can be encapsulated into separate strategies and passed to an object that needs sorting.
2. **Database access:** Different database access strategies can be encapsulated into separate strategies and passed to an object that needs to access data from different sources.
3. **Payment strategy:** Different payment methods can be encapsulated into separate strategies and passed to an object that needs to process payments.
   - In a shopping cart application, the Strategy Design Pattern can be employed to neatly organize various payment methods, such as credit card, PayPal, and cryptocurrency, into distinct strategies. Each strategy encapsulates its own unique processing logic. This approach enables the application's payment processing system to delegate the payment handling tasks to the active payment method's strategy.

## Implementation Example

1. **PaymentStrategy Interface:** Declares a method for executing the payment strategy.
```Java
   public interface PaymentStrategy { 
        void processPayment(double amount);
   } 
```

2. **Concrete Payment Strategies:** Classes that implement the PaymentStrategy interface, providing specific payment implementations.

```Java
   public class CreditCardPayment implements PaymentStrategy {
      public void processPayment(double amount) {
      // Implementation of credit card payment
      }
   }

   public class PayPalPayment implements PaymentStrategy {
      public void processPayment(double amount) {
      // Implementation of PayPal payment
      }
   }
```

3. **PaymentContext Class:** Contains a reference to the PaymentStrategy interface and provides a method to execute the payment strategy.

```Java
   public class PaymentContext {
       private PaymentStrategy paymentStrategy;
   
       public PaymentContext(PaymentStrategy paymentStrategy) {
           this.paymentStrategy = paymentStrategy;
       }
   
       public void processPayment(double amount) {
           paymentStrategy.processPayment(amount);
       }
   }
```

4. **Choose a Payment Strategy:** Instantiate the PaymentContext with a specific payment strategy (e.g., CreditCardPayment or PayPalPayment).

```Java
    PaymentContext creditCardContext = new PaymentContext(new CreditCardPaymentStrategy());
    PaymentProcessor payPalPaymentProcessor = new PaymentProcessor(new PayPalPayment());

```

5. **Process Payment:** Use the processPayment method to execute the chosen payment strategy.

```java
    public class Main {
        public static void main(String[] args) {
            PaymentProcessor debitPaymentProcessor = new PaymentProcessor(new DebitCardPaymentStrategy());
            debitPaymentProcessor.processPayment(100);
         
            PaymentProcessor paypalPaymentProcessor = new PaymentProcessor(new PaypalPaymentStrategy());
            paypalPaymentProcessor.processPayment(500);
        }
   }
```

### Benefits
**Flexibility:** Easily switch between different payment strategies at runtime.
**Maintainability:** Payment strategies are encapsulated in separate classes, making the code easier to maintain and extend.
**Scalability:** Adding new payment strategies is straightforward without modifying existing code.

# Structural Pattern

## Decorator Design Pattern

A Decorator pattern can be used to attach additional responsibilities to an object either statically or dynamically. A Decorator provides an enhanced interface to the original object.

This pattern is useful when you need to extend the functionalities of objects in a flexible and reusable way, without modifying their code.

### Example

Building a software system for a trendy coffee shop that offers a wide variety of beverages. These beverages could include traditional choices like Coffee and Tea, each with its unique flavor and pricing.

Now, to cater to the diverse preferences of customers, your system employs the Decorator Design Pattern. This pattern is particularly beneficial because it allows for dynamic and flexible customization of beverages without modifying their core implementation.

### Implementation Steps
1. **Component Interface/Class(Beverage):** Create an interface or class that declares the methods to be implemented by concrete components.

```Java
    public interface Beverage {
        String getDescription();
        double cost();
    }
```

2. **Implement ConcreteComponent(Coffee, Tea):** Create a class that implements the Component interface, providing the base behavior.

```Java
   public class Coffee implements Beverage {
      public String getDescription() {
         return "Coffee";
      }
   
      public double cost() {
         return 2.0;
      }
   }
   
   public class Tea implements Beverage {
      public String getDescription() {
         return "Tea";
      }
   
      public double cost() {
         return 1.5;
      }
   }
```

3. **Create Decorator Class(CondimentDecorator):** Define an abstract class that implements the Component interface and holds a reference to a Component.

```Java
   public abstract class CondimentDecorator implements Beverage {
      protected Beverage beverage;
   
      public CondimentDecorator(Beverage beverage) {
         this.beverage = beverage;
      }
   
      public String getDescription() {
         return beverage.getDescription();
      }
   
      public double cost() {
         return beverage.cost();
      }
   }
```

4. **Implement ConcreteDecorator (Milk, Sugar):** Create concrete decorator classes by extending the Decorator class and adding specific responsibilities.

```Java
   public class Milk extends CondimentDecorator {
      public Milk(Beverage beverage) {
         super(beverage);
      }
   
      public String getDescription() {
         return super.getDescription() + ", Milk";
      }
   
      public double cost() {
         return super.cost() + 0.5;
      }
   }
   
   public class Sugar extends CondimentDecorator {
      public Sugar(Beverage beverage) {
         super(beverage);
      }
   
      public String getDescription() {
         return super.getDescription() + ", Sugar";
      }
   
      public double cost() {
         return super.cost() + 0.3;
      }
   }

```

5. **Use Decorator Pattern:** In your application, create instances of concrete components and decorate them with different decorators as needed.

```Java
    Beverage coffee = new Coffee();
    System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());
    
    Beverage tea = new Tea();
    System.out.println(tea.getDescription() + " Cost: $" + tea.cost());

    // Decorate Coffee with Milk and Sugar
    Beverage milkCoffee = new Milk(new Sugar(new Coffee()));
    System.out.println(milkCoffee.getDescription() + " Cost: $" + milkCoffee.cost());

    // Decorate Tea with Milk
    Beverage milkTea = new Milk(new Tea());
    System.out.println(milkTea.getDescription() + " Cost: $" + milkTea.cost());
```

### Benefits
**Flexibility:** Allows adding or altering object behavior dynamically.
**Reusable Components:** Decorators can be reused and combined in various ways.
**Open/Closed Principle:** Follows the open/closed principle, allowing for extension without modifying existing code.