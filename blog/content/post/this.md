---
title: "The `this` keyword"
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

In objected oriented (OO) design, objects are aware of the contents inside of themselves.

In Java, the object can access its attributes with the `this` keyword.  
In Python, we commonly use the `self` variable (though it is arbitrary and up to you).

```java
class MyObject {
    private int someNumber;

    public MyObject() {
        this.someNumber = 2
    }

    public int getNumber() {
        return this.someNumber;
    }
}

//

MyObject obj = new MyObject();
obj.getNumber();
```

In this example, we can see that we are using the `this` keyword to access the `someNumber` attribute in our object.

Removing this `this` keyword
---

Sometimes we can also get rid of the `this` keyword, as the Java language does not explicitly require it.

<details>

```java
class MyObject {
    private int someNumber;

    public MyObject() {
        someNumber = 2
    }

    public int getNumber() {
        return someNumber;
    }
}

//

MyObject obj = new MyObject();
obj.getNumber();
```
</details>

When `this` is required
---
There are times when we **must** use the `this` keyword, however.  
For example, when we have arguments in the function signature.

```java
  private int myNumber;
  public int setNumber(int myNumber) {
      // This won't work!
      myNumber = myNumber;

      // We have to use `this`
      this.myNumber = myNumber;
  }
```

We **cannot** use `this` in the context of a class method (In Java, these would be `static` methods)

Summary
---

* As good practice, **always use the `this` keyword** when an attribute is accessed.  
* `this` will not work in `static` / class methods
