catchsomeexceptions: catchsomeexceptions-test
catchsomeexceptions-compile:
	javac -cp junit.jar -d . given/TestException.java src/CatchSomeExceptions.java test/CatchSomeExceptionsTest.java
catchsomeexceptions-test: catchsomeexceptions-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore CatchSomeExceptionsTest

timetest: timetest-test
timetest-compile:
	javac -cp junit.jar -d . src/Time.java test/TimeTest.java
timetest-test: timetest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore TimeTest

calculatestring: processstring-test
processstring-compile:
	javac -cp junit.jar -d . src/CalculateString.java test/CalculateStringTest.java
processstring-test: processstring-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore CalculateStringTest

jeditest: jeditest-test
jeditest-compile:
	javac -cp junit.jar -d . given/Person.java given/ForceUser.java src/Jedi.java test/JediTest.java
jeditest-test: jeditest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore JediTest

sithtest: sithtest-test
sithtest-compile:
	javac -cp junit.jar -d . given/Person.java given/ForceUser.java src/Sith.java test/SithTest.java
sithtest-test: sithtest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore SithTest

arraystufftest: arraystufftest-test
arraystufftest-compile:
	javac -cp junit.jar -d . src/ArrayStuff.java test/ArrayStuffTest.java
arraystufftest-test: arraystufftest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore ArrayStuffTest

lotrtest: lotrtest-test
lotrtest-compile:
	javac -cp junit.jar -d . src/Human.java src/Elf.java src/Hobbit.java src/LOTR.java given/Person.java test/LOTRTest.java
lotrtest-test: lotrtest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore LOTRTest

humantest: lotrtest1-test
lotrtest1-compile:
	javac -cp junit.jar -d . src/Human.java given/Person.java test/HumanTest.java
lotrtest1-test: lotrtest1-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore HumanTest

hobbittest: lotrtest2-test
lotrtest2-compile:
	javac -cp junit.jar -d . src/Hobbit.java given/Person.java test/HobbitTest.java
lotrtest2-test: lotrtest2-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore HobbitTest

elftest: lotrtest3-test
lotrtest3-compile:
	javac -cp junit.jar -d . src/Elf.java given/Person.java test/ElfTest.java
lotrtest3-test: lotrtest3-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore ElfTest

clean:
	rm *.class
