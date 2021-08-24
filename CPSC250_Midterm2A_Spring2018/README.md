# Midterm 2

Make sure you cloned the proper repo that you were assigned.

Code I have given that you do NOT modify is in the ``given`` folder.
Code you modify is in the ``src`` folder.
JUnit test code is in the ``test`` folder.

You may only consult with:
* Dr. Conner to clarify intent of questions if needed
* https://docs.oracle.com/javase/8/docs/api/index.html - Java API documentation
* https://gitlab.pcs.cnu.edu   - your personal CS250 repo's only
* https://web-cat.cs.vt.edu    - your webcat submissions
* Your single double sided sheet of handwritten notes

No other help is allowed.

Change your WebCat `login.txt` right now!

Make sure you verify that all submissions make it to webcat.  This is required for full credit.

The following sections are all part of this single repo, but are submitted as separate tests to WebCat.

Your code must compile in WebCat.
Be warned Eclipse will sometimes "force compile" code to run what it can, but WebCat requires all code to compile before it will grade.  Make sure you check your WebCat submissions.
Comment out any code that you cannot get to work if it is causing compilation issues on WebCat.
(Leave it in place in case I look for partial credit.)

Passing WebCat tests give you full credit.  
If you score less than 50% on a problem, then I will grade manually for partial credit up to 50%.  Any credit requires an honest and significant attempt, and problems that are likely due to minor compilation issues.
I will consider code that is commented out in attempt to get the system to compile.

There are six problems, each worth 15 points; you may choose any five to complete for a maximum of 75 points.
I will take your five highest scores if you attempt more than five.

If you get stuck on something, move on to the next problem, or comment out a portion so it still compiles, and move on!  Time management is key.  You may choose which problems you attempt, and in what order you attempt them.

Your overall score is your scholar points plus the total of the five highest programming scores.

## 1) StarWars (15 pts total)

You are given a class ```Person``` that defines a person by their name, and an interface ```ForceUser```.  Modify the two classes ```Jedi``` and ```Sith``` so they are Persons who are also ForceUsers.   Sith always use ``red`` blades; Jedi mostly use blue or green blades.  Write the constructors given their Java Doc definitions.  

You may need to add a field variable to ``Jedi.java``, but do not add any fields to ``Sith.java``.

The JUnit test StarWarsTest defines the complete requirements.

## 2) CatchSomeExceptionsTest (15 pts)
 You are given a class ```TestException``` class with a method ```doIt``` that may throw several different types of exceptions depending on how the class is constructed by the JUnit test.

 You will write a ```runIt``` in the ```CatchSomeExceptions``` class.  The ```runIt``` takes a reference to an instance of the ```TestException``` class, and should catch any exceptions thrown by ``doIt`` method, and return the designated string.
 The ```runIt``` should NOT throw any exceptions itself.

## 3) CompareTo (15 pts)

Given a ```Time``` class with two fields ``seconds`` and ``nanoseconds``, you are to compare the time values of two instances.  

The Time class separates the whole seconds from the fraction part stored in nanoseconds; thus, as a floating point equivalent one would write "seconds.nanoseconds" to represent the time.  
When the nanoseconds reaches 999,999,999 and one nanosecond is added, the nanoseconds becomes 0 and the whole seconds is incremented.  (This is NOT part of the problem!)

When doing the comparison, do NOT convert to floating point. First compare based on whole seconds, and secondly based on nanoseconds.

Make sure your class implements the proper interface so that we can use our time class in ArrayLists and sort them using standard Java Collections.sort.

## 4) ArrayStuff (15 pts)

 Implement the ```remove``` that receives an array of Integers and an index number to remove from the list.

 For example, given the array {18, 29, 12, 7, 25, -2} and index 1, the method removes the 29 value, such that
 the array is {18, 12, 7, 25, -2, null}, and returns the Integer value 29.

 Note: You are NOT creating a new array, you are modifying the current array.  

Use the JUnit class ArrayStuffTest to test your implementation.


## 5) CalculateString (15 pts)

You are given a string with `words` separated by either tabs, spaces, or commas.

The first word is a numerical operation command.  For this exam, valid commands are either ```ADD``` or ```MULTIPLY```.  Following the command should be a list of two or more numbers.   If all numbers are valid, then perform the requested operation.  The answer is returned as an ```Integer``` type.

If any command or number is invalid, then return a null value.

For example, given:
```
ADD 3 4 6
```
would return a value of 13.

```
MULTIPLY 2 3 4 -5
```
should return a value of -120.

```
Delci  3 4 5
```
would return ```null```.

```
ADD 2 3 joe
```
would return ```null```.

This is tested with the ```CalculateStringTest.java``` JUNit.

## 6) Lord of the Rings (15 pts)

Given class ``Person``, and shell classes ``Human``, ``Elf``, and ``Hobbit``.
Humans, Elves, and Hobbits are all Persons.
Modify the shell classes accordingly (5pts)

Check ElfTest.java, HumanTest.java, and HobbitTest.java

This is required to do the remaining.

Given class ``LOTR``, modify ``getCharacters`` method to return an ArrayList of Persons
that contains the following names in order with their race in parenthesis:
"Aragorn" (Human)
"Frodo" (Hobbit)
"Boromir" (Human)
"Legolas" (Elf)
"Arwen" (Elf)
(5 pts for method)

Modify getElves() to return an Array list of elves given a list of Persons. (5pts)



## Push to GitLab and check submission on WebCat
