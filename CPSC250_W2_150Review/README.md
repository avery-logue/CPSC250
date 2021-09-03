Several demonstrations of common coding issues seen in 150, plus a review of 1D and 2D arrays.

The provided code has multiple errors that we will fix in class.

You will create several JUnit tests.  For tests that you create, place these in the `src/` folder to upload to web-cat.


## Setup
* Fork this project into your course group.

* Clone your fork of repo to your computer
* Create Eclipse project that points to this repo
 * Be sure to add JUnit library
* Update the login.txt with your web-cat information
 * Make sure you are using your CNU student ID as the User name
 * There was issue with multiple accounts that were created

## Odd and OddTest

This code performs an isOdd test on any integer.
There is also JUnit test provided in the `src/` folder that you will need to modify.

BOTH files are WRONG!!!!!!!!!!!

First figure out what's wrong with our unit test.  Have we tested all of our ``corner cases``?

Add additional unit tests that catches any errors first.

Commit the updated OddTest.java that fails with the current code.

Correct the Odd.java, and commit the updated code.

Push latest commits to server.



## BadCode

BadCode is a mess.  It does not follow naming conventions and other coding standards; it has several logic and usage errors.

Begin by correcting the variable naming conventions, then the method naming conventions.

The corrected version should have 2 constructors, including the default no argument constructor, and a two argument constructor in given order.  There should be two accessor methods, and two mutator methods using the recommended naming convention.

Correct the naming first without correcting the internal logic.

Commit the corrected naming prior to correcting the logic.

Then write BadCodeTest using the JUnit test framework in Eclipse, and test for proper constructors and getters.  

Commit at least once while your BadCode still fails most of the new BadCodeTest JUnit tests.  Be sure to add and commit the new BadCodeTest.java.

After this commit, correct the logical errors in the code.

Make a commit after BadCode and BadCodeTest are correct.

Be sure to push to server for back up after this point.

## CopyArray and CopyArrayTest

Write a CopyArray class that has three static methods that perform:

 * shallowCopy - Shallow copy of 1D array of double
 * deepCopy - Deep copy of 1D array of String
 * deepCopyOdd - Deep copy of only the odd values from 1D array of integers
  *  Use isOdd method from Odd.java
  *  Note I said "values", not "indices".

I have given you shell code that defines the method signature, and returns a null value so that it compiles.  Shell includes basic JavaDoc to detail the requirements.

Each method should return an array of the appropriate type.

 If the input array is null, return null
 If input array is empty, then return an empty array.

Write a CopyArrayTest JUnit test that tests each method *well*.


## Even and EvenTest

Write Even.java with a single isEven(int) method, and EvenTest.java and commit to the repo.

Here WebCat will be testing that your EvenTest.java properly covers the different use cases as well as your formatting and JavaDoc.

Neither the Even.java nor EvenTest.java are provided.  You need to create both from scratch.  I will have additional JUnit tests only in Web-cat to test your creations.

## Notes:

* There are additional unit tests that will be run on WebCat server, so make sure your tests are sufficient to catch all errors.
* Web-cat is picky on style and logic.  You can have correct code that will still lose points in web-cat.  Look at the reports
 * Web-cat wants extra braces around single line statements.  Just do it.
 * Web-cat will expect your Unit tests to cover all of your code by calling every method, including main and constructors, at least once in your unit test.
 * Web-cat expects at least one assert in each @Test method.
 * JUnit tests should do one test well.  You may have multiple asserts in a single test, but the test should test only one concept.
