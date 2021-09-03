badcode: badcode-test
badcode-compile:
	javac -cp junit.jar -d . src/BadCode.java src/BadCodeTest.java
badcode-test: badcode-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore BadCodeTest

odd: odd-test
odd-compile:
	javac -cp junit.jar -d . src/Odd.java src/OddTest.java
odd-test: odd-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore OddTest

even: even-test
even-compile:
	javac -cp junit.jar -d . src/Even.java src/EvenTest.java
even-test: even-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore EvenTest

copyarray: copyarray-test
copyarray-compile:
	javac -cp junit.jar -d . src/CopyArray.java src/CopyArrayTest.java src/Odd.java
copyarray-test: copyarray-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore CopyArrayTest

clean:
	rm *.class
