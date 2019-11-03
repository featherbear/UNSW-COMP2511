---
title: "JUnit Testing"
date: 2019-10-29T16:00:28+11:00

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

TL;DR: Testing is important!
---

In Java, Unit Tests are commonly provided by the JUnit library

Have a look at this cheat-sheet:

![](junit_cheatsheet.png)

Source: https://jrebel.com/rebellabs/junit-cheat-sheet/

---

- Each test should be independent, and **not rely on each other**

- Each test should have some variant of a test decorator

```java
@Test
void myCoolTest() {
  // doStuff();
}
```

- `fail()` - instantly fail a test
- `fail(String message)` - instantly fail a test with a message

```java
@Test
void doTheThing() {
  // doMoreStuff()
  if (result != 6) {
    fail();
  }
}
```

- `assertTrue()`
- `assertFalse()`
- `assertEqual(expected, value)`

```java
void checkThatThing() {
  assertTrue(obj.hasThingy());
  assertFalse(obj.isRound());
  
  assertEqual(6, obj.getValue());
  assertTrue(obj.getValue() == 6); // Also the same

  // Though as usual, String comparisons _require_ the .equals() construction
  assertEqual("Pan", obj.getText());
  // FAIL (probably): assertTrue("Pan" == obj.getText());
}
```

## Parameterised Testing

You can systematically supply arguments into your test cases. These arguments can be sourced from an iterable value in the testing file.

```java
@ParamaterisedTest
@MethodSoure(value = "data")
void test(int arg) {
  // doStuff();
}

public static int[] data() {
  return new int[] {5,3,10,2,20,42 };
}
```
