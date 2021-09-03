stackmethods:
	$(eval SOURCEFILES:=src/Stack.java src/Node.java src/StackMethods.java src/StackMethodsTest.java)
	$(eval TEST_CLASSNAME:=StackMethodsTest)
	$(eval LOG_OUTPUT=stackmethods-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)

queuemethods:
	$(eval SOURCEFILES:=src/Queue.java src/Candy.java src/QueueMethods.java src/QueueMethodsTest.java)
	$(eval TEST_CLASSNAME:=QueueMethodsTest)
	$(eval LOG_OUTPUT=queuemethods-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)

clean:
	rm *.class
