CS150StuffTest: cs150stuff-test
cs150stuff-compile:
	javac -cp junit.jar -d . src/CS150Stuff.java test/CS150StuffTest.java
cs150stuff-test: cs150stuff-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore CS150StuffTest

Array2DTest: array2d-test
array2d-compile:
	javac -cp junit.jar -d . src/Array2D.java test/Array2DTest.java
array2d-test: array2d-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore Array2DTest

CrazyNameAnimalTest: cna-test
cna-compile:
	javac -cp junit.jar -d . given/Animal.java src/CrazyNameAnimal.java test/CrazyNameAnimalTest.java
cna-test: cna-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore CrazyNameAnimalTest

MammalTest: mammal-test
mammal-compile:
	javac -cp junit.jar -d . given/Animal.java src/CrazyNameAnimal.java src/Mammal.java test/MammalTest.java
mammal-test: mammal-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore MammalTest

ReptileTest: mammal-test
reptile-compile:
	javac -cp junit.jar -d . given/Animal.java src/CrazyNameAnimal.java src/Reptile.java test/ReptileTest.java
reptile-test: reptile-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore ReptileTest

RaccoonTest: raccoon-test
raccoon-compile:
	javac -cp junit.jar -d . given/Animal.java src/Raccoon.java src/CrazyNameAnimal.java src/Mammal.java test/RaccoonTest.java
raccoon-test: raccoon-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore RaccoonTest

SnakeTest: snake-test
snake-compile:
	javac -cp junit.jar -d . given/Animal.java src/CrazyNameAnimal.java src/Snake.java src/Reptile.java test/SnakeTest.java
snake-test: snake-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore SnakeTest

OffenseTest: offense-test
offense-compile:
	javac -cp junit.jar -d . given/Player.java src/Offense.java test/OffenseTest.java
offense-test: offense-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore OffenseTest

DefenseTest: defense-test
defense-compile:
	javac -cp junit.jar -d . given/Player.java src/Defense.java test/DefenseTest.java
defense-test: defense-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore DefenseTest

QuarterBackTest: qb-test
qb-compile:
	javac -cp junit.jar -d . given/Player.java src/QuarterBack.java src/Offense.java test/QuarterBackTest.java
qb-test: qb-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore QuarterBackTest

LineBackerTest: lb-test
lb-compile:
	javac -cp junit.jar -d . given/Player.java src/LineBacker.java src/Defense.java test/LineBackerTest.java
lb-test: lb-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore LineBackerTest

GetOffenseTest: go-test
go-compile:
	javac -cp junit.jar -d . given/Player.java src/QuarterBack.java src/Offense.java src/LineBacker.java src/Defense.java src/GetOffense.java test/GetOffenseTest.java
go-test: go-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore GetOffenseTest


clean:
	rm *.class
