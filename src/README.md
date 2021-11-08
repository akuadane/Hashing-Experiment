# Project #: Project Name

* Author: Your Name
* Class: CS321 Section #
* Semester: 

## Overview

In  this  project,  we  will  study  how  the  load  factor  affects  the  average  number  of  probesrequired  by  open  addressing  while  using  linear  probing  and  double  hashing  for  differenttypes of inputs.  This will also improve our understanding of how hashing works.  Note thatwe are not attempting to create a generic hash table that is usable by all applications

## Reflection

The most challenging part of the program at first was determining the exiting
conditions for the while loops in the data generators. I thought the value of n
should be given and spent a couple of days to figure out how to detrmine n.
But finally how of my classmates gave me suggestions on how to do it, and I figured 
the condition could be to let the loops run until n/m is under alpha.

Another difficult thing was structuring my code into classes, subclasses and iterfaces.
I had to come up with parent class for the two Hashtable probing techniques, Linear probing and 
double hashing. I created common interface for the different kinds of Debuggers and also 
I created another interface for the data generators. This allowed my to use the debuggers and data
generators flexibly. 

## Compiling and Using

To compile use the Javac command followed by the main class, HashtableTest.java.
```bash
$javac HashtableTest.java
```

```bash
java HashtableTest <input type> <load_factor> [<debug level>]
```
Example
```bash
java HashtableTest  1 0.5 1
```


## Results 

The results match with the once given in the test folder. 
I used the diff operator to compare the sample outs and they match.

## Sources used

If you used any sources outside of the lecture notes, class lab files,
or text book you need to list them here. If you looked something up on
stackoverflow.com and fail to cite it in this section it will be
considered plagiarism and be dealt with accordingly. So be safe CITE!

----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).
