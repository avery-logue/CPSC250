simplelinkedlisttest: simplelinkedlisttest-test
simplelinkedlisttest-compile:
	javac -cp junit.jar -d . src/Node.java src/SimpleLinkedList.java test/SimpleLinkedListTest.java
simplelinkedlisttest-test: simplelinkedlisttest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore SimpleLinkedListTest

somelinkedlisttest: somelinkedlisttest-test
somelinkedlisttest-compile:
	javac -cp junit.jar -d . src/Node.java src/SimpleLinkedList.java src/SomeLinkedList.java test/SomeLinkedListTest.java
somelinkedlisttest-test: somelinkedlisttest-compile
	java -cp hamcrest.jar:junit.jar:. org.junit.runner.JUnitCore SomeLinkedListTest

clean:
	rm *.class
