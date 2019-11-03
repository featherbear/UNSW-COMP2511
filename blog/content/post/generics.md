---
title: "Generics"
date: 2019-10-29T16:35:39+11:00

description: ""
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams: 
  enable: false
  options: ""

---

Generics enable types (That is, both classes and interfaces) to **be parameters** of class, interface and method definitions

They are powerful, and benefit in several ways:

- Remove the need for continuous type-casting
- Allow types to be statically checked during compile
- Allow for the implementation of generic algorithms that work on collections of various types

# Syntax

While the naming of the type placeholder is arbitrary, there are some commonly used placeholders:

- `E` - element
- `K` - key
- `N` - number
- `T` - type
- `V` - value
- `S` - 2nd type
- `U` -  3rd Type
- `V` -  4th Type

There is also the `?` wildcard symbol, which means "any object" - however it does not capture the type

## Generic Classes

```java
class Container<T> {
  private T obj;
  
  Container(T objectToStore) {
    this.obj = objectToStore;
  }

  T getStoredItem() {
    return this.obj
  }
}
```

Here, we have defined a class which is of variable type `T`. When we retrieve the item, that item will be statically returned as having type `T`.

`(new Container<Circle>(new Circle())).getStoredItem().getClass()` -> `Circle`

## Generic Interfaces

```java
interface Container<T> {
  public T getStoredItem();
}
```

Similarly, we can apply generics to interfaces like we did to classes

## Generic Methods


```java
public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
}
```

Source: [Oracle Docs](https://docs.oracle.com/javase/tutorial/java/generics/methods.html)

If a class type is not already defined by a generic class nor a generic interface, types for a generic method can be defined before the return type in the definition.

### Bounded Methods

Bounded class methods restrict the class type that can be accepted in a method.

`<T extends Integer>` - Type `T` that extends `Integer`

`<T super Integer>` - Type `T` that `Integer` extends.

#### Multiple Bounds

`<T extends B1 & B2 & B3>` - Type `T` that extends `B1`, `B2`, and `B3`

If one of the bounds is a class, it must be specified first.

### Wildcard Methods

`<? extends Integer>` - Any object that extends `Integer`

`<? super Integer>` - Any object that `Integer` extends.

#### Unbounded Wildcards

When the needed type of a generic is unknown, the unbounded wildcard can be used.

e.g. `List<?>`
