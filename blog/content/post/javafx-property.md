---
title: "JavaFX Property Wrappers"
date: 2019-11-08T13:26:06+11:00

hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

JavaFX provides functionality to listen to changes of our primitive data types (`int`, `boolean`, etc). These are provided as Property classes, for example `BooleanProperty` and `IntegerProperty`.

These classes themselves are abstract (cannot be instantiated), but must instead be sub-classed - such as `SimpleIntegerProperty` and `SimpleBooleanProperty`.

```java
BooleanProperty isAlive = new SimpleBooleanProperty(true);
isAlive.get(); // -> true
isAlive.set(false);
isAlive.get(); // -> false
```

Listening for change
---

```java
IntegerProperty myNumber = new SimpleIntegerProperty(15);

myNumber.addListener((observer, oldValue, newValue) -> {
    System.out.println("myNumber is now: " + newValue);
});

myNumber.set(100);
// :: myNumber is now: 100
```

