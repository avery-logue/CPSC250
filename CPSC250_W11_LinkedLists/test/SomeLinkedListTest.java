import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeLinkedListTest {

    @Test
    public void test_doubleListEmpty() {
        SomeLinkedList<String> expected = new SomeLinkedList<String>();

        SomeLinkedList<String> actual = new SomeLinkedList<String>();
        actual.doubleList();

        for (Node<String> expCur = expected.first, actCur = actual.first; expCur != null; expCur = expCur.next, actCur = actCur.next) {
            assertEquals("Incorrect result", expCur.value, actCur.value);
        }
    }

    @Test
    public void test_doubleListWithOne() {
        SomeLinkedList<String> expected = new SomeLinkedList<String>();
        expected.first = new Node<String>("Alice");
        expected.first.next = new Node<String>("Alice");

        SomeLinkedList<String> actual = new SomeLinkedList<String>();
        actual.first = new Node<String>("Alice");
        actual.doubleList();

        for (Node<String> expCur = expected.first, actCur = actual.first; expCur != null; expCur = expCur.next, actCur = actCur.next) {
            assertEquals("Incorrect result", expCur.value, actCur.value);
        }
    }

    @Test
    public void test_doubleListWithMany() {
        SomeLinkedList<String> expected = new SomeLinkedList<String>();
        expected.first = new Node<String>("Alice");
        expected.first.next = new Node<String>("Alice");
        expected.first.next.next = new Node<String>("Bob");
        expected.first.next.next.next = new Node<String>("Bob");
        expected.first.next.next.next.next = new Node<String>("Carol");
        expected.first.next.next.next.next.next = new Node<String>("Carol");

        SomeLinkedList<String> actual = new SomeLinkedList<String>();
        actual.first = new Node<String>("Alice");
        actual.first.next = new Node<String>("Bob");
        actual.first.next.next = new Node<String>("Carol");
        actual.doubleList();

        for (Node<String> expCur = expected.first, actCur = actual.first; expCur != null; expCur = expCur.next, actCur = actCur.next) {
            assertEquals("Incorrect result", expCur.value, actCur.value);
        }

    }

    @Test
    public void test_removeAllMany() {
        SomeLinkedList<String> expected = new SomeLinkedList<String>();
        expected.first = new Node<String>("Alice");
        expected.first.next = new Node<String>("Bob");
        expected.first.next.next = new Node<String>("David");
        expected.first.next.next.next = new Node<String>("Edward");
        expected.first.next.next.next.next = new Node<String>("Frank");

        SomeLinkedList<String> actual = new SomeLinkedList<String>();
        actual.first = new Node<String>("Alice");
        actual.first.next = new Node<String>("Carol");
        actual.first.next.next = new Node<String>("Bob");
        actual.first.next.next.next = new Node<String>("Carol");
        actual.first.next.next.next.next = new Node<String>("David");
        actual.first.next.next.next.next.next = new Node<String>("Edward");
        actual.first.next.next.next.next.next.next = new Node<String>("Carol");
        actual.first.next.next.next.next.next.next.next = new Node<String>(
                "Frank");
        actual.removeAll("Carol");

        for (Node<String> expCur = expected.first, actCur = actual.first; expCur != null; expCur = expCur.next, actCur = actCur.next) {
            assertEquals("Incorrect result", expCur.value, actCur.value);
        }
    }

    @Test
    public void test_removeAllManyFront() {
        SomeLinkedList<String> expected = new SomeLinkedList<String>();
        expected.first = new Node<String>("Alice");
        expected.first.next = new Node<String>("Bob");
        expected.first.next.next = new Node<String>("David");
        expected.first.next.next.next = new Node<String>("Edward");
        expected.first.next.next.next.next = new Node<String>("Frank");

        SomeLinkedList<String> actual = new SomeLinkedList<String>();
        actual.first = new Node<String>("Carol");
        actual.first.next = new Node<String>("Alice");
        actual.first.next.next = new Node<String>("Bob");
        actual.first.next.next.next = new Node<String>("Carol");
        actual.first.next.next.next.next = new Node<String>("David");
        actual.first.next.next.next.next.next = new Node<String>("Edward");
        actual.first.next.next.next.next.next.next = new Node<String>("Carol");
        actual.first.next.next.next.next.next.next.next = new Node<String>(
                "Frank");
        actual.first.next.next.next.next.next.next.next.next = new Node<String>(
                "Carol");
        actual.removeAll("Carol");

        for (Node<String> expCur = expected.first, actCur = actual.first; expCur != null; expCur = expCur.next, actCur = actCur.next) {
            assertEquals("Incorrect result", expCur.value, actCur.value);
        }
    }

    @Test
    public void test_removeAllEmpty() {
        SomeLinkedList<String> expected = new SomeLinkedList<String>();

        SomeLinkedList<String> actual = new SomeLinkedList<String>();
        actual.removeAll("Carol");

        for (Node<String> expCur = expected.first, actCur = actual.first; actCur != null; expCur = expCur.next, actCur = actCur.next) {
            assertEquals("Incorrect result", expCur.value, actCur.value);
        }
    }
}
