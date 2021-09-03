combination:
	$(eval SOURCEFILES:=src/Combination.java src/CombinationTest.java)
	$(eval TEST_CLASSNAME:=CombinationTest)
	$(eval LOG_OUTPUT=combination-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)

lock:
	$(eval SOURCEFILES:=src/Combination.java src/InvalidLockCombinationException.java src/Lock.java src/LockTest.java)
	$(eval TEST_CLASSNAME:=LockTest)
	$(eval LOG_OUTPUT=lock-result.txt)
	javac $(SOURCEFILES) -cp junit.jar -d .
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore $(TEST_CLASSNAME) 2>&1 | tee $(LOG_OUTPUT)

clean:
	rm *.class
