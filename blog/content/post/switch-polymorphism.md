---
title: "Switch to Polymorphism!"
date: 2019-10-06T22:44:19+11:00

description: "Using polymorphism to remove the need for switch statements"
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

Consider the code from assignment one

```java
if (small > small_count || medium > medium_count || large > large_count) {
  freeRooms = this.venue.getFreeRooms(dateRange);
}

if (small > small_count) {
  this.addRooms(Room.getRoomsBySize(freeRooms, Size.SMALL), small - small_count);
} else if (small < small_count) {
  this.removeRooms(Size.SMALL, small_count - small);
}

if (medium > medium_count) {
  this.addRooms(Room.getRoomsBySize(freeRooms, Size.MEDIUM), medium - medium_count);
} else if (medium < medium_count) {
  this.removeRooms(Size.MEDIUM, medium_count - medium);
}

if (large > large_count) {
  this.addRooms(Room.getRoomsBySize(freeRooms, Size.LARGE), large - large_count);
} else if (large < large_count) {
  this.removeRooms(Size.LARGE, large_count - large);
}
```

[Source](https://github.com/featherbear/UNSW-COMP2511/tree/master/Assignments/assign1/src/unsw/venues/Booking.java#L205-L226)

If we were to add more room sizes, we would have to add another repeated block of code for each size.  
We can avoid that by using polymorphism (where an object changes functionality depending on its required use)
