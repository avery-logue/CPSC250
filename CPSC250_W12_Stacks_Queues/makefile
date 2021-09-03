queuetest: queuetest-test
queuetest-compile:
	javac -cp junit.jar -d . given/Node.java given/SimpleLinkedList.java src/SimpleQueue.java  given/SimpleQueueInterface.java test/SimpleQueueTest.java
queuetest-test: queuetest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore SimpleQueueTest

stacktest: stacktest-test
stacktest-compile:
	javac -cp junit.jar -d . given/Node.java given/SimpleLinkedList.java src/SimpleStack.java  given/SimpleStackInterface.java test/SimpleStackTest.java
stacktest-test: stacktest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore SimpleStackTest

stackmethodstest: stackmethodstest-test
stackmethodstest-compile:
	javac -cp junit.jar -d . given/Node.java given/SimpleLinkedList.java src/SimpleStack.java  given/SimpleStackInterface.java src/StackMethods.java test/StackMethodsTest.java
stackmethodstest-test: stackmethodstest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore StackMethodsTest

queuemethodstest: queuemethodstest-test
queuemethodstest-compile:
	javac -cp junit.jar -d . given/Node.java given/SimpleLinkedList.java src/SimpleQueue.java given/SimpleQueueInterface.java src/QueueMethods.java test/QueueMethodsTest.java
queuemethodstest-test: queuemethodstest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore QueueMethodsTest

clean:
	rm *.class
