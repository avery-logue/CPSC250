exceptions: exceptions-test
exceptions-compile:
	javac -cp junit.jar -d . given/Exceptions.java src/MyException.java test/ExceptionsTest.java
exceptions-test: exceptions-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore ExceptionsTest

fraction: fraction-test
fraction-compile:
	javac -cp junit.jar -d . src/Fraction.java test/FractionTest.java
fraction-test: fraction-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore FractionTest

movietest: movietest-test
movietest-compile:
	javac -cp junit.jar -d . src/Movie.java src/MovieTest.java
movietest-test: movietest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore MovieTest

imaxmovietest: imaxmovietest-test
imaxmovietest-compile:
	javac -cp junit.jar -d . src/Movie.java src/IMAXMovie.java src/IMAXMovieTest.java
imaxmovietest-test: imaxmovietest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore IMAXMovieTest


clean:
	rm *.class
