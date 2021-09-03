genericpairtest: genericpairtest-test
genericpairtest-compile:
	javac -cp junit.jar -d . src/GenericPair.java test/GenericPairTest.java
genericpairtest-test: genericpairtest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore GenericPairTest

generic2pairtest: genericpairtest-test
generic2pairtest-compile:
	javac -cp junit.jar -d . src/Generic2Pair.java test/Generic2PairTest.java
generic2pairtest-test: generic2pairtest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore Generic2PairTest

genericmethodstest: genericmethodstest-test
genericmethodstest-compile:
	javac -cp junit.jar -d . src/GenericMethods.java test/GenericMethodsTest.java
genericmethodstest-test: genericmethodstest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore GenericMethodsTest

integerpairtest: integerpairtest-test
integerpairtest-compile:
	javac -cp junit.jar -d . src/IntegerPair.java test/IntegerPairTest.java
integerpairtest-test: integerpairtest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore IntegerPairTest

drawertest: drawertest-test
drawertest-compile:
	javac -cp junit.jar -d . src/Drawer.java test/DrawerTest.java
drawertest-test: drawertest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore DrawerTest

clean:
	rm *.class
