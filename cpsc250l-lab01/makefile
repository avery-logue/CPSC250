helloworld:
	$(eval SOURCEFILES:=src/HelloWorld.java src/HelloWorldTest.java)
	$(eval TEST_CLASSNAME:=HelloWorldTest)
	$(eval LOG_OUTPUT=helloworld-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)
arguments:
	$(eval SOURCEFILES:=src/Arguments.java src/ArgumentsTest.java)
	$(eval TEST_CLASSNAME:=ArgumentsTest)
	$(eval LOG_OUTPUT=arguments-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)
debugging:
	$(eval SOURCEFILES:=src/Debugging.java src/DebuggingTest.java)
	$(eval TEST_CLASSNAME:=DebuggingTest)
	$(eval LOG_OUTPUT=debugging-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)
clean:
	rm *.class
