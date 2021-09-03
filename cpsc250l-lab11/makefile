linkedlistmethods:
	$(eval SOURCEFILES:=src/Node.java src/LinkedListMethods.java src/LinkedListMethodsTest.java)
	$(eval TEST_CLASSNAME:=LinkedListMethodsTest)
	$(eval LOG_OUTPUT=linkedlistmethods-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)
arraylist_checker:
	python arraylist_checker.py
clean:
	rm *.class
