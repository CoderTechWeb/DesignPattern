# Solid Principle

## Single Responsibility

The Single Responsibility Principle (SRP) is one of the SOLID principles of object-oriented programming. It states that a class should have only one reason to change, meaning that it should only have one responsibility.

### Example

Suppose we have a Report class that is responsible for generating reports and sending notifications. This violates the SRP because it has two responsibilities.

```Java
   public class Report {
       public void generateReport() {
           // Code to generate a report
       }
   
       public void sendNotification() {
           // Code to send a notification
       }
   }
```
To adhere to the Single Responsibility Principle, we can split this class into two separate classes, each with a single responsibility.

```Java
      // Class responsible for generating reports
   public class ReportGenerator {
      public void generateReport() {
         // Code to generate a report
      }
   }
   
   // Class responsible for sending notifications
   public class NotificationSender {
      public void sendNotification() {
         // Code to send a notification
      }
   }
```

Now, each class has a single responsibility – one for generating reports and the other for sending notifications. This makes the code more modular, maintainable, and easier to understand. If there are changes in the report generation logic, it won't affect the notification sending, and vice versa.

## Open-Closed Principle

The Open/Closed Principle (OCP) is one of the SOLID principles, and it states that a class should be open for extension but closed for modification. In other words, you should be able to add new functionality to a system without altering existing code.

### Example

System that calculates the total cost of different shapes. 
Initially, we have a class that calculates the total cost directly, violating the Open/Closed Principle.

```Java
   public class TotalCostCalculator {
       public double calculateTotalCost(Shape[] shapes) {
           double totalCost = 0;
           for (Shape shape : shapes) {
               if (shape.getType().equals("Circle")) {
                   totalCost += calculateCircleCost(shape);
               } else if (shape.getType().equals("Rectangle")) {
                   totalCost += calculateRectangleCost(shape);
               }
               // Add more conditions for other shapes
           }
           return totalCost;
       }
   
       private double calculateCircleCost(Shape shape) {
           // Calculation for circle cost
           return 0;
       }
   
       private double calculateRectangleCost(Shape shape) {
           // Calculation for rectangle cost
           return 0;
       }
   }
```
This implementation violates the Open/Closed Principle because if we want to add a new shape (e.g., a triangle), we have to modify the TotalCostCalculator class.

To adhere to the Open/Closed Principle, we can introduce an abstract class (Shape) and use polymorphism to allow for extension without modification:

```Java
   public abstract class Shape {
       public abstract double calculateCost();
   }
   
   public class Circle extends Shape {
       private double radius;
   
       // Constructor and other methods for Circle
   
       @Override
       public double calculateCost() {
           // Calculation for circle cost
           return 0;
       }
   }
   
   public class Rectangle extends Shape {
       private double length;
       private double width;
   
       // Constructor and other methods for Rectangle
   
       @Override
       public double calculateCost() {
           // Calculation for rectangle cost
           return 0;
       }
   }
   
   public class TotalCostCalculator {
       public double calculateTotalCost(Shape[] shapes) {
           double totalCost = 0;
           for (Shape shape : shapes) {
               totalCost += shape.calculateCost();
           }
           return totalCost;
       }
   }
```
Now, the Shape class is open for extension because you can easily add new shapes (e.g., a Triangle class) without modifying the existing TotalCostCalculator class. Each new shape extends the abstract Shape class and provides its own implementation of the calculateCost method. This adheres to the Open/Closed Principle and makes the system more flexible and maintainable.

## Liskov substitution principle.

The Liskov Substitution Principle (LSP) is one of the SOLID principles, and it states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. In other words, a subclass should behave in such a way that it can be used interchangeably with its superclass.

### Example
Bird superclass and two subclasses, Sparrow and Ostrich. 
Initially, the fly method is present in the superclass, but the Ostrich subclass cannot fly, violating the Liskov Substitution Principle.

```Java
public class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }

   public void eat() {
      System.out.println("Bird is eating");
   }
}

public class Sparrow extends Bird {
    // Sparrow inherits the fly method from Bird
}

public class Ostrich extends Bird {
    @Override
    public void fly() {
        // Ostrich cannot fly, so override and do nothing
    }
}
```

This violates the Liskov Substitution Principle because code that expects a Bird to fly might break when an Ostrich is substituted.

To adhere to the Liskov Substitution Principle, we should reconsider the class hierarchy. One approach is to create an interface for flying birds:

```Java
public class Bird {
   public void eat() {
      System.out.println("I can eat.");
   }
}

public class FlyingBird extends Bird {
   public void fly() {
      System.out.println("I can fly.");
   }
}
public class Sparrow extends FlyingBird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

   @Override
   public void eat() {
      System.out.println("Sparrow is eating");
   }
}

public class Ostrich extends Bird {
    @Override
    void eat() {
        System.out.println("Can I eat taco?");
    }
}
```
Now, let's demonstrate how objects of a subclass can replace objects of the superclass without affecting the correctness of the program:
In this revised example, the Ostrich class does not implement the FlyingBird interface, and it doesn't include the fly method. Now, when using objects of FlyingBird, we can be confident that all implementing classes can actually fly, adhering to the Liskov Substitution Principle.

```Java
public class LSPExample {
    static void birdInAction(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        // Using an object of the superclass
        Bird genericBird = new Bird();
        birdInAction(genericBird);  // Output: "I can fly"

        // Using an object of the subclass (LSP in action)
        Sparrow sparrow = new Sparrow();
        birdInAction(sparrow);  // Output: "I can fly"
    }
}
```
In this example, the birdInAction method takes an object of the Bird class as a parameter. According to LSP, we should be able to substitute an object of any subclass of Bird without affecting the correctness of the program.

When we pass an instance of Sparrow to birdInAction, it works correctly because Sparrow is a subclass of Bird and inherits the fly() method. The behavior of the program is consistent, and substituting Sparrow for Bird does not break anything.

## Interface segregation principle.

The Interface Segregation Principle (ISP) is one of the SOLID principles, and it states that a class should not be forced to implement interfaces it does not use. In other words, a class should not be burdened with the responsibility of implementing methods it doesn't need.

### Example
Let consider Document management system where documents can be printed and scanned. Initially, we might design an interface that includes both print and scan methods:

```Java
// Interface with print and scan methods
interface Machine {
   void print(Document document);

   void scan(Document document);
}

// Concrete class implementing the Machine interface
class MultiFunctionPrinter implements Machine {
   @Override
   public void print(Document document) {
      // Implementation for printing
   }

   @Override
   public void scan(Document document) {
      // Implementation for scanning
   }
}

// Document class representing a document
class SimplePrinter  implements Machine {
   @Override
   public void print(Document document) {
      // Implementation for printing
   }

   @Override
   public void scan(Document document) {
      // Not valid method as this machine only print and dont scan
   }
}
```
Here's a revised example that adheres to the Interface Segregation Principle:

```Java
// Separate interfaces for print and scan functionality
interface Printer {
    void print(Document document);
}

interface Scanner {
    void scan(Document document);
}

// Concrete classes implementing specific interfaces
class SimplePrinter implements Printer {
    @Override
    public void print(Document document) {
        // Implementation for printing
    }
}

class MultiFunctionMachine implements Printer, Scanner {
    @Override
    public void print(Document document) {
        // Implementation for printing
    }

    @Override
    public void scan(Document document) {
        // Implementation for scanning
    }
}
```

Now, the Printer and Scanner interfaces are separate, allowing classes to implement only the functionality they need. The SimplePrinter class implements only the Printer interface, and the MultiFunctionMachine class implements both the Printer and Scanner interfaces. This adheres to the Interface Segregation Principle, ensuring that classes are not burdened with unnecessary methods.

## Dependency injection
Dependency Injection (DI) is a design pattern and a technique in software development where the dependencies of a class, rather than being created within the class itself, are provided (injected) from the outside. In other words, instead of a class creating its own dependencies, those dependencies are supplied externally, typically through constructor parameters, method parameters, or property setters.

In simpler terms, Dependency Injection is a way of achieving inversion of control, where the control over the creation and management of objects is shifted from the class itself to an external entity, often a framework or a container.

### Example
Simple blogging application where we have a BlogService class that depends on a NotificationService for sending notifications.

```Java
// NotificationService interface
public interface NotificationService {
    void sendNotification(String message);
}

// EmailNotificationService implementation of NotificationService
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Implementation for sending email notifications
        System.out.println("Sending email notification: " + message);
    }
}

// BlogService class with dependency injection
public class BlogService {
    private final NotificationService notificationService;

    // Constructor injection for providing the NotificationService dependency
    public BlogService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Method in BlogService that uses the injected NotificationService
    public void publishPost(String postTitle) {
        // Logic to publish a blog post
        // Notify subscribers using the injected NotificationService
        notificationService.sendNotification("New blog post published: " + postTitle);
    }
}

// Application class where DI is used to create objects and wire dependencies
public class BlogApp {
    public static void main(String[] args) {
        // Create an instance of EmailNotificationService
        NotificationService emailNotificationService = new EmailNotificationService();

        // Inject the EmailNotificationService into the BlogService
        BlogService blogService = new BlogService(emailNotificationService);

        // Use the BlogService to publish a post
        blogService.publishPost("Dependency Injection in Action");
    }
}
```
By using Dependency Injection, the BlogService class is not tightly coupled to a specific implementation of NotificationService. This makes it easier to switch to a different notification service implementation (e.g., SMS notification service) without modifying the BlogService class. It also makes testing easier, as we can inject mock implementations for testing purposes.

# Design Patterns 

## Creational Patterns

### Purpose: 
Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

### Focus: 
They focus on how objects are instantiated and composed to form larger structures.
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
1. **Observer Pattern**
2. **Strategy Pattern**

# Singleton Pattern

The Singleton Pattern is a design pattern that ensures a class has only one instance and provides a global point of access to that instance. It is particularly useful when exactly one object is needed to coordinate actions across the system.

### Overview

The pattern allows us to create a class for which only one object can be created, providing a global point of access to that instance throughout the application.

#### Example
- If the ShoppingCart bean were configured as a singleton, a single instance of the ShoppingCart would be shared among all users of the application. This would lead to undesirable behavior in the context of a shopping cart, where each user should have their own isolated cart.

## Advantages

1. **Avoid Memory Overhead:**
   - By restricting the instantiation of a class to a single instance, the Singleton Pattern helps avoid unnecessary memory overhead associated with multiple instances.

2. **Maintain Consistency in Data:**
   - Ensures that there is a single source of truth, maintaining consistency in the data managed by the singleton instance.

### Common Use Cases

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
### Overview
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

### Why Use the Builder Design Pattern?
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

### Overview
The Prototype Design Pattern involves creating new objects by copying an existing object, while the Prototype Registry centralizes the management of prototypes. This combination is useful when creating objects involves a costly or complex initialization process.

### Prototype Pattern:
The Prototype Pattern is a creational design pattern that involves creating new objects by copying an existing object, known as the prototype. Instead of using a constructor, objects are cloned to create new instances. This pattern is useful when the cost of creating a new object is more expensive than copying an existing one.

### Prototype Registry (or Prototype Manager) Pattern:
The Prototype Registry Pattern involves using a registry or manager to keep track of various prototypes. This registry provides a central place to store and retrieve prototype objects. Instead of creating and maintaining instances directly, clients can request instances from the registry.

```Java
    public class ShapeRegistry {
        private final Map<String, Shape> shapeMap;

        public ShapeRegistry() {
            shapeMap = new HashMap<>();
            shapeMap.put("circle", new Circle());
            shapeMap.put("Square", new Square());
        }

        public void addShape(String key, Shape shape) {
            shapeMap.put(key, shape);
        }

        public Shape getShape(String key) {
            Shape shape = shapeMap.get(key);
            if (shape != null)
                return shape.clone();
            return null;
        }
    }

    //main class
    public static void main(String[] args) {
        ShapeRegistry shapeRegistry = new ShapeRegistry();

        Shape circle = shapeRegistry.getShape("circle");
        circle.draw();

        Shape square = shapeRegistry.getShape("Square");
        square.draw();

        shapeRegistry.addShape("triangle", new Triangle());
        Shape triangle = shapeRegistry.getShape("triangle");
        if (triangle != null) triangle.draw();
    }
```

## Factory Pattern:

The Factory Pattern provides an interface for creating objects in a super class but allows subclasses to alter the type of objects that will be created. It involves a single interface or abstract class with a method for creating objects, and multiple concrete classes that implement this interface to create different types of objects.

## Abstract Factory Pattern:

The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. It involves multiple interfaces or abstract classes (one for each type of object), each with multiple concrete implementations. The concrete factories produce families of related objects.

### When to use each

Factory Pattern is suitable for creating a single type of object, while the Abstract Factory Pattern is suitable for creating families of related objects with multiple variations. The choice between them depends on the complexity and structure of the objects you need to create in your application.

# Behavioral Patterns

# Observer Pattern

The Observer Pattern is a behavioral design pattern where an object, known as the subject, maintains a list of its dependents, called observers, that are notified of any state changes, typically by calling one of their methods.

This pattern is useful in scenarios where multiple objects need to be informed about changes in another object's state without coupling the sender to its recipients.

Read more: https://javarevisited.blogspot.com/2011/12/observer-design-pattern-java-example.html#ixzz8OFHalr9y

### Example
1. Company updates all its shareholders for any decision they make here Company is Subject and Shareholders are Observers, any change in the policy of company and the Company notifies all its Shareholders or Observer.

2. When interest rate of Loan is subject to change and when it changes, Loan notifies to Newspaper or Internet media to display a new loan interest rate.

### How it Works

### Components
1. **Subject:** The object that holds a list of observers and notifies them of state changes.

2. **Observer:** An interface or abstract class that defines the update method. Concrete observers implement this method to react to changes.

### Implementation Example

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

# Strategy Pattern

The Strategy Design Pattern is a behavioral design pattern. It allows you to dynamically change the behavior of an object by encapsulating it into different strategies.

This pattern is particularly useful when there are multiple ways to perform a task, and the algorithm can vary independently from the client that uses it.

### Example

1. **Sorting algorithms:** Different sorting algorithms can be encapsulated into separate strategies and passed to an object that needs sorting.
2. **Database access:** Different database access strategies can be encapsulated into separate strategies and passed to an object that needs to access data from different sources.
3. **Payment strategy:** Different payment methods can be encapsulated into separate strategies and passed to an object that needs to process payments.
   - In a shopping cart application, the Strategy Design Pattern can be employed to neatly organize various payment methods, such as credit card, PayPal, and cryptocurrency, into distinct strategies. Each strategy encapsulates its own unique processing logic. This approach enables the application's payment processing system to delegate the payment handling tasks to the active payment method's strategy.

### Implementation Example

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

# Decorator Design Pattern

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

- **Flexibility:** Allows adding or altering object behavior dynamically.
- **Reusable Components:** Decorators can be reused and combined in various ways.
- **Open/Closed Principle:** Follows the open/closed principle, allowing for extension without modifying existing code.

## Facade Pattern

The Facade Design Pattern is a structural pattern that provides a simplified interface to a set of interfaces in a subsystem, making it easier to use and reducing the complexity of interacting with the subsystem. It involves creating a unified interface that wraps multiple interfaces in a subsystem to make them more accessible.

### Example

Subsystems for a television and a sound system, and we'll create a HomeTheaterFacade to simplify the control of these subsystems.

src/main/java/org/design/structural/facade/hometheater/Main.java

## FlyWeight Pattern

FlyWeight pattern is used to reduce the memory footprint. It can also improve performance in applications where object instantiation is expensive.

Simply put, the flyweight pattern is based on a factory which recycles created objects by storing them after creation. Each time an object is requested, the factory looks up the object in order to check if it’s already been created. If it has, the existing object is returned – otherwise, a new one is created, stored and then returned.

### Example

In the context of a Counter-Strike game, the Flyweight Factory Pattern can be applied to optimize the creation of multiple terrorist and counter-terrorist players with similar behaviors. Specifically, terrorists share common characteristics related to placing bombs, and counter-terrorists share common characteristics related to defusing bombs.

The Flyweight Factory can efficiently manage and create instances of terrorist and counter-terrorist players, reusing shared behaviors where possible. This helps minimize memory usage and enhances the game's performance by avoiding redundant object creation.

### In this scenario:

- The shared behavior for terrorists involves placing a bomb.
- The shared behavior for counter-terrorists involves defusing a bomb.

The Flyweight Factory ensures that instances of terrorist and counter-terrorist players are created and reused appropriately, optimizing the game's resource utilization while accommodating unique characteristics for individual players when necessary.
