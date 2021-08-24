minefield: minefield-test
minefield-compile:
	javac -cp junit.jar -d . src/MineField.java test/MineFieldTest.java
minefield-test: minefield-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore MineFieldTest

clean:
	rm *.class
