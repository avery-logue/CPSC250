
public class LinkedListMethods {

    public static int size(Node<String> head) {

        if (head == null) {
            return 0;
        }
        Node<String> current = new Node<String>(head.value, head.next);
        int count = 0;

        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public static double sum(Node<Double> head) {

        if (head == null) {
            return 0;
        }

        Node<Double> current = new Node<Double>(head.value, head.next);
        double count = head.value;

        while (current.next != null) {
            count += head.next.value;
            current = current.next;
        }
        return count;
    }
    public static Node<Character> getUppercaseList(Node<Character> head) {

        if (head == null) {
            return null;
        }

        Node<Character> current = new Node<Character>(head.value, head.next);

        while (current != null && current.next != null) {
            if (head.value == 'A' || head.value == 'B' || head.value == 'C' || head.value == 'D' || head.value == 'E'|| head.value == 'F'|| head.value == 'G'|| head.value == 'H' || head.value == 'L') {
                current = head;
                return head;
            }
            current = current.next;
        }

        return null;
    }

    //        if (head == null) {
    //            return null;
    //        }
    //        Node<Character> last = new Node<Character>(head.value, head.next);
    //        Node<Character> current = new Node<Character>(head.value, head.next);
    //        Character character = 'b';
    //        
    //        while (current != null) {
    //            if(head.value.toLowerCase(character) == character) {
    //                last = head.next;
    //                character++;
    //            }
    //            current = current.next;
    //        }
    //        return last;

}
