twodarraymethods:
	$(eval SOURCEFILES:=src/TwoDArrayMethods.java src/TwoDArrayMethodsTest.java)
	$(eval TEST_CLASSNAME:=TwoDArrayMethodsTest)
	$(eval LOG_OUTPUT=twodarraymethods-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)

arraylistmethods:
	$(eval SOURCEFILES:=src/ArrayListMethods.java src/ArrayListMethodsTest.java)
	$(eval TEST_CLASSNAME:=ArrayListMethodsTest)
	$(eval LOG_OUTPUT=arraylistmethods-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)

clean:
	rm *.class
