---
title: "<Object>.toString"
date: 2019-09-25T16:11:23+10:00

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

The `<Object>.toString` function is used to represent an object as a `String`.

```java
class Circle {
  private int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  @Override
  public String toString() {
    return "Circle with radius " + radius;
  }
```

---

For more complicated concatenations, you may prefer to use the `String.format(format, ...args)` static method.

For example:

```java
// ...

  @Override
  public String toString() {
    return String.format("Circle with radius %dcm, colour %s", this.radius, this.colour);
  }
```
