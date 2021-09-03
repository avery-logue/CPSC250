eggstravaganza: egg-test
egg-compile:
	javac -cp junit.jar -d . src/Egg.java test/EggTest.java
egg-test: egg-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore EggTest

farmtest: farmtest-test
farmtest-compile:
	javac -cp junit.jar -d . src/Cow.java src/Duck.java src/FarmAnimal.java test/FarmAnimalsTest.java src/Goat.java src/Rooster.java src/Ruminant.java src/WingedAnimal.java
farmtest-test: farmtest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore FarmAnimalsTest

clean:
	rm *.class
