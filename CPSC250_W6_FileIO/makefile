carstest: carstest-test
carstest-compile:
	javac -cp junit.jar -d . src/Car.java src/CarsForSale.java test/CarsForSaleTest.java
carstest-test: carstest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore CarsForSaleTest

arrayiotest: arrayiotest-test
arrayiotest-compile:
	javac -cp junit.jar -d . src/Array2D.java test/Array2DTest.java
arrayiotest-test: arrayiotest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore Array2DTest

clean:
	rm *.class
