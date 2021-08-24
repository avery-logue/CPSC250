helloworld: helloworld-test
helloworld-compile:
	javac -cp junit.jar -d . src/HelloWorld.java test/HelloWorldTest.java
helloworld-test: helloworld-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore HelloWorldTest
clean:
	rm *.class
