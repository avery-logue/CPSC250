linkedlistmethods2:
	$(eval SOURCEFILES:=src/Node.java src/LinkedListMethods2.java src/LinkedListMethods2Test.java)
	$(eval TEST_CLASSNAME:=LinkedListMethodsTest2)
	$(eval LOG_OUTPUT=linkedlistmethods2-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)
arraylist_checker:
	python arraylist_checker.py
clean:
	rm *.class
