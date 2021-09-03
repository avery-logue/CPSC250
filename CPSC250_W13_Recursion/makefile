factorialtest: factorialtest-test
factorialtest-compile:
	javac -cp junit.jar -d . src/Factorial.java test/FactorialTest.java
factorialtest-test: factorialtest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore FactorialTest

fibonaccitest: fibonaccitest-test
fibonaccitest-compile:
	javac -cp junit.jar -d . src/Fibonacci.java test/FibonacciTest.java
fibonaccitest-test: fibonaccitest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore FibonacciTest

recursiontest: recursiontest-test
recursiontest-compile:
	javac -cp junit.jar -d . src/RecursiveMethods.java test/RecursiveMethodsTest.java
recursiontest-test: recursiontest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore RecursiveMethodsTest

recursionBtest: recursiontest-test
recursionBtest-compile:
	javac -cp junit.jar -d . src/RecursionB.java test/RecursionBTest.java
recursionBtest-test: recursionBtest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore RecursionBTest


clean:
	rm *.class
