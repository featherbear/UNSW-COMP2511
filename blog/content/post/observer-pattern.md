---
title: "Observer Pattern"
date: 2019-10-09T17:14:51+11:00

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


# Event-Driven Programming

An order-of-execution independent system (independent of time).

For example:

* `EventEmitter` in Node.js
  * `const EventEmitter = require('events');`
* [Website hooks](#aside) (Although subscribing is done manually)


# Observer Pattern

We can consider this a callback driven system, where you supply function references, which can be called later.

* Parties
  * Subject/Observable/Publisher
  * Observer/Subscriber
* Subscribe to a subject/observable/publisher
* When a given observable updates, it pushes an update to its subscribers
* _Can have 'channels' by separating which subscribers are notified for a specific event._

* One publisher may have zero to an infinite number of subscribers (1 to many)


## A bad approach

Each subscriber adds the publisher to an internal list. Every 'tick' they check the observer.

But this is bad, as it is a very expensive operation.  
_`n_subscribers * n_ticks * n_publishers_in_list * ... == alot`_.

In addition, we may miss a change if a value in the publisher changes during a tick loop cycle.

<div id="aside">  

> Aside: Sometimes we might need to set it up this way, especially when it comes to code split upon multiple machines (ie IoT). Due to network conditions (_firewalls, non-persistent connections, etcetera_), it may not be possible for the publisher to connect directly to the subscriber.  
&nbsp;  
In that case we could implement something like polling.

## A better approach - publish-subscribe

Each subscriber adds a callback to the publisher's list. When the publisher object is updated, each client is notified.

`1_event * n_subscribers == not alot!`

# Aside: `java.util.Observer` and `java.util.Observable`

* Requires an inheritance 
  * `Observable` is a class, not an interface?
  * `Observable` protects its `setChanged`?
* Dumb.

---

![](https://refactoring.guru/images/patterns/diagrams/observer/structure-2x.png)

---

# Push and Pull

## Push

Updated data is pushed to the observer.

`<Observer>.update(data1, data2, ...);`

## Pull

When data is updated, the observer will manually request data from the subject

`<Observer>.update(this);`

# Java Code

```java
// Observer.java
interface Observer {
  void update(Object obj);
}
```

```java
// Subject.java
interface Subject {
  void addListener(Observer obs);
  void removeListener(Observer obs);
  void notifyListeners();
}
```

```java
// ObserverImplementation.java

class ObserverImplementation implements Observer {
  /*
   *  void update(Object obj) {
   *    // We could use this method, which will occur for all objects
   *  }
   */

  void update(SubjectOne obj) {
    // called when SubjectOne is passed in
  }

  void update(SubjectTwo obj) {
    // called when SubjectTwo is passed in
  }
}
```

```java
// SubjectImplementation.java

class SubjectImplementation implements Subject {
  @Override
  void addListener(Observer obs) {
    if (this.observers.contains(obs)) return;
    this.observers.add(obs);
  }

  @Override
  void removeListener(Observer obs) {
    this.observers.remove(obs);
  }

  @Override
  void notifyListeners() {
    for (Observer obs : this.observers) {
      obs.update();
    }
  }

  if (obj instanceof Thermometer) {
    ...
  }
}
```

* Observer can overload its `update` method to function differently, depending on which object has notified it.


## Passing functions as observers

Can create an interface which exposes a single method -> SAM - Single Abstract Method.

```
addListener(new MyCoolSAM() {
  @Override
  int something(int arg1, int arg2) {
    return arg1 * arg2;
  }
})
```

Could also use a lambda function

```
addListener((int arg1, String arg2)-> arg1*arg2);
```