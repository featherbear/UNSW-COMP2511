---
title: "Inheritance"
date: 2019-09-18T16:00:00+10:00

description: "Lecture 02"
categories: ["Lectures", "Java"]
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

In Object-Oriented Programming, programmers focus on user-defined data types called **classes**.

Each class contains **attributes** and **methods** that can manipulate data.

An instance of a class is called an **object**.

**Encapsulation** is the privatisation of its attributes and methods, where its properties are exposed to other objects only if explicitly set.

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

## Good Practices for Inheritance

- Only use inheritance if all of the inherited attributes and methods make sense!

## Inheritance Relationships

### Is-A

An "is a" relationship functions by extending a class to produce another

### Has-A

A "has a" relationship functions by containing an object of a class within another class.

For example, writing a wrapper class.
