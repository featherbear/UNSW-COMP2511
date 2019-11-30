---
title: "Visitor Pattern"
date: 2019-11-17T20:52:39+11:00
categories: ["Design Patterns", "Behavioural Patterns"]

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

> Adds new operations and behaviours to existing objects without modifying them.

Able to separate an algorithm from the object on which it operates.


* "Double Dispatch" technique
  * An object takes in a visitor, and calls the right visitor method with the needed data

ie Car

```pseudo
visitor = Visitor()
Car.accept(visitor)
-> for each element in car:
   -> element.accept(visitor)
      -> visitor.visit(this)
visitor.visit(this)
```

* Define a `Visitor` class which knows of the classes it will visit
  * Has a `visit(T)` method for each class type
    * In the implementation, do whatever you need
* Define an interface `Visitable` which exposes an `accept(Visitor)` method
  * In the implementation, `<Visitor>.visit(this)`

A new class would require a new visit method to be added to each visitor...

---

![](https://refactoring.guru/images/patterns/diagrams/visitor/structure-2x.png)