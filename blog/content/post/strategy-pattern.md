---
title: "Strategy Pattern"
date: 2019-10-08T16:24:30+11:00

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

---

The strategy method performs different functionality depending on its provided internals.

i.e. `Car car = new Car(new HybridEngine(), new BrakeDisc());`  

This way, the same object class can be used, and reused with different behaviour

# Code

```java
interface Engine {
  void vroom();
  void performMaintenance();
}

class DieselEngine implements Engine {
  void vroom() { System.out.println("gdrgdgrdgrgdgrgdgrg"); };
  void performMaintenance() { ... };
}

class ElectricEngine implements Engine {
  void vroom() { System.out.println("-------------------"); };
  void performMaintenance() { ... };
}

class Car {
  private Engine engine;
  public MyCar(Engine e) {
    this.engine = e;
  }

  void vroom() {
    this.engine.vroom();
  }

  void performMaintenance() {
    this.engine.performMaintenance();
  }
}

///

Car car1 = new Car(new DieselEngine());   // gdrgdgrdgrgdgrgdgrg
Car car2 = new Car(new ElectricEngine()); // -------------------
```

# UML 

Interfaces are joined to their contexts through a solid line with a white diamond on the context side.

Implementations of the interface are joined through a dotted line with a white triangle on the interface.

---

![](https://refactoring.guru/images/patterns/diagrams/strategy/structure-2x.png)