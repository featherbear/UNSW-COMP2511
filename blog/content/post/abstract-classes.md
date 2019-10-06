---
title: "Abstract Classes"
date: 2019-10-06T20:17:01+11:00

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

# Abstract Classes

Abstract classes are classes than **cannot be instantiated**.  
One might create an abstract class to act as a sort of "template" class, to which other classes inherit.

```java
abstract class AbstractClass {
  abstract private String secretString;
}

// new AbstractClass() // won't work!
```
