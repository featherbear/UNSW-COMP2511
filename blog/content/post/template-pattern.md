---
title: "Template Method Pattern"
date: 2019-11-11T23:21:00+11:00
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

The Template Method pattern aims to encapsulate the "things that vary", whilst outlining a common procedure.

They allow us to put generalised (abstract) methods in the super class, whose child classes will override.

The template method itself is `final`-ised, allowing only the steps in the method to be changed

## Example

Coffee / Tea maker

A coffee maker would have the steps:

* Boil water
* Brew coffee
* Pour cup
* Add sugar

Whereas a tea maker would have the steps:

* Boil water
* Steep tea
* Pour cup
* Add lemon

In either case, we see that we have the common steps, "Boil water", and "Pour cup".  
By using the Template Method pattern we can unify the common steps, for example through a `make` method.

```java
abstract class DrinkMaker {
  final Drink make() {
    boilWater();
    brew();
    pourCup();
    addCondiments();

    return this.drink;
  }

  void boilWater() { ... }
  abstract void brew();
  void pourCup() { ... }
  abstract void addCondiments();
}
```

In this semi-pseudo-code, children of this abstract class implement the `brew` and `addCondiments` method, with the `boilWater` and `pourCup` functionality already implemented. Also note that `make` has been finalised, and hence the child classes are unable to override its functionality.

---

![](https://refactoring.guru/images/patterns/diagrams/template-method/structure-2x.png)