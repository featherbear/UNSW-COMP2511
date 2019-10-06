---
title: "Assignment One - Booking System"
date: 2019-09-23T11:54:41+10:00

description: "Yay reused assignments"
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

> We were given an assignment, to implement the backend of a simple venue hiring system.  
> Each venue contains rooms of either small, medium, or large size.  
> Each booking required an (unique) ID, a start and end date, and the number of small, medium and large rooms.  
> Bookings were date-based, rather than time-based - so a given room on a given day could only be booked for one event.  
> Interacting with the system was through a sequence of JSON objects, the output also being JSON responses.

> UI

I created a little web application, not to act (per se) as a frontend of this backend (Maybe I should've...), but rather to help create queries for testing my code.

[Take a look here!](https://featherbear.github.io/UNSW-COMP2511-Helper)

> Git

Code available on GitHub: [featherbear/UNSW-COMP2511](https://github.com/featherbear/UNSW-COMP2511/tree/master/Assignments/assign1)

# Inspection

## Design Considerations

- Don't need to validate input - Input will always be valid
- Don't need to check for duplicate reservation identifiers - always unique

## Design Rules

- Source files to be located in the `unsw.venues` package'
- No third-party libraries

## System Rules

- Venues will be processed in order of input
- When displayed with `list`, rooms are output in order of date (earliest to latest)
- The first available rooms are assigned to the reservation.
- A larger room will not be assigned to a request for a small rule
- Rooms are not reassigned to create space

# Progress

## 1) UML Diagram

Firstly, I had to make a UML Class Diagram for planning out how to design and build the system.
![](Class Diagram - z5206677.png])

I had a few questions, mainly:

- I have a `DateUtils` class, that only contains `static` methods, do I include it in the class diagram? If so, how?
- I have a `Size` enumerator, do I include it in the class diagram? If so, how?
- I have a `LocalDateRange` class that is used in my classes, but not created nor stored. Do I include it in the class diagram? If so, how?
  - low-key code smell

## 2) Tests

<s>tEsT dRiVeN dEvElOpMeNt</s> is quite good actually. Comparing program output to generated output is dumb.

I wrote a script to compile and test my code from a shell, so I don't have to open up Eclipse every darn time.

- [./runTests.sh](https://github.com/featherbear/UNSW-COMP2511/blob/master/Assignments/assign1/runTests.sh) - Build, decommentify, and compare program outputs
- [./build.sh](https://github.com/featherbear/UNSW-COMP2511/blob/master/Assignments/assign1/build.sh) - Compile the code
- [./tests/decommentify.sh](https://github.com/featherbear/UNSW-COMP2511/blob/master/Assignments/assign1/tests/decommentify.sh) - Strip comment lines from the commented input files (in case my commented files break the assignment marking tests)

Also - [who said writing tests can't be fun?](https://github.com/featherbear/UNSW-COMP2511/blob/master/Assignments/assign1/tests/input6.commented.json)

## 3) Clackity clackity clackity

Given the class diagram, it was just a matter of implementing all of the functions

## 4) Bug fixing

My main bugs were caused by bad copy-paste-find-replace'ing.  
That, and my [`<Venue>.getFreeRooms` method](https://github.com/featherbear/UNSW-COMP2511/blob/master/Assignments/assign1/src/unsw/venues/Venue.java#L250-L267), which would unintentionally modify its internal state.

# Comments

- I would have liked to have implemented some error handling / throwing of exceptions, but the assignment specification had said that input will always be valid
- As always, [anonymous / lambda functions are cool](https://github.com/featherbear/UNSW-COMP2511/blob/master/Assignments/assign1/src/unsw/venues/Venue.java#L206)
