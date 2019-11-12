---
title: "Comparing"
date: 2019-11-13T00:41:48+11:00

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

`java.util.Comparator` provides an interface which allows two objects of a given type to be compared against a user defined order algorithm.

```java
class MyNumberObject implements Comparator<MyNumberObject> {
  private int secretValue;
  
  public MyNumberObject(int x) {
    this.secretValue = (x*2 - 1) % 3;
  }

  @Override
  public int compare(MyNumberObject o1, MyNumberObject o2) {
    return o1.secretValue - o2.secretValue;
  }
}
```

`java.util.Comparable` provides a de-facto interface to compare two objects of a given type against a user defined order algorithm.

```java
public class MySpecialObject implements Comparable<MySpecialObject> {
  @Override
  public int compareTo(MySpecialObject obj) {
    return ...
  }

}
```

---

## Comparable vs Comparator

* Comparable interface can be used to provide single way of sorting whereas Comparator interface is used to provide different ways of sorting.
* For using Comparable, Class needs to implement it whereas for using Comparator we don’t need to make any change in the class.
* Comparable interface is in `java.lang` package (default) whereas Comparator interface is present in `java.util` package (needs to be imported).
* We don’t need to make any code changes at client side for using Comparable, `Arrays.sort()` or `Collection.sort()` methods automatically uses the compareTo() method of the class. For Comparator, client needs to provide the Comparator class to use in compare() method.
[Source: journaldev](https://www.journaldev.com/780/comparable-and-comparator-in-java-example)

TL;DR:  

* Comparable is for a single definitive comparison whereas Comparator can be used as a utility (multiple ways), whereas
* Comparable is implemented within the class, whereas Comparator is implemented in its own class.
