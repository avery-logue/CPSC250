Practice with Exceptions and Equals 

## ExceptionDemo

We will use this during in-class work, but it will not be uploaded to web-cat or graded


## Exceptions and ExceptionsTest

We will use this program to explore and test exceptions

As part of this we will create MyException.java; be sure to add that to your repo for submission.

These will be graded by web-cat, so mind your test completeness and JavaDoc

## Fraction and FractionTest

We will add code to catch numerous exceptions, and code the JavaDoc to test.

This will be graded by web-cat.

Practice with creating proper equals and toString

## Movie and MovieTest

Add a toString() method that overrides the default Object toString
Add appropriate tests to the MovieTest.java file.
The toString() should return a string equal to:

```"These aren't the droids you're looking for."  Star Wars (1977)```

That is, our quote in quotation marks (remember to use the escape character \" to actually print "), followed by the movie title and then year in parenthesis.

This code apparently passes the equals tests.  But we will see the implementation is not sufficient.


## IMAXMovie and IMAXMovieTest

Add a toString() that prints "IMAX " prefix before the quote.


```IMAX "That's not how the force works.."  Star Wars (2015)```

Try to do this without accessing any of the getters or field variables directly.  HINT: It's a bird, it's a plane, no, it's the ```super``` class.

We fail some of the IMAXMovieTest methods.  We need to figure out why, and then fix the equals methods of both IMAXMovie and Movie so that we obey the equals contract.


This will be graded by web-cat.


## Notes:

* I am not requiring that you create tests that cover you code; webcat will score your code coverage in report, but I'm not counting it.  However, ...
* There are additional unit tests that will be run on WebCat server, so you may want to make sure the JUnit tests are sufficient to catch all errors.
* Web-cat is picky on style and logic.  You can have correct code that will still lose points in web-cat.  Look at the reports
