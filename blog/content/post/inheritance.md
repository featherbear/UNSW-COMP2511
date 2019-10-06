---
title: "Inheritance"
date: 2019-10-06T20:18:37+11:00

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

# Inheritance in OOP

**Inheritance** is a programming concept where new classes can use existing attributes and methods from other classes. These new classes can then be referred to as _subclasses_

For example

```java
class Animal {
  private String _sound;

  public String whatSound() {
    return this._sound;
  }
}

class Dog extends Animal {
  private String _sound = "Woof";
}

// ------------------------------ //
//              ...
// ------------------------------ //

Dog d = new Dog();
d.whatSound();
```

## Method Overriding

- Argument list should be the same as that of the overridden method
- The return type must be the same, or a subtype
- [Access level](../access-modifiers) cannot be more restrictive than the overridden method's access level
- Static methods cannot be overridden

## Good Practices for Inheritance

- Only use inheritance if all of the inherited attributes and methods make sense!
- [Liskov Substitution Principle](../solid#liskov-substitution-principle)
- Favour composition over inheritance

## Inheritance Relationships

[Click here](../relationships#inheritance-relationships)

## Types

Consider a class `B` that extends class `A` - we are able to represent an instance of `B` as its parent type.  
i.e. `A newObj = new B()`.

This can be possibly bad, as whilst `newObj` is of type `A`, the object contains methods for type `B`
