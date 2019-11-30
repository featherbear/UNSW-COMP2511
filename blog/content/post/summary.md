---
title: "Summary"
date: 2019-11-30T22:04:30+11:00

description: "The pre-exam TL;DR of the course"
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams: 
  enable: false
  options: ""

---

**Disclaimer: This is not a Java course**  
But that said, we will give you Java-specific implementations that we expect you to know.

# Course Summary

## About Java

[[See more here](../java-introduction)]

Java is programming language centred around the Object-Oriented paradigm. Compared to other languages, there is automatic garbage collection, and is multi-threaded by design.  
Java source files (`.java`) are compiled into Java byte-code (`.javac`) files, where the Java Runtime Environment (JRE) will execute the byte-code in near-native speeds.

### Language

[[See more here](../language-basics)]

* Everything is a class
* Packages contain related classes
  * Packages are just folders
* Java entry-points are a `public static void main(String[] args) {...}`

#### The Object.equals(...) method

[[See more here](../object.equals)]

#### The Object.toString() method

[[See more here](../object.toString)]

## Objected-Oriented Design

[[See more here](../java-classes)]

### Constructors

* No-type functions that are executed as soon as an object is instantiated
* Often used to initialise variables

### Abstraction

* Used to ensure that sub-classes implement all of the required methods
* Abstract classes cannot be instantiated
* Defines a template that sub-classes can inherit and implement
* Sub-classes can be referred/grouped by the parent abstract class

### Encapsulation

* Privatisation of the attributes within a class
* Public getter and setter methods to access the private attributes
* Removes the chance of the state in a class being set to an invalid value

### Inheritance

* Sub-class "inherits" / adopts all of the attributes of its parent class
* Can only inherit one parent class
* Inheritance through the `extends` keyword.
  * `class child extends parent { ... }`
* Requires `super()` in the constructor of the child class

### Interfaces

[[See more here](../interfaces)]

* Like an abstract class, but only methods are defined
  * aka no attributes!
* Classes can `implement` multiple interfaces
* Preferred over inheritance

## Method Forwarding

A method called on a given object will call another method from a different object composed within that class.

## Method Overriding

* Allows the overriding of functionality of a parent class

## Method Overloading

* Adding functionality to a method by allowing it to take multiple arguments (types, length, etc)

## Polymorphism

* When a class is inherited, its subclasses are also instances of the parent class

## Refactoring

[[See more here](../good-software-design)]

### Design Smells

Symptoms of poor design, which violate key design principles

* Rigidity - hard to change
* Fragility - everything breaks when something is changed
* Immobility - hard to reuse
* Viscosity - hard to improve
* Opacity - hard to understand
* Needless complexity - too complex
* Needless repetition - redundancy

### Code Smells

[[See more here](../code-smells)]

* Duplicate code
* Long method
* Large class
* Long parameter list
* dAtA cLaSsEs
* sWiTcH sTaTeMeNtS
* Divergent change - a single class is commonly changed for a single reason
* Shotgun surgery - many classes need be commonly changed for a single reason
* Refused bequest - subclasses doesn't fully utilise its parent class

### Good Design

* Loose Coupling
  * Low dependencies on other classes
  * High coupling means that a class requires a lot of other classes
* High Cohesion
  * Things work together
  * Low cohesion means that two entities are not very compatible with each other

#### SOLID

[[See more here](../solid)]

* **S**ingle Responsibility Principle - Class does one thing
* **O**pen Closed Principle - Additional functionality without modifying the original source code
* **L**iskov Substitution Principle - Correct functionality even when a parent is represented as a child class
* **I**nterface Segregation Principle - Each interface does one thing; Encouragement to use several interfaces
* **D**ependency Inversion Principle - Depend upon abstractions, not concretions - Refer to objects through their interfaces

#### Law of Demeter / Principle of Least Knowledge

* "Only one dot"
* Cannot access the methods of objects return by a method
* Allowable method calls
  * Object itself
  * Object when passed in as a method parameter
  * Object initialised within a method
  * Component objects

## Design Patterns

### Behavioural Patterns

* [Strategy Pattern](../strategy-pattern)
  * Behaviour is delegated to another class
* [State Pattern](../state-pattern)
  * For a "finite-state-machine" with only a finite number of states
  * Functionality of the class depends on its state
  * The current functionality is able to change the state of the machine
* [Observer Pattern](../observer-pattern)
  * Pull Behaviour
    * `A` tells `B` to notify `A` when `B` changes
    * `A` then gets the required value from `B`
  * Push Behaviour
    * `A` tells `B` to notify `A` when `B` changes
    * `A` is then given the required value from `B`
* [Iterator Pattern](../iterator-pattern)
  * Encapsulates the access of a group of items stored inside an object into an `Iterator` object
  * Removes the need to know of the object's storage implementation
* [Template Method](../template-pattern)
  * Given a certain execution of methods, allows those methods to be implemented elsewhere whilst maintaining the order of execution
* [Visitor Pattern](../visitor-pattern)
  * Add extra functionality to a class through a Visitor class

### Structural Patterns

* [Composite Pattern](../composite-pattern)
  * A 'container' class that mirrors its children's functionality
  * Method forwards functionality to its children
    * Can also have extra functionality
* [Decorator Pattern](../decorator-pattern)
  * Wraps an object (through class extension), allowing us to add more functionality into a given method
* [Adapter Pattern](../adapter-pattern)
  * The Swiss-army-knife / WD-40 / Duct Tape for incompatible objects

### Creational Patterns

* [Factory Method](../factory-method)
  * Create an object and set up its state
* [Abstract Factory](../abstract-factory-method)
  * Class that can produce a family of related items
* [Builder Pattern](../builder-pattern)
  * A builder class that implements a `Builder` interface contains the actual implementation
  * A `Director` class which aggregates a `Builder` defines the order of execution of the builder
* [Singleton Pattern](../singleton-pattern)
  * Only one instance of that class can exist

## Design By Contract

A contract has pre-conditions, post-conditions and invariants.  

Should be precise, formal and verifiable.  
Must **not** contain implementation details

### Pre-condition

The conditions to which the function is guaranteed to work.  
Any state outside of those conditions may cause the function to break or ignore the call.

### Post-condition

Guaranteed results of the method (given the precondition was passed)

### Invariants

Values that will not change during the life of the method's execution

## Exceptions

Used to handle foreseeable (checked) errors during the execution of code.  
System (unchecked) do not need to be explicitly caught (but a good idea!)

```java
try {
  ...
} catch (YourExceptionClass e) {
  ...
}
```

A class that implements a method that may throw an exception must throw the most strongly-defined exception.  

_i.e. `FileNotFoundException` rather than `IOException` if both exceptions are throwable._

[[See more here](../exceptions)]

## Generics

[[See more here](../generics)]

Allows the type (or, subtype) of a given class to be given by another class, allowing that given class to be used for multiple purposes

* Class definition - `GenericClass<YourOtherType>`
* Method definition - `<YourTypeHere, MaybeAnotherType> void doSomething() { ... }`

### Bounded Types

#### Upper bound

* `T extends ClassA`
* `T extends ClassA & InterfaceB`

* Can only have one class in the bound, and that class must be specified first

#### Lower bound

* `U super ChildA`

### Wildcards

If we don't care about capturing the type of a passed class, we can use `?` instead

