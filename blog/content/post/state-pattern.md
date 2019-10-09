---
title: "State Pattern"
date: 2019-10-09T16:22:47+11:00

description: ""
hiddenFromHomePage: false
postMetaInFooter: false
---

The same input can produce a different output, depending on **the context/current state of the machine
.**

+Pressing "Coke" on a Vending Machine won'give a Coke un*ess it has money inside.flowchartDiagrams:
enable: false
* options: ""

sequenceDiagrams:
enable: false
options: ""

---

> **State Machine**  
> A _finite state machine_ has, at any given time, only one state.  
> The state changes only in response to some _external input_.  
> The change from one state to another is called a _transition_

---

**The same input can produce a different output, depending on the context/current state of the machine.**

_i.e. Pressing "Coke" on a Vending Machine won't give a Coke unless it has money inside._

## A basic state pattern

Consider the three inputs `X`, `Y`, `Z`, and the three states `A`, `B`, `C`

```
myY() {
  if (currentState == A) {
    ...
    currentState = B;
  } else if (currentState == B) {
    ...
    currentState = C;
  } else if (currentState == C) {
    ...
    currentState = A;
  }
}
```

## The same state pattern, with switch

```
myY() {
  switch (currentState) {
    case A:
      ...
      currentState = B;
    case B:
      ...
      currentState = C;
    case C:
    ...
      currentState = A;
  }
```

### Issues

This is bad! Each new input or state will require the modification of all relevant `if`/`else if` / `switch` statements.

## Solution

Instead, for each given state we could create a class that implements a common interface.

```java
interface ObjState {
  void myX();
  void myY();
  void myZ();
}

class stateA implements ObjState {
  void myX() {
    ...
  }

  void myY() {
    ...
  }

  void myZ() {
    ...
  }
}

class stateB implements ObjState {
  void myX() {
    ...
  }

  void myY() {
    ...
  }

  void myZ() {
    ...
  }
}

class stateC implements ObjState {
  void myX() {
    ...
  }

  void myY() {
    ...
  }

  void myZ() {
    ...
  }
}

class MyClassWithState implements ObjState {
  private ObjState state;

  MyClassWithState() {
    this.state = new stateA();
  }

  void myX() {
    this.state.myX();
  }

  void myY() {
    this.state.myY();
  }

  void myZ() {
    this.state.myZ();
  }
}
```

## Setting the state

In order to update the next state, we will have to pass in a way for the state to change.

### Ideas

- Pass `this` into all methods
- **Pass `this` (context) in the state constructor**
  - **Create a `setContext` method in the context, which the states can call**
- Pass an update callback function
  - `this.state.myFunction(this.changeState);`
- The return type of the values could be the next state
  - `this.state = this.state.myFunction();`

Best Method: Pass the context into the state class through the constructor. It is also a good idea to create the states during the initialisation of the context

![](https://refactoring.guru/images/patterns/diagrams/state/structure-2x.png)
