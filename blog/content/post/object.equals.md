---
title: "<Object>.equals"
date: 2019-09-25T16:11:23+10:00

description: "Defining the functionality of <Object>.equals()"

hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

The `<Object>.equals` function (by definition) must be equivalent in the following ways:

- reflexive - `x.equals(x)`
- symmetric - `x.equals(y) && y.equals(x)`
- transitive - `x.equals(y) && y.equals(z) && x.equals(z)`
- consistent - `while (true) x.equals(y)`
- `x.equals(null) == false`

# Implementing `<Object>.equals`

In writing an `equals` function, we perform the following routine:

- Add the `@Override` annotation before the method signature
- Check that the supplied `obj` is not `null`
- Check that the classes match
- Cast the `obj` to the correct type
- Perform necessary equality checking

---

```java
class MyObject() {
  int i;
  String b;

  MyObject(int i, String s) {
    this.i = i;
    this.s = s;
  }

  @Override
  boolean equals(Object obj) {
    if (obj == null) return false;
    if (this.getClass() != obj.getClass()) return false;
    MyObject o = (MyObject) obj;

    return ( this.i == o.i && this.s.equals(o.s) );
  }
}
```

Note: Reminder, that to compare strings we need the `<String>.equals` function, rather than the `==` operator

## Inherited classes

For inherited classes, it is beneficial to test the equality of their superclasses.

```java
class MyOtherNewObject extends MyNewObject {
  boolean b;

  // ...

  @Override
  boolean equals(Object obj) {
    if (obj == null) return false;
    if (this.getClass() != obj.getClass()) return false;

    MyObject n = (MyObject) obj;
    if (!super.equals(n)) return false;

    MyOtherNewObject o = (MyOtherNewObject) obj;
    return this.b == o.b;
  }

// ...
```
